package com.mdgd.lib.contract;

/**
 * Created by Max
 * on 23/07/2018.
 */
public interface IToast {

    void showToast(int msgRes);

    void showToast(int msgRes, String query);
}
