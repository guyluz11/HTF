package com.htf.dto;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {

    private String mId;
    private String mFirstName;
    private String mLastName;
    // mHackathon - key = id of the hackathon, key of thr group
    private Map<String, String> mHackathons;
    private List<String> mSkills;

    public User() {
    }

    /**
     * Generate user
     *
     * @param uid = Firebase.Auth uid of the user
     */
    public User(String uid) {
        mId = uid;
        mFirstName = "N312321iv";
        mLastName = "Sap412321arov";
        mHackathons = new HashMap<>();
        addHackathon("115515", "543");
        addHackathon("2", "2432");
        addHackathon("3", "1321");
        mSkills = new ArrayList<String>();
        mSkills.add("skill1");
        mSkills.add("skill2");
    }

    /**
     * Create new user - use this method in order to create new user
     */
    public User(String firstname, String lastname, ArrayList<String> skills) {
        mId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        mFirstName = firstname;
        mLastName = lastname;
        mHackathons = new HashMap<>();
        mSkills = skills;
    }

    /**
     * for test only
     *
     * @param hackathonId
     * @param groupId     because when user first join an hackathon he will never have also a group
     */
    public void addHackathon(String hackathonId, String groupId) {
        mHackathons.put(hackathonId, groupId);
    }

    public void addHackathon(String hackathonId) {
        mHackathons.put(hackathonId, "");
    }


    public List<String> getmSkills() {
        return mSkills;
    }

    public Map<String, String> getmHackathons() {
        return mHackathons;
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public String getmId() {
        return mId;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setmHackathons(Map<String, String> mHackathons) {
        this.mHackathons = mHackathons;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public void setmSkills(List<String> mSkills) {
        this.mSkills = mSkills;
    }
}