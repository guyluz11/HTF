package com.htf.ui.main.fr.profession;

import com.htf.R;
import com.htf.components.network.INetwork;
import com.htf.dto.Profession;
import com.htf.dto.User;
import com.htf.lib.result.Result;
import com.htf.lib.v7.fragment.FragmentPresenter;
import com.htf.util.TextUtils;

import java.util.ArrayList;
import java.util.List;

public class ProfessionFragmentPresenter extends FragmentPresenter<ProfessionFragmentContract.IView>
        implements ProfessionFragmentContract.IPresenter {

    private final INetwork network;

    public ProfessionFragmentPresenter(ProfessionFragmentContract.IView view, INetwork network) {
        super(view);
        this.network = network;
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

    @Override
    public void updateUser(String name, int profession) {
        if (isInvalid(name, profession)) return;

        view.showProgress(R.string.empty, R.string.wait_please);
        network.updateUser(new User(name, profession), (Result<Boolean> result) -> {
            view.hideProgress();
            if (result.isSuccess()) {
                view.goToSkills();
            } else {
                view.showToast(R.string.request_failed);
            }
        });
    }

    private boolean isInvalid(String name, int profession) {
        boolean hasError = false;
        if (TextUtils.isEmpty(name)) {
            view.setNameError(view.getString(R.string.please_enter_name));
            hasError = true;
        } else {
            view.setNameError(null);
        }
        if (profession == -1) {
            view.showToast(R.string.please_select_profession);
            hasError = true;
        }
        return hasError;
    }
}
