package com.example.d09_shapeselectorstyletest;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onStatusChanged (View view) {
        ToggleButton tb = (ToggleButton)view;
        Snackbar.make(view , "상태: " + tb.isChecked() , Snackbar. LENGTH_SHORT).show();
    }


}
