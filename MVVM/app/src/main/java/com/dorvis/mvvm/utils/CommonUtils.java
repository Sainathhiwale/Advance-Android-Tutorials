package com.dorvis.mvvm.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class CommonUtils {
    private ProgressDialog progressDialog;

    public ProgressDialog startProgressDialog(Context context,String message){
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.show();
        return progressDialog;
    }
    public ProgressDialog stopProgressDialog(Context context){
        progressDialog = new ProgressDialog(context);
        progressDialog.dismiss();
        return progressDialog;
    }
}
