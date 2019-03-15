package com.mdgd.lib.v7.fragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.mdgd.lib.contract.fragment.FragmentContract;
import com.mdgd.lib.contract.progress.IProgressView;
import com.mdgd.lib.contract.progress.ProgressDialogWrapper;
import com.mdgd.lib.utilities.PermissionsUtil;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by Max
 * on 19/07/2017.
 */

public abstract class HostedFragment<PRESENTER extends FragmentContract.IPresenter, HOST extends FragmentContract.IHost>
        extends Fragment implements FragmentContract.IView {
    private boolean hasProgress = false;
    private IProgressView progress;
    protected HOST host;

    @Override
    @SuppressWarnings("unchecked")
    public void onAttach(Context context) {
        super.onAttach(context);
        host = (HOST)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(getLayoutResId(), container, false);
        initViews(v);
        return v;
    }

    protected abstract int getLayoutResId();

    protected void initViews(final View v){}

    @Override
    public boolean hasProgress() {
        return hasProgress;
    }

    public void setHasProgress(boolean hasProgress) {
        this.hasProgress = hasProgress;
    }

    @Override
    public void showProgress() {
        showProgress("", "");
    }

    @Override
    public void showProgress(int titleRes, int messageRes) {
        showProgress(getString(titleRes), getString(messageRes));
    }

    @Override
    @CallSuper
    public void showProgress(String title, String message) {
        try {
            if (progress == null) progress = createProgressView(title, message);
            if (!progress.isShowing() && host != null && !host.isFinishing()) progress.show();
        }
        catch (Throwable e){
            e.printStackTrace();
        }
    }

    protected IProgressView createProgressView(String title, String message) {
        return new ProgressDialogWrapper(getActivity(), title, message);
    }

    @Override
    @CallSuper
    public void hideProgress() {
        if(progress != null && progress.isShowing() && host != null && !host.isFinishing()){
            progress.dismiss();
            progress = null;
        }
    }

    @Override
    public void showToast(int msgRes) {
        final Context ctx = getActivity();
        if(ctx != null) Toast.makeText(ctx, msgRes, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showToast(int msgRes, String query) {
        final Context ctx = getActivity();
        if(ctx != null) Toast.makeText(ctx, getString(msgRes, query), Toast.LENGTH_LONG).show();
    }


    @TargetApi(16)
    protected boolean requestPermissionsIfNeed(int requestCode, String... permissions) {
        return PermissionsUtil.requestPermissionsIfNeed(getActivity(), requestCode, permissions);
    }

    @TargetApi(16)
    protected boolean hasPermissions(String... permissions) {
        return PermissionsUtil.checkPermissions(getActivity(), permissions);
    }
}
