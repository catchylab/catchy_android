package com.example.nguyentin.catchyapp.startup;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.activity.ExploreActivity;
import com.example.nguyentin.catchyapp.adapter.TestAdapter;
import com.example.nguyentin.catchyapp.model.TestModel;
import com.example.nguyentin.catchyapp.ui.view.CatchyCamera;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, AppBarLayout.OnOffsetChangedListener {

    RecyclerView recHotDeal;
    ArrayList<TestModel> list;
    FrameLayout btnExplore;
    ImageView imgCamera;
    NestedScrollView nestedScroll;

    CoordinatorLayout coordinatorParent;
    AppBarLayout appBarParent;
    CollapsingToolbarLayout collapsing;
    LinearLayout linearSmallIcon, linearScroll;
    ConstraintLayout constraintParent;

    // Var
    int height;
    int linearHeight;
    int parentHeight;
    int cameraHeight;

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
        imgCamera = (ImageView) findViewById(R.id.imgNext);
        nestedScroll = (NestedScrollView) findViewById(R.id.nestedScroll);

        coordinatorParent = (CoordinatorLayout) findViewById(R.id.coordinatorParent);
        appBarParent = (AppBarLayout) findViewById(R.id.appBarParent);
        collapsing = (CollapsingToolbarLayout) findViewById(R.id.collapsing);

        linearSmallIcon  = (LinearLayout) findViewById(R.id.linearSmallIcon);
        linearScroll     = (LinearLayout) findViewById(R.id.linearScroll);

        constraintParent = (ConstraintLayout) findViewById(R.id.constraintParent);

        height = appBarParent.getHeight();

        appBarParent.addOnOffsetChangedListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnExplore:
                Intent intent = new Intent(HomeActivity.this, ExploreActivity.class);
                startActivity(intent);
                break;
            case R.id.imgNext:
                Intent intent1 = new Intent(HomeActivity.this, CatchyCamera.class);
                startActivity(intent1);
                break;
        }
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        float offsetAlpha = (appBarLayout.getY() / appBarLayout.getTotalScrollRange());
        linearSmallIcon.setAlpha(offsetAlpha * (-1));
        if (appBarLayout.getTotalScrollRange() - Math.abs(verticalOffset) < height + 10) {
            //collapse
            linearSmallIcon.setEnabled(true);
//                    collapsing.setScrimVisibleHeightTrigger(appBarLayout.getTotalScrollRange() - (height + 10));
        } else {
            //expands
            linearSmallIcon.setEnabled(false);
//                    collapsing.setScrimVisibleHeightTrigger(5);
        }
    }
}
