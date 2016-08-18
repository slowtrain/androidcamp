package com.example.sendtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cafelivro.oslc.HTTPToMaximo;
import com.ibm.json.java.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HTTPToMaximo toMaximo=new HTTPToMaximo("http","192.168.0.15","7001","maxadmin","maxadmin");
                //HTTPToMaximo toMaximo=new HTTPToMaximo("http://ayme:7001/maximo/oslc/os");
                System.out.println(toMaximo.getBasicUri());
                addPerson(toMaximo);
            }
        });
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HTTPToMaximo toMaximo=new HTTPToMaximo("http","192.168.0.15","7001","maxadmin","maxadmin");
                //HTTPToMaximo toMaximo=new HTTPToMaximo("http://ayme:7001/maximo/oslc/os");
                System.out.println(toMaximo.getBasicUri());
                addAsset(toMaximo);
            }
        });

    }

    public  void addPerson(HTTPToMaximo toMaximo){
        //Create JSONObject here
        JSONObject person = new JSONObject();
        person.put("spi:personid", "TEST001");
        person.put("spi:displayname", "TEST001");

        toMaximo.add("oslcperson", person);
    }

    public static void addAsset(HTTPToMaximo toMaximo){
        //Create JSONObject here
        JSONObject asset = new JSONObject();
        asset.put("spi:assetnum", "TEST001");
        asset.put("spi:description", "8151007test");
        asset.put("spi:siteid", "BEDFORD");
        toMaximo.add("oslcasset", asset);
    }

}
