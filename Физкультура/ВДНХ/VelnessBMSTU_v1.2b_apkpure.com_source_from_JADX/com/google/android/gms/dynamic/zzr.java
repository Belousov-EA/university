package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class zzr extends zzl {
    private Fragment zzgwp;

    private zzr(Fragment fragment) {
        this.zzgwp = fragment;
    }

    public static zzr zza(Fragment fragment) {
        return fragment != null ? new zzr(fragment) : null;
    }

    public final Bundle getArguments() {
        return this.zzgwp.getArguments();
    }

    public final int getId() {
        return this.zzgwp.getId();
    }

    public final boolean getRetainInstance() {
        return this.zzgwp.getRetainInstance();
    }

    public final String getTag() {
        return this.zzgwp.getTag();
    }

    public final int getTargetRequestCode() {
        return this.zzgwp.getTargetRequestCode();
    }

    public final boolean getUserVisibleHint() {
        return this.zzgwp.getUserVisibleHint();
    }

    public final IObjectWrapper getView() {
        return zzn.zzz(this.zzgwp.getView());
    }

    public final boolean isAdded() {
        return this.zzgwp.isAdded();
    }

    public final boolean isDetached() {
        return this.zzgwp.isDetached();
    }

    public final boolean isHidden() {
        return this.zzgwp.isHidden();
    }

    public final boolean isInLayout() {
        return this.zzgwp.isInLayout();
    }

    public final boolean isRemoving() {
        return this.zzgwp.isRemoving();
    }

    public final boolean isResumed() {
        return this.zzgwp.isResumed();
    }

    public final boolean isVisible() {
        return this.zzgwp.isVisible();
    }

    public final void setHasOptionsMenu(boolean z) {
        this.zzgwp.setHasOptionsMenu(z);
    }

    public final void setMenuVisibility(boolean z) {
        this.zzgwp.setMenuVisibility(z);
    }

    public final void setRetainInstance(boolean z) {
        this.zzgwp.setRetainInstance(z);
    }

    public final void setUserVisibleHint(boolean z) {
        this.zzgwp.setUserVisibleHint(z);
    }

    public final void startActivity(Intent intent) {
        this.zzgwp.startActivity(intent);
    }

    public final void startActivityForResult(Intent intent, int i) {
        this.zzgwp.startActivityForResult(intent, i);
    }

    public final IObjectWrapper zzapx() {
        return zzn.zzz(this.zzgwp.getActivity());
    }

    public final zzk zzapy() {
        return zza(this.zzgwp.getParentFragment());
    }

    public final IObjectWrapper zzapz() {
        return zzn.zzz(this.zzgwp.getResources());
    }

    public final zzk zzaqa() {
        return zza(this.zzgwp.getTargetFragment());
    }

    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzgwp.registerForContextMenu((View) zzn.zzx(iObjectWrapper));
    }

    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzgwp.unregisterForContextMenu((View) zzn.zzx(iObjectWrapper));
    }
}
