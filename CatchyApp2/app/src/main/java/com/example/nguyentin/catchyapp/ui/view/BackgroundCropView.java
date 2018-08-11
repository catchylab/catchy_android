package com.example.nguyentin.catchyapp.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.drm.DrmStore;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.nguyentin.catchyapp.R;

/**
 * Create by DavidSon Nguyen
 */

public class BackgroundCropView extends LinearLayout {
    // Constructor
    private Context context;

    // View
    private FrameLayout displayView;
    private View viewTop, viewBottom, viewLeft, viewRight, tempView1, tempView2, tempView3, tempView4;

    // Parameter
    private int side;
    private int colorBackground;

    public BackgroundCropView(Context context) {
        super(context);
        initView(context);
    }

    public BackgroundCropView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        initAttribute(context, attrs);
    }

    public BackgroundCropView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        initAttribute(context, attrs);
    }

    private void initView(Context context){
        inflate(context, R.layout.view_background_crop, this);
        displayView = (FrameLayout) findViewById(R.id.frameDisplay);
        viewTop    = (View) findViewById(R.id.viewTop   );
        viewBottom = (View) findViewById(R.id.viewBottom);
        viewLeft   = (View) findViewById(R.id.viewLeft  );
        viewRight  = (View) findViewById(R.id.viewRight );

        tempView1 = (View) findViewById(R.id.tempView1);
        tempView2 = (View) findViewById(R.id.tempView2);
        tempView3 = (View) findViewById(R.id.tempView3);
        tempView4 = (View) findViewById(R.id.tempView4);

    }

    private void initAttribute(Context context, AttributeSet attributeSet){
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.BackgroundCropView);
        side = typedArray.getDimensionPixelSize(R.styleable.BackgroundCropView_side, 230);
        colorBackground = typedArray.getColor(R.styleable.BackgroundCropView_colorBackground, 0);

        displayView.setLayoutParams(new LayoutParams(side, side));
        viewTop.setBackgroundColor(colorBackground);
        viewBottom.setBackgroundColor(colorBackground);
        viewLeft.setBackgroundColor(colorBackground);
        viewRight.setBackgroundColor(colorBackground);

        tempView1.setBackgroundColor(colorBackground);
        tempView2.setBackgroundColor(colorBackground);
        tempView3.setBackgroundColor(colorBackground);
        tempView4.setBackgroundColor(colorBackground);
        typedArray.recycle();
    }

    public int getXCrop(){
        return (getWidth() - side) / 2;
    }

    public int getYCrop(){
        return (getHeight() - side) / 2;
    }

    public int getSide(){
        return  side;
    }
}
