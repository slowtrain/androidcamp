package org.cafelivro.d02_activityjumptest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String title = intent.getStringExtra( "title" );
        setTitle(title != null ? title : "타이틀 없음" );
        //setTitle("Second Activity");

        Button moveMain =(Button)findViewById(R.id.second_move_main);
        moveMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jumpToMainActivity = new Intent(SecondActivity.super.getBaseContext(),MainActivity.class);
                jumpToMainActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                jumpToMainActivity.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                startActivity(jumpToMainActivity);
            }
        });

        Button moveThird =(Button)findViewById(R.id.second_move_third);
        moveThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jumpToThirdActivity = new Intent(SecondActivity.super.getBaseContext(),ThirdActivity.class);
                jumpToThirdActivity.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                jumpToThirdActivity.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                startActivity(jumpToThirdActivity);
            }
        });


    }


}
