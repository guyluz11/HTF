package com.htf.lib.permissions;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;

import com.htf.lib.utilities.PermissionsUtil;

/**
 * Created by Owner
 * on 09/07/2018.
 */
public class PermissionItem {
    public final IPermissionAction action;
    public final String[] permissions;
    public final int rcCode;
    public final IHint hint;
    public final int label;

    private boolean doNotAskAgainOff = true;

    public PermissionItem(int label, int rcCode, String... permissions) {
        this.label = label;
        this.permissions = permissions;
        this.rcCode = rcCode;
        this.action = null;
        this.hint = null;
    }

    public PermissionItem(int label, int rcCode, IPermissionAction action) {
        this.label = label;
        this.permissions = null;
        this.action = action;
        this.rcCode = rcCode;
        this.hint = null;
    }

    public PermissionItem(int label, int rcCode, IPermissionAction action, IHint hint) {
        this.label = label;
        this.permissions = null;
        this.action = action;
        this.rcCode = rcCode;
        this.hint = hint;
    }

    public boolean hasPermission(Activity activity){
        if(permissions != null){
            boolean hasPermission = true;
            for(String permission : permissions){
                hasPermission = hasPermission && activity.checkPermission(permission, Process.myPid(), Process.myUid()) == PackageManager.PERMISSION_GRANTED;
            }
            return hasPermission;
        }
        else if(action != null) return action.hasPermission(activity);
        return false;
    }

    public void requestPermission(Activity activity) {
        if (permissions != null) {
            if (doNotAskAgainOff) PermissionsUtil.requestPermissionsIfNeed(activity, rcCode, permissions);
            else {
                final Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                intent.setData(Uri.parse("package:" + activity.getPackageName()));
                if (activity.getPackageManager().resolveActivity(intent, 0) != null)
                    activity.startActivityForResult(intent, rcCode);
            }
        } else if (action != null) action.requestPermission(activity, hint);
    }

    public void setDoNotAskAgainOff(boolean doNotAskAgainOff) {
        this.doNotAskAgainOff = doNotAskAgainOff;
    }

    public boolean containsPermission(String permission) {
        if(permissions == null || TextUtils.isEmpty(permission)) return false;
        for(String p : permissions){
            if(p.equals(permission)) return true;
        }
        return false;
    }
}
