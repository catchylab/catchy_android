package com.example.nguyentin.catchyapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nguyentin.catchyapp.R;

/**
 * Create by DavidSon Nguyen
 */

public class StylistAdapter extends RecyclerView.Adapter<StylistAdapter.ViewHolder> {

    public static final int MULTI_CHECK = 1;
    public static final int CLICK = 0;

    private Context context;
    private int flag;

    public StylistAdapter(Context context, int flagAction) {
        this.context = context;
        this.flag = flagAction;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_stylist, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position == 0){
            holder.txtStyleName.setText("Đường phố");
            holder.imgBackground.setImageDrawable(context.getDrawable(R.drawable.album2));
        }

        if (position == 1){
            holder.txtStyleName.setText("Thể thao");
            holder.imgBackground.setImageDrawable(context.getDrawable(R.drawable.album3));
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView imgBackground;
        private TextView txtStyleName;
        private CheckBox cbSelect;
        private View viewNormal, viewSelected;

        public ViewHolder(View itemView) {
            super(itemView);
            imgBackground = (ImageView) itemView.findViewById(R.id.imgBackground);
            cbSelect     = (CheckBox) itemView.findViewById(R.id.cbSelect);

            txtStyleName = (TextView) itemView.findViewById(R.id.txtStyleName);

            viewNormal   = (View) itemView.findViewById(R.id.viewNormal);
            viewSelected = (View) itemView.findViewById(R.id.viewSelected);

            itemView.setOnClickListener(this);

            switch (flag){
                case MULTI_CHECK:
                    cbSelect.setVisibility(View.VISIBLE);
                    break;
                case CLICK:
                    cbSelect.setVisibility(View.GONE);
                    break;
            }
        }

        @Override
        public void onClick(View view) {
            switch (flag){
                case MULTI_CHECK:
                    cbSelect.setChecked(!cbSelect.isChecked());
                    if (cbSelect.isChecked()){
                        viewNormal.setVisibility(View.GONE);
                        viewSelected.setVisibility(View.VISIBLE);
                    }else {
                        viewNormal.setVisibility(View.VISIBLE);
                        viewSelected.setVisibility(View.GONE);
                    }
                    break;
                case CLICK:
                    break;
            }
        }
    }
}
