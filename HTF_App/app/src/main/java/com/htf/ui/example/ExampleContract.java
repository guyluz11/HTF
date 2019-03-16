package com.htf.ui.example;

import com.htf.lib.contract.mvp.ActivityContract;

public class ExampleContract {
    public interface IPresenter extends ActivityContract.IPresenter {}

    public interface IView extends ActivityContract.IView {}
}
