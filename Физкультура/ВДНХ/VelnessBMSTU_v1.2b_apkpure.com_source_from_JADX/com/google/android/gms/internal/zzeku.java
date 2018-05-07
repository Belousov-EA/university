package com.google.android.gms.internal;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.support.annotation.Nullable;
import java.io.File;
import java.lang.Thread.State;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;

public final class zzeku {
    private static final AtomicInteger zzndq = new AtomicInteger(0);
    private static final Charset zzndr = Charset.forName("UTF-8");
    private static ThreadFactory zzndz = Executors.defaultThreadFactory();
    private static zzekt zznea = new zzekv();
    private volatile Socket socket = null;
    private final int zzfny = zzndq.incrementAndGet();
    private final zzejc zzmlr;
    @Nullable
    private final String zzmnu;
    private volatile int zznds = zzeky.zzned;
    private zzekz zzndt = null;
    private final URI zzndu;
    private final zzeld zzndv;
    private final zzele zzndw;
    private final zzelb zzndx;
    private final Thread zzndy = zzndz.newThread(new zzekw(this));

    public zzeku(zzebi com_google_android_gms_internal_zzebi, URI uri, String str, Map<String, String> map) {
        this.zzndu = uri;
        this.zzmnu = com_google_android_gms_internal_zzebi.zzbug();
        this.zzmlr = new zzejc(com_google_android_gms_internal_zzebi.zzbub(), "WebSocket", "sk_" + this.zzfny);
        this.zzndx = new zzelb(uri, null, map);
        this.zzndv = new zzeld(this);
        this.zzndw = new zzele(this, "TubeSock", this.zzfny);
    }

    private final Socket createSocket() {
        Throwable th;
        String str;
        String valueOf;
        String valueOf2;
        String scheme = this.zzndu.getScheme();
        String host = this.zzndu.getHost();
        int port = this.zzndu.getPort();
        if (scheme != null && scheme.equals("ws")) {
            try {
                return new Socket(host, port == -1 ? 80 : port);
            } catch (Throwable e) {
                th = e;
                str = "unknown host: ";
                valueOf = String.valueOf(host);
                throw new zzela(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th);
            } catch (Throwable e2) {
                valueOf2 = String.valueOf(this.zzndu);
                throw new zzela(new StringBuilder(String.valueOf(valueOf2).length() + 31).append("error while creating socket to ").append(valueOf2).toString(), e2);
            }
        } else if (scheme == null || !scheme.equals("wss")) {
            host = "unsupported protocol: ";
            valueOf = String.valueOf(scheme);
            throw new zzela(valueOf.length() != 0 ? host.concat(valueOf) : new String(host));
        } else {
            SSLSessionCache sSLSessionCache;
            SSLSocket sSLSocket;
            if (port == -1) {
                port = 443;
            }
            try {
                if (this.zzmnu != null) {
                    sSLSessionCache = new SSLSessionCache(new File(this.zzmnu));
                    sSLSocket = (SSLSocket) SSLCertificateSocketFactory.getDefault(60000, sSLSessionCache).createSocket(host, port);
                    if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                        return sSLSocket;
                    }
                    scheme = String.valueOf(this.zzndu);
                    throw new zzela(new StringBuilder(String.valueOf(scheme).length() + 39).append("Error while verifying secure socket to ").append(scheme).toString());
                }
            } catch (Throwable th2) {
                this.zzmlr.zzb("Failed to initialize SSL session cache", th2, new Object[0]);
            }
            sSLSessionCache = null;
            try {
                sSLSocket = (SSLSocket) SSLCertificateSocketFactory.getDefault(60000, sSLSessionCache).createSocket(host, port);
                if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSocket.getSession())) {
                    return sSLSocket;
                }
                scheme = String.valueOf(this.zzndu);
                throw new zzela(new StringBuilder(String.valueOf(scheme).length() + 39).append("Error while verifying secure socket to ").append(scheme).toString());
            } catch (Throwable e22) {
                th2 = e22;
                str = "unknown host: ";
                valueOf = String.valueOf(host);
                throw new zzela(valueOf.length() != 0 ? str.concat(valueOf) : new String(str), th2);
            } catch (Throwable e222) {
                valueOf2 = String.valueOf(this.zzndu);
                throw new zzela(new StringBuilder(String.valueOf(valueOf2).length() + 38).append("error while creating secure socket to ").append(valueOf2).toString(), e222);
            }
        }
    }

    static ThreadFactory getThreadFactory() {
        return zzndz;
    }

    private final synchronized void zza(byte b, byte[] bArr) {
        if (this.zznds != zzeky.zznef) {
            this.zzndt.zza(new zzela("error while sending data: not connected"));
        } else {
            try {
                this.zzndw.zza(b, true, bArr);
            } catch (Throwable e) {
                this.zzndt.zza(new zzela("Failed to send frame", e));
                close();
            }
        }
    }

    static zzekt zzcas() {
        return zznea;
    }

    private final synchronized void zzcav() {
        if (this.zznds != zzeky.zzneh) {
            this.zzndv.zzcba();
            this.zzndw.zzcbc();
            if (this.socket != null) {
                try {
                    this.socket.close();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
            this.zznds = zzeky.zzneh;
            this.zzndt.onClose();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzcax() {
        /*
        r12 = this;
        r4 = 1;
        r11 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r3 = 0;
        r1 = r12.createSocket();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        monitor-enter(r12);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r12.socket = r1;	 Catch:{ all -> 0x0025 }
        r2 = r12.zznds;	 Catch:{ all -> 0x0025 }
        r5 = com.google.android.gms.internal.zzeky.zzneh;	 Catch:{ all -> 0x0025 }
        if (r2 != r5) goto L_0x0032;
    L_0x0011:
        r1 = r12.socket;	 Catch:{ IOException -> 0x001e }
        r1.close();	 Catch:{ IOException -> 0x001e }
        r1 = 0;
        r12.socket = r1;	 Catch:{ all -> 0x0025 }
        monitor-exit(r12);	 Catch:{ all -> 0x0025 }
        r12.close();
    L_0x001d:
        return;
    L_0x001e:
        r1 = move-exception;
        r2 = new java.lang.RuntimeException;	 Catch:{ all -> 0x0025 }
        r2.<init>(r1);	 Catch:{ all -> 0x0025 }
        throw r2;	 Catch:{ all -> 0x0025 }
    L_0x0025:
        r1 = move-exception;
        monitor-exit(r12);	 Catch:{ all -> 0x0025 }
        throw r1;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
    L_0x0028:
        r1 = move-exception;
        r2 = r12.zzndt;	 Catch:{ all -> 0x00c1 }
        r2.zza(r1);	 Catch:{ all -> 0x00c1 }
        r12.close();
        goto L_0x001d;
    L_0x0032:
        monitor-exit(r12);	 Catch:{ all -> 0x0025 }
        r7 = new java.io.DataInputStream;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = r1.getInputStream();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r7.<init>(r2);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r8 = r1.getOutputStream();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r12.zzndx;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r1.zzcay();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r8.write(r1);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r1 = new byte[r1];	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = new java.util.ArrayList;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2.<init>();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r5 = r3;
        r6 = r1;
        r1 = r3;
    L_0x0055:
        if (r1 != 0) goto L_0x00eb;
    L_0x0057:
        r9 = r7.read();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r10 = -1;
        if (r9 != r10) goto L_0x0089;
    L_0x005e:
        r1 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = "Connection closed before handshake was complete";
        r1.<init>(r2);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        throw r1;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
    L_0x0066:
        r1 = move-exception;
        r3 = r12.zzndt;	 Catch:{ all -> 0x00c1 }
        r4 = new com.google.android.gms.internal.zzela;	 Catch:{ all -> 0x00c1 }
        r5 = "error while connecting: ";
        r2 = r1.getMessage();	 Catch:{ all -> 0x00c1 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x00c1 }
        r6 = r2.length();	 Catch:{ all -> 0x00c1 }
        if (r6 == 0) goto L_0x01c7;
    L_0x007b:
        r2 = r5.concat(r2);	 Catch:{ all -> 0x00c1 }
    L_0x007f:
        r4.<init>(r2, r1);	 Catch:{ all -> 0x00c1 }
        r3.zza(r4);	 Catch:{ all -> 0x00c1 }
        r12.close();
        goto L_0x001d;
    L_0x0089:
        r9 = (byte) r9;
        r6[r5] = r9;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r5 = r5 + 1;
        r9 = r5 + -1;
        r9 = r6[r9];	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r10 = 10;
        if (r9 != r10) goto L_0x00c6;
    L_0x0096:
        r9 = r5 + -2;
        r9 = r6[r9];	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r10 = 13;
        if (r9 != r10) goto L_0x00c6;
    L_0x009e:
        r5 = new java.lang.String;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r9 = zzndr;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r5.<init>(r6, r9);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r6 = r5.trim();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r9 = "";
        r6 = r6.equals(r9);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        if (r6 == 0) goto L_0x00b9;
    L_0x00b1:
        r1 = r4;
    L_0x00b2:
        r5 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r5 = new byte[r5];	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r6 = r5;
        r5 = r3;
        goto L_0x0055;
    L_0x00b9:
        r5 = r5.trim();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2.add(r5);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        goto L_0x00b2;
    L_0x00c1:
        r1 = move-exception;
        r12.close();
        throw r1;
    L_0x00c6:
        if (r5 != r11) goto L_0x0055;
    L_0x00c8:
        r1 = new java.lang.String;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = zzndr;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1.<init>(r6, r2);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r3 = "Unexpected long line in handshake: ";
        r1 = java.lang.String.valueOf(r1);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r4 = r1.length();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        if (r4 == 0) goto L_0x00e5;
    L_0x00dd:
        r1 = r3.concat(r1);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
    L_0x00e1:
        r2.<init>(r1);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        throw r2;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
    L_0x00e5:
        r1 = new java.lang.String;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1.<init>(r3);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        goto L_0x00e1;
    L_0x00eb:
        r1 = 0;
        r1 = r2.get(r1);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = (java.lang.String) r1;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r4 = 9;
        r5 = 12;
        r1 = r1.substring(r4, r5);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r1.intValue();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r4 = 407; // 0x197 float:5.7E-43 double:2.01E-321;
        if (r1 != r4) goto L_0x010e;
    L_0x0106:
        r1 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = "connection failed: proxy authentication not supported";
        r1.<init>(r2);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        throw r1;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
    L_0x010e:
        r4 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        if (r1 != r4) goto L_0x011a;
    L_0x0112:
        r1 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = "connection failed: 404 not found";
        r1.<init>(r2);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        throw r1;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
    L_0x011a:
        r4 = 101; // 0x65 float:1.42E-43 double:5.0E-322;
        if (r1 == r4) goto L_0x0139;
    L_0x011e:
        r2 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r3 = 50;
        r4 = new java.lang.StringBuilder;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r4.<init>(r3);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r3 = "connection failed: unknown status code ";
        r3 = r4.append(r3);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r3.append(r1);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r1.toString();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2.<init>(r1);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        throw r2;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
    L_0x0139:
        r1 = 0;
        r2.remove(r1);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r4 = new java.util.HashMap;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r4.<init>();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r0 = r2;
        r0 = (java.util.ArrayList) r0;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r0;
        r5 = r1.size();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
    L_0x014a:
        if (r3 >= r5) goto L_0x0165;
    L_0x014c:
        r2 = r1.get(r3);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r3 = r3 + 1;
        r2 = (java.lang.String) r2;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r6 = ": ";
        r9 = 2;
        r2 = r2.split(r6, r9);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r6 = 0;
        r6 = r2[r6];	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r9 = 1;
        r2 = r2[r9];	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r4.put(r6, r2);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        goto L_0x014a;
    L_0x0165:
        r1 = "Upgrade";
        r1 = r4.get(r1);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = (java.lang.String) r1;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = java.util.Locale.US;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r1.toLowerCase(r2);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = "websocket";
        r1 = r1.equals(r2);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        if (r1 != 0) goto L_0x0183;
    L_0x017b:
        r1 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = "connection failed: missing header field in server handshake: Upgrade";
        r1.<init>(r2);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        throw r1;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
    L_0x0183:
        r1 = "Connection";
        r1 = r4.get(r1);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = (java.lang.String) r1;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = java.util.Locale.US;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r1.toLowerCase(r2);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = "upgrade";
        r1 = r1.equals(r2);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        if (r1 != 0) goto L_0x01a1;
    L_0x0199:
        r1 = new com.google.android.gms.internal.zzela;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r2 = "connection failed: missing header field in server handshake: Connection";
        r1.<init>(r2);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        throw r1;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
    L_0x01a1:
        r1 = r12.zzndw;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1.zzb(r8);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r12.zzndv;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1.zza(r7);	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = com.google.android.gms.internal.zzeky.zznef;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r12.zznds = r1;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r12.zzndw;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r1.zzcbe();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1.start();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r12.zzndt;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1.zzbvg();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1 = r12.zzndv;	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r1.run();	 Catch:{ zzela -> 0x0028, IOException -> 0x0066 }
        r12.close();
        goto L_0x001d;
    L_0x01c7:
        r2 = new java.lang.String;	 Catch:{ all -> 0x00c1 }
        r2.<init>(r5);	 Catch:{ all -> 0x00c1 }
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzeku.zzcax():void");
    }

    public final synchronized void close() {
        switch (zzekx.zznec[this.zznds - 1]) {
            case 1:
                this.zznds = zzeky.zzneh;
                break;
            case 2:
                zzcav();
                break;
            case 3:
                try {
                    this.zznds = zzeky.zzneg;
                    this.zzndw.zzcbc();
                    this.zzndw.zza((byte) 8, true, new byte[0]);
                    break;
                } catch (Throwable e) {
                    this.zzndt.zza(new zzela("Failed to send close frame", e));
                    break;
                }
        }
    }

    public final synchronized void connect() {
        if (this.zznds != zzeky.zzned) {
            this.zzndt.zza(new zzela("connect() already called"));
            close();
        } else {
            String str = "TubeSockReader-";
            zznea.zza(this.zzndy, new StringBuilder(String.valueOf(str).length() + 11).append(str).append(this.zzfny).toString());
            this.zznds = zzeky.zznee;
            this.zzndy.start();
        }
    }

    public final void zza(zzekz com_google_android_gms_internal_zzekz) {
        this.zzndt = com_google_android_gms_internal_zzekz;
    }

    final synchronized void zzaq(byte[] bArr) {
        zza((byte) 10, bArr);
    }

    final void zzb(zzela com_google_android_gms_internal_zzela) {
        this.zzndt.zza(com_google_android_gms_internal_zzela);
        if (this.zznds == zzeky.zznef) {
            close();
        }
        zzcav();
    }

    final zzekz zzcat() {
        return this.zzndt;
    }

    final void zzcau() {
        zzcav();
    }

    public final void zzcaw() throws InterruptedException {
        if (this.zzndw.zzcbe().getState() != State.NEW) {
            this.zzndw.zzcbe().join();
        }
        this.zzndy.join();
    }

    public final synchronized void zzps(String str) {
        zza((byte) 1, str.getBytes(zzndr));
    }
}
