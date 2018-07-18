package com.example.nguyentin.catchyapp.startup;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.adapter.TestAdapter;
import com.example.nguyentin.catchyapp.model.TestModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    RecyclerView recHotDeal;

    ArrayList<TestModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recHotDeal = (RecyclerView) findViewById(R.id.recHotDeal);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        
        list = new ArrayList<>();
        list.add(new TestModel(BitmapFactory.decodeResource(getResources(), R.drawable.test_hot_deal_1), "Cute summer dress HOT SALE UP TO 50%", "YAME Shop"));
        list.add(new TestModel(BitmapFactory.decodeResource(getResources(), R.drawable.test_hot_deal_2), "Cute summer dress HOT SALE UP TO 50%", "YAME Shop"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recHotDeal.setLayoutManager(linearLayoutManager);

        TestAdapter adapter = new TestAdapter(getApplicationContext(), list);
        recHotDeal.setAdapter(adapter);
    }
}
