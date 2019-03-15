package com.mdgd.lib.contract.progress;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * Created by Max
 * on 05/09/2018.
 */
public class ProgressDialogWrapper implements IProgressView {

    private final ProgressDialog progressView;

    public ProgressDialogWrapper(Context context, String title, String message) {
        progressView = new ProgressDialog(context);
        progressView.setTitle(title);
        progressView.setMessage(message);
        progressView.setIndeterminate(true);
    }

    @Override
    public void show() {
        progressView.show();
    }

    @Override
    public boolean isShowing() {
        return progressView.isShowing();
    }

    @Override
    public void dismiss() {
        progressView.dismiss();
    }

    @Override
    public void cancel() {
        progressView.cancel();
    }
}
