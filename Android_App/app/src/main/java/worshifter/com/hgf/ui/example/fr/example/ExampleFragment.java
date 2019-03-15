package worshifter.com.hgf.ui.example.fr.example;

import android.os.Bundle;

import com.mdgd.lib.v7.fragment.HostedFragment;

import javax.inject.Inject;

import androidx.annotation.Nullable;


public class ExampleFragment extends HostedFragment<ExampleFragmentContract.IPresenter,
        ExampleFragmentContract.IHost> implements ExampleFragmentContract.IView {

    @Inject
    protected ExampleFragmentContract.IPresenter presenter;

    public static ExampleFragment newInstance() {
        return new ExampleFragment();
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerExampleFragmentComponent.builder()
                .exampleFragmentModule(new ExampleFragmentModule(this))
                .build().injectPresenter(this);
    }
}
