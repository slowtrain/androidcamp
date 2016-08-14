package org.cafelivro.d02_activityjumptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent intent = getIntent();
        String title = intent.getStringExtra( "title" );
        setTitle(title != null ? title : "타이틀 없음" );
       //setTitle("Third Activity");

        Button backMain =(Button)findViewById(R.id.third_move_main);
        backMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jumpToMainActivity = new Intent(ThirdActivity.super.getBaseContext(),MainActivity.class);
                jumpToMainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                jumpToMainActivity.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                startActivity(jumpToMainActivity);
            }
        });


        Button moveSecond =(Button)findViewById(R.id.third_move_second);
        moveSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jumpToSecondActivity = new Intent(ThirdActivity.super.getBaseContext(),SecondActivity.class);
                jumpToSecondActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                jumpToSecondActivity.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                startActivity(jumpToSecondActivity);
            }
        });
    }
}
