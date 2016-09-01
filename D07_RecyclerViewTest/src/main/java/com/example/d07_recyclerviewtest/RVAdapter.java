package com.example.d07_recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by baeks on 8/30/2016.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.TextViewHolder> {

    private static final String TAG = RVAdapter.class.getSimpleName();
    private static final int LIST_COUNT = 100;
    private TextView tvStatus;
    private TextViewHolder lastCreatedHolder;
    public RVAdapter(TextView _tvStatus) {
        tvStatus=_tvStatus;
    }

    @Override
    public TextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item , parent , false );
        return lastCreatedHolder = new TextViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(TextViewHolder holder, int position) {
        holder.tvHolderNo.setText( "holder: " + holder.holderCount);
        holder.tvPosition.setText("position: "+position);
        holder.tvContents.setText(" Main Contents");
    }

    @Override
    public void onViewRecycled (TextViewHolder holder) {
        super.onViewRecycled(holder);
        tvStatus.setText(String.format( "Recycled Holder: %d, Max Holder Count: %d" , holder. holderCount , lastCreatedHolder . holderCount )) ;
    }

    @Override
    public int getItemCount() {
        return LIST_COUNT;
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
