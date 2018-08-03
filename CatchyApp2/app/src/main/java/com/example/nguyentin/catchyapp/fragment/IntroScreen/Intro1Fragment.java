package com.example.nguyentin.catchyapp.fragment.IntroScreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.nguyentin.catchyapp.R;

public class Intro1Fragment extends Fragment {
    View view;
    ImageView imgForAnim;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_intro_1, container, false);
        imgForAnim = (ImageView) view.findViewById(R.id.imgForAnim);
        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.intro_camera_anim);
        imgForAnim.setAnimation(animation);
        return view;
    }
}
