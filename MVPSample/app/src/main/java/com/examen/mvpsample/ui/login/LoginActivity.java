package com.examen.mvpsample.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.examen.mvpsample.MainActivity;
import com.examen.mvpsample.R;
import com.examen.mvpsample.base.MyApp;
import com.examen.mvpsample.data.models.User;
import com.examen.mvpsample.data.prefs.DataManager;
import com.examen.mvpsample.utils.AppConstants;
import com.examen.mvpsample.utils.CommonUtils;
import com.examen.mvpsample.utils.Validation;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {
    private static final String TAG = "LoginActivity";
    @Bind(R.id.tvTitle)
    TextView tvTitle;
    @Bind(R.id.etEmail)
    EditText etEmail;
    @Bind(R.id.etPassword)
    EditText etPassword;
    @Bind(R.id.btnLogin)
    Button btnLogin;
    @Bind(R.id.llloginLayout)
    LinearLayout llloginLayout;
    private LoginPresenterImpl presenter;
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        dataManager = ((MyApp) getApplication()).getDataManager();
        if (dataManager.getLoggedInMode()){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            presenter = new LoginPresenterImpl(this);
        }

    }

    @OnClick(R.id.btnLogin)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnLogin:
                if (checkValidation()){
                    userLogin();
                }else {
                    Toast.makeText(this, "Please enter the fields!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private boolean checkValidation() {
        boolean valid = true;
        if (!Validation.hasText(etEmail)) valid = false;
        if (!Validation.hasText(etPassword)) valid = false;
        return valid;
    }

    private void userLogin() {
        presenter = new LoginPresenterImpl(this, new GetLoginIntractorImpl(etEmail.getText().toString().trim(), etPassword.getText().toString().trim(), 1));
        presenter.validateLoginInFromServer();
    }

    @Override
    public void showProgress() {
        CommonUtils.startProgressBarDialog(LoginActivity.this, "Wait Sign In....");

    }

    @Override
    public void hideProgress() {
      CommonUtils.stopProgressBarDialog();
    }

    @Override
    public void setLoginInfoData(User user) {
        if (user != null) {
          String email = user.getUserName();
           dataManager.setUserName(email);
            Intent homeIntent = new Intent(this, MainActivity.class);
            homeIntent.putExtra(AppConstants.USERNAME,email);
            startActivity(homeIntent);
            finish();
        }
    }

    @Override
    public void onFailureResponse(Throwable throwable) {
        Snackbar snackbar = Snackbar.make(llloginLayout,"Something went wrong!",Snackbar.LENGTH_SHORT);
        snackbar.show();
    }
}
