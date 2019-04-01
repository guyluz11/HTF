package com.htf.ui.main.fr.skills;

import com.htf.dto.Skill;
import com.htf.lib.contract.fragment.FragmentContract;

import java.util.List;

public class SkillsFragmentContract {
    public interface IPresenter extends FragmentContract.IPresenter {
        void getSkills();

        void updateUsersSkills(List<String> skills);
    }

    public interface IHost extends FragmentContract.IHost {
    }

    public interface IView extends FragmentContract.IView {
        void setSkills(List<Skill> skills);

        void goToMainScreen();
    }
}
