package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.Version;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class VersionUtil {
    public static final String VERSION_FILE = "VERSION.txt";
    private static final Pattern VERSION_SEPARATOR = Pattern.compile("[-_./;:]");
    private final Version _version;

    protected VersionUtil() {
        Version v = null;
        try {
            v = versionFor(getClass());
        } catch (Exception e) {
            System.err.println("ERROR: Failed to load Version information for bundle (via " + getClass().getName() + ").");
        }
        if (v == null) {
            v = Version.unknownVersion();
        }
        this._version = v;
    }

    public Version version() {
        return this._version;
    }

    public static Version versionFor(Class<?> cls) {
        InputStream in;
        Version version = null;
        try {
            in = cls.getResourceAsStream(VERSION_FILE);
            if (in != null) {
                BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                String groupStr = null;
                String artifactStr = null;
                String versionStr = br.readLine();
                if (versionStr != null) {
                    groupStr = br.readLine();
                    if (groupStr != null) {
                        groupStr = groupStr.trim();
                        artifactStr = br.readLine();
                        if (artifactStr != null) {
                            artifactStr = artifactStr.trim();
                        }
                    }
                }
                version = parseVersion(versionStr, groupStr, artifactStr);
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        } catch (IOException e3) {
        } catch (Throwable th) {
            in.close();
        }
        return version == null ? Version.unknownVersion() : version;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fasterxml.jackson.core.Version mavenVersionFor(java.lang.ClassLoader r8, java.lang.String r9, java.lang.String r10) {
        /*
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "META-INF/maven/";
        r5 = r5.append(r6);
        r6 = "\\.";
        r7 = "/";
        r6 = r9.replaceAll(r6, r7);
        r5 = r5.append(r6);
        r6 = "/";
        r5 = r5.append(r6);
        r5 = r5.append(r10);
        r6 = "/pom.properties";
        r5 = r5.append(r6);
        r5 = r5.toString();
        r0 = r8.getResourceAsStream(r5);
        if (r0 == 0) goto L_0x0057;
    L_0x0031:
        r3 = new java.util.Properties;	 Catch:{ IOException -> 0x0053, all -> 0x005c }
        r3.<init>();	 Catch:{ IOException -> 0x0053, all -> 0x005c }
        r3.load(r0);	 Catch:{ IOException -> 0x0053, all -> 0x005c }
        r5 = "version";
        r4 = r3.getProperty(r5);	 Catch:{ IOException -> 0x0053, all -> 0x005c }
        r5 = "artifactId";
        r1 = r3.getProperty(r5);	 Catch:{ IOException -> 0x0053, all -> 0x005c }
        r5 = "groupId";
        r2 = r3.getProperty(r5);	 Catch:{ IOException -> 0x0053, all -> 0x005c }
        r5 = parseVersion(r4, r2, r1);	 Catch:{ IOException -> 0x0053, all -> 0x005c }
        r0.close();	 Catch:{ IOException -> 0x0061 }
    L_0x0052:
        return r5;
    L_0x0053:
        r5 = move-exception;
        r0.close();	 Catch:{ IOException -> 0x0063 }
    L_0x0057:
        r5 = com.fasterxml.jackson.core.Version.unknownVersion();
        goto L_0x0052;
    L_0x005c:
        r5 = move-exception;
        r0.close();	 Catch:{ IOException -> 0x0065 }
    L_0x0060:
        throw r5;
    L_0x0061:
        r6 = move-exception;
        goto L_0x0052;
    L_0x0063:
        r5 = move-exception;
        goto L_0x0057;
    L_0x0065:
        r6 = move-exception;
        goto L_0x0060;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.util.VersionUtil.mavenVersionFor(java.lang.ClassLoader, java.lang.String, java.lang.String):com.fasterxml.jackson.core.Version");
    }

    @Deprecated
    public static Version parseVersion(String versionStr) {
        return parseVersion(versionStr, null, null);
    }

    public static Version parseVersion(String versionStr, String groupId, String artifactId) {
        String snapshot = null;
        if (versionStr == null) {
            return null;
        }
        versionStr = versionStr.trim();
        if (versionStr.length() == 0) {
            return null;
        }
        int minor;
        int patch;
        String[] parts = VERSION_SEPARATOR.split(versionStr);
        int major = parseVersionPart(parts[0]);
        if (parts.length > 1) {
            minor = parseVersionPart(parts[1]);
        } else {
            minor = 0;
        }
        if (parts.length > 2) {
            patch = parseVersionPart(parts[2]);
        } else {
            patch = 0;
        }
        if (parts.length > 3) {
            snapshot = parts[3];
        }
        return new Version(major, minor, patch, snapshot, groupId, artifactId);
    }

    protected static int parseVersionPart(String partStr) {
        partStr = partStr.toString();
        int len = partStr.length();
        int number = 0;
        for (int i = 0; i < len; i++) {
            char c = partStr.charAt(i);
            if (c > '9' || c < '0') {
                break;
            }
            number = (number * 10) + (c - 48);
        }
        return number;
    }
}
