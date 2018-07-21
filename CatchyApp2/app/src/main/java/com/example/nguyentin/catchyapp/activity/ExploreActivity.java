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
    ViewPager viewPager;
    TabLayout tabLayout;
    ExploreAdapter adapter;
    ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);
        initView();
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorBlack),
                getResources().getColor(R.color.colorAccent));

        imgBack.setOnClickListener(this);
    }

    private void initView(){
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        imgBack = (ImageView) findViewById(R.id.imgBack);

        adapter = new ExploreAdapter(this, getSupportFragmentManager());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBack:
                finish();
                break;
        }
    }
}
