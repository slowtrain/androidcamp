package com.example.d04_launchmodetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public abstract class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intentStandard = new Intent( this, StandardActivity.class );
        final Intent intentSingleTop = new Intent( this, SingleTopActivity.class );
        final Intent intentSingleTask = new Intent( this, SingleTaskActivity.class );
        final Intent intentSingleInstance = new Intent( this, SingleInstanceActivity.class );
    TextView tvActivityLaunchMode = (TextView) findViewById(R.id.tvActivityLaunchMode );
            tvActivityLaunchMode.setText(getClass().getSimpleName());
    findViewById(R.id.btStandard ).setOnClickListener(new View.OnClickListener() {
                                                           @Override
                                                           public void onClick(View view) {

                                                               startActivity(intentStandard);
                                                           }
                                                       });

    findViewById(R.id.btSingleTop ).setOnClickListener(new View.OnClickListener() {
                                                            @Override
                                                            public void onClick(View view) {

                                                                startActivity(intentSingleTop);

                                                            }
                                                        });

    findViewById(R.id.btSingleTask ).setOnClickListener(new View.OnClickListener() {
                                                             @Override
                                                             public void onClick(View view) {
                                                                 startActivity(intentSingleTask);

                                                             }
                                                         });

    findViewById(R.id.btSingleInstance ).setOnClickListener(new View.OnClickListener() {
                                                                 @Override
                                                                 public void onClick(View view) {
                                                                     startActivity(intentSingleInstance);

                                                                 };
                                                             });

}
    @Override
    protected void onNewIntent (Intent intent) {
        super .onNewIntent(intent);
        Toast.makeText( this, "onNewIntent() called!!!" , Toast.LENGTH_SHORT ).show();
    }
}
