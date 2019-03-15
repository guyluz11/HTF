package com.htf.lib.v7.fragment.recycler;

import android.view.View;

import com.htf.lib.R;
import com.htf.lib.contract.fragment.FragmentContract;
import com.htf.lib.recycler.CommonRecyclerAdapter;
import com.htf.lib.v7.fragment.HostedFragment;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Max
 * on 02/01/2018.
 */

public abstract class RecyclerFragment<PRESENTER extends FragmentContract.IPresenter, HOST extends FragmentContract.IHost, ITEM>
        extends HostedFragment<PRESENTER, HOST> implements CommonRecyclerAdapter.IOnItemClickListener<ITEM> {

    protected CommonRecyclerAdapter<ITEM> adapter;
    protected RecyclerView recycler;

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_recycler;
    }

    @Override
    protected void initViews(View v) {
        recycler = v.findViewById(R.id.fragment_recycler);
        adapter = getAdapter();
        recycler.setAdapter(adapter);
    }

    protected abstract CommonRecyclerAdapter<ITEM> getAdapter();
}
