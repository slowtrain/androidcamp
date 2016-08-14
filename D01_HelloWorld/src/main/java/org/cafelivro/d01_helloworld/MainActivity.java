package org.cafelivro.d01_helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView=(TextView) findViewById(R.id.hello_world);
        button=(Button) findViewById(R.id.hello_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=(String)textView.getText();
                System.out.println(text);
                String[] texts=text.split(":");
                System.out.println(texts[1]);
                Integer aa=Integer.parseInt(texts[1]);
                aa++;
                textView.setText("Click count :"+aa);
            }
        });


    }


    public void changeText(View view){
        textView.setText("휴 돼나돼나");
        Toast.makeText(this,"속이 메스꺼워",Toast.LENGTH_SHORT).show();
    }



}
