package com.example.nguyentin.catchyapp.activity;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.adapter.IntroPagerAdapter;
/**
 * Create by DavidSon Nguyen
 */

public class IntroActivity extends AppCompatActivity {
    ViewPager viewPager;
    IntroPagerAdapter adapter;
    RadioGroup rdg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        rdg = (RadioGroup) findViewById(R.id.rdGroup);

        adapter = new IntroPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        rdg.check(R.id.rb1);
                        break;
                    case 1:
                        rdg.check(R.id.rb2);
                        break;
                    case 2:
                        rdg.check(R.id.rb3);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void scrollTo(int pos){
        viewPager.setCurrentItem(pos);
    }

    public void gotoNextActivity(){
        Intent intent = new Intent(this, PreLoginActivity.class);
        startActivity(intent);
        finish();
    }
}
