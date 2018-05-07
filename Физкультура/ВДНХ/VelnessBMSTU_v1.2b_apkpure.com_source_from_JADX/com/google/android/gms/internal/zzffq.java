package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzffq<FieldDescriptorType extends zzffs<FieldDescriptorType>> {
    private static final zzffq zzpgm = new zzffq(true);
    private boolean zzktj;
    private final zzfhy<FieldDescriptorType, Object> zzpgk = zzfhy.zzma(16);
    private boolean zzpgl = false;

    private zzffq() {
    }

    private zzffq(boolean z) {
        if (!this.zzktj) {
            this.zzpgk.zzbiy();
            this.zzktj = true;
        }
    }

    static int zza(zzfiy com_google_android_gms_internal_zzfiy, int i, Object obj) {
        int i2;
        int zzlg = zzffg.zzlg(i);
        if (com_google_android_gms_internal_zzfiy == zzfiy.GROUP) {
            zzffz.zzh((zzfhe) obj);
            i2 = zzlg << 1;
        } else {
            i2 = zzlg;
        }
        return i2 + zzb(com_google_android_gms_internal_zzfiy, obj);
    }

    public static Object zza(zzffb com_google_android_gms_internal_zzffb, zzfiy com_google_android_gms_internal_zzfiy, boolean z) throws IOException {
        zzfje com_google_android_gms_internal_zzfje = zzfje.STRICT;
        switch (zzfix.zzpgo[com_google_android_gms_internal_zzfiy.ordinal()]) {
            case 1:
                return Double.valueOf(com_google_android_gms_internal_zzffb.readDouble());
            case 2:
                return Float.valueOf(com_google_android_gms_internal_zzffb.readFloat());
            case 3:
                return Long.valueOf(com_google_android_gms_internal_zzffb.zzcvv());
            case 4:
                return Long.valueOf(com_google_android_gms_internal_zzffb.zzcvu());
            case 5:
                return Integer.valueOf(com_google_android_gms_internal_zzffb.zzcvw());
            case 6:
                return Long.valueOf(com_google_android_gms_internal_zzffb.zzcvx());
            case 7:
                return Integer.valueOf(com_google_android_gms_internal_zzffb.zzcvy());
            case 8:
                return Boolean.valueOf(com_google_android_gms_internal_zzffb.zzcvz());
            case 9:
                return com_google_android_gms_internal_zzffb.zzcwb();
            case 10:
                return Integer.valueOf(com_google_android_gms_internal_zzffb.zzcwc());
            case 11:
                return Integer.valueOf(com_google_android_gms_internal_zzffb.zzcwe());
            case 12:
                return Long.valueOf(com_google_android_gms_internal_zzffb.zzcwf());
            case 13:
                return Integer.valueOf(com_google_android_gms_internal_zzffb.zzcwg());
            case 14:
                return Long.valueOf(com_google_android_gms_internal_zzffb.zzcwh());
            case 15:
                return com_google_android_gms_internal_zzfje.zza(com_google_android_gms_internal_zzffb);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    static void zza(zzffg com_google_android_gms_internal_zzffg, zzfiy com_google_android_gms_internal_zzfiy, int i, Object obj) throws IOException {
        if (com_google_android_gms_internal_zzfiy == zzfiy.GROUP) {
            zzffz.zzh((zzfhe) obj);
            com_google_android_gms_internal_zzffg.zze(i, (zzfhe) obj);
            return;
        }
        com_google_android_gms_internal_zzffg.zzz(i, com_google_android_gms_internal_zzfiy.zzdae());
        switch (zzffr.zzpgo[com_google_android_gms_internal_zzfiy.ordinal()]) {
            case 1:
                com_google_android_gms_internal_zzffg.zzn(((Double) obj).doubleValue());
                return;
            case 2:
                com_google_android_gms_internal_zzffg.zzf(((Float) obj).floatValue());
                return;
            case 3:
                com_google_android_gms_internal_zzffg.zzct(((Long) obj).longValue());
                return;
            case 4:
                com_google_android_gms_internal_zzffg.zzct(((Long) obj).longValue());
                return;
            case 5:
                com_google_android_gms_internal_zzffg.zzlc(((Integer) obj).intValue());
                return;
            case 6:
                com_google_android_gms_internal_zzffg.zzcv(((Long) obj).longValue());
                return;
            case 7:
                com_google_android_gms_internal_zzffg.zzlf(((Integer) obj).intValue());
                return;
            case 8:
                com_google_android_gms_internal_zzffg.zzdd(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzfhe) obj).zza(com_google_android_gms_internal_zzffg);
                return;
            case 10:
                com_google_android_gms_internal_zzffg.zze((zzfhe) obj);
                return;
            case 11:
                if (obj instanceof zzfes) {
                    com_google_android_gms_internal_zzffg.zzay((zzfes) obj);
                    return;
                } else {
                    com_google_android_gms_internal_zzffg.zzts((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzfes) {
                    com_google_android_gms_internal_zzffg.zzay((zzfes) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                com_google_android_gms_internal_zzffg.zzi(bArr, 0, bArr.length);
                return;
            case 13:
                com_google_android_gms_internal_zzffg.zzld(((Integer) obj).intValue());
                return;
            case 14:
                com_google_android_gms_internal_zzffg.zzlf(((Integer) obj).intValue());
                return;
            case 15:
                com_google_android_gms_internal_zzffg.zzcv(((Long) obj).longValue());
                return;
            case 16:
                com_google_android_gms_internal_zzffg.zzle(((Integer) obj).intValue());
                return;
            case 17:
                com_google_android_gms_internal_zzffg.zzcu(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfga) {
                    com_google_android_gms_internal_zzffg.zzlc(((zzfga) obj).zzhq());
                    return;
                } else {
                    com_google_android_gms_internal_zzffg.zzlc(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private void zza(FieldDescriptorType fieldDescriptorType, Object obj) {
        Object obj2;
        if (!fieldDescriptorType.zzcxj()) {
            zza(fieldDescriptorType.zzcxh(), obj);
            obj2 = obj;
        } else if (obj instanceof List) {
            obj2 = new ArrayList();
            obj2.addAll((List) obj);
            ArrayList arrayList = (ArrayList) obj2;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj3 = arrayList.get(i);
                i++;
                zza(fieldDescriptorType.zzcxh(), obj3);
            }
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj2 instanceof zzfgg) {
            this.zzpgl = true;
        }
        this.zzpgk.zza((Comparable) fieldDescriptorType, obj2);
    }

    private static void zza(zzfiy com_google_android_gms_internal_zzfiy, Object obj) {
        boolean z = false;
        zzffz.checkNotNull(obj);
        switch (zzffr.zzpgn[com_google_android_gms_internal_zzfiy.zzdad().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if ((obj instanceof zzfes) || (obj instanceof byte[])) {
                    z = true;
                    break;
                }
            case 8:
                if ((obj instanceof Integer) || (obj instanceof zzfga)) {
                    z = true;
                    break;
                }
            case 9:
                if ((obj instanceof zzfhe) || (obj instanceof zzfgg)) {
                    z = true;
                    break;
                }
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static int zzb(zzffs<?> com_google_android_gms_internal_zzffs_, Object obj) {
        int i = 0;
        zzfiy zzcxh = com_google_android_gms_internal_zzffs_.zzcxh();
        int zzhq = com_google_android_gms_internal_zzffs_.zzhq();
        if (!com_google_android_gms_internal_zzffs_.zzcxj()) {
            return zza(zzcxh, zzhq, obj);
        }
        if (com_google_android_gms_internal_zzffs_.zzcxk()) {
            for (Object zzb : (List) obj) {
                i += zzb(zzcxh, zzb);
            }
            return zzffg.zzlp(i) + (zzffg.zzlg(zzhq) + i);
        }
        for (Object zzb2 : (List) obj) {
            i += zza(zzcxh, zzhq, zzb2);
        }
        return i;
    }

    private static int zzb(zzfiy com_google_android_gms_internal_zzfiy, Object obj) {
        switch (zzffr.zzpgo[com_google_android_gms_internal_zzfiy.ordinal()]) {
            case 1:
                return zzffg.zzo(((Double) obj).doubleValue());
            case 2:
                return zzffg.zzg(((Float) obj).floatValue());
            case 3:
                return zzffg.zzcw(((Long) obj).longValue());
            case 4:
                return zzffg.zzcx(((Long) obj).longValue());
            case 5:
                return zzffg.zzlh(((Integer) obj).intValue());
            case 6:
                return zzffg.zzcz(((Long) obj).longValue());
            case 7:
                return zzffg.zzlk(((Integer) obj).intValue());
            case 8:
                return zzffg.zzde(((Boolean) obj).booleanValue());
            case 9:
                return zzffg.zzg((zzfhe) obj);
            case 10:
                return obj instanceof zzfgg ? zzffg.zza((zzfgg) obj) : zzffg.zzf((zzfhe) obj);
            case 11:
                return obj instanceof zzfes ? zzffg.zzaz((zzfes) obj) : zzffg.zztt((String) obj);
            case 12:
                return obj instanceof zzfes ? zzffg.zzaz((zzfes) obj) : zzffg.zzbd((byte[]) obj);
            case 13:
                return zzffg.zzli(((Integer) obj).intValue());
            case 14:
                return zzffg.zzll(((Integer) obj).intValue());
            case 15:
                return zzffg.zzda(((Long) obj).longValue());
            case 16:
                return zzffg.zzlj(((Integer) obj).intValue());
            case 17:
                return zzffg.zzcy(((Long) obj).longValue());
            case 18:
                return obj instanceof zzfga ? zzffg.zzlm(((zzfga) obj).zzhq()) : zzffg.zzlm(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static int zzb(Entry<FieldDescriptorType, Object> entry) {
        zzffs com_google_android_gms_internal_zzffs = (zzffs) entry.getKey();
        Object value = entry.getValue();
        return (com_google_android_gms_internal_zzffs.zzcxi() != zzfjd.MESSAGE || com_google_android_gms_internal_zzffs.zzcxj() || com_google_android_gms_internal_zzffs.zzcxk()) ? zzb(com_google_android_gms_internal_zzffs, value) : value instanceof zzfgg ? zzffg.zzb(((zzffs) entry.getKey()).zzhq(), (zzfgg) value) : zzffg.zzd(((zzffs) entry.getKey()).zzhq(), (zzfhe) value);
    }

    public static <T extends zzffs<T>> zzffq<T> zzcxf() {
        return new zzffq();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzffq com_google_android_gms_internal_zzffq = new zzffq();
        for (int i = 0; i < this.zzpgk.zzczj(); i++) {
            Entry zzmb = this.zzpgk.zzmb(i);
            com_google_android_gms_internal_zzffq.zza((zzffs) zzmb.getKey(), zzmb.getValue());
        }
        for (Entry entry : this.zzpgk.zzczk()) {
            com_google_android_gms_internal_zzffq.zza((zzffs) entry.getKey(), entry.getValue());
        }
        com_google_android_gms_internal_zzffq.zzpgl = this.zzpgl;
        return com_google_android_gms_internal_zzffq;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzffq)) {
            return false;
        }
        return this.zzpgk.equals(((zzffq) obj).zzpgk);
    }

    public final int hashCode() {
        return this.zzpgk.hashCode();
    }

    public final Iterator<Entry<FieldDescriptorType, Object>> iterator() {
        return this.zzpgl ? new zzfgj(this.zzpgk.entrySet().iterator()) : this.zzpgk.entrySet().iterator();
    }

    public final int zzcxg() {
        int i = 0;
        int i2 = 0;
        while (i < this.zzpgk.zzczj()) {
            i2 += zzb(this.zzpgk.zzmb(i));
            i++;
        }
        for (Entry zzb : this.zzpgk.zzczk()) {
            i2 += zzb(zzb);
        }
        return i2;
    }
}
