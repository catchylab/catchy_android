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

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);

        List<ItemObjects> gaggeredList = getListItemData();

        ItemHomeViewAdapter rcAdapter = new ItemHomeViewAdapter(HomeActivity.this, gaggeredList);
        recyclerView.setAdapter(rcAdapter);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, CameraActivity.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<ItemObjects> getListItemData(){
        List<ItemObjects> listViewItems = new ArrayList<ItemObjects>();
        listViewItems.add(new ItemObjects("Alkane", R.drawable.one));
        listViewItems.add(new ItemObjects("Ethane", R.drawable.two));
        listViewItems.add(new ItemObjects("Alkyne", R.drawable.album3));
        listViewItems.add(new ItemObjects("Benzene", R.drawable.album4));
        listViewItems.add(new ItemObjects("Amide", R.drawable.one));
        listViewItems.add(new ItemObjects("Amino Acid", R.drawable.two));
        listViewItems.add(new ItemObjects("Phenol", R.drawable.album7));
        listViewItems.add(new ItemObjects("Carbonxylic", R.drawable.album8));
        listViewItems.add(new ItemObjects("Nitril", R.drawable.album9));
        listViewItems.add(new ItemObjects("Ether", R.drawable.album10));
        listViewItems.add(new ItemObjects("Ester", R.drawable.album1));
        listViewItems.add(new ItemObjects("Alcohol", R.drawable.album11));

        return listViewItems;
    }
}
