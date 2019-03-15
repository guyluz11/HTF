package com.htf.lib.utilities;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Process;

import androidx.core.app.ActivityCompat;

/**
 * Created by Max
 * on 09/07/2018.
 */
public class PermissionsUtil {

    /**
     * return true if has permission, false other way
     */
    @TargetApi(16)
    public static boolean checkPermissions(final Context ctx, final String... permissions) {
        return checkPermissionAndExec(ctx, null, permissions);
    }

    /**
     * return true if has permission, false other way
     */
    @TargetApi(16)
    public static boolean requestPermissionsIfNeed(final Activity ctx, final int requestCode, final String... permissions) {
        return checkPermissionAndExec(ctx, new IPermissionCmd() {
            @Override
            public void exec(final String permission) {
                ActivityCompat.requestPermissions(ctx, new String[]{permission}, requestCode);
            }
        } , permissions);
    }

    @TargetApi(16)
    private static boolean checkPermissionAndExec(final Context ctx, final IPermissionCmd cmd, final String... permissions) {
        if(ctx == null || permissions == null){
            return false;
        }
        boolean result = true;
        for (String p : permissions) {
            if (ctx.checkPermission(p, Process.myPid(), Process.myUid()) != PackageManager.PERMISSION_GRANTED) {
                result = false;
                if(cmd != null){
                    cmd.exec(p);
                }
            }
        }
        return result;
    }

    public static boolean areAllPermissionsGranted(int[] grantResults) {
        boolean result = false;
        for (int i : grantResults) {
            if (i == PackageManager.PERMISSION_GRANTED) {
                result = true;
            }
        }
        return result;
    }
}
