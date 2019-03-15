package worshifter.com.hgf.ui.example;

import android.os.Bundle;

import com.mdgd.lib.v7.fragment.HostActivity;

import javax.inject.Inject;

import androidx.fragment.app.Fragment;
import worshifter.com.hgf.ui.example.fr.example.ExampleFragment;

public class ExampleActivity extends HostActivity<ExampleContract.IPresenter> implements ExampleContract.IView {

    @Inject
    public ExampleContract.IPresenter presenter;

    @Override
    protected Fragment getFirstFragment() {
        return ExampleFragment.newInstance();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerExampleActivityComponent.builder()
                .exampleActivityModule(new ExampleActivityModule(this))
                .build().injectPresenter(this);
    }
}
