package com.htf.ui.main.fr.hackaton_groups;

import com.htf.components.network.INetwork;
import com.htf.dto.Hackathon;
import com.htf.lib.result.Result;
import com.htf.lib.v7.fragment.FragmentPresenter;

import java.util.List;

public class AccountFragmentPresenter extends FragmentPresenter<HackathonFragmentContract.IView>
        implements HackathonFragmentContract.IPresenter {

    private final INetwork network;

    public AccountFragmentPresenter(HackathonFragmentContract.IView view, INetwork network) {
        super(view);
        this.network = network;
    }

    @Override
    public void getHackatons() {
        view.showProgress();
        network.loadHackathons("cascsa", (Result<List<Hackathon>> result) -> {
            view.hideProgress();
            if (result.isFail()) {

            } else {
                view.setHackatons(result.data);
            }
        });
    }
}
