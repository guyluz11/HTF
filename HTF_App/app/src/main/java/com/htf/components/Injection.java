package com.htf.components;

public class Injection {
    private static ComponentProvider provider;

    public static void setProvider(ComponentProvider provider) {
        Injection.provider = provider;
    }

    public static ComponentProvider getProvider() {
        return provider;
    }


}
