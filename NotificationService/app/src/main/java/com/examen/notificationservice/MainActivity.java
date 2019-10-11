package com.examen.notificationservice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

//foreground service with start_sticky
public class MainActivity extends AppCompatActivity {
    //create the intent for calling service
    Intent serviceIntent;
    @Bind(R.id.btnStartService)
    Button btnStartService;
    @Bind(R.id.btnStopService)
    Button btnStopService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initService();

    }

    private void initService() {
        serviceIntent = new Intent(MainActivity.this,LocalNotificationService.class);
    }

    @OnClick({R.id.btnStartService, R.id.btnStopService})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnStartService:
                startService(serviceIntent);
                Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btnStopService:
                stopService(serviceIntent);
                Toast.makeText(this, "Stopped", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
