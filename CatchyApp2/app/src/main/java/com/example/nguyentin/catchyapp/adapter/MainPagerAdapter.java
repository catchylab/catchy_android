package com.example.nguyentin.catchyapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.nguyentin.catchyapp.fragment.home.HomeFragment;
import com.example.nguyentin.catchyapp.fragment.home.UserFragment;

public class MainPagerAdapter extends FragmentPagerAdapter{
    HomeFragment homeFragment;
    UserFragment userFragment;

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                if (homeFragment == null){
                    homeFragment = new HomeFragment();
                }
                return homeFragment;
            case 1:
                if (userFragment == null){
                    userFragment = new UserFragment();
                }
                return userFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
