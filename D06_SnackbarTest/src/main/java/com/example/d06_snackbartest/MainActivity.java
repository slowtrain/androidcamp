package com.example.d06_snackbartest;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Snackbar snackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View rootView =findViewById(R.id.activity_main);
        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    snackbar.show();

            }
        });
        // 스낵바는 하나만 가능
        snackbar=Snackbar.make(rootView,"두번째 스낵바입니다.",Snackbar.LENGTH_LONG);
        snackbar.setAction("버튼1", new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"1 토스트를 띄웠습니다.",Toast.LENGTH_LONG).show();
            }
        });



    }
}
