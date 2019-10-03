package com.examen.mvpsample.utils;

import android.app.ProgressDialog;
import android.content.Context;

public class CommonUtils {
    private static ProgressDialog mProgressDialog;

    public static void startProgressBarDialog(Context context, String message){
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage(message);
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
    }

    public static void stopProgressBarDialog(){
        mProgressDialog.dismiss();
    }

}
