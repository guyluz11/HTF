package com.htf.ui.main.fr.skills;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.htf.R;
import com.htf.dto.Profession;
import com.htf.dto.Skill;
import com.htf.lib.recycler.CommonRecyclerAdapter;
import com.htf.lib.recycler.CommonViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;

public class SkillsAdapter extends CommonRecyclerAdapter<Skill> {

    SkillsAdapter(Context context, IOnItemClickListener<Skill> listener) {
        super(context, listener);
    }

    @NonNull
    @Override
    public CommonViewHolder<Skill> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(context).inflate(R.layout.item_skill, parent, false);
        return new SkillsVH(v);
    }

    public List<String> getSelectedSkills() {
        final List<String> skills = new ArrayList<>();
        for(Skill s : items){
            if(s.getIsChecked()) skills.add(context.getString(s.getName()));
        }
        return skills;
    }

    private class SkillsVH extends CommonViewHolder<Skill> implements View.OnClickListener {
        private final AppCompatCheckBox view;

        SkillsVH(View v) {
            super(v);
            view = (AppCompatCheckBox)v;
            v.setOnClickListener(this);
        }

        @Override
        public void bindItem(Skill item, int position) {
            view.setText(item.getName());
            view.setChecked(item.getIsChecked());
        }

        @Override
        public void onClick(View v) {
            final int position = getAdapterPosition();
            final Skill skill = items.get(position);
            skill.setIsChecked(!skill.getIsChecked());
            notifyItemChanged(position);
        }
    }
}
