package com.example.android.android_me.app;

import android.app.Application;

/**
 * @author Renat Kaitmazov
 */

public final class AndroidMeApp extends Application {

    /*------------------------------------------------------------------------*/
    // Lifecycle Events
    /*------------------------------------------------------------------------*/

    @Override
    public final void onCreate() {
        super.onCreate();
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
    }
}
