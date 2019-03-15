package com.htf.lib.contract.mvp;

import com.htf.lib.contract.IToast;
import com.htf.lib.contract.progress.IProgressContainer;

/**
 * Created by Max
 * on 05/09/2018.
 */
public class ActivityContract {

    public interface IPresenter { }

    public interface IView extends IToast, IProgressContainer {

        String getString(int id);

        String getString(int id, Object... args);

        boolean isFinishing();

        String getPackageName();

        void finish();

        void onBackPressed();
    }
}
