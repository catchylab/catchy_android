package com.example.nguyentin.catchyapp.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.widget.TimePicker;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.adapter.YearPickerAdapter;
import com.example.nguyentin.catchyapp.communication.OnItemClickListener;
import com.example.nguyentin.catchyapp.communication.OnYearPickerResult;

/**
 * Create by DavidSon Nguyen
 */

public class YearPickerDialog extends Dialog {
    private Context context;
    private int year;
    private OnYearPickerResult onYearPickerResult;

    public YearPickerDialog(@NonNull Context context, int year) {
        super(context);
        this.context = context;
        this.year = year;
    }

    RecyclerView recPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_year_picker);
        recPicker = (RecyclerView) findViewById(R.id.recPicker);

        YearPickerAdapter adapter = new YearPickerAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recPicker.setLayoutManager(linearLayoutManager);
        recPicker.setAdapter(adapter);

        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recPicker);

        recPicker.scrollToPosition(year - adapter.getCurrentYear() + 101 - 2);
        adapter.addOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(int position, Object data) {
                if (onYearPickerResult != null){
                    onYearPickerResult.onResult(data);
                    YearPickerDialog.this.cancel();
                }
            }
        });
    }

    public void addOnYearPickerListener(OnYearPickerResult onYearPickerResult){
        this.onYearPickerResult = onYearPickerResult;
    }
}
