package com.dorvis.mvvm.utils;

import android.widget.EditText;

public class Validation {
    public static final String MSG ="can not be empty!";
    public  boolean hasText(EditText editText) {
       String text = editText.getText().toString().trim();
        editText.setError(null);
        editText.setFocusable(true);
       if (text.length()==0){
           editText.setError(MSG);
           return false;
       }
       return true;
    }
}
