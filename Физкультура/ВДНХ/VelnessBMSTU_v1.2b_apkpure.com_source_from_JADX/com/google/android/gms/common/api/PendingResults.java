package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.common.api.internal.zzco;
import com.google.android.gms.common.api.internal.zzda;
import com.google.android.gms.common.internal.zzbq;

public final class PendingResults {

    static final class zza<R extends Result> extends BasePendingResult<R> {
        private final R zzfnd;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.zzfnd = r;
        }

        protected final R zzb(Status status) {
            if (status.getStatusCode() == this.zzfnd.getStatus().getStatusCode()) {
                return this.zzfnd;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    static final class zzb<R extends Result> extends BasePendingResult<R> {
        private final R zzfne;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.zzfne = r;
        }

        protected final R zzb(Status status) {
            return this.zzfne;
        }
    }

    static final class zzc<R extends Result> extends BasePendingResult<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected final R zzb(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        PendingResult<Status> com_google_android_gms_common_api_internal_zzda = new zzda(Looper.getMainLooper());
        com_google_android_gms_common_api_internal_zzda.cancel();
        return com_google_android_gms_common_api_internal_zzda;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        zzbq.checkNotNull(r, "Result must not be null");
        zzbq.checkArgument(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        PendingResult<R> com_google_android_gms_common_api_PendingResults_zza = new zza(r);
        com_google_android_gms_common_api_PendingResults_zza.cancel();
        return com_google_android_gms_common_api_PendingResults_zza;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        zzbq.checkNotNull(r, "Result must not be null");
        PendingResult com_google_android_gms_common_api_PendingResults_zzc = new zzc(null);
        com_google_android_gms_common_api_PendingResults_zzc.setResult(r);
        return new zzco(com_google_android_gms_common_api_PendingResults_zzc);
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        zzbq.checkNotNull(status, "Result must not be null");
        PendingResult com_google_android_gms_common_api_internal_zzda = new zzda(Looper.getMainLooper());
        com_google_android_gms_common_api_internal_zzda.setResult(status);
        return com_google_android_gms_common_api_internal_zzda;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzbq.checkNotNull(r, "Result must not be null");
        zzbq.checkArgument(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        PendingResult com_google_android_gms_common_api_PendingResults_zzb = new zzb(googleApiClient, r);
        com_google_android_gms_common_api_PendingResults_zzb.setResult(r);
        return com_google_android_gms_common_api_PendingResults_zzb;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzbq.checkNotNull(status, "Result must not be null");
        PendingResult com_google_android_gms_common_api_internal_zzda = new zzda(googleApiClient);
        com_google_android_gms_common_api_internal_zzda.setResult(status);
        return com_google_android_gms_common_api_internal_zzda;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzbq.checkNotNull(r, "Result must not be null");
        PendingResult com_google_android_gms_common_api_PendingResults_zzc = new zzc(googleApiClient);
        com_google_android_gms_common_api_PendingResults_zzc.setResult(r);
        return new zzco(com_google_android_gms_common_api_PendingResults_zzc);
    }
}
