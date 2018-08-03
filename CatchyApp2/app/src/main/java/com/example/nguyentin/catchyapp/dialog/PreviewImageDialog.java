package com.example.nguyentin.catchyapp.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nguyentin.catchyapp.MainActivity;
import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.camera.CropImageActivity;
import com.example.nguyentin.catchyapp.ui.view.CropView;
import com.example.nguyentin.catchyapp.util.OperateBitmap;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.UnsupportedEncodingException;

public class PreviewImageDialog extends Dialog implements View.OnClickListener {
    // Constructor
    private Bitmap bitmap;

    // View
    ImageView imgPreview, imgBack;

    public PreviewImageDialog(@NonNull Context context, Bitmap bitmap) {
        super(context, R.style.ResultCaptureDialog);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.bitmap = bitmap;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        setContentView(R.layout.dialog_preview_image);
        initView();

        imgPreview.setImageBitmap(bitmap);
        imgBack.setOnClickListener(this);
    }

    private void initView(){
        imgPreview = (ImageView) findViewById(R.id.imgPreview);
        imgBack    = (ImageView) findViewById(R.id.imgBack);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgBack:
                cancel();
                break;
        }
    }
}
