package com.example.sendtest;

import android.app.Activity;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cafelivro.oslc.HTTPToMaximo;
import com.ibm.json.java.JSONObject;

public class MainActivity extends AppCompatActivity {
    public static final String TARGET_ASSET="ASSET";
    public static final String TARGET_PERSON="PERSON";
    public static final String TARGET_WORKORDER="WORKORDER";
    String url;
    String port;
    String user;
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        url = getString(R.string.maximourl);
        port = getString(R.string.maximoport);
        user = getString(R.string.maximouser);
        password = getString(R.string.maximopassword);

        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HTTPAsync async = new HTTPAsync();
                async.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR,TARGET_PERSON);

            }
        });
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HTTPAsync async = new HTTPAsync();
                async.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR,TARGET_ASSET);
            }
        });
        Button button3=(Button)findViewById(R.id.button2);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HTTPAsync async = new HTTPAsync();
                async.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR,TARGET_WORKORDER);
            }
        });

    }




   public class HTTPAsync extends AsyncTask<String,Integer,Integer>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("HTTPASYNC","onPreExecute");
        }

        @Override
        protected Integer doInBackground(String... params) {
            HTTPToMaximo toMaximo=new HTTPToMaximo("http",url,port,user,password);
            Log.d("HTTPASYNC",params[0]);
            String param=params[0];
            switch (param){
                case "PERSON":
                    JSONObject person = new JSONObject();
                    person.put("spi:personid", "TEST001");
                    person.put("spi:displayname", "TEST001");
                    return toMaximo.add("oslcperson", person);
                case "ASSET":
                    JSONObject asset = new JSONObject();
                    asset.put("spi:assetnum", "TEST001");
                    asset.put("spi:description", "8151007test");
                    asset.put("spi:siteid", "BEDFORD");
                    return toMaximo.add("oslcasset", asset);
                case "WORKORDER":
                    JSONObject wo = new JSONObject();
                    wo.put("spi:wonum", "TEST001");
                    wo.put("spi:description", "8151007test");
                    wo.put("spi:siteid", "BEDFORD");
                    return toMaximo.add("oslcwo", wo);
            }

            return -1;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d("HTTPASYNC","onProgressUpdate");
        }


        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Log.d("HTTPASYNC","onPostExecute");
        }

    }


}
