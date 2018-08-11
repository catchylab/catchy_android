package com.example.nguyentin.catchyapp.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.adapter.ExploreAdapter;
import com.example.nguyentin.catchyapp.ui.view.CatchyCamera;

/**
 * Create by DavidSon Nguyen
 */

public class ExploreActivity extends AppCompatActivity implements View.OnClickListener {
    // View
    ImageView imgBack, imgCamera;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        initView();

    }

    private void initView(){
        imgBack   = (ImageView) findViewById(R.id.imgBack);
        imgCamera = (ImageView) findViewById(R.id.imgCamera);

        imgBack.setOnClickListener(this);
        imgCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBack:
                finish();
                break;
            case R.id.imgCamera:
                CatchyCamera.openCamera(this);
                break;
        }
    }
}
