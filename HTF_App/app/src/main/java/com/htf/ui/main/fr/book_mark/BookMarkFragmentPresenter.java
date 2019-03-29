package com.htf.ui.main.fr.book_mark;

import com.htf.components.network.INetwork;
import com.htf.dto.Hackathon;
import com.htf.lib.result.Result;
import com.htf.lib.v7.fragment.FragmentPresenter;

import java.util.List;

public class BookMarkFragmentPresenter extends FragmentPresenter<BookMarkFragmentContract.IView>
        implements BookMarkFragmentContract.IPresenter {

    private final INetwork network;

    public BookMarkFragmentPresenter(BookMarkFragmentContract.IView view, INetwork network) {
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
