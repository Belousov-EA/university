package com.google.android.gms.tasks;

final class zzb implements Runnable {
    private /* synthetic */ Task zzkua;
    private /* synthetic */ zza zzkub;

    zzb(zza com_google_android_gms_tasks_zza, Task task) {
        this.zzkub = com_google_android_gms_tasks_zza;
        this.zzkua = task;
    }

    public final void run() {
        try {
            this.zzkub.zzktz.setResult(this.zzkub.zzkty.then(this.zzkua));
        } catch (Exception e) {
            if (e.getCause() instanceof Exception) {
                this.zzkub.zzktz.setException((Exception) e.getCause());
            } else {
                this.zzkub.zzktz.setException(e);
            }
        } catch (Exception e2) {
            this.zzkub.zzktz.setException(e2);
        }
    }
}
