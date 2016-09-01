package com.example.d07_recyclerviewtest;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    List<Map<String,String>> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvStatus = (TextView) findViewById(R.id.status );
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        //recyclerView.setAdapter(new RVAdapter(tvStatus));

        MyAsyncTask myAsyncTask=new MyAsyncTask(this);
        myAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        recyclerView.setAdapter(new MyAdapter(this,list));



    }

    public class MyAsyncTask extends AsyncTask<String, Integer, List<Map<String,String>>> {

        Context context;
        public MyAsyncTask(Context context){
            list = new ArrayList<Map<String,String>>();
            this.context=context;
        }


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List doInBackground(String... params) {

            Map<String,String> data;
            for(int i=1;i<101;i++){
                data = new HashMap<String,String>();
                data.put("wonum","wonum"+i);
                data.put("location","location"+i);
                data.put("description","description"+i);
                list.add(data);
            }

            return list;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(List<Map<String,String>> list) {
            super.onPostExecute(list);
        }
    }


}
