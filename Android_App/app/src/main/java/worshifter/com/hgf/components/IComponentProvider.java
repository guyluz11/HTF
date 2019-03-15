package worshifter.com.hgf.components;

import com.mdgd.lib.sqlite.IDataBase;

import worshifter.com.hgf.components.network.INetwork;
import worshifter.com.hgf.components.prefs.IPrefs;
import worshifter.com.hgf.dto.Income;
import worshifter.com.hgf.dto.Outcome;

public interface IComponentProvider {

    INetwork getNetwork();

    IPrefs getPrefs();

    IDataBase<Income> getIncomeDB();

    IDataBase<Outcome> getOutcomeDB();
}
