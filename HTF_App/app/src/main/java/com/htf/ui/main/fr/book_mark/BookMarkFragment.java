package com.htf.ui.main.fr.book_mark;

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


public class BookMarkFragment extends RecyclerFragment<BookMarkFragmentContract.IPresenter,
        BookMarkFragmentContract.IHost, Hackathon> implements BookMarkFragmentContract.IView {

    private RecyclerView recycler;

    @Inject
    protected BookMarkFragmentContract.IPresenter presenter;

    public static BookMarkFragment newInstance() {
        return new BookMarkFragment();
    }


    // get layout
    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_book_mark;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DaggerBookMarkFragmentComponent.builder()
                .bookMarkFragmentModule(new BookMarkFragmentModule(this)).build().injectPresenter(this);


    }

    // max method, finds all views by id From HostedFragment
    @Override
    protected void initViews(View v) {
        recycler = v.findViewById(R.id.recyclerview);
        adapter = getAdapter();

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
    }

    // JUST CREATE THE ADAPTER  FOR RECYCLER
    @Override
    protected CommonRecyclerAdapter<Hackathon> getAdapter() {
        return new BookMarkAdapter(getActivity(),1,this);
    }


    //
    @Override
    public void onStart() {
        super.onStart();
        presenter.getHackatons();
    }

    @Override
    public void onItemClicked(Hackathon item, int position) {
        if (host != null) host.showHackatonDetails(item);
    }

    @Override
    public void setHackatons(List<Hackathon> data) {
        data.add(new Hackathon());
        ArrayList<Hackathon> hackathons = new ArrayList<>();
        hackathons.add(new Hackathon("title1", "sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1", "sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1", "sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1", "sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1", "sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1", "sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1", "sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1", "sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1", "sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1", "sdedacdsacsad", 15, 10));
        hackathons.add(new Hackathon("title1", "sdedacdsacsad", 15, 10));
        adapter.setItems(hackathons);
    }
}
