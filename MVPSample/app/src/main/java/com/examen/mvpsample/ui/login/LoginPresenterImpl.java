package com.examen.mvpsample.ui.login;


import com.examen.mvpsample.data.models.User;

public class LoginPresenterImpl implements LoginContract.LoginPresenter,LoginContract.GetLoginInIntractor.OnLoginInFinishedListener{
    private LoginContract.LoginView loginView;
    private LoginContract.GetLoginInIntractor getLoginInIntractor;

    public LoginPresenterImpl(LoginContract.LoginView loginView, LoginContract.GetLoginInIntractor getLoginInIntractor) {
        this.loginView = loginView;
        this.getLoginInIntractor = getLoginInIntractor;
    }

    public LoginPresenterImpl(LoginContract.LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onDestory() {
        loginView = null;
    }

    @Override
    public void validateLoginInFromServer() {
      if(loginView!=null){
          loginView.showProgress();
          getLoginInIntractor.getLoginInfoData(this);
      }
    }

    @Override
    public void onLoginFinished(User user) {
        if (loginView!=null){
            loginView.hideProgress();
            loginView.setLoginInfoData(user);
        }
    }

    @Override
    public void onLoginFailure(Throwable throwable) {
        if (loginView!=null){
            loginView.hideProgress();
            loginView.onFailureResponse(throwable);
        }
    }
}