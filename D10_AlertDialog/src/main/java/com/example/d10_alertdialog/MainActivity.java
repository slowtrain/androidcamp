package com.example.d10_alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(android.R.id.content ).setOnClickListener(this::popupAlertDialog);


    }
    private void showSnackbar(View v , int which) {
        String msg = (which == DialogInterface.BUTTON_POSITIVE? "OK 를 선택하셨습니다." : "Cancel 을 선택하셨습니다." );
        Snackbar.make(v , msg , Snackbar. LENGTH_SHORT ).show();
    }

    private void popupAlertDialog (View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Alert Dialog Test").setMessage("Cancel / OK 를 눌러주세요.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showSnackbar(view, which);
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showSnackbar(view, which);
            }
        }).show();
    }
}



