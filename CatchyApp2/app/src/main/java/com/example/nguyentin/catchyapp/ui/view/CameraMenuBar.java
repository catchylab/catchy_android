package com.example.nguyentin.catchyapp.ui.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.nguyentin.catchyapp.R;

public class CameraMenuBar extends ConstraintLayout {
    // Constructor
    private Context context;

    // View
    ImageView imgCamera, imgMovie, imgMessage;

    public CameraMenuBar(Context context) {
        super(context);
        this.context = context;
        initView();
    }

    public CameraMenuBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    public CameraMenuBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView(){
        inflate(context, R.layout.view_camera_menu_bar, this);
        imgCamera  = (ImageView) findViewById(R.id.imgCamera);
        imgMovie   = (ImageView) findViewById(R.id.imgMovie);
        imgMessage = (ImageView) findViewById(R.id.imgMessage);
    }

    public ImageView getImgCamera() {
        return imgCamera;
    }

    public ImageView getImgMessage() {
        return imgMessage;
    }

    public ImageView getImgMovie() {
        return imgMovie;
    }
}
