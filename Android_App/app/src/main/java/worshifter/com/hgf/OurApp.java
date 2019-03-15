package worshifter.com.hgf;

import android.app.Application;

import worshifter.com.hgf.components.ComponentProvider;
import worshifter.com.hgf.components.Injection;

public class OurApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injection.setProvider(new ComponentProvider(this));
    }
}
