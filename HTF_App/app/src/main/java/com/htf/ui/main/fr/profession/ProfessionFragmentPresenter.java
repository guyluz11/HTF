package com.htf.ui.main.fr.profession;

import com.htf.R;
import com.htf.dto.Profession;
import com.htf.lib.v7.fragment.FragmentPresenter;

import java.util.ArrayList;
import java.util.List;

public class ProfessionFragmentPresenter extends FragmentPresenter<ProfessionFragmentContract.IView>
        implements ProfessionFragmentContract.IPresenter {

    public ProfessionFragmentPresenter(ProfessionFragmentContract.IView view) {
        super(view);
    }

    @Override
    public void loadProfessions() {
        final List<Profession> profs = new ArrayList<>();
        profs.add(new Profession(R.mipmap.ic_dev, R.string.developer));
        profs.add(new Profession(R.mipmap.ic_designer, R.string.designer));
        profs.add(new Profession(R.mipmap.ic_product, R.string.product));
        profs.add(new Profession(R.mipmap.ic_other, R.string.other));
        view.setProfessions(profs);
    }
}
