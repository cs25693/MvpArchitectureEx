package com.inube.mvparchitectureex.Data.network;

import com.inube.mvparchitectureex.Data.network.ApiHeader;
import com.inube.mvparchitectureex.Data.network.model.BlogResponse;
import com.inube.mvparchitectureex.Data.network.model.LoginRequest;
import com.inube.mvparchitectureex.Data.network.model.LoginResponse;
import com.inube.mvparchitectureex.Data.network.model.LogoutResponse;
import com.inube.mvparchitectureex.Data.network.model.OpenSourceResponse;

import io.reactivex.Single;



public interface ApiHelper {

    ApiHeader getApiHeader();

    Single<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Single<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Single<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Single<LogoutResponse> doLogoutApiCall();

    Single<BlogResponse> getBlogApiCall();

    Single<OpenSourceResponse> getOpenSourceApiCall();
}
