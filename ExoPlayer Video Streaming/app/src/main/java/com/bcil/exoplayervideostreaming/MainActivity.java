package com.bcil.exoplayervideostreaming;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.buttonPlayUrlVideo)
    Button buttonPlayUrlVideo;
    @BindView(R.id.buttonPlayDefaultVideo)
    Button buttonPlayDefaultVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        ButterKnife.bind(this);
    }

    @OnClick({R.id.buttonPlayUrlVideo, R.id.buttonPlayDefaultVideo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonPlayUrlVideo:
                showDialogPrompt();
                break;
            case R.id.buttonPlayDefaultVideo:
                Intent mIntent = ExoPlayerActivity.getStartIntent(this, VideoPlayerConfig.DEFAULT_VIDEO_URL);
                startActivity(mIntent);
                break;
        }
    }

    private void showDialogPrompt() {
        LayoutInflater li = LayoutInflater.from(this);
        View promptsView = li.inflate(R.layout.dialog_prompts,null);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        // set dialog_prompts.xml to dialog
        mBuilder.setView(promptsView);
        final EditText userInputURL = (EditText) promptsView
                .findViewById(R.id.editTextDialogUrlInput);

        mBuilder.setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                        boolean isURL = Patterns.WEB_URL.matcher(userInputURL.getText().toString().trim()).matches();
                        if (isURL){
                            Intent mIntent = ExoPlayerActivity.getStartIntent(MainActivity.this, userInputURL.getText().toString().trim());
                            startActivity(mIntent);
                        }else {
                            Toast.makeText(MainActivity.this, getString(R.string.error_message_url_not_valid), Toast.LENGTH_SHORT).show();
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int id) {
                       dialogInterface.dismiss();
                    }
                }).create().show();
    }
}
