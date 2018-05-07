package com.google.android.gms.internal;

import java.io.PrintStream;
import java.io.PrintWriter;

final class zzdvq extends zzdvm {
    zzdvq() {
    }

    public final void zza(Throwable th, PrintStream printStream) {
        th.printStackTrace(printStream);
    }

    public final void zza(Throwable th, PrintWriter printWriter) {
        th.printStackTrace(printWriter);
    }
}
