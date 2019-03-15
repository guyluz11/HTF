package worshifter.com.hgf.ui.example.fr.example;

import dagger.Module;
import dagger.Provides;

@Module
public class ExampleFragmentModule {

    private final ExampleFragmentContract.IView view;

    public ExampleFragmentModule(ExampleFragmentContract.IView view) {
        this.view = view;
    }

    @Provides
    public ExampleFragmentContract.IPresenter providePresenter() {
        return new ExampleFragmentPresenter(view);
    }
}
