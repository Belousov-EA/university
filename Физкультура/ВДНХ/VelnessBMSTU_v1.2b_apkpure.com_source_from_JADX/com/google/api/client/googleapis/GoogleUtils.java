package com.google.api.client.googleapis;

import com.google.api.client.util.SecurityUtils;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;

public final class GoogleUtils {
    public static final Integer BUGFIX_VERSION = Integer.valueOf(0);
    public static final Integer MAJOR_VERSION = Integer.valueOf(1);
    public static final Integer MINOR_VERSION = Integer.valueOf(23);
    public static final String VERSION;
    static KeyStore certTrustStore;

    static {
        String valueOf = String.valueOf(String.valueOf(MAJOR_VERSION));
        String valueOf2 = String.valueOf(String.valueOf(MINOR_VERSION));
        String valueOf3 = String.valueOf(String.valueOf(BUGFIX_VERSION));
        VERSION = new StringBuilder(((valueOf.length() + 2) + valueOf2.length()) + valueOf3.length()).append(valueOf).append(".").append(valueOf2).append(".").append(valueOf3).toString().toString();
    }

    public static synchronized KeyStore getCertificateTrustStore() throws IOException, GeneralSecurityException {
        KeyStore keyStore;
        synchronized (GoogleUtils.class) {
            if (certTrustStore == null) {
                certTrustStore = SecurityUtils.getJavaKeyStore();
                SecurityUtils.loadKeyStore(certTrustStore, GoogleUtils.class.getResourceAsStream("google.jks"), "notasecret");
            }
            keyStore = certTrustStore;
        }
        return keyStore;
    }

    private GoogleUtils() {
    }
}
