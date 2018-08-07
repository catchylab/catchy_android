package com.example.nguyentin.catchyapp.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.adapter.SignUpAdapter;
import com.example.nguyentin.catchyapp.adapter.SignUpPagerAdapter;
import com.example.nguyentin.catchyapp.layoutmanager.NonScrollLayoutManager;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBack;
    RecyclerView recForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();

        imgBack.setOnClickListener(this);
    }

    private void initView(){
        imgBack = (ImageView) findViewById(R.id.imgBack);
        recForm = (RecyclerView) findViewById(R.id.recForm);

        SignUpAdapter adapter = new SignUpAdapter(this);
        NonScrollLayoutManager linearLayoutManager = new NonScrollLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recForm.setLayoutManager(linearLayoutManager);
        recForm.setAdapter(adapter);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recForm);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        goBack();
    }

    private void goBack(){
        Intent intent = new Intent(this, PreLoginActivity.class);
        startActivity(intent);
    }

    public void gotoNext(){
        recForm.scrollToPosition(1);
    }

    public void gotoPrev(){
        recForm.scrollToPosition(0);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBack:
                goBack();
                break;
        }
    }
}
