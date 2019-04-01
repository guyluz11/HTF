package com.htf.ui.main.fr.skills;

import android.os.Bundle;
import android.view.View;

import com.htf.R;
import com.htf.dto.Skill;
import com.htf.lib.v7.fragment.HostedFragment;
import com.htf.ui.main.fr.profession.ProfessionsAdapter;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class SkillsFragment extends HostedFragment<SkillsFragmentContract.IPresenter,
        SkillsFragmentContract.IHost> implements SkillsFragmentContract.IView, View.OnClickListener {

    @Inject
    protected SkillsFragmentContract.IPresenter presenter;
    private SkillsAdapter adapter;

    public static SkillsFragment newInstance() {
        return new SkillsFragment();
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_skills;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerSkillsFragmentComponent.builder()
                .skillsFragmentModule(new SkillsFragmentModule(this))
                .build().injectPresenter(this);
    }

    @Override
    protected void initViews(View v) {
        final RecyclerView professions = v.findViewById(R.id.professions);
        professions.setLayoutManager(new LinearLayoutManager(getActivity()));
        professions.setAdapter(adapter = new SkillsAdapter(getActivity(), null));
        v.findViewById(R.id.btn_start).setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.getSkills();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_start: {
                presenter.updateUsersSkills(adapter.getSelectedSkills());
            } break;
        }
    }

    @Override
    public void setSkills(List<Skill> skills) {
        adapter.setItems(skills);
    }

    @Override
    public void goToMainScreen() {
        Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_skillsFragment_to_mainScreen);
    }
}
