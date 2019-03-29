package com.htf.components.prefs;

import android.content.Context;

import com.htf.lib.prefs.BasicPrefsImpl;

public class Prefs extends BasicPrefsImpl implements IPrefs {

    private static final String KEY_INTEREST = "interests";

    public Prefs(Context ctx) {
        super(ctx);
    }

    @Override
    public String getDefaultPrefsFileName() {
        return "hackatons";
    }

    @Override
    public void putInterest(String interests) {
        put(KEY_INTEREST, interests);
    }

    @Override
    public String getInterest(String interests) {
        return get(KEY_INTEREST, "");
    }

}
