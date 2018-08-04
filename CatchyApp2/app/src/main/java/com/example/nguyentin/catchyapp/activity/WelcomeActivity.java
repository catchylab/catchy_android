package com.example.nguyentin.catchyapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.adapter.WelcomeStyleAdapter;
import com.example.nguyentin.catchyapp.startup.HomeActivity;

public class WelcomeActivity extends AppCompatActivity {
    // View
    private RecyclerView recWelcomeStyle;
    private FrameLayout frameNext;

    private WelcomeStyleAdapter adapter;
    private GridLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();

        layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        adapter = new WelcomeStyleAdapter(this);

        recWelcomeStyle.setLayoutManager(layoutManager);
        recWelcomeStyle.setAdapter(adapter);

        frameNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoHome();
            }
        });
    }

    private void initView(){
        recWelcomeStyle = (RecyclerView) findViewById(R.id.recWelcomeStyle);
        frameNext = (FrameLayout) findViewById(R.id.frameNext);
    }

    private void gotoHome(){
        Intent intent = new Intent(this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
