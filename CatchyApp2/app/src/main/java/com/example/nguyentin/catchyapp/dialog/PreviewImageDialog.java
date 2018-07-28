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

public class PreviewImageDialog extends Dialog {
    // Constructor
    private Context context;
    private byte[] bytes;
    private Activity activity;

    // View
    CropView cropView;
    ImageView imgCrop;

    public PreviewImageDialog(@NonNull Context context, byte[] bytes, Activity activity) {
        super(context, android.R.style.Theme_Light_NoTitleBar_Fullscreen);
        this.context = context;
        this.bytes = bytes;
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        setContentView(R.layout.dialog_preview_image);
        cropView = (CropView) findViewById(R.id.cropView);
        imgCrop = (ImageView) findViewById(R.id.imgCrop);

        imgCrop.setImageBitmap(OperateBitmap.rotate(OperateBitmap.getBitmap(bytes), 90));

        int width = activity.getWindowManager().getDefaultDisplay().getWidth();
        int height = activity.getWindowManager().getDefaultDisplay().getHeight();

        Bitmap bitmap1 = Bitmap.createScaledBitmap(((BitmapDrawable) imgCrop.getDrawable())
                .getBitmap(),
                width,
                height, false);

        Bitmap bitmap = Bitmap.createBitmap(bitmap1,
                cropView.getLeft(), cropView.getTop(), width,
                height);

        imgCrop.setImageBitmap(bitmap);

//        cropView.setOnUpCallback(new CropView.OnUpCallback() {
//            @Override
//            public void onRectFinished(Rect rect) {
//                Bitmap bitmap1 = Bitmap.createScaledBitmap(((BitmapDrawable) imgCrop.getDrawable())
//                        .getBitmap(), imgCrop.getWidth(), imgCrop
//                        .getHeight(), false);
//
//                if (rect.height() <= bitmap1.getHeight()
//                        && rect.width() <= bitmap1.getWidth()) {
//                    Bitmap bitmap = Bitmap.createBitmap(bitmap1,
//                            cropView.getLeft(), cropView.getTop(), cropView.getWidth(),
//                            cropView.getHeight());
//
//                    imgCrop.setImageBitmap(bitmap);
//
//                }
//            }
//        });
    }
}
