package worshifter.com.hgf.components;

import android.content.Context;

import com.mdgd.lib.injection.BasicProvider;
import com.mdgd.lib.sqlite.IDataBase;

import java.lang.ref.WeakReference;

import worshifter.com.hgf.components.db.income.IncomeDB;
import worshifter.com.hgf.components.db.outcome.OutcomeDB;
import worshifter.com.hgf.components.network.INetwork;
import worshifter.com.hgf.components.network.NetworkImpl;
import worshifter.com.hgf.components.prefs.IPrefs;
import worshifter.com.hgf.components.prefs.Prefs;
import worshifter.com.hgf.dto.Income;
import worshifter.com.hgf.dto.Outcome;

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
