package com.inube.mvparchitectureex.di.module;

import android.app.Application;
import android.content.Context;

import com.inube.mvparchitectureex.BuildConfig;
import com.inube.mvparchitectureex.Data.AppDataManager;
import com.inube.mvparchitectureex.Data.DataManager;
import com.inube.mvparchitectureex.Data.Db.AppDbHelper;
import com.inube.mvparchitectureex.Data.Db.DbHelper;
import com.inube.mvparchitectureex.Data.network.ApiHeader;
import com.inube.mvparchitectureex.Data.network.ApiHelper;
import com.inube.mvparchitectureex.Data.network.AppApiHelper;
import com.inube.mvparchitectureex.Data.prefs.AppPreferencesHelper;
import com.inube.mvparchitectureex.Data.prefs.PreferencesHelper;
import com.inube.mvparchitectureex.R;
import com.inube.mvparchitectureex.Utils.AppConstants;
import com.inube.mvparchitectureex.di.ApiInfo;
import com.inube.mvparchitectureex.di.ApplicationContext;
import com.inube.mvparchitectureex.di.DatabaseInfo;
import com.inube.mvparchitectureex.di.PreferenceInfo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}
