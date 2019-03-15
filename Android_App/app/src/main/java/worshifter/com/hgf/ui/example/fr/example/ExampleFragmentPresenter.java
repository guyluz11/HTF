package worshifter.com.hgf.ui.example.fr.example;

import com.mdgd.lib.v7.fragment.FragmentPresenter;

public class ExampleFragmentPresenter extends FragmentPresenter<ExampleFragmentContract.IView>
        implements ExampleFragmentContract.IPresenter {

    public ExampleFragmentPresenter(ExampleFragmentContract.IView view) {
        super(view);
    }
}
