package worshifter.com.hgf.ui.example;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ExampleActivityModule.class})
public interface ExampleActivityComponent {

    void injectPresenter(ExampleActivity view);
}
