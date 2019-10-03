package com.examen.mvpsample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.examen.mvpsample.base.MyApp;
import com.examen.mvpsample.data.prefs.DataManager;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.examen.mvpsample.utils.AppConstants.USERNAME;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.tvEmail)
    TextView tvEmail;
    private DataManager dataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dataManager = ((MyApp) getApplication()).getDataManager();
        dataManager.setLoggedIn();

        String email = getIntent().getStringExtra(USERNAME);
        if (email!=null){
            tvEmail.setText(email);
        }else {
            tvEmail.setText(dataManager.getUserName());
        }
    }
}
