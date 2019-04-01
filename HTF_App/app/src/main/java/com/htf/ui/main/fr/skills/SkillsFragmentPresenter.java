package com.htf.ui.main.fr.skills;

import com.htf.R;
import com.htf.components.network.INetwork;
import com.htf.dto.Skill;
import com.htf.lib.result.Result;
import com.htf.lib.v7.fragment.FragmentPresenter;

import java.util.ArrayList;
import java.util.List;

public class SkillsFragmentPresenter extends FragmentPresenter<SkillsFragmentContract.IView>
        implements SkillsFragmentContract.IPresenter {

    private final INetwork network;

    public SkillsFragmentPresenter(SkillsFragmentContract.IView view, INetwork network) {
        super(view);
        this.network = network;
    }

    @Override
    public void getSkills() {
        final List<Skill> skills = new ArrayList<>();
        skills.add(new Skill(R.string.ui_ux));
        skills.add(new Skill(R.string.graphic_design));
        skills.add(new Skill(R.string.photography));
        skills.add(new Skill(R.string.interaction_design));
        skills.add(new Skill(R.string.advertising));
        skills.add(new Skill(R.string.illustration));
        skills.add(new Skill(R.string.industriak_design));
        skills.add(new Skill(R.string.motion_graphic));
        skills.add(new Skill(R.string.web_design));
        skills.add(new Skill(R.string.architecture));
        skills.add(new Skill(R.string.animator));
        view.setSkills(skills);
    }

    @Override
    public void updateUsersSkills(List<String> skills) {
        view.showProgress(R.string.empty, R.string.wait_please);
        network.updateUsersSkills(skills, (Result<Boolean> result) -> {
            view.hideProgress();
            if(result.isSuccess()){
                view.goToMainScreen();
            } else {
                view.showToast(R.string.request_failed);
            }
        });
    }
}
