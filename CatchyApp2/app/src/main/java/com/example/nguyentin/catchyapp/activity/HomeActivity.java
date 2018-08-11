package com.example.nguyentin.catchyapp.activity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.adapter.TestAdapter;
import com.example.nguyentin.catchyapp.model.TestModel;
import com.example.nguyentin.catchyapp.ui.view.CatchyCamera;

import java.util.ArrayList;

/**
 * Create by DavidSon Nguyen
 */
public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recHotDeal;
    ArrayList<TestModel> list;
    FrameLayout btnExplore;
    ImageView imgCamera;
    ScrollView nestedScroll;
    LinearLayout linearSmallIcon, linearScroll;
    ConstraintLayout constraintParent, constraintHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initView();

        list = new ArrayList<>();
        list.add(new TestModel(BitmapFactory.decodeResource(getResources(), R.drawable.test_hot_deal_1), "Cute summer dress HOT SALE UP TO 50%", "YAME Shop"));
        list.add(new TestModel(BitmapFactory.decodeResource(getResources(), R.drawable.test_hot_deal_2), "Cute summer dress HOT SALE UP TO 50%", "YAME Shop"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recHotDeal.setLayoutManager(linearLayoutManager);

        TestAdapter adapter = new TestAdapter(getApplicationContext(), list);
        recHotDeal.setAdapter(adapter);

        btnExplore.setOnClickListener(this);
        imgCamera.setOnClickListener(this);
    }

    private void initView(){
        recHotDeal = (RecyclerView) findViewById(R.id.recHotDeal);
        btnExplore = (FrameLayout) findViewById(R.id.btnExplore);
        imgCamera = (ImageView) findViewById(R.id.imgCamera);
        nestedScroll = (ScrollView) findViewById(R.id.nestedScroll);

        linearSmallIcon  = (LinearLayout) findViewById(R.id.linearSmallIcon);
        linearScroll     = (LinearLayout) findViewById(R.id.linearScroll);

        constraintParent = (ConstraintLayout) findViewById(R.id.constraintParent);
        constraintHeader = (ConstraintLayout) findViewById(R.id.constraintHeader);

        nestedScroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = nestedScroll.getScrollY(); // For ScrollView

                if (scrollY > 30){
                    constraintHeader.setVisibility(View.INVISIBLE);
                    linearSmallIcon.setVisibility(View.VISIBLE);
                }else {
                    constraintHeader.setVisibility(View.VISIBLE);
                    linearSmallIcon.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnExplore:
                Intent intent = new Intent(HomeActivity.this, ExploreActivity.class);
                startActivity(intent);
                break;
            case R.id.imgCamera:
                CatchyCamera.openCamera(this);
                break;
        }
    }
}