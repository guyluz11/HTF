package worshifter.com.hgf.components;

import worshifter.com.hgf.ui.example.ExampleActivityPresenter;
import worshifter.com.hgf.ui.example.ExampleContract;
import worshifter.com.hgf.ui.example.fr.ExampleFragmentContract;
import worshifter.com.hgf.ui.example.fr.ExampleFragmentPresenter;

public class Injection {
    private static ComponentProvider provider;

    public static void setProvider(ComponentProvider provider) {
        Injection.provider = provider;
    }

    public static ComponentProvider getProvider() {
        return provider;
    }





    public static ExampleContract.IPresenter getExamplePresenter(ExampleContract.IView view) {
        return new ExampleActivityPresenter(view);
    }

    public static ExampleFragmentContract.IPresenter getExampleFragmentPresenter(ExampleFragmentContract.IView view) {
        return new ExampleFragmentPresenter(view);
    }
}
