package com.htf.ui.main.fr.hackaton_groups;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htf.R;
import com.htf.dto.Hackathon;
import com.htf.ui.main.fr.GlobalAdapter;
import com.htf.ui.main.fr.book_mark.BookMarkFragmentContract;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class HackathonGroups extends Fragment implements BookMarkFragmentContract.IView {
    private View myView;
    private RecyclerView recyclerView;      // Obtaining a handle to the object in the fragment
    private RecyclerView.Adapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_hackathon_groups, container, false);
        constructViews();

        return myView;
    }

    private void constructViews() {        // initialize all the variables in an organized way
        recyclerView = myView.findViewById(R.id.listOfHackatons);
    }


    @Override
    public void onStart() {
        super.onStart();

        recyclerVIewConfig();
    }


    private void recyclerVIewConfig() {

        recyclerView.setHasFixedSize(true);

        // LayoutManager for the recyclerView
        // use a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(myView.getContext());
        recyclerView.setLayoutManager(layoutManager);


        mAdapter  = new GlobalAdapter(myView.getContext(), 2, (item, position) -> {});
        recyclerView.setAdapter(mAdapter);



        //ToDo Un comment this part
//        RecyclerView.Adapter mAdapter = new ListOfDishAdapter(mView.getContext(), navigationActivity.listFoodObject);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(mView.getContext(), RecyclerView.VERTICAL, false));
//        recyclerView.setAdapter(mAdapter);


    }

    public void updateRecyclerView() {
        mAdapter.notifyDataSetChanged();
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
    }

    public void setItems(List<Hackathon> items) {
        items = items;
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(int msgRes) {

    }

    @Override
    public void showToast(String msg) {

    }

    @Override
    public void showToast(int msgRes, String query) {

    }

    @Override
    public boolean hasProgress() {
        return false;
    }

    @Override
    public void showProgress(String title, String message) {

    }

    @Override
    public void showProgress(int titleRes, int messageRes) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }
}
