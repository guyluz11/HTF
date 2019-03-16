package com.htf.lib.contract.progress;

/**
 * Created by Max
 * on 23/07/2018.
 */
public interface IProgressContainer {

    boolean hasProgress();

    void showProgress(String title, String message);

    void showProgress(int titleRes, int messageRes);

    void showProgress();

    void hideProgress();
}
