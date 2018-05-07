package com.google.firebase.database;

import com.google.android.gms.internal.zzekd;

public class Transaction {

    public interface Handler {
        Result doTransaction(MutableData mutableData);

        void onComplete(DatabaseError databaseError, boolean z, DataSnapshot dataSnapshot);
    }

    public static class Result {
        private boolean zzmld;
        private zzekd zzmle;

        private Result(boolean z, zzekd com_google_android_gms_internal_zzekd) {
            this.zzmld = z;
            this.zzmle = com_google_android_gms_internal_zzekd;
        }

        public boolean isSuccess() {
            return this.zzmld;
        }

        public final zzekd zzbsv() {
            return this.zzmle;
        }
    }

    public static Result abort() {
        return new Result(false, null);
    }

    public static Result success(MutableData mutableData) {
        return new Result(true, mutableData.zzbsv());
    }
}
