package com.example.nguyentin.catchyapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.communication.OnItemClickListener;

import java.util.Calendar;
import java.util.Date;

public class YearPickerAdapter extends RecyclerView.Adapter<YearPickerAdapter.YearHolder>{
    private int currentYear;
    private OnItemClickListener onItemClickListener;

    public YearPickerAdapter() {
        currentYear = Calendar.getInstance().get(Calendar.YEAR);
    }

    public int getCurrentYear(){
        return currentYear;
    }

    @NonNull
    @Override
    public YearHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new YearHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_year_picker, null));
    }

    @Override
    public void onBindViewHolder(@NonNull YearHolder holder, int position) {
        if (position < 2 || position > 101){
            holder.txtYear.setText("");
        }else {
            holder.txtYear.setText(currentYear - 101 + position + "");
        }
    }

    @Override
    public int getItemCount() {
        return 104;
    }

    public void addOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    public class YearHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView txtYear;

        public YearHolder(View itemView) {
            super(itemView);
            txtYear = (TextView) itemView.findViewById(R.id.txtYear);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (onItemClickListener != null){
                if (!txtYear.getText().equals("")){
                    onItemClickListener.onClick(getAdapterPosition(), txtYear.getText().toString());
                }
            }
        }
    }
}
