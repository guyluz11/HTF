package com.mdgd.lib.recycler;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Max
 * on 01/01/2018.
 */

public abstract class CommonViewHolder<T> extends RecyclerView.ViewHolder {

    public CommonViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindItem(T item, int position);
}