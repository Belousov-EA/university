package com.google.android.gms.internal;

import android.util.Base64;
import com.google.common.net.HttpHeaders;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;

final class zzelb {
    private String protocol = null;
    private URI zzndu = null;
    private String zznej = null;
    private Map<String, String> zznek = null;

    public zzelb(URI uri, String str, Map<String, String> map) {
        this.zzndu = uri;
        this.protocol = null;
        this.zznek = map;
        this.zznej = zzcaz();
    }

    private static String zza(LinkedHashMap<String, String> linkedHashMap) {
        String str = new String();
        String str2 = str;
        for (String str3 : linkedHashMap.keySet()) {
            String valueOf = String.valueOf(str2);
            str2 = (String) linkedHashMap.get(str3);
            str2 = new StringBuilder(((String.valueOf(valueOf).length() + 4) + String.valueOf(str3).length()) + String.valueOf(str2).length()).append(valueOf).append(str3).append(": ").append(str2).append("\r\n").toString();
        }
        return str2;
    }

    private static String zzcaz() {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) ((int) ((Math.random() * 255.0d) + 0.0d));
        }
        return Base64.encodeToString(bArr, 2);
    }

    public final byte[] zzcay() {
        Object obj;
        String path = this.zzndu.getPath();
        String query = this.zzndu.getQuery();
        String valueOf = String.valueOf(path);
        if (query == null) {
            obj = "";
        } else {
            String str = "?";
            path = String.valueOf(query);
            obj = path.length() != 0 ? str.concat(path) : new String(str);
        }
        path = String.valueOf(obj);
        valueOf = path.length() != 0 ? valueOf.concat(path) : new String(valueOf);
        obj = this.zzndu.getHost();
        if (this.zzndu.getPort() != -1) {
            path = String.valueOf(obj);
            obj = new StringBuilder(String.valueOf(path).length() + 12).append(path).append(":").append(this.zzndu.getPort()).toString();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(HttpHeaders.HOST, obj);
        linkedHashMap.put(HttpHeaders.UPGRADE, "websocket");
        linkedHashMap.put(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE);
        linkedHashMap.put("Sec-WebSocket-Version", "13");
        linkedHashMap.put("Sec-WebSocket-Key", this.zznej);
        if (this.protocol != null) {
            linkedHashMap.put("Sec-WebSocket-Protocol", this.protocol);
        }
        if (this.zznek != null) {
            for (String path2 : this.zznek.keySet()) {
                if (!linkedHashMap.containsKey(path2)) {
                    linkedHashMap.put(path2, (String) this.zznek.get(path2));
                }
            }
        }
        query = String.valueOf(new StringBuilder(String.valueOf(valueOf).length() + 15).append("GET ").append(valueOf).append(" HTTP/1.1\r\n").toString());
        path2 = String.valueOf(zza(linkedHashMap));
        path2 = String.valueOf(path2.length() != 0 ? query.concat(path2) : new String(query)).concat("\r\n");
        Object obj2 = new byte[path2.getBytes().length];
        System.arraycopy(path2.getBytes(), 0, obj2, 0, path2.getBytes().length);
        return obj2;
    }
}
