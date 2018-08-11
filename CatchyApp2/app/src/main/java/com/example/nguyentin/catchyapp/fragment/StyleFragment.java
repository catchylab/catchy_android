package com.example.nguyentin.catchyapp.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.nguyentin.catchyapp.R;

/**
 * Create by DavidSon Nguyen
 */

public class StyleFragment extends Fragment {
    // View
    View view;
    ImageView imgTest;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_style, container, false);
        imgTest = (ImageView) view.findViewById(R.id.imgTest);
        return view;
    }
}
