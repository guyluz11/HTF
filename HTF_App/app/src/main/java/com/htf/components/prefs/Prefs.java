package com.htf.components.prefs;

import android.content.Context;

import com.htf.lib.prefs.BasicPrefsImpl;

public class Prefs extends BasicPrefsImpl implements IPrefs {

    public Prefs(Context ctx) {
        super(ctx);
    }

    @Override
    public String getDefaultPrefsFileName() {
        return "easy_money";
    }
}
