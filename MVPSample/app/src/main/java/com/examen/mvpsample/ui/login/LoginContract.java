package com.examen.mvpsample.ui.login;

import com.examen.mvpsample.data.models.User;
public interface LoginContract {
    interface LoginView{
        void showProgress();
        void hideProgress();
        void setLoginInfoData(User user);
        void onFailureResponse(Throwable throwable);
    }

    interface LoginPresenter{
        void onDestory();
        void validateLoginInFromServer();

    }

    interface GetLoginInIntractor{
       interface OnLoginInFinishedListener{
           void onLoginFinished(User user);
           void onLoginFailure(Throwable throwable);
       }

       void getLoginInfoData(OnLoginInFinishedListener loginInFinishedListener);
    }
}
