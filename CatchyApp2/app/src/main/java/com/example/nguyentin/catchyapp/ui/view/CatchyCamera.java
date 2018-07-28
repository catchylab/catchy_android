package com.example.nguyentin.catchyapp.ui.view;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.camera.CameraActivity;
import com.example.nguyentin.catchyapp.dialog.PreviewImageDialog;
import com.example.nguyentin.catchyapp.util.OperateBitmap;

import java.io.IOException;

public class CatchyCamera extends Activity implements SurfaceHolder.Callback, Camera.PictureCallback {
    SurfaceView surfaceView;
    Camera camera;
    SurfaceHolder holder;
    boolean mPreviewRunning;

    ImageView imgCapture;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_catchy_camera);
        imgCapture = (ImageView) findViewById(R.id.imgCapture);
        surfaceView = (SurfaceView) findViewById(R.id.surfaceView);

        holder = surfaceView.getHolder();
        holder.addCallback(this);
        holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

        imgCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camera.takePicture(null, null, CatchyCamera.this);
            }
        });
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        camera = Camera.open();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
        if (mPreviewRunning) {
            camera.stopPreview();
        }
        camera.setDisplayOrientation(90);
        Camera.Parameters params = camera.getParameters();
        params.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_PICTURE);

        params.setRotation(90);
        camera.setParameters(params);
        try {
            camera.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        camera.startPreview();
        mPreviewRunning = true;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        camera.stopPreview();
        mPreviewRunning = false;
        camera.release();
    }

    @Override
    public void onPictureTaken(byte[] bytes, final Camera camera) {
        PreviewImageDialog dialog = new PreviewImageDialog(this, bytes, this);
        dialog.show();

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                camera.startPreview();
            }
        });
    }
}
