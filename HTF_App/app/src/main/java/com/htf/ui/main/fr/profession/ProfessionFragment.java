package com.htf.ui.main.fr.profession;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.htf.R;
import com.htf.dto.Profession;
import com.htf.lib.v7.fragment.HostedFragment;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ProfessionFragment extends HostedFragment<ProfessionFragmentContract.IPresenter,
        ProfessionFragmentContract.IHost> implements ProfessionFragmentContract.IView, View.OnClickListener {

    @Inject
    protected ProfessionFragmentContract.IPresenter presenter;
    private ImageView photo;
    private ProfessionsAdapter adapter;
    private EditText name;

    public static ProfessionFragment newInstance() {
        return new ProfessionFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerProfessionFragmentComponent.builder()
                .professionFragmentModule(new ProfessionFragmentModule(this))
                .build().injectPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_profession;
    }

    @Override
    protected void initViews(View v) {
        name = v.findViewById(R.id.name);
        final RecyclerView professions = v.findViewById(R.id.professions);
        professions.setLayoutManager(new LinearLayoutManager(getActivity()));
        professions.setAdapter(adapter = new ProfessionsAdapter(getActivity(), null));
        photo = v.findViewById(R.id.profile_img);
        photo.setOnClickListener(this);
        v.findViewById(R.id.btn_continue).setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        presenter.loadProfessions();
    }

    @Override
    public void setProfessions(List<Profession> profs) {
        adapter.setItems(profs);
    }

    @Override
    public void goToSkills() {
        Navigation.findNavController(Objects.requireNonNull(getView())).navigate(R.id.action_splashFragment_to_skillsFragment);
    }

    @Override
    public void setNameError(String error) {
        name.setError(error);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.profile_img: {
                // todo request image
            }
            break;
            case R.id.btn_continue: {
                presenter.updateUser(name.getText().toString(), adapter.getSelectedProfession());
            }
            break;
        }
    }
}
