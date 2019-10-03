package com.dorvis.daggersample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dorvis.daggersample.base.App;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Bind(R.id.tvTitle)
    TextView tvTitle;
    @Bind(R.id.ivMember)
    ImageView ivMember;
    @Bind(R.id.etMemberId)
    EditText etMemberId;
    @Bind(R.id.btnSubmit)
    Button btnSubmit;

    @Inject
    MemberDataManager memberDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        App.getApp().getMemberAppComponent().inject(this);
    }

    @OnClick(R.id.btnSubmit)
    public void onViewClicked() {
      checkMemberID();
    }

    private void checkMemberID() {
        if (etMemberId.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Member ID is empty", Toast.LENGTH_SHORT).show();
        }else {
            String input = etMemberId.getText().toString();

            String result = memberDataManager.checkMemberStatus(input);
            Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

        }
    }
}
