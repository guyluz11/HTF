package worshifter.com.hgf.ui.example;

import android.support.v4.app.Fragment;

import com.mdgd.lib.v7.fragment.HostActivity;

import worshifter.com.hgf.components.Injection;
import worshifter.com.hgf.ui.example.fr.ExampleFragment;

public class ExampleActivity extends HostActivity<ExampleContract.IPresenter> implements ExampleContract.IView {

    @Override
    protected ExampleContract.IPresenter getPresenter() {
        return Injection.getExamplePresenter(this);
    }

    @Override
    protected Fragment getFirstFragment() {
        return ExampleFragment.newInstance();
    }
}
