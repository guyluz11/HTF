package com.htf.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Not need it for now ...
 *
 */
public class Hackathon {
    private String mTitle;
    private String mDescription;
    private List<String> mImagesUrl;
    private int mMaxNumberOfGroups;
    private int mMaxNumberOfPeopleInGroup;
    private List<String> mGroupListId;

    public Hackathon(){};

    public Hackathon(String title, String description,int maxNumberOfGroups, int maxNumberOfPeopleInGroup){
        mTitle = title;
        mDescription = description;
        mMaxNumberOfGroups = maxNumberOfGroups;
        mMaxNumberOfPeopleInGroup = maxNumberOfPeopleInGroup;
        mImagesUrl = new ArrayList<String>(); // give default image in case user wont added any images
        mGroupListId = new ArrayList<String>();
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setmImagesUrl(List<String> mImagesUrl) {
        this.mImagesUrl = mImagesUrl;
    }

    public void setmMaxNumberOfGroups(int mMaxNumberOfGroups) {
        this.mMaxNumberOfGroups = mMaxNumberOfGroups;
    }

    public void setmMaxNumberOfPeopleInGroup(int mMaxNumberOfPeopleInGroup) {
        this.mMaxNumberOfPeopleInGroup = mMaxNumberOfPeopleInGroup;
    }

    public void setmGroupListId(List<String> mGroupListId) {
        this.mGroupListId = mGroupListId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public List<String> getmImagesUrl() {
        return mImagesUrl;
    }

    public int getmMaxNumberOfGroups() {
        return mMaxNumberOfGroups;
    }

    public int getmMaxNumberOfPeopleInGroup() {
        return mMaxNumberOfPeopleInGroup;
    }

    public List<String> getmGroupListId() {
        return mGroupListId;
    }
}
