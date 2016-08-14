package org.cafelivro.d02_activityjumptest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity. class .getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button moveSecond =(Button)findViewById(R.id.main_move_second);
        moveSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jumpToSecondActivity = new Intent(MainActivity.super.getBaseContext(),SecondActivity.class);
                jumpToSecondActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                jumpToSecondActivity.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                jumpToSecondActivity.putExtra("title","MainActivity로부터 전달된 Second Title");
                startActivity(jumpToSecondActivity);
            }
        });

        Log.d( TAG , "LifeCycle: onCreate()" );
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d( TAG , "LifeCycle: onStart()" );
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d( TAG , "LifeCycle: onResume()" );
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d( TAG , "LifeCycle: onPause()" );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d( TAG , "LifeCycle: onDestroy()" );
    }

    public void jumpThird (View view) {
        Intent jumpToThirdActivity = new Intent(this, ThirdActivity.class);
        jumpToThirdActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        jumpToThirdActivity.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        jumpToThirdActivity.putExtra("title","MainActivity로부터 전달된 Third Title");
        startActivity(jumpToThirdActivity);
        //finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Log.d( TAG , "onBackPressed!!!" );
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();

        Log.d( TAG , "onUserLeaveHint!!!" );
    }
}
