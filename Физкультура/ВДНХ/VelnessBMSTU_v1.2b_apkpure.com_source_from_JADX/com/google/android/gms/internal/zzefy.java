package com.google.android.gms.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.database.DatabaseError;
import java.util.ArrayList;
import java.util.List;

final class zzefy implements zzebl, zzefw {
    private /* synthetic */ zzefh zzmvz;
    private final zzeil zzmwm;
    private final zzega zzmwn;

    public zzefy(zzefh com_google_android_gms_internal_zzefh, zzeil com_google_android_gms_internal_zzeil) {
        this.zzmvz = com_google_android_gms_internal_zzefh;
        this.zzmwm = com_google_android_gms_internal_zzeil;
        this.zzmwn = com_google_android_gms_internal_zzefh.zze(com_google_android_gms_internal_zzeil.zzbyz());
    }

    public final List<? extends zzeib> zzb(DatabaseError databaseError) {
        if (databaseError == null) {
            return this.zzmwn != null ? this.zzmvz.zza(this.zzmwn) : this.zzmvz.zzs(this.zzmwm.zzbyz().zzbsy());
        } else {
            zzejc zza = this.zzmvz.zzmlr;
            String valueOf = String.valueOf(this.zzmwm.zzbyz().zzbsy());
            String databaseError2 = databaseError.toString();
            zza.zze(new StringBuilder((String.valueOf(valueOf).length() + 19) + String.valueOf(databaseError2).length()).append("Listen at ").append(valueOf).append(" failed: ").append(databaseError2).toString(), null);
            return this.zzmvz.zza(this.zzmwm.zzbyz(), databaseError);
        }
    }

    public final String zzbuh() {
        return this.zzmwm.zzbza().zzbzt();
    }

    public final boolean zzbui() {
        return zzelo.zzn(this.zzmwm.zzbza()) > PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
    }

    public final zzebb zzbuj() {
        zzejn zzh = zzejn.zzh(this.zzmwm.zzbza());
        List<zzedk> zzbtz = zzh.zzbtz();
        List arrayList = new ArrayList(zzbtz.size());
        for (zzedk zzbwg : zzbtz) {
            arrayList.add(zzbwg.zzbwg());
        }
        return new zzebb(arrayList, zzh.zzbua());
    }
}
