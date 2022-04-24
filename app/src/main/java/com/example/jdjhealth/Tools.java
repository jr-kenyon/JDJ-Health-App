package com.example.jdjhealth;

import android.app.Activity;
import android.app.AlertDialog;

public class Tools {
    public static void sendAlert(Activity activity, String message) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(activity);

        alertBuilder.setTitle("Alert")
                .setMessage(message)
                .setPositiveButton("Continue", (dialog, id) -> {
                    dialog.cancel();
                })
                .setCancelable(true);
        AlertDialog alertDialog = alertBuilder.create();
        alertDialog.show();
    }
}
