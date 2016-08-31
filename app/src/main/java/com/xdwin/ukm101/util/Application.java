package com.xdwin.ukm101.util;

import timber.log.Timber;

/**
 * Created by Edwin on 8/31/2016.
 */
public class Application extends android.app.Application {

    private final boolean DEBUG_MODE = true;

    @Override
    public void onCreate() {
        super.onCreate();
        if (DEBUG_MODE){
            Timber.plant(new Timber.DebugTree());
        }
    }
}
