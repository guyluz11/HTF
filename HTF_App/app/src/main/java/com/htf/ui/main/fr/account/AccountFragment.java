package com.htf.ui.main.fr.account;

import android.os.Bundle;
import android.view.View;

import com.htf.R;
import com.htf.dto.Hackathon;
import com.htf.lib.recycler.CommonRecyclerAdapter;
import com.htf.lib.v7.fragment.recycler.RecyclerFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class AccountFragment extends RecyclerFragment<AccountFragmentContract.IPresenter,
        AccountFragmentContract.IHost, Hackathon> implements AccountFragmentContract.IView {

    private RecyclerView recycler;

    @Inject
    protected AccountFragmentContract.IPresenter presenter;

    public static AccountFragment newInstance() {
        return new AccountFragment();
    }


    // get layout
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_account;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerAccountFragmentComponent.builder()
                .accountFragmentModule(new AccountFragmentModule(this)).build().injectPresenter(this);

    }

    // max method, finds all views by id From HostedFragment
    @Override
    protected void initViews(View v) {
        recycler = v.findViewById(R.id.recycler_fragmentAccount);
        adapter = getAdapter();
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
    }

    // JUST CREATE THE ADAPTER  FOR RECYCLER
    @Override
    protected CommonRecyclerAdapter<Hackathon> getAdapter() {
        return new AccountAdapter(getActivity(), this);
    }


    //
    @Override
    public void onStart() {
        super.onStart();
        presenter.getHackatons();
    }

    @Override
    public void onItemClicked(Hackathon item, int position) {
        if(host != null) host.showHackatonDetails(item);
    }

    @Override
    public void setHackatons(List<Hackathon> data) {
        data.add(new Hackathon());
        ArrayList<Hackathon> hackathons = new ArrayList<>();
        hackathons.add(new Hackathon("title1","sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1","sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1","sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1","sdedacdsacsad", 15, 10));
        adapter.setItems(hackathons);
    }
}
