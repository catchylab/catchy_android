package com.example.nguyentin.catchyapp.adapter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.fragment.SignUp.EmailPassFragment;
import com.example.nguyentin.catchyapp.fragment.SignUp.UserInfoFragment;

public class SignUpPagerAdapter extends FragmentPagerAdapter {

    public SignUpPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new EmailPassFragment();
            case 1:
                return new UserInfoFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
