package com.example.nguyentin.catchyapp.fragment.IntroScreen;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.activity.IntroActivity;
import com.example.nguyentin.catchyapp.startup.HomeActivity;

public class Intro3Fragment extends Fragment {
    View view;
    TextView txtStart;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_intro_3, container, false);
        txtStart = (TextView) view.findViewById(R.id.txtStart);
        txtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((IntroActivity)getActivity()).gotoNextActivity();
            }
        });
        return view;
    }
}
