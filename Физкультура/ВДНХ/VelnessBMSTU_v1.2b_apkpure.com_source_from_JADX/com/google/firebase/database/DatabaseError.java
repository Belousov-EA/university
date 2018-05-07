package com.google.firebase.database;

import com.google.android.gms.internal.zzdvl;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class DatabaseError {
    public static final int DATA_STALE = -1;
    public static final int DISCONNECTED = -4;
    public static final int EXPIRED_TOKEN = -6;
    public static final int INVALID_TOKEN = -7;
    public static final int MAX_RETRIES = -8;
    public static final int NETWORK_ERROR = -24;
    public static final int OPERATION_FAILED = -2;
    public static final int OVERRIDDEN_BY_SET = -9;
    public static final int PERMISSION_DENIED = -3;
    public static final int UNAVAILABLE = -10;
    public static final int UNKNOWN_ERROR = -999;
    public static final int USER_CODE_EXCEPTION = -11;
    public static final int WRITE_CANCELED = -25;
    private static final Map<Integer, String> zzmjv;
    private static final Map<String, Integer> zzmjw;
    private final int code;
    private final String message;
    private final String zzmjx;

    static {
        Map hashMap = new HashMap();
        zzmjv = hashMap;
        hashMap.put(Integer.valueOf(-1), "The transaction needs to be run again with current data");
        zzmjv.put(Integer.valueOf(-2), "The server indicated that this operation failed");
        zzmjv.put(Integer.valueOf(-3), "This client does not have permission to perform this operation");
        zzmjv.put(Integer.valueOf(-4), "The operation had to be aborted due to a network disconnect");
        zzmjv.put(Integer.valueOf(-6), "The supplied auth token has expired");
        zzmjv.put(Integer.valueOf(-7), "The supplied auth token was invalid");
        zzmjv.put(Integer.valueOf(-8), "The transaction had too many retries");
        zzmjv.put(Integer.valueOf(-9), "The transaction was overridden by a subsequent set");
        zzmjv.put(Integer.valueOf(-10), "The service is unavailable");
        zzmjv.put(Integer.valueOf(-11), "User code called from the Firebase Database runloop threw an exception:\n");
        zzmjv.put(Integer.valueOf(-24), "The operation could not be performed due to a network error");
        zzmjv.put(Integer.valueOf(-25), "The write was canceled by the user.");
        zzmjv.put(Integer.valueOf(UNKNOWN_ERROR), "An unknown error occurred");
        hashMap = new HashMap();
        zzmjw = hashMap;
        hashMap.put("datastale", Integer.valueOf(-1));
        zzmjw.put("failure", Integer.valueOf(-2));
        zzmjw.put("permission_denied", Integer.valueOf(-3));
        zzmjw.put("disconnected", Integer.valueOf(-4));
        zzmjw.put("expired_token", Integer.valueOf(-6));
        zzmjw.put("invalid_token", Integer.valueOf(-7));
        zzmjw.put("maxretries", Integer.valueOf(-8));
        zzmjw.put("overriddenbyset", Integer.valueOf(-9));
        zzmjw.put("unavailable", Integer.valueOf(-10));
        zzmjw.put("network_error", Integer.valueOf(-24));
        zzmjw.put("write_canceled", Integer.valueOf(-25));
    }

    private DatabaseError(int i, String str) {
        this(-11, str, null);
    }

    private DatabaseError(int i, String str, String str2) {
        this.code = i;
        this.message = str;
        this.zzmjx = "";
    }

    public static DatabaseError fromException(Throwable th) {
        Writer stringWriter = new StringWriter();
        zzdvl.zza(th, new PrintWriter(stringWriter));
        String valueOf = String.valueOf((String) zzmjv.get(Integer.valueOf(-11)));
        String valueOf2 = String.valueOf(stringWriter.toString());
        return new DatabaseError(-11, valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
    }

    public static DatabaseError zzbc(String str, String str2) {
        Integer num = (Integer) zzmjw.get(str.toLowerCase());
        Integer valueOf = num == null ? Integer.valueOf(UNKNOWN_ERROR) : num;
        return new DatabaseError(valueOf.intValue(), str2 == null ? (String) zzmjv.get(valueOf) : str2, null);
    }

    public static DatabaseError zzgp(int i) {
        if (zzmjv.containsKey(Integer.valueOf(-25))) {
            return new DatabaseError(-25, (String) zzmjv.get(Integer.valueOf(-25)), null);
        }
        throw new IllegalArgumentException("Invalid Firebase Database error code: -25");
    }

    public static DatabaseError zzpg(String str) {
        Integer num = (Integer) zzmjw.get(str.toLowerCase());
        Integer valueOf = num == null ? Integer.valueOf(UNKNOWN_ERROR) : num;
        return new DatabaseError(valueOf.intValue(), (String) zzmjv.get(valueOf), null);
    }

    public int getCode() {
        return this.code;
    }

    public String getDetails() {
        return this.zzmjx;
    }

    public String getMessage() {
        return this.message;
    }

    public DatabaseException toException() {
        String str = "Firebase Database error: ";
        String valueOf = String.valueOf(this.message);
        return new DatabaseException(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
    }

    public String toString() {
        String str = "DatabaseError: ";
        String valueOf = String.valueOf(this.message);
        return valueOf.length() != 0 ? str.concat(valueOf) : new String(str);
    }
}
