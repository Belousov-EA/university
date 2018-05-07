package com.google.api.client.googleapis.extensions.android.gms.auth;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.AccountPicker;
import com.google.api.client.googleapis.extensions.android.accounts.GoogleAccountManager;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.BackOff;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;
import java.util.Collection;

@Beta
public class GoogleAccountCredential implements HttpRequestInitializer {
    private final GoogleAccountManager accountManager;
    private String accountName;
    private BackOff backOff;
    final Context context;
    final String scope;
    private Account selectedAccount;
    private Sleeper sleeper = Sleeper.DEFAULT;

    @Beta
    class RequestHandler implements HttpExecuteInterceptor, HttpUnsuccessfulResponseHandler {
        boolean received401;
        String token;

        RequestHandler() {
        }

        public void intercept(HttpRequest request) throws IOException {
            try {
                this.token = GoogleAccountCredential.this.getToken();
                HttpHeaders headers = request.getHeaders();
                String str = "Bearer ";
                String valueOf = String.valueOf(this.token);
                headers.setAuthorization(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            } catch (GooglePlayServicesAvailabilityException e) {
                throw new GooglePlayServicesAvailabilityIOException(e);
            } catch (UserRecoverableAuthException e2) {
                throw new UserRecoverableAuthIOException(e2);
            } catch (GoogleAuthException e3) {
                throw new GoogleAuthIOException(e3);
            }
        }

        public boolean handleResponse(HttpRequest request, HttpResponse response, boolean supportsRetry) {
            if (response.getStatusCode() != HttpStatusCodes.STATUS_CODE_UNAUTHORIZED || this.received401) {
                return false;
            }
            this.received401 = true;
            GoogleAuthUtil.invalidateToken(GoogleAccountCredential.this.context, this.token);
            return true;
        }
    }

    public GoogleAccountCredential(Context context, String scope) {
        this.accountManager = new GoogleAccountManager(context);
        this.context = context;
        this.scope = scope;
    }

    public static GoogleAccountCredential usingOAuth2(Context context, Collection<String> scopes) {
        boolean z = scopes != null && scopes.iterator().hasNext();
        Preconditions.checkArgument(z);
        String str = "oauth2: ";
        String valueOf = String.valueOf(Joiner.on(' ').join(scopes));
        return new GoogleAccountCredential(context, valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public static GoogleAccountCredential usingAudience(Context context, String audience) {
        Preconditions.checkArgument(audience.length() != 0);
        String str = "audience:";
        String valueOf = String.valueOf(audience);
        return new GoogleAccountCredential(context, valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public final GoogleAccountCredential setSelectedAccountName(String accountName) {
        this.selectedAccount = this.accountManager.getAccountByName(accountName);
        if (this.selectedAccount == null) {
            accountName = null;
        }
        this.accountName = accountName;
        return this;
    }

    public final GoogleAccountCredential setSelectedAccount(Account selectedAccount) {
        this.selectedAccount = selectedAccount;
        this.accountName = selectedAccount == null ? null : selectedAccount.name;
        return this;
    }

    public void initialize(HttpRequest request) {
        RequestHandler handler = new RequestHandler();
        request.setInterceptor(handler);
        request.setUnsuccessfulResponseHandler(handler);
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getScope() {
        return this.scope;
    }

    public final GoogleAccountManager getGoogleAccountManager() {
        return this.accountManager;
    }

    public final Account[] getAllAccounts() {
        return this.accountManager.getAccounts();
    }

    public final Account getSelectedAccount() {
        return this.selectedAccount;
    }

    public BackOff getBackOff() {
        return this.backOff;
    }

    public GoogleAccountCredential setBackOff(BackOff backOff) {
        this.backOff = backOff;
        return this;
    }

    public final Sleeper getSleeper() {
        return this.sleeper;
    }

    public final GoogleAccountCredential setSleeper(Sleeper sleeper) {
        this.sleeper = (Sleeper) Preconditions.checkNotNull(sleeper);
        return this;
    }

    public final String getSelectedAccountName() {
        return this.accountName;
    }

    public final Intent newChooseAccountIntent() {
        return AccountPicker.newChooseAccountIntent(this.selectedAccount, null, new String[]{"com.google"}, true, null, null, null, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getToken() throws java.io.IOException, com.google.android.gms.auth.GoogleAuthException {
        /*
        r4 = this;
        r1 = r4.backOff;
        if (r1 == 0) goto L_0x0009;
    L_0x0004:
        r1 = r4.backOff;
        r1.reset();
    L_0x0009:
        r1 = r4.context;	 Catch:{ IOException -> 0x0014 }
        r2 = r4.accountName;	 Catch:{ IOException -> 0x0014 }
        r3 = r4.scope;	 Catch:{ IOException -> 0x0014 }
        r1 = com.google.android.gms.auth.GoogleAuthUtil.getToken(r1, r2, r3);	 Catch:{ IOException -> 0x0014 }
        return r1;
    L_0x0014:
        r0 = move-exception;
        r1 = r4.backOff;	 Catch:{ InterruptedException -> 0x0024 }
        if (r1 == 0) goto L_0x0023;
    L_0x0019:
        r1 = r4.sleeper;	 Catch:{ InterruptedException -> 0x0024 }
        r2 = r4.backOff;	 Catch:{ InterruptedException -> 0x0024 }
        r1 = com.google.api.client.util.BackOffUtils.next(r1, r2);	 Catch:{ InterruptedException -> 0x0024 }
        if (r1 != 0) goto L_0x0009;
    L_0x0023:
        throw r0;	 Catch:{ InterruptedException -> 0x0024 }
    L_0x0024:
        r1 = move-exception;
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential.getToken():java.lang.String");
    }
}
