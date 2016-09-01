package com.example.d07_recyclerviewtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by baeks on 8/30/2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.TextViewHolder> {

    private static final String TAG = MyAdapter.class.getSimpleName();

    private TextView tvStatus;
    private TextViewHolder lastCreatedHolder;
    private List<Map<String,String>> list;
    private Context context;

    public MyAdapter(Context context, List<Map<String,String>> list) {
        this.context=context;
        this.list=list;
        AppCompatActivity activity=(AppCompatActivity)context;
        this.tvStatus = (TextView) activity.findViewById(R.id.status );
    }


    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(context).inflate(R.layout.list_item , parent , false );
        return lastCreatedHolder = new TextViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        Map<String,String> data=list.get(position);
        holder.tvHolderNo.setText( "Wonum : " + data.get("wonum"));
        holder.tvPosition.setText("Location : "+data.get("location"));
        holder.tvContents.setText("Description : "+data.get("description"));
        Log.d("onBindViewHolder : ",position+"");
    }

    @Override
    public void onViewRecycled (TextViewHolder holder) {
        super.onViewRecycled(holder);
        tvStatus.setText(String.format( "Recycled Holder: %d, Max Holder Count: %d" , holder. holderCount , lastCreatedHolder . holderCount )) ;
    }

    @Override
    public int getItemCount() {
        Log.d("getItemCount : ",list.size()+"");
        return list.size();
    }






    int lastHolderCount;

    class TextViewHolder extends RecyclerView.ViewHolder {
        TextView tvHolderNo;
        TextView tvPosition;
        TextView tvContents;

        int holderCount;

        public TextViewHolder(View itemView) {
            super(itemView);
            tvHolderNo = (TextView)itemView.findViewById(R.id.holder);
            tvPosition = (TextView)itemView.findViewById(R.id.position);
            tvContents = (TextView)itemView.findViewById(R.id.contents);

            holderCount = lastHolderCount++;
        }
    }
}
