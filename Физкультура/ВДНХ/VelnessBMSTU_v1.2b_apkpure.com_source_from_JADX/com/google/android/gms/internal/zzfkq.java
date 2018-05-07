package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class zzfkq extends zzfjm<zzfkq> implements Cloneable {
    private String tag;
    private int zzala;
    private boolean zzmsn;
    private zzfks zzofi;
    public long zzpql;
    public long zzpqm;
    private long zzpqn;
    private int zzpqo;
    private zzfkr[] zzpqp;
    private byte[] zzpqq;
    private zzfko zzpqr;
    public byte[] zzpqs;
    private String zzpqt;
    private String zzpqu;
    private zzfkn zzpqv;
    private String zzpqw;
    public long zzpqx;
    private zzfkp zzpqy;
    public byte[] zzpqz;
    private String zzpra;
    private int zzprb;
    private int[] zzprc;
    private long zzprd;

    public zzfkq() {
        this.zzpql = 0;
        this.zzpqm = 0;
        this.zzpqn = 0;
        this.tag = "";
        this.zzpqo = 0;
        this.zzala = 0;
        this.zzmsn = false;
        this.zzpqp = zzfkr.zzdba();
        this.zzpqq = zzfjv.zzpnv;
        this.zzpqr = null;
        this.zzpqs = zzfjv.zzpnv;
        this.zzpqt = "";
        this.zzpqu = "";
        this.zzpqv = null;
        this.zzpqw = "";
        this.zzpqx = 180000;
        this.zzpqy = null;
        this.zzpqz = zzfjv.zzpnv;
        this.zzpra = "";
        this.zzprb = 0;
        this.zzprc = zzfjv.zzpnp;
        this.zzprd = 0;
        this.zzofi = null;
        this.zzpnc = null;
        this.zzpfd = -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.zzfkq zzar(com.google.android.gms.internal.zzfjj r8) throws java.io.IOException {
        /*
        r7 = this;
        r1 = 0;
    L_0x0001:
        r0 = r8.zzcvt();
        switch(r0) {
            case 0: goto L_0x000e;
            case 8: goto L_0x000f;
            case 18: goto L_0x0016;
            case 26: goto L_0x001d;
            case 34: goto L_0x005c;
            case 50: goto L_0x0063;
            case 58: goto L_0x006a;
            case 66: goto L_0x007b;
            case 74: goto L_0x0082;
            case 80: goto L_0x0094;
            case 88: goto L_0x009c;
            case 96: goto L_0x00a4;
            case 106: goto L_0x00ac;
            case 114: goto L_0x00b4;
            case 120: goto L_0x00bc;
            case 130: goto L_0x00c4;
            case 136: goto L_0x00d6;
            case 146: goto L_0x00de;
            case 152: goto L_0x00e6;
            case 160: goto L_0x0119;
            case 162: goto L_0x014d;
            case 168: goto L_0x018f;
            case 176: goto L_0x0197;
            case 186: goto L_0x019f;
            case 194: goto L_0x01b1;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = super.zza(r8, r0);
        if (r0 != 0) goto L_0x0001;
    L_0x000e:
        return r7;
    L_0x000f:
        r2 = r8.zzcvv();
        r7.zzpql = r2;
        goto L_0x0001;
    L_0x0016:
        r0 = r8.readString();
        r7.tag = r0;
        goto L_0x0001;
    L_0x001d:
        r0 = 26;
        r2 = com.google.android.gms.internal.zzfjv.zzb(r8, r0);
        r0 = r7.zzpqp;
        if (r0 != 0) goto L_0x0049;
    L_0x0027:
        r0 = r1;
    L_0x0028:
        r2 = r2 + r0;
        r2 = new com.google.android.gms.internal.zzfkr[r2];
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r3 = r7.zzpqp;
        java.lang.System.arraycopy(r3, r1, r2, r1, r0);
    L_0x0032:
        r3 = r2.length;
        r3 = r3 + -1;
        if (r0 >= r3) goto L_0x004d;
    L_0x0037:
        r3 = new com.google.android.gms.internal.zzfkr;
        r3.<init>();
        r2[r0] = r3;
        r3 = r2[r0];
        r8.zza(r3);
        r8.zzcvt();
        r0 = r0 + 1;
        goto L_0x0032;
    L_0x0049:
        r0 = r7.zzpqp;
        r0 = r0.length;
        goto L_0x0028;
    L_0x004d:
        r3 = new com.google.android.gms.internal.zzfkr;
        r3.<init>();
        r2[r0] = r3;
        r0 = r2[r0];
        r8.zza(r0);
        r7.zzpqp = r2;
        goto L_0x0001;
    L_0x005c:
        r0 = r8.readBytes();
        r7.zzpqq = r0;
        goto L_0x0001;
    L_0x0063:
        r0 = r8.readBytes();
        r7.zzpqs = r0;
        goto L_0x0001;
    L_0x006a:
        r0 = r7.zzpqv;
        if (r0 != 0) goto L_0x0075;
    L_0x006e:
        r0 = new com.google.android.gms.internal.zzfkn;
        r0.<init>();
        r7.zzpqv = r0;
    L_0x0075:
        r0 = r7.zzpqv;
        r8.zza(r0);
        goto L_0x0001;
    L_0x007b:
        r0 = r8.readString();
        r7.zzpqt = r0;
        goto L_0x0001;
    L_0x0082:
        r0 = r7.zzpqr;
        if (r0 != 0) goto L_0x008d;
    L_0x0086:
        r0 = new com.google.android.gms.internal.zzfko;
        r0.<init>();
        r7.zzpqr = r0;
    L_0x008d:
        r0 = r7.zzpqr;
        r8.zza(r0);
        goto L_0x0001;
    L_0x0094:
        r0 = r8.zzcvz();
        r7.zzmsn = r0;
        goto L_0x0001;
    L_0x009c:
        r0 = r8.zzcvw();
        r7.zzpqo = r0;
        goto L_0x0001;
    L_0x00a4:
        r0 = r8.zzcvw();
        r7.zzala = r0;
        goto L_0x0001;
    L_0x00ac:
        r0 = r8.readString();
        r7.zzpqu = r0;
        goto L_0x0001;
    L_0x00b4:
        r0 = r8.readString();
        r7.zzpqw = r0;
        goto L_0x0001;
    L_0x00bc:
        r2 = r8.zzcwh();
        r7.zzpqx = r2;
        goto L_0x0001;
    L_0x00c4:
        r0 = r7.zzpqy;
        if (r0 != 0) goto L_0x00cf;
    L_0x00c8:
        r0 = new com.google.android.gms.internal.zzfkp;
        r0.<init>();
        r7.zzpqy = r0;
    L_0x00cf:
        r0 = r7.zzpqy;
        r8.zza(r0);
        goto L_0x0001;
    L_0x00d6:
        r2 = r8.zzcvv();
        r7.zzpqm = r2;
        goto L_0x0001;
    L_0x00de:
        r0 = r8.readBytes();
        r7.zzpqz = r0;
        goto L_0x0001;
    L_0x00e6:
        r2 = r8.getPosition();
        r3 = r8.zzcvw();	 Catch:{ IllegalArgumentException -> 0x010c }
        switch(r3) {
            case 0: goto L_0x0115;
            case 1: goto L_0x0115;
            case 2: goto L_0x0115;
            default: goto L_0x00f1;
        };	 Catch:{ IllegalArgumentException -> 0x010c }
    L_0x00f1:
        r4 = new java.lang.IllegalArgumentException;	 Catch:{ IllegalArgumentException -> 0x010c }
        r5 = 45;
        r6 = new java.lang.StringBuilder;	 Catch:{ IllegalArgumentException -> 0x010c }
        r6.<init>(r5);	 Catch:{ IllegalArgumentException -> 0x010c }
        r3 = r6.append(r3);	 Catch:{ IllegalArgumentException -> 0x010c }
        r5 = " is not a valid enum InternalEvent";
        r3 = r3.append(r5);	 Catch:{ IllegalArgumentException -> 0x010c }
        r3 = r3.toString();	 Catch:{ IllegalArgumentException -> 0x010c }
        r4.<init>(r3);	 Catch:{ IllegalArgumentException -> 0x010c }
        throw r4;	 Catch:{ IllegalArgumentException -> 0x010c }
    L_0x010c:
        r3 = move-exception;
        r8.zzmg(r2);
        r7.zza(r8, r0);
        goto L_0x0001;
    L_0x0115:
        r7.zzprb = r3;	 Catch:{ IllegalArgumentException -> 0x010c }
        goto L_0x0001;
    L_0x0119:
        r0 = 160; // 0xa0 float:2.24E-43 double:7.9E-322;
        r2 = com.google.android.gms.internal.zzfjv.zzb(r8, r0);
        r0 = r7.zzprc;
        if (r0 != 0) goto L_0x013f;
    L_0x0123:
        r0 = r1;
    L_0x0124:
        r2 = r2 + r0;
        r2 = new int[r2];
        if (r0 == 0) goto L_0x012e;
    L_0x0129:
        r3 = r7.zzprc;
        java.lang.System.arraycopy(r3, r1, r2, r1, r0);
    L_0x012e:
        r3 = r2.length;
        r3 = r3 + -1;
        if (r0 >= r3) goto L_0x0143;
    L_0x0133:
        r3 = r8.zzcvw();
        r2[r0] = r3;
        r8.zzcvt();
        r0 = r0 + 1;
        goto L_0x012e;
    L_0x013f:
        r0 = r7.zzprc;
        r0 = r0.length;
        goto L_0x0124;
    L_0x0143:
        r3 = r8.zzcvw();
        r2[r0] = r3;
        r7.zzprc = r2;
        goto L_0x0001;
    L_0x014d:
        r0 = r8.zzcwi();
        r3 = r8.zzks(r0);
        r2 = r8.getPosition();
        r0 = r1;
    L_0x015a:
        r4 = r8.zzcwk();
        if (r4 <= 0) goto L_0x0166;
    L_0x0160:
        r8.zzcvw();
        r0 = r0 + 1;
        goto L_0x015a;
    L_0x0166:
        r8.zzmg(r2);
        r2 = r7.zzprc;
        if (r2 != 0) goto L_0x0184;
    L_0x016d:
        r2 = r1;
    L_0x016e:
        r0 = r0 + r2;
        r0 = new int[r0];
        if (r2 == 0) goto L_0x0178;
    L_0x0173:
        r4 = r7.zzprc;
        java.lang.System.arraycopy(r4, r1, r0, r1, r2);
    L_0x0178:
        r4 = r0.length;
        if (r2 >= r4) goto L_0x0188;
    L_0x017b:
        r4 = r8.zzcvw();
        r0[r2] = r4;
        r2 = r2 + 1;
        goto L_0x0178;
    L_0x0184:
        r2 = r7.zzprc;
        r2 = r2.length;
        goto L_0x016e;
    L_0x0188:
        r7.zzprc = r0;
        r8.zzkt(r3);
        goto L_0x0001;
    L_0x018f:
        r2 = r8.zzcvv();
        r7.zzpqn = r2;
        goto L_0x0001;
    L_0x0197:
        r2 = r8.zzcvv();
        r7.zzprd = r2;
        goto L_0x0001;
    L_0x019f:
        r0 = r7.zzofi;
        if (r0 != 0) goto L_0x01aa;
    L_0x01a3:
        r0 = new com.google.android.gms.internal.zzfks;
        r0.<init>();
        r7.zzofi = r0;
    L_0x01aa:
        r0 = r7.zzofi;
        r8.zza(r0);
        goto L_0x0001;
    L_0x01b1:
        r0 = r8.readString();
        r7.zzpra = r0;
        goto L_0x0001;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfkq.zzar(com.google.android.gms.internal.zzfjj):com.google.android.gms.internal.zzfkq");
    }

    private final zzfkq zzdaz() {
        try {
            zzfkq com_google_android_gms_internal_zzfkq = (zzfkq) super.zzdaf();
            if (this.zzpqp != null && this.zzpqp.length > 0) {
                com_google_android_gms_internal_zzfkq.zzpqp = new zzfkr[this.zzpqp.length];
                for (int i = 0; i < this.zzpqp.length; i++) {
                    if (this.zzpqp[i] != null) {
                        com_google_android_gms_internal_zzfkq.zzpqp[i] = (zzfkr) this.zzpqp[i].clone();
                    }
                }
            }
            if (this.zzpqr != null) {
                com_google_android_gms_internal_zzfkq.zzpqr = (zzfko) this.zzpqr.clone();
            }
            if (this.zzpqv != null) {
                com_google_android_gms_internal_zzfkq.zzpqv = (zzfkn) this.zzpqv.clone();
            }
            if (this.zzpqy != null) {
                com_google_android_gms_internal_zzfkq.zzpqy = (zzfkp) this.zzpqy.clone();
            }
            if (this.zzprc != null && this.zzprc.length > 0) {
                com_google_android_gms_internal_zzfkq.zzprc = (int[]) this.zzprc.clone();
            }
            if (this.zzofi != null) {
                com_google_android_gms_internal_zzfkq.zzofi = (zzfks) this.zzofi.clone();
            }
            return com_google_android_gms_internal_zzfkq;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        return zzdaz();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzfkq)) {
            return false;
        }
        zzfkq com_google_android_gms_internal_zzfkq = (zzfkq) obj;
        if (this.zzpql != com_google_android_gms_internal_zzfkq.zzpql) {
            return false;
        }
        if (this.zzpqm != com_google_android_gms_internal_zzfkq.zzpqm) {
            return false;
        }
        if (this.zzpqn != com_google_android_gms_internal_zzfkq.zzpqn) {
            return false;
        }
        if (this.tag == null) {
            if (com_google_android_gms_internal_zzfkq.tag != null) {
                return false;
            }
        } else if (!this.tag.equals(com_google_android_gms_internal_zzfkq.tag)) {
            return false;
        }
        if (this.zzpqo != com_google_android_gms_internal_zzfkq.zzpqo) {
            return false;
        }
        if (this.zzala != com_google_android_gms_internal_zzfkq.zzala) {
            return false;
        }
        if (this.zzmsn != com_google_android_gms_internal_zzfkq.zzmsn) {
            return false;
        }
        if (!zzfjq.equals(this.zzpqp, com_google_android_gms_internal_zzfkq.zzpqp)) {
            return false;
        }
        if (!Arrays.equals(this.zzpqq, com_google_android_gms_internal_zzfkq.zzpqq)) {
            return false;
        }
        if (this.zzpqr == null) {
            if (com_google_android_gms_internal_zzfkq.zzpqr != null) {
                return false;
            }
        } else if (!this.zzpqr.equals(com_google_android_gms_internal_zzfkq.zzpqr)) {
            return false;
        }
        if (!Arrays.equals(this.zzpqs, com_google_android_gms_internal_zzfkq.zzpqs)) {
            return false;
        }
        if (this.zzpqt == null) {
            if (com_google_android_gms_internal_zzfkq.zzpqt != null) {
                return false;
            }
        } else if (!this.zzpqt.equals(com_google_android_gms_internal_zzfkq.zzpqt)) {
            return false;
        }
        if (this.zzpqu == null) {
            if (com_google_android_gms_internal_zzfkq.zzpqu != null) {
                return false;
            }
        } else if (!this.zzpqu.equals(com_google_android_gms_internal_zzfkq.zzpqu)) {
            return false;
        }
        if (this.zzpqv == null) {
            if (com_google_android_gms_internal_zzfkq.zzpqv != null) {
                return false;
            }
        } else if (!this.zzpqv.equals(com_google_android_gms_internal_zzfkq.zzpqv)) {
            return false;
        }
        if (this.zzpqw == null) {
            if (com_google_android_gms_internal_zzfkq.zzpqw != null) {
                return false;
            }
        } else if (!this.zzpqw.equals(com_google_android_gms_internal_zzfkq.zzpqw)) {
            return false;
        }
        if (this.zzpqx != com_google_android_gms_internal_zzfkq.zzpqx) {
            return false;
        }
        if (this.zzpqy == null) {
            if (com_google_android_gms_internal_zzfkq.zzpqy != null) {
                return false;
            }
        } else if (!this.zzpqy.equals(com_google_android_gms_internal_zzfkq.zzpqy)) {
            return false;
        }
        if (!Arrays.equals(this.zzpqz, com_google_android_gms_internal_zzfkq.zzpqz)) {
            return false;
        }
        if (this.zzpra == null) {
            if (com_google_android_gms_internal_zzfkq.zzpra != null) {
                return false;
            }
        } else if (!this.zzpra.equals(com_google_android_gms_internal_zzfkq.zzpra)) {
            return false;
        }
        if (this.zzprb != com_google_android_gms_internal_zzfkq.zzprb) {
            return false;
        }
        if (!zzfjq.equals(this.zzprc, com_google_android_gms_internal_zzfkq.zzprc)) {
            return false;
        }
        if (this.zzprd != com_google_android_gms_internal_zzfkq.zzprd) {
            return false;
        }
        if (this.zzofi == null) {
            if (com_google_android_gms_internal_zzfkq.zzofi != null) {
                return false;
            }
        } else if (!this.zzofi.equals(com_google_android_gms_internal_zzfkq.zzofi)) {
            return false;
        }
        return (this.zzpnc == null || this.zzpnc.isEmpty()) ? com_google_android_gms_internal_zzfkq.zzpnc == null || com_google_android_gms_internal_zzfkq.zzpnc.isEmpty() : this.zzpnc.equals(com_google_android_gms_internal_zzfkq.zzpnc);
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = (((((this.zzmsn ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.zzpql ^ (this.zzpql >>> 32)))) * 31) + ((int) (this.zzpqm ^ (this.zzpqm >>> 32)))) * 31) + ((int) (this.zzpqn ^ (this.zzpqn >>> 32)))) * 31)) * 31) + this.zzpqo) * 31) + this.zzala) * 31)) * 31) + zzfjq.hashCode(this.zzpqp)) * 31) + Arrays.hashCode(this.zzpqq);
        zzfko com_google_android_gms_internal_zzfko = this.zzpqr;
        hashCode = (this.zzpqu == null ? 0 : this.zzpqu.hashCode()) + (((this.zzpqt == null ? 0 : this.zzpqt.hashCode()) + (((((com_google_android_gms_internal_zzfko == null ? 0 : com_google_android_gms_internal_zzfko.hashCode()) + (hashCode * 31)) * 31) + Arrays.hashCode(this.zzpqs)) * 31)) * 31);
        zzfkn com_google_android_gms_internal_zzfkn = this.zzpqv;
        hashCode = (((this.zzpqw == null ? 0 : this.zzpqw.hashCode()) + (((com_google_android_gms_internal_zzfkn == null ? 0 : com_google_android_gms_internal_zzfkn.hashCode()) + (hashCode * 31)) * 31)) * 31) + ((int) (this.zzpqx ^ (this.zzpqx >>> 32)));
        zzfkp com_google_android_gms_internal_zzfkp = this.zzpqy;
        hashCode = (((((((this.zzpra == null ? 0 : this.zzpra.hashCode()) + (((((com_google_android_gms_internal_zzfkp == null ? 0 : com_google_android_gms_internal_zzfkp.hashCode()) + (hashCode * 31)) * 31) + Arrays.hashCode(this.zzpqz)) * 31)) * 31) + this.zzprb) * 31) + zzfjq.hashCode(this.zzprc)) * 31) + ((int) (this.zzprd ^ (this.zzprd >>> 32)));
        zzfks com_google_android_gms_internal_zzfks = this.zzofi;
        hashCode = ((com_google_android_gms_internal_zzfks == null ? 0 : com_google_android_gms_internal_zzfks.hashCode()) + (hashCode * 31)) * 31;
        if (!(this.zzpnc == null || this.zzpnc.isEmpty())) {
            i = this.zzpnc.hashCode();
        }
        return hashCode + i;
    }

    public final /* synthetic */ zzfjs zza(zzfjj com_google_android_gms_internal_zzfjj) throws IOException {
        return zzar(com_google_android_gms_internal_zzfjj);
    }

    public final void zza(zzfjk com_google_android_gms_internal_zzfjk) throws IOException {
        int i = 0;
        if (this.zzpql != 0) {
            com_google_android_gms_internal_zzfjk.zzf(1, this.zzpql);
        }
        if (!(this.tag == null || this.tag.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(2, this.tag);
        }
        if (this.zzpqp != null && this.zzpqp.length > 0) {
            for (zzfjs com_google_android_gms_internal_zzfjs : this.zzpqp) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    com_google_android_gms_internal_zzfjk.zza(3, com_google_android_gms_internal_zzfjs);
                }
            }
        }
        if (!Arrays.equals(this.zzpqq, zzfjv.zzpnv)) {
            com_google_android_gms_internal_zzfjk.zzc(4, this.zzpqq);
        }
        if (!Arrays.equals(this.zzpqs, zzfjv.zzpnv)) {
            com_google_android_gms_internal_zzfjk.zzc(6, this.zzpqs);
        }
        if (this.zzpqv != null) {
            com_google_android_gms_internal_zzfjk.zza(7, this.zzpqv);
        }
        if (!(this.zzpqt == null || this.zzpqt.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(8, this.zzpqt);
        }
        if (this.zzpqr != null) {
            com_google_android_gms_internal_zzfjk.zza(9, this.zzpqr);
        }
        if (this.zzmsn) {
            com_google_android_gms_internal_zzfjk.zzl(10, this.zzmsn);
        }
        if (this.zzpqo != 0) {
            com_google_android_gms_internal_zzfjk.zzaa(11, this.zzpqo);
        }
        if (this.zzala != 0) {
            com_google_android_gms_internal_zzfjk.zzaa(12, this.zzala);
        }
        if (!(this.zzpqu == null || this.zzpqu.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(13, this.zzpqu);
        }
        if (!(this.zzpqw == null || this.zzpqw.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(14, this.zzpqw);
        }
        if (this.zzpqx != 180000) {
            com_google_android_gms_internal_zzfjk.zzg(15, this.zzpqx);
        }
        if (this.zzpqy != null) {
            com_google_android_gms_internal_zzfjk.zza(16, this.zzpqy);
        }
        if (this.zzpqm != 0) {
            com_google_android_gms_internal_zzfjk.zzf(17, this.zzpqm);
        }
        if (!Arrays.equals(this.zzpqz, zzfjv.zzpnv)) {
            com_google_android_gms_internal_zzfjk.zzc(18, this.zzpqz);
        }
        if (this.zzprb != 0) {
            com_google_android_gms_internal_zzfjk.zzaa(19, this.zzprb);
        }
        if (this.zzprc != null && this.zzprc.length > 0) {
            while (i < this.zzprc.length) {
                com_google_android_gms_internal_zzfjk.zzaa(20, this.zzprc[i]);
                i++;
            }
        }
        if (this.zzpqn != 0) {
            com_google_android_gms_internal_zzfjk.zzf(21, this.zzpqn);
        }
        if (this.zzprd != 0) {
            com_google_android_gms_internal_zzfjk.zzf(22, this.zzprd);
        }
        if (this.zzofi != null) {
            com_google_android_gms_internal_zzfjk.zza(23, this.zzofi);
        }
        if (!(this.zzpra == null || this.zzpra.equals(""))) {
            com_google_android_gms_internal_zzfjk.zzn(24, this.zzpra);
        }
        super.zza(com_google_android_gms_internal_zzfjk);
    }

    public final /* synthetic */ zzfjm zzdaf() throws CloneNotSupportedException {
        return (zzfkq) clone();
    }

    public final /* synthetic */ zzfjs zzdag() throws CloneNotSupportedException {
        return (zzfkq) clone();
    }

    protected final int zzq() {
        int i;
        int i2 = 0;
        int zzq = super.zzq();
        if (this.zzpql != 0) {
            zzq += zzfjk.zzc(1, this.zzpql);
        }
        if (!(this.tag == null || this.tag.equals(""))) {
            zzq += zzfjk.zzo(2, this.tag);
        }
        if (this.zzpqp != null && this.zzpqp.length > 0) {
            i = zzq;
            for (zzfjs com_google_android_gms_internal_zzfjs : this.zzpqp) {
                if (com_google_android_gms_internal_zzfjs != null) {
                    i += zzfjk.zzb(3, com_google_android_gms_internal_zzfjs);
                }
            }
            zzq = i;
        }
        if (!Arrays.equals(this.zzpqq, zzfjv.zzpnv)) {
            zzq += zzfjk.zzd(4, this.zzpqq);
        }
        if (!Arrays.equals(this.zzpqs, zzfjv.zzpnv)) {
            zzq += zzfjk.zzd(6, this.zzpqs);
        }
        if (this.zzpqv != null) {
            zzq += zzfjk.zzb(7, this.zzpqv);
        }
        if (!(this.zzpqt == null || this.zzpqt.equals(""))) {
            zzq += zzfjk.zzo(8, this.zzpqt);
        }
        if (this.zzpqr != null) {
            zzq += zzfjk.zzb(9, this.zzpqr);
        }
        if (this.zzmsn) {
            zzq += zzfjk.zzlg(10) + 1;
        }
        if (this.zzpqo != 0) {
            zzq += zzfjk.zzad(11, this.zzpqo);
        }
        if (this.zzala != 0) {
            zzq += zzfjk.zzad(12, this.zzala);
        }
        if (!(this.zzpqu == null || this.zzpqu.equals(""))) {
            zzq += zzfjk.zzo(13, this.zzpqu);
        }
        if (!(this.zzpqw == null || this.zzpqw.equals(""))) {
            zzq += zzfjk.zzo(14, this.zzpqw);
        }
        if (this.zzpqx != 180000) {
            zzq += zzfjk.zzh(15, this.zzpqx);
        }
        if (this.zzpqy != null) {
            zzq += zzfjk.zzb(16, this.zzpqy);
        }
        if (this.zzpqm != 0) {
            zzq += zzfjk.zzc(17, this.zzpqm);
        }
        if (!Arrays.equals(this.zzpqz, zzfjv.zzpnv)) {
            zzq += zzfjk.zzd(18, this.zzpqz);
        }
        if (this.zzprb != 0) {
            zzq += zzfjk.zzad(19, this.zzprb);
        }
        if (this.zzprc != null && this.zzprc.length > 0) {
            i = 0;
            while (i2 < this.zzprc.length) {
                i += zzfjk.zzlh(this.zzprc[i2]);
                i2++;
            }
            zzq = (zzq + i) + (this.zzprc.length * 2);
        }
        if (this.zzpqn != 0) {
            zzq += zzfjk.zzc(21, this.zzpqn);
        }
        if (this.zzprd != 0) {
            zzq += zzfjk.zzc(22, this.zzprd);
        }
        if (this.zzofi != null) {
            zzq += zzfjk.zzb(23, this.zzofi);
        }
        return (this.zzpra == null || this.zzpra.equals("")) ? zzq : zzq + zzfjk.zzo(24, this.zzpra);
    }
}
