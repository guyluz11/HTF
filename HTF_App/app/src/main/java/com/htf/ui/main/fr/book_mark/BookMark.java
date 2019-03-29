package com.htf.ui.main.fr.book_mark;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.htf.R;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BookMark extends Fragment {
    private View myView;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        myView = inflater.inflate(R.layout.fragment_book_mark, container, false);
        constructViews();

        return myView;
    }


    @Override
    public void onStart() {
        super.onStart();
        recyclerVIewConfig();
    }

    private void constructViews() {        // initialize all the variables in an organized way
        mRecyclerView = myView.findViewById(R.id.recyclerview);
    }


    //configure the recyclerView with this adapter
    private void recyclerVIewConfig() {
        mRecyclerView.setHasFixedSize(true);
        // TODO: 15/02/2019 create adapter for the recyclerView
        List<String> listFoodObject = new ArrayList<>();
        listFoodObject.add("EUROHACK: The Eurovision Hackathon");
        listFoodObject.add("2");
        listFoodObject.add("EUROHACK: The Eurovision Hackathon");
        listFoodObject.add("One");
        listFoodObject.add("2");
        listFoodObject.add("EUROHACK: The Eurovision Hackathon");
        listFoodObject.add("One");
        listFoodObject.add("2");
        listFoodObject.add("Tree");
        listFoodObject.add("One");
        listFoodObject.add("2");
        listFoodObject.add("Tree");
        mAdapter = new GroupAdapter(myView.getContext(), 4, listFoodObject);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(myView.getContext(), RecyclerView.VERTICAL, false));
        mRecyclerView.setAdapter(mAdapter);
    }


    public void updateRecyclerView() {
        mAdapter.notifyDataSetChanged();
    }

}