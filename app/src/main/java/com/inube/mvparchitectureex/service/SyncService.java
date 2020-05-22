package com.inube.mvparchitectureex.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

import com.inube.mvparchitectureex.Data.DataManager;
import com.inube.mvparchitectureex.Utils.AppLogger;
import com.inube.mvparchitectureex.Utils.MvpArchotectureApp;
import com.inube.mvparchitectureex.di.component.DaggerServiceComponent;
import com.inube.mvparchitectureex.di.component.ServiceComponent;

import javax.inject.Inject;

import io.reactivex.annotations.Nullable;


public class SyncService extends Service {

    private static final String TAG = "SyncService";

    @Inject
    DataManager mDataManager;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SyncService.class);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, SyncService.class);
        context.startService(starter);
    }

    public static void stop(Context context) {
        context.stopService(new Intent(context, SyncService.class));
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ServiceComponent component = DaggerServiceComponent.builder()
                .applicationComponent(((MvpArchotectureApp) getApplication()).getComponent())
                .build();
        component.inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        AppLogger.d(TAG, "SyncService started");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        AppLogger.d(TAG, "SyncService stopped");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
