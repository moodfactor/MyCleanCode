package com.example.mycleancode.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.example.mycleancode.R;

import androidx.appcompat.app.AlertDialog;

public class ProgressLoader {
    private AlertDialog alertDialog;

    public ProgressLoader(Context context) {
        alertDialog = new AlertDialog.Builder(context).create();
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_progress, null);
        alertDialog.setView(view);
        alertDialog.setCancelable(false);
    }

    public void show() {
        alertDialog.show();
    }

    public void hide() {
        alertDialog.dismiss();
    }
}
