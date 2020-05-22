package com.inube.mvparchitectureex.ui.splash;


import com.inube.mvparchitectureex.ui.base.MvpView;

public interface SplashMvpView extends MvpView {

    void openLoginActivity();

    void openMainActivity();

    void startSyncService();
}
