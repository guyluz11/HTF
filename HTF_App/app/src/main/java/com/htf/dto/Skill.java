package com.htf.dto;

public class Skill {
    private int name;
    private boolean isChecked;

    public Skill() {
    }

    public Skill(int nameResId){
        name = nameResId;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public boolean getIsChecked() {
        return isChecked;
    }

    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }
}
