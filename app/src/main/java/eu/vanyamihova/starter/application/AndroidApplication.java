package eu.vanyamihova.starter.application;

import android.app.Activity;
import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import javax.inject.Inject;

import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import eu.vanyamihova.starter.BuildConfig;
import eu.vanyamihova.starter.data.datastore.AppDatabaseManager;

/**
 * Created by Vanya Mihova on 12.01.2018
 */

public final class AndroidApplication extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

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

    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
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


    private void setupDagger() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

}
