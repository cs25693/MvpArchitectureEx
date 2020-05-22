package com.inube.mvparchitectureex.di.component;

import android.app.Application;
import android.content.Context;

import com.inube.mvparchitectureex.Data.DataManager;
import com.inube.mvparchitectureex.Utils.MvpArchotectureApp;
import com.inube.mvparchitectureex.di.ApplicationContext;
import com.inube.mvparchitectureex.di.module.ApplicationModule;
import com.inube.mvparchitectureex.service.SyncService;

import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpArchotectureApp app);

    void inject(SyncService service);

    @ApplicationContext
    Context context();

    Application application();

    DataManager getDataManager();
}