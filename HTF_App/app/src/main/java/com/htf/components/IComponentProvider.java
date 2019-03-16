package com.htf.components;

import com.htf.components.network.INetwork;
import com.htf.components.prefs.IPrefs;
import com.htf.dto.Income;
import com.htf.dto.Outcome;
import com.htf.lib.sqlite.IDataBase;

public interface IComponentProvider {

    INetwork getNetwork();

    IPrefs getPrefs();

    IDataBase<Income> getIncomeDB();

    IDataBase<Outcome> getOutcomeDB();
}
