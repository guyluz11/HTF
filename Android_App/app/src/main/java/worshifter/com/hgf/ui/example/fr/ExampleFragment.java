package worshifter.com.hgf.ui.example.fr;

import com.mdgd.lib.v7.fragment.HostedFragment;

import worshifter.com.hgf.components.Injection;

public class ExampleFragment extends HostedFragment<ExampleFragmentContract.IPresenter,
        ExampleFragmentContract.IHost> implements ExampleFragmentContract.IView {

    public static ExampleFragment newInstance() {
        return new ExampleFragment();
    }

    @Override
    protected ExampleFragmentContract.IPresenter getPresenter() {
        return Injection.getExampleFragmentPresenter(this);
    }

    @Override
    protected int getLayoutResId() {
        return 0;
    }
}
