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

import org.w3c.dom.Text;

public class WelcomeStyleAdapter extends RecyclerView.Adapter<WelcomeStyleAdapter.ViewHolder> {
    private Context context;

    public WelcomeStyleAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_welcome_style, null);
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

        public ViewHolder(View itemView) {
            super(itemView);
            imgBackground = (ImageView) itemView.findViewById(R.id.imgBackground);
            cbSelect     = (CheckBox) itemView.findViewById(R.id.cbSelect);

            txtStyleName = (TextView) itemView.findViewById(R.id.txtStyleName);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            cbSelect.setChecked(!cbSelect.isChecked());
        }
    }
}
