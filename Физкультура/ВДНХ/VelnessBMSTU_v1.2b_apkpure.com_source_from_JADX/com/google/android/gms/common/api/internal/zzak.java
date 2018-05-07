package com.google.android.gms.common.api.internal;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zzak extends GoogleApiClient {
    private final String zzfqu;

    public zzak(String str) {
        this.zzfqu = str;
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public void connect() {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public void disconnect() {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    @NonNull
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public boolean hasConnectedApi(@NonNull Api<?> api) {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public boolean isConnected() {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public boolean isConnecting() {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public void reconnect() {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
        throw new UnsupportedOperationException(this.zzfqu);
    }

    public void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
        throw new UnsupportedOperationException(this.zzfqu);
    }
}
