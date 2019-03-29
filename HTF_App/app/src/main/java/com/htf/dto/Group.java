package com.htf.dto;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private String mTitle;
    private String mDescription;
    private int mMaxNumber;
    private String mWhoIsAdmin;
    private List<String> mParticipates;
    private List<String> mWaitingList;

    /**
     * Ctor
     * <p>
     * the user which create the hackathon will be the admin, and the first participates
     */

    public Group() {
    }

    public Group(String title, String description, int maxNumber) {

        String idCreator = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mTitle = title;
        mDescription = description;
        mMaxNumber = maxNumber;
        mWhoIsAdmin = idCreator;
        mParticipates = new ArrayList<>();
        mParticipates.add(idCreator);
        mWaitingList = new ArrayList<>();
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public int getmMaxNumber() {
        return mMaxNumber;
    }

    public String getmWhoIsAdmin() {
        return mWhoIsAdmin;
    }

    public List<String> getmParticipates() {
        return mParticipates;
    }

    public List<String> getmWaitingList() {
        return mWaitingList;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public void setmMaxNumber(int mMaxNumber) {
        this.mMaxNumber = mMaxNumber;
    }

    public void setmWhoIsAdmin(String mWhoIsAdmin) {
        this.mWhoIsAdmin = mWhoIsAdmin;
    }

    public void setmParticipates(List<String> mParticipates) {
        this.mParticipates = mParticipates;
    }

    public void setmWaitingList(List<String> mWaitingList) {
        this.mWaitingList = mWaitingList;
    }
}