package com.htf.ui.main.fr.profession;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.htf.R;
import com.htf.dto.Profession;
import com.htf.lib.recycler.CommonRecyclerAdapter;
import com.htf.lib.recycler.CommonViewHolder;

import androidx.annotation.NonNull;

public class ProfessionsAdapter extends CommonRecyclerAdapter<Profession> {

    private int selectedProfession = -1;

    ProfessionsAdapter(Context context, IOnItemClickListener<Profession> listener) {
        super(context, listener);
    }

    @NonNull
    @Override
    public CommonViewHolder<Profession> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(context).inflate(R.layout.item_profession, parent, false);
        return new ProfessionVH(v);
    }

    public int getSelectedProfession() {
        return selectedProfession;
    }

    private class ProfessionVH extends CommonViewHolder<Profession> implements View.OnClickListener {
        private final ImageView logo;
        private final TextView prof_radio;

        ProfessionVH(View v) {
            super(v);
            logo = v.findViewById(R.id.prof_logo);
            prof_radio = v.findViewById(R.id.prof_name);
            v.setOnClickListener(this);
        }

        @Override
        public void bindItem(Profession item, int position) {
            logo.setImageResource(item.getImage());
            prof_radio.setText(item.getName());
            prof_radio.setSelected(item.getSelected());
        }

        @Override
        public void onClick(View v) {
            final int position = getAdapterPosition();
            items.get(position).setSelected(true);
            selectedProfession = position;
            for (int i = 0; i < getItemCount(); i++) {
                if (i != position) items.get(i).setSelected(false);
            }
            notifyDataSetChanged();
        }
    }
}
