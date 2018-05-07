package com.google.android.gms.internal;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectTimeoutException;

final class zzag extends zzah {
    private final zzaq zzbp;

    zzag(zzaq com_google_android_gms_internal_zzaq) {
        this.zzbp = com_google_android_gms_internal_zzaq;
    }

    public final zzap zza(zzr<?> com_google_android_gms_internal_zzr_, Map<String, String> map) throws IOException, zza {
        try {
            HttpResponse zzb = this.zzbp.zzb(com_google_android_gms_internal_zzr_, map);
            int statusCode = zzb.getStatusLine().getStatusCode();
            Header[] allHeaders = zzb.getAllHeaders();
            List arrayList = new ArrayList(allHeaders.length);
            for (Header header : allHeaders) {
                arrayList.add(new zzl(header.getName(), header.getValue()));
            }
            if (zzb.getEntity() == null) {
                return new zzap(statusCode, arrayList);
            }
            long contentLength = zzb.getEntity().getContentLength();
            if (((long) ((int) contentLength)) == contentLength) {
                return new zzap(statusCode, arrayList, (int) zzb.getEntity().getContentLength(), zzb.getEntity().getContent());
            }
            throw new IOException("Response too large: " + contentLength);
        } catch (ConnectTimeoutException e) {
            throw new SocketTimeoutException(e.getMessage());
        }
    }
}
