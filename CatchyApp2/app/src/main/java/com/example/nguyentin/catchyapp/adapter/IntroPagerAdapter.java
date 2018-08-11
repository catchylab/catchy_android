package com.example.nguyentin.catchyapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.nguyentin.catchyapp.fragment.IntroScreen.Intro1Fragment;
import com.example.nguyentin.catchyapp.fragment.IntroScreen.Intro2Fragment;
import com.example.nguyentin.catchyapp.fragment.IntroScreen.Intro3Fragment;

/**
 * Create by DavidSon Nguyen
 */

public class IntroPagerAdapter extends FragmentPagerAdapter {
    public IntroPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new Intro1Fragment();
                break;
            case 1:
                fragment = new Intro2Fragment();
                break;
            case 2:
                fragment = new Intro3Fragment();
                break;
            default:
                fragment = new Fragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
