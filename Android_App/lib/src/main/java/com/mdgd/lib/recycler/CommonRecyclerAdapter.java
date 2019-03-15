package com.mdgd.lib.recycler;

import android.content.Context;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by Max
 * on 01/01/2018.
 */

public abstract class CommonRecyclerAdapter<T> extends RecyclerView.Adapter<CommonViewHolder<T>> {
    protected final IOnItemClickListener<T> listener;
    protected final Context context;
    protected List<T> items;

    public CommonRecyclerAdapter(Context context, IOnItemClickListener<T> listener){
        this.listener = listener;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull CommonViewHolder<T> holder, int position) {
        if(items != null && position >= 0 && position < items.size()) holder.bindItem(items.get(position), position);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public void setItems(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public void addItems(List<T> items) {
        if(items == null || items.isEmpty()) return;
        if(this.items == null) setItems(items);
        else {
            final int start = this.items.size();
            this.items.addAll(items);
            notifyItemRangeInserted(start, items.size());
        }
    }

    public interface IOnItemClickListener<T> {
        void onItemClicked(T item, int position);
    }
}
