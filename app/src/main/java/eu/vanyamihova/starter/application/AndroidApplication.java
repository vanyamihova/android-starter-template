package eu.vanyamihova.starter.application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import eu.vanyamihova.starter.BuildConfig;
import eu.vanyamihova.starter.data.datastore.AppDatabaseManager;

/**
 * Created by Vanya Mihova on 12.01.2018
 */

public final class AndroidApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        setupLeakcanary();
        setupRoom();
        setupDagger();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        AppDatabaseManager.close();
    }

    private void setupLeakcanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }

        // Start Leakcanary only in DEBUG mode
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this);
        }
    }

    private void setupRoom() {
        AppDatabaseManager.create(getApplicationContext());
    }

//    Setup for Dagger 1
    private static DaggerConfiguration mDaggerConfiguration;

    private void setupDagger() {
        mDaggerConfiguration = new DaggerConfiguration(this);
    }

    public static void inject(Object object) {
        mDaggerConfiguration.inject(object);
    }

}
