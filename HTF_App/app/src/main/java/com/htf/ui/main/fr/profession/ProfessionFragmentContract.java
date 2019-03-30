package com.htf.ui.main.fr.profession;

import com.htf.dto.Profession;
import com.htf.lib.contract.fragment.FragmentContract;

import java.util.List;

public class ProfessionFragmentContract {
    public interface IPresenter extends FragmentContract.IPresenter {
        void loadProfessions();
    }

    public interface IHost extends FragmentContract.IHost {
    }

    public interface IView extends FragmentContract.IView {
        void setProfessions(List<Profession> profs);
    }
}
