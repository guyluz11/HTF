package com.htf.ui.main.fr.account;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.htf.R;
import com.htf.dto.Hackathon;
import com.htf.lib.recycler.CommonRecyclerAdapter;
import com.htf.lib.recycler.CommonViewHolder;

import androidx.annotation.NonNull;

class AccountAdapter extends CommonRecyclerAdapter<Hackathon> {

    AccountAdapter(Context context, IOnItemClickListener<Hackathon> listener) {
        super(context, listener);
    }

    @NonNull
    @Override
    public CommonViewHolder<Hackathon> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_hackathon, parent, false);
        return new HackatonVH(v);
    }

    private class HackatonVH extends CommonViewHolder<Hackathon> implements View.OnClickListener {

        private TextView tvHeadTitle, tvSubTitle, tvLittleTitle;
        private ImageView imageHackathon;

        public HackatonVH(View v) {
            super(v);
            // find views and set listeners
            itemView.setOnClickListener(this);
            tvHeadTitle = v.findViewById(R.id.tvHeadTitleAccount);
            tvSubTitle = v.findViewById(R.id.tvSubTitleAccount);
            tvLittleTitle = v.findViewById(R.id.tv_littleTitleAccount);
            imageHackathon = v.findViewById(R.id.image_itemHackathon);
        }

        @Override
        public void bindItem(Hackathon item, int position) {
            // fill views from item
            tvHeadTitle.setText(item.getmTitle());
            tvSubTitle.setText(item.getmDescription());
            tvLittleTitle.setText(Time.getCurrentTimezone());
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (listener != null) listener.onItemClicked(items.get(position), position);
        }
    }
}
