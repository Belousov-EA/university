package com.google.android.gms.internal;

import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpStatusCodes;
import com.google.common.net.HttpHeaders;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.SSLSocketFactory;

public final class zzar extends zzah {
    private final zzas zzch;
    private final SSLSocketFactory zzci;

    public zzar() {
        this(null);
    }

    private zzar(zzas com_google_android_gms_internal_zzas) {
        this(null, null);
    }

    private zzar(zzas com_google_android_gms_internal_zzas, SSLSocketFactory sSLSocketFactory) {
        this.zzch = null;
        this.zzci = null;
    }

    private static InputStream zza(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (IOException e) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static void zza(HttpURLConnection httpURLConnection, zzr<?> com_google_android_gms_internal_zzr_) throws IOException, zza {
        byte[] zzf = com_google_android_gms_internal_zzr_.zzf();
        if (zzf != null) {
            httpURLConnection.setDoOutput(true);
            String str = HttpHeaders.CONTENT_TYPE;
            String str2 = "application/x-www-form-urlencoded; charset=";
            String valueOf = String.valueOf("UTF-8");
            httpURLConnection.addRequestProperty(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.write(zzf);
            dataOutputStream.close();
        }
    }

    private static List<zzl> zzc(Map<String, List<String>> map) {
        List<zzl> arrayList = new ArrayList(map.size());
        for (Entry entry : map.entrySet()) {
            if (entry.getKey() != null) {
                for (String com_google_android_gms_internal_zzl : (List) entry.getValue()) {
                    arrayList.add(new zzl((String) entry.getKey(), com_google_android_gms_internal_zzl));
                }
            }
        }
        return arrayList;
    }

    public final zzap zza(zzr<?> com_google_android_gms_internal_zzr_, Map<String, String> map) throws IOException, zza {
        String zzg;
        String url = com_google_android_gms_internal_zzr_.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(com_google_android_gms_internal_zzr_.getHeaders());
        hashMap.putAll(map);
        if (this.zzch != null) {
            zzg = this.zzch.zzg(url);
            if (zzg == null) {
                String str = "URL blocked by rewriter: ";
                zzg = String.valueOf(url);
                throw new IOException(zzg.length() != 0 ? str.concat(zzg) : new String(str));
            }
        }
        zzg = url;
        URL url2 = new URL(zzg);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url2.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        int zzh = com_google_android_gms_internal_zzr_.zzh();
        httpURLConnection.setConnectTimeout(zzh);
        httpURLConnection.setReadTimeout(zzh);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        "https".equals(url2.getProtocol());
        for (String url3 : hashMap.keySet()) {
            httpURLConnection.addRequestProperty(url3, (String) hashMap.get(url3));
        }
        switch (com_google_android_gms_internal_zzr_.getMethod()) {
            case -1:
                break;
            case 0:
                httpURLConnection.setRequestMethod(HttpMethods.GET);
                break;
            case 1:
                httpURLConnection.setRequestMethod(HttpMethods.POST);
                zza(httpURLConnection, (zzr) com_google_android_gms_internal_zzr_);
                break;
            case 2:
                httpURLConnection.setRequestMethod(HttpMethods.PUT);
                zza(httpURLConnection, (zzr) com_google_android_gms_internal_zzr_);
                break;
            case 3:
                httpURLConnection.setRequestMethod(HttpMethods.DELETE);
                break;
            case 4:
                httpURLConnection.setRequestMethod(HttpMethods.HEAD);
                break;
            case 5:
                httpURLConnection.setRequestMethod(HttpMethods.OPTIONS);
                break;
            case 6:
                httpURLConnection.setRequestMethod(HttpMethods.TRACE);
                break;
            case 7:
                httpURLConnection.setRequestMethod(HttpMethods.PATCH);
                zza(httpURLConnection, (zzr) com_google_android_gms_internal_zzr_);
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        zzh = httpURLConnection.getResponseCode();
        if (zzh == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        boolean z = (com_google_android_gms_internal_zzr_.getMethod() == 4 || ((100 <= zzh && zzh < 200) || zzh == HttpStatusCodes.STATUS_CODE_NO_CONTENT || zzh == HttpStatusCodes.STATUS_CODE_NOT_MODIFIED)) ? false : true;
        return !z ? new zzap(zzh, zzc(httpURLConnection.getHeaderFields())) : new zzap(zzh, zzc(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), zza(httpURLConnection));
    }
}
