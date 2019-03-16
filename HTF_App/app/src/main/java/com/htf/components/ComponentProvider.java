package com.htf.components;

import android.content.Context;

import com.htf.components.db.income.IncomeDB;
import com.htf.components.db.outcome.OutcomeDB;
import com.htf.components.network.INetwork;
import com.htf.components.network.NetworkImpl;
import com.htf.components.prefs.IPrefs;
import com.htf.components.prefs.Prefs;
import com.htf.dto.Income;
import com.htf.dto.Outcome;
import com.htf.lib.injection.BasicProvider;
import com.htf.lib.sqlite.IDataBase;

import java.lang.ref.WeakReference;

public class ComponentProvider extends BasicProvider implements IComponentProvider {
    private final Context appCtx;

    private WeakReference<IDataBase<Outcome>> outcomeDbRef;
    private WeakReference<IDataBase<Income>> incomeDbRef;
    private WeakReference<INetwork> networkRef;
    private WeakReference<IPrefs> prefsRef;


    public ComponentProvider(Context appCtx) {
        this.appCtx = appCtx;
    }

    @Override
    public INetwork getNetwork() {
        networkRef = checkIfExists(networkRef, NetworkImpl::new);
        return networkRef.get();
    }

    @Override
    public IPrefs getPrefs() {
        prefsRef = checkIfExists(prefsRef, () -> new Prefs(appCtx));
        return prefsRef.get();
    }

    @Override
    public IDataBase<Income> getIncomeDB() {
        incomeDbRef = checkIfExists(incomeDbRef, () -> new IncomeDB(appCtx));
        return incomeDbRef.get();
    }

    @Override
    public IDataBase<Outcome> getOutcomeDB() {
        outcomeDbRef = checkIfExists(outcomeDbRef, () -> new OutcomeDB(appCtx));
        return outcomeDbRef.get();
    }
}
