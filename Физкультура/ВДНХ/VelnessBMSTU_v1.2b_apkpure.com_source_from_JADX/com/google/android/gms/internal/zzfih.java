package com.google.android.gms.internal;

final class zzfih {
    static String zzbc(zzfes com_google_android_gms_internal_zzfes) {
        zzfij com_google_android_gms_internal_zzfii = new zzfii(com_google_android_gms_internal_zzfes);
        StringBuilder stringBuilder = new StringBuilder(com_google_android_gms_internal_zzfii.size());
        for (int i = 0; i < com_google_android_gms_internal_zzfii.size(); i++) {
            byte zzkn = com_google_android_gms_internal_zzfii.zzkn(i);
            switch (zzkn) {
                case (byte) 7:
                    stringBuilder.append("\\a");
                    break;
                case (byte) 8:
                    stringBuilder.append("\\b");
                    break;
                case (byte) 9:
                    stringBuilder.append("\\t");
                    break;
                case (byte) 10:
                    stringBuilder.append("\\n");
                    break;
                case (byte) 11:
                    stringBuilder.append("\\v");
                    break;
                case (byte) 12:
                    stringBuilder.append("\\f");
                    break;
                case (byte) 13:
                    stringBuilder.append("\\r");
                    break;
                case (byte) 34:
                    stringBuilder.append("\\\"");
                    break;
                case (byte) 39:
                    stringBuilder.append("\\'");
                    break;
                case (byte) 92:
                    stringBuilder.append("\\\\");
                    break;
                default:
                    if (zzkn >= (byte) 32 && zzkn <= (byte) 126) {
                        stringBuilder.append((char) zzkn);
                        break;
                    }
                    stringBuilder.append('\\');
                    stringBuilder.append((char) (((zzkn >>> 6) & 3) + 48));
                    stringBuilder.append((char) (((zzkn >>> 3) & 7) + 48));
                    stringBuilder.append((char) ((zzkn & 7) + 48));
                    break;
            }
        }
        return stringBuilder.toString();
    }
}
