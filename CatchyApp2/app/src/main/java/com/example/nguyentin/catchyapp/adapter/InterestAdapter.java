package com.example.nguyentin.catchyapp.adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.model.ItemInterest;

import java.util.List;

public class InterestAdapter extends RecyclerView.Adapter<InterestAdapter.MyViewHolder> {

    private Context mContext;
    private List<ItemInterest> itemInterestList;
    private boolean interest = true;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nameOfItemInterest;
        public ConstraintLayout imageOfItemInterest;
        public ImageView interestOfItemInterest;
        public RelativeLayout interest_alpha;

        public MyViewHolder(View view) {
            super(view);
            nameOfItemInterest = (TextView) view.findViewById(R.id.nameOfItemInterest);
            imageOfItemInterest = (ConstraintLayout) view.findViewById(R.id.imageOfItemInterest);
            interestOfItemInterest = (ImageView) view.findViewById(R.id.interestOfItemInterest);
            interest_alpha  = (RelativeLayout) view.findViewById(R.id.interest_alpha);
        }
    }


    public InterestAdapter(Context mContext, List<ItemInterest> itemInterestList) {
        this.mContext = mContext;
        this.itemInterestList = itemInterestList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_interest, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        ItemInterest itemInterest = itemInterestList.get(position);
        holder.nameOfItemInterest.setText(itemInterestList.get(position).getNameOfItemInterest());
        holder.imageOfItemInterest.setBackgroundResource(itemInterestList.get(position).getImageOfItemInterest());

        if(itemInterestList.get(position).isInterest()==false) {
            holder.interestOfItemInterest.setBackgroundResource(R.drawable.ic_asset_round_not_select);
            holder.imageOfItemInterest.setAlpha(45);
        } else {
            holder.interestOfItemInterest.setBackgroundResource(R.drawable.ic_asset_round_select);
            holder.imageOfItemInterest.setAlpha(50);
        }

        holder.imageOfItemInterest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(itemInterestList.get(position).isInterest()==true) {
                    itemInterestList.get(position).setInterest(false);
                    holder.imageOfItemInterest.setAlpha(100);
                } else {
                    itemInterestList.get(position).setInterest(true);
                    holder.imageOfItemInterest.setAlpha(45);
                }
                notifyDataSetChanged();
            }
        });
    }


    @Override
    public int getItemCount() {
        return itemInterestList.size();
    }
}