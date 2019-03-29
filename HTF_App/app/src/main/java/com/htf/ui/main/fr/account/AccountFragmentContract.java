package com.htf.ui.main.fr.account;

import com.htf.dto.Hackathon;
import com.htf.lib.contract.fragment.FragmentContract;

import java.util.List;

public class AccountFragmentContract {

    public interface IPresenter extends FragmentContract.IPresenter {
        void getHackatons();
    }

    public interface IHost extends FragmentContract.IHost {
        void showHackatonDetails(Hackathon item);
    }

    public interface IView extends FragmentContract.IView {
        void setHackatons(List<Hackathon> data);
    }
}
