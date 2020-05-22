package com.inube.mvparchitectureex.Utils;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.androidnetworking.interceptors.HttpLoggingInterceptor.Level;
import com.inube.mvparchitectureex.Data.DataManager;
import com.inube.mvparchitectureex.di.component.ApplicationComponent;
import com.inube.mvparchitectureex.di.component.DaggerApplicationComponent;
import com.inube.mvparchitectureex.di.module.ApplicationModule;


import javax.inject.Inject;

import timber.log.BuildConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MvpArchotectureApp extends Application {
    @Inject
    DataManager mDataManager;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

        mApplicationComponent.inject(this);

        AppLogger.init();

        AndroidNetworking.initialize(getApplicationContext());
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig);
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
