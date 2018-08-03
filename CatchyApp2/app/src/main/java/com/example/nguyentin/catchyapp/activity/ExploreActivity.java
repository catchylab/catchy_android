package com.example.nguyentin.catchyapp.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.adapter.ExploreAdapter;

public class ExploreActivity extends AppCompatActivity implements View.OnClickListener {
    // View

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        initView();

    }

    private void initView(){
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
        }
    }
}
