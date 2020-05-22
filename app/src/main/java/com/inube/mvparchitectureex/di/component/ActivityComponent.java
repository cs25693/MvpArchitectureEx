package com.inube.mvparchitectureex.di.component;


import com.inube.mvparchitectureex.SplashActivity;
import com.inube.mvparchitectureex.di.PerActivity;
import com.inube.mvparchitectureex.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
//    void inject(MainActivity activity);
//
//    void inject(LoginActivity activity);

    void inject(SplashActivity activity);

//    activityvoid inject(FeedActivity activity);
//
//    void inject(AboutFragment fragment);
//
//    void inject(OpenSourceFragment fragment);
//
//    void inject(BlogFragment fragment);
//
//    void inject(RateUsDialog dialog);

}
