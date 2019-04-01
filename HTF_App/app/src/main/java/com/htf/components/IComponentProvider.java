package com.htf.components;

import com.htf.components.network.INetwork;
import com.htf.components.prefs.IPrefs;

public interface IComponentProvider {

    INetwork getNetwork();

    IPrefs getPrefs();
}
