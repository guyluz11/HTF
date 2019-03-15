package com.htf.lib.permissions;

import android.app.Activity;
import android.content.Context;

/**
 * Created by Owner
 * on 16/07/2018.
 */
public interface IPermissionAction {

    boolean hasPermission(final Context ctx);

    void requestPermission(final Activity ctx, IHint hint);
}
