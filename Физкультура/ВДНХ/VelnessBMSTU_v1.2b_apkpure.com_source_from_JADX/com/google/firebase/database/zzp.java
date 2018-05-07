package com.google.firebase.database;

final class zzp implements ValueEventListener {
    private /* synthetic */ ValueEventListener zzmky;
    private /* synthetic */ Query zzmkz;

    zzp(Query query, ValueEventListener valueEventListener) {
        this.zzmkz = query;
        this.zzmky = valueEventListener;
    }

    public final void onCancelled(DatabaseError databaseError) {
        this.zzmky.onCancelled(databaseError);
    }

    public final void onDataChange(DataSnapshot dataSnapshot) {
        this.zzmkz.removeEventListener((ValueEventListener) this);
        this.zzmky.onDataChange(dataSnapshot);
    }
}
