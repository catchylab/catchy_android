package com.example.nguyentin.catchyapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.model.TestModel;
import com.example.nguyentin.catchyapp.ui.view.RoundedImageView;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {

    private Context context;
    private ArrayList<TestModel> list;

    public TestAdapter(Context context, ArrayList<TestModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_hot_deal, null);
        return new TestHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        TestModel test = list.get(position);
        if (holder != null){
            holder.imgBanner.setImageBitmap(test.getImage());
            holder.txtShopName.setText(test.getName());
            holder.txtContent.setText(test.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TestHolder extends RecyclerView.ViewHolder{
        RoundedImageView imgBanner;
        TextView txtContent, txtShopName;

        public TestHolder(View itemView) {
            super(itemView);
            imgBanner = (RoundedImageView) itemView.findViewById(R.id.imgBanner);
            txtContent = (TextView) itemView.findViewById(R.id.txtContent);
            txtShopName = (TextView) itemView.findViewById(R.id.txtShopName);
        }
    }
}
