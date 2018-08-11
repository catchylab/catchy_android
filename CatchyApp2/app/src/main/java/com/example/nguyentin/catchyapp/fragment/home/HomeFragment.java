package com.example.nguyentin.catchyapp.fragment.home;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.activity.ExploreActivity;
import com.example.nguyentin.catchyapp.activity.MainActivity;
import com.example.nguyentin.catchyapp.adapter.TestAdapter;
import com.example.nguyentin.catchyapp.model.TestModel;
import com.example.nguyentin.catchyapp.ui.view.CatchyCamera;
import com.example.nguyentin.catchyapp.util.ActivityUtil;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements View.OnClickListener {

    // View
    View view;
    RecyclerView recHotDeal;
    ArrayList<TestModel> list;
    FrameLayout btnExplore;
    ScrollView nestedScroll;
    LinearLayout linearSmallIcon, linearScroll;
    ConstraintLayout constraintParent, constraintHeader;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        view = inflater.inflate(R.layout.fragment_home, container, false);
        initView();

        list = new ArrayList<>();
        list.add(new TestModel(BitmapFactory.decodeResource(getResources(), R.drawable.test_hot_deal_1), "Cute summer dress HOT SALE UP TO 50%", "YAME Shop"));
        list.add(new TestModel(BitmapFactory.decodeResource(getResources(), R.drawable.test_hot_deal_2), "Cute summer dress HOT SALE UP TO 50%", "YAME Shop"));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recHotDeal.setLayoutManager(linearLayoutManager);

        TestAdapter adapter = new TestAdapter(getContext(), list);
        recHotDeal.setAdapter(adapter);

        btnExplore.setOnClickListener(this);
        return view;
    }

    private void initView(){
        recHotDeal = (RecyclerView) view.findViewById(R.id.recHotDeal);
        btnExplore = (FrameLayout) view.findViewById(R.id.btnExplore);
        nestedScroll = (ScrollView) view.findViewById(R.id.nestedScroll);

        linearSmallIcon  = (LinearLayout) view.findViewById(R.id.linearSmallIcon);
        linearScroll     = (LinearLayout) view.findViewById(R.id.linearScroll);

        constraintParent = (ConstraintLayout) view.findViewById(R.id.constraintParent);
        constraintHeader = (ConstraintLayout) view.findViewById(R.id.constraintHeader);

        nestedScroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                int scrollY = nestedScroll.getScrollY(); // For ScrollView

                if (scrollY > 30){
                    constraintHeader.setVisibility(View.INVISIBLE);
                    linearSmallIcon.setVisibility(View.VISIBLE);
                }else {
                    constraintHeader.setVisibility(View.VISIBLE);
                    linearSmallIcon.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnExplore:
                ActivityUtil.launchActivity(getActivity(), ExploreActivity.class);
                break;
        }
    }
}
