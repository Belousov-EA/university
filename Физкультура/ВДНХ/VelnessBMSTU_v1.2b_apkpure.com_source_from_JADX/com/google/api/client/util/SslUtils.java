package com.google.api.client.util;

import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class SslUtils {

    static class C02751 implements X509TrustManager {
        C02751() {
        }

        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    static class C02762 implements HostnameVerifier {
        C02762() {
        }

        public boolean verify(String arg0, SSLSession arg1) {
            return true;
        }
    }

    public static SSLContext getSslContext() throws NoSuchAlgorithmException {
        return SSLContext.getInstance("SSL");
    }

    public static SSLContext getTlsSslContext() throws NoSuchAlgorithmException {
        return SSLContext.getInstance("TLS");
    }

    public static TrustManagerFactory getDefaultTrustManagerFactory() throws NoSuchAlgorithmException {
        return TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    }

    public static TrustManagerFactory getPkixTrustManagerFactory() throws NoSuchAlgorithmException {
        return TrustManagerFactory.getInstance("PKIX");
    }

    public static KeyManagerFactory getDefaultKeyManagerFactory() throws NoSuchAlgorithmException {
        return KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    }

    public static KeyManagerFactory getPkixKeyManagerFactory() throws NoSuchAlgorithmException {
        return KeyManagerFactory.getInstance("PKIX");
    }

    public static SSLContext initSslContext(SSLContext sslContext, KeyStore trustStore, TrustManagerFactory trustManagerFactory) throws GeneralSecurityException {
        trustManagerFactory.init(trustStore);
        sslContext.init(null, trustManagerFactory.getTrustManagers(), null);
        return sslContext;
    }

    @Beta
    public static SSLContext trustAllSSLContext() throws GeneralSecurityException {
        TrustManager[] trustAllCerts = new TrustManager[]{new C02751()};
        SSLContext context = getTlsSslContext();
        context.init(null, trustAllCerts, null);
        return context;
    }

    @Beta
    public static HostnameVerifier trustAllHostnameVerifier() {
        return new C02762();
    }

    private SslUtils() {
    }
}
