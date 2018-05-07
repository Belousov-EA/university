package com.google.android.gms.internal;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolVersion;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;

public abstract class zzah implements zzaq {
    public abstract zzap zza(zzr<?> com_google_android_gms_internal_zzr_, Map<String, String> map) throws IOException, zza;

    @Deprecated
    public final HttpResponse zzb(zzr<?> com_google_android_gms_internal_zzr_, Map<String, String> map) throws IOException, zza {
        zzap zza = zza(com_google_android_gms_internal_zzr_, map);
        HttpResponse basicHttpResponse = new BasicHttpResponse(new BasicStatusLine(new ProtocolVersion("HTTP", 1, 1), zza.getStatusCode(), ""));
        List arrayList = new ArrayList();
        for (zzl com_google_android_gms_internal_zzl : zza.zzp()) {
            arrayList.add(new BasicHeader(com_google_android_gms_internal_zzl.getName(), com_google_android_gms_internal_zzl.getValue()));
        }
        basicHttpResponse.setHeaders((Header[]) arrayList.toArray(new Header[arrayList.size()]));
        InputStream content = zza.getContent();
        if (content != null) {
            HttpEntity basicHttpEntity = new BasicHttpEntity();
            basicHttpEntity.setContent(content);
            basicHttpEntity.setContentLength((long) zza.getContentLength());
            basicHttpResponse.setEntity(basicHttpEntity);
        }
        return basicHttpResponse;
    }
}
