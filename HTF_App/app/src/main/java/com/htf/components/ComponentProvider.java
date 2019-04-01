package com.htf.components;

import android.content.Context;

import com.htf.components.network.INetwork;
import com.htf.components.network.NetworkImpl;
import com.htf.components.prefs.IPrefs;
import com.htf.components.prefs.Prefs;
import com.htf.lib.injection.BasicProvider;

import java.lang.ref.WeakReference;

public class ComponentProvider extends BasicProvider implements IComponentProvider {
    private final Context appCtx;

    private WeakReference<INetwork> networkRef;
    private WeakReference<IPrefs> prefsRef;


    public ComponentProvider(Context appCtx) {
        this.appCtx = appCtx;
    }

    @Override
    public INetwork getNetwork() {
        networkRef = checkIfExists(networkRef, () -> new NetworkImpl(appCtx));
        return networkRef.get();
    }

    @Override
    public IPrefs getPrefs() {
        prefsRef = checkIfExists(prefsRef, () -> new Prefs(appCtx));
        return prefsRef.get();
    }
}
