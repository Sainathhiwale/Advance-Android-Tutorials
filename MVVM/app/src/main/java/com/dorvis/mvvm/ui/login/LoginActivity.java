package com.dorvis.mvvm.ui.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dorvis.mvvm.MainActivity;
import com.dorvis.mvvm.R;
import com.dorvis.mvvm.base.BaseActivity;
import com.dorvis.mvvm.data.DataManager;
import com.dorvis.mvvm.data.SharedPrefsHelper;
import com.dorvis.mvvm.data.model.User;
import com.dorvis.mvvm.utils.CommonUtils;
import com.dorvis.mvvm.utils.Validation;
import com.dorvis.mvvm.utils.ViewModelFactory;
import com.google.android.material.snackbar.Snackbar;

import javax.inject.Inject;

import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    @BindView(R.id.etName)
    EditText etName;
    @BindView(R.id.etPaasword)
    EditText etPaasword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.llloginLayout)
    LinearLayout llloginLayout;
    private SharedPrefsHelper sharedPrefsHelper;
   private LoginViewModel loginViewModel;

   @Inject
    ViewModelFactory viewModelFactory;

    @Override
    protected int layoutRes() {
        return R.layout.activity_login;

    }

    @Override
    protected void onResume() {
        super.onResume();
        loginViewModel = ViewModelProviders.of(this,viewModelFactory).get(LoginViewModel.class);
        sharedPrefsHelper = new SharedPrefsHelper(LoginActivity.this);
        if (sharedPrefsHelper.getLoggedInMode()){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }



    @OnClick(R.id.btnLogin)
    public void onViewClicked(View view){
        if (view.getId() ==R.id.btnLogin){
            if (checkValidation()){
                //new CommonUtils().startProgressDialog(LoginActivity.this,"Login In....Wait");
                saveUser();
            }else {
                Snackbar snackbar = Snackbar.make(llloginLayout,"No Internet Connection!",Snackbar.LENGTH_SHORT);
                View view1 = snackbar.getView();
                TextView textView = (TextView)view1.findViewById(com.google.android.material.R.id.snackbar_text);
                textView.setTextColor(Color.RED);
                snackbar.show();
            }
        }
    }

    private void saveUser() {
        User user = new User();
        user.setUserName(etName.getText().toString().trim());
        user.setPassword(etPaasword.getText().toString().trim());
        loginViewModel.callLoginUser(user);
         sharedPrefsHelper.putUserEmail(user.getUserName());
         sharedPrefsHelper.setLoggedInMode(true);
      //  new CommonUtils().stopProgressDialog(LoginActivity.this);
        Snackbar snackbar = Snackbar.make(llloginLayout,"Login Successfully!",Snackbar.LENGTH_SHORT);
        View view1 = snackbar.getView();
        TextView textView = (TextView)view1.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(Color.RED);
        snackbar.show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    private boolean checkValidation() {
        boolean valid = true;
        if (!new Validation().hasText(etName)) valid = false;
        if (!new Validation().hasText(etPaasword)) valid = false;
        return valid;
    }
}
