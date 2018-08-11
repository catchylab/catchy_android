package com.example.nguyentin.catchyapp.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.nguyentin.catchyapp.fragment.SeenFragment;
import com.example.nguyentin.catchyapp.fragment.StyleFragment;
import com.example.nguyentin.catchyapp.fragment.TrendFragment;

/**
 * Create by DavidSon Nguyen
 */

public class ExploreAdapter extends FragmentPagerAdapter {
    private final int TOTAL_TAB = 3;

    private Context context;

    public ExploreAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TrendFragment();
            case 1:
                return new StyleFragment();
            case 2:
                return  new SeenFragment();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "XU HƯỚNG";
            case 1:
                return "PHONG CÁCH";
            case 2:
                return  "XEM GẦN ĐÂY";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return TOTAL_TAB;
    }
}
