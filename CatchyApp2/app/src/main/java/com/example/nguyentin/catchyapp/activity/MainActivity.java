package com.example.nguyentin.catchyapp.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.adapter.MainPagerAdapter;
import com.example.nguyentin.catchyapp.ui.view.CatchyCamera;
import com.example.nguyentin.catchyapp.ui.view.HomeMenuBar;

/**
 * Create by DavidSon Nguyen
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, HomeMenuBar.OnCheckedChange, ViewPager.OnPageChangeListener {
    ViewPager viewPager;
    HomeMenuBar homeMenuBar;
    ImageView imgCamera;

    MainPagerAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initView();
    }

    private void initView(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        homeMenuBar = (HomeMenuBar) findViewById(R.id.homeMenuBar);
        imgCamera = (ImageView) findViewById(R.id.imgCamera);

        adapter = new MainPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        imgCamera.setOnClickListener(this);
        viewPager.addOnPageChangeListener(this);
        homeMenuBar.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        CatchyCamera.openCamera(this);
    }

    // bar change
    @Override
    public void onChanged(View view, int checkedId) {
        viewPager.setCurrentItem(checkedId);
    }

    // pager change
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        homeMenuBar.check(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
