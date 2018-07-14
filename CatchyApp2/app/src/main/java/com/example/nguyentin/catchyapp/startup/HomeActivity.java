package com.example.nguyentin.catchyapp.startup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.adapter.ItemHomeViewAdapter;
import com.example.nguyentin.catchyapp.camera.CameraActivity;
import com.example.nguyentin.catchyapp.model.ItemObjects;

public class HomeActivity extends AppCompatActivity {

    private StaggeredGridLayoutManager gaggeredGridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }
}
