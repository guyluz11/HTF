package com.htf.dto;

public class Profession {
    private boolean selected = false;
    private final int image;
    private final int name;

    public Profession(int imgResId, int labelResId) {
        image = imgResId;
        name = labelResId;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean getSelected() {
        return selected;
    }

    public int getImage() {
        return image;
    }

    public int getName() {
        return name;
    }
}
