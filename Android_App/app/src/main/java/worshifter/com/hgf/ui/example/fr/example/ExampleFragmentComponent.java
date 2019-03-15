package worshifter.com.hgf.ui.example.fr.example;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ExampleFragmentModule.class})
public interface ExampleFragmentComponent {

    void injectPresenter(ExampleFragment view);
}
