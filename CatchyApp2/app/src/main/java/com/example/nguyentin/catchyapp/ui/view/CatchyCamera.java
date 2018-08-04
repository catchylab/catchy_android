package com.example.nguyentin.catchyapp.ui.view;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.nguyentin.catchyapp.R;
import com.example.nguyentin.catchyapp.dialog.PreviewImageDialog;
import com.example.nguyentin.catchyapp.util.OperateBitmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CatchyCamera extends Activity implements View.OnClickListener, Camera.PictureCallback {
    RelativeLayout bgPreview;

    Camera mCamera;
    CameraPreview mPreview;

    ImageView imgCapture, imgBack;
    CheckBox checkFlash, checkChangeCamera;
    BackgroundCropView bgCropView;

    private int REQUEST_CODE = 1539;
    private boolean cameraFront = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_catchy_camera);
        initView();

        imgCapture.setOnClickListener(this);
        imgBack.setOnClickListener(this);
        checkFlash.setOnClickListener(this);
        checkChangeCamera.setOnClickListener(this);
    }

    private void initView(){
        bgPreview = (RelativeLayout) findViewById(R.id.surfaceView);

        imgCapture = (ImageView) findViewById(R.id.imgCapture);
        imgBack    = (ImageView) findViewById(R.id.imgBack);

        checkChangeCamera = (CheckBox) findViewById(R.id.checkChangeCamera);
        checkFlash        = (CheckBox) findViewById(R.id.checkFlash);

        bgCropView = (BackgroundCropView) findViewById(R.id.bgCropView);

        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
            checkFlash.setVisibility(View.VISIBLE);
        }else {
            checkFlash.setVisibility(View.GONE);
        }

        if (getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FRONT)){
            checkChangeCamera.setVisibility(View.VISIBLE);
        }else {
            checkChangeCamera.setVisibility(View.GONE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE){
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                mPreview = new CameraPreview(this, mCamera);
                bgPreview.addView(mPreview);

                if (!hasCamera(this)) {
                    Toast toast = Toast.makeText(this, "Sorry, your phone does not have a camera!", Toast.LENGTH_LONG);
                    toast.show();
                    finish();
                }
                if (mCamera == null) {
                    //if the front facing camera does not exist
                    if (findFrontFacingCamera() < 0) {
                        Toast.makeText(this, "No front facing camera found.", Toast.LENGTH_LONG).show();
//                switchCamera.setVisibility(View.GONE);
                    }
                    mCamera = Camera.open(findBackFacingCamera());
                    mPreview.refreshCamera(mCamera);
                }
            }else {
                finish();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CODE);
            return;
        }else {
            if (mPreview == null) {
                mPreview = new CameraPreview(this, mCamera);
                bgPreview.addView(mPreview);
            }
        }

        if (!hasCamera(this)) {
            Toast toast = Toast.makeText(this, "Sorry, your phone does not have a camera!", Toast.LENGTH_LONG);
            toast.show();
            finish();
        }
        if (mCamera == null) {
            //if the front facing camera does not exist
            if (findFrontFacingCamera() < 0) {
                Toast.makeText(this, "No front facing camera found.", Toast.LENGTH_LONG).show();
//                switchCamera.setVisibility(View.GONE);
            }
            mCamera = Camera.open(findBackFacingCamera());
            mPreview.refreshCamera(mCamera);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseCamera();
    }

    private Bitmap cropImage(byte[] bytes){
        int width = bgCropView.getWidth();
        int height = bgCropView.getHeight();

        Bitmap originBitmap = OperateBitmap.getBitmap(bytes);
        Bitmap rotateBitmap = originBitmap;
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) {
            rotateBitmap = OperateBitmap.rotate(originBitmap, 90);
        }
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(rotateBitmap, width, height, true);
        Bitmap cropBitmap   = Bitmap.createBitmap(scaledBitmap, bgCropView.getXCrop(), bgCropView.getYCrop(), bgCropView.getSide(), bgCropView.getSide());
        if (checkChangeCamera.isChecked()){
            cropBitmap = OperateBitmap.flip(cropBitmap, OperateBitmap.VERTICAL);
            cropBitmap = OperateBitmap.flip(cropBitmap, OperateBitmap.HORIZONTAL);
        }

        return cropBitmap;
    }


    public void chooseCamera() {
        //if the camera preview is the front
        if (cameraFront) {
            int cameraId = findBackFacingCamera();
            if (cameraId >= 0) {
                mCamera = Camera.open(cameraId);
                mPreview.refreshCamera(mCamera);
            }
        } else {
            int cameraId = findFrontFacingCamera();
            if (cameraId >= 0) {
                mCamera = Camera.open(cameraId);
                mPreview.refreshCamera(mCamera);
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imgCapture:
                mCamera.takePicture(null, null, this);
                break;
            case R.id.imgBack:
                finish();
                break;
            case R.id.checkFlash:
                if (checkFlash.isChecked()){
                    mPreview.setFlash(true);
                }else {
                    mPreview.setFlash(false);
                }
                break;
            case R.id.checkChangeCamera:
                int camerasNumber = Camera.getNumberOfCameras();
                if (camerasNumber > 1) {
                    releaseCamera();
                    chooseCamera();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Sorry, your phone has only one camera!", Toast.LENGTH_LONG);
                    toast.show();
                }
                break;
        }
    }

    private int findFrontFacingCamera() {
        int cameraId = -1;
        // Search for the front facing camera
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_FRONT) {
                cameraId = i;
                cameraFront = true;
                break;
            }
        }
        return cameraId;
    }

    private int findBackFacingCamera() {
        int cameraId = -1;
        //Search for the back facing camera
        //get the number of cameras
        int numberOfCameras = Camera.getNumberOfCameras();
        //for every camera check
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = new Camera.CameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == Camera.CameraInfo.CAMERA_FACING_BACK) {
                cameraId = i;
                cameraFront = false;
                break;
            }
        }
        return cameraId;
    }

    private boolean hasCamera(Context context) {
        //check if the device has camera
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }

    private void releaseCamera() {
        // stop and release camera
        if (mCamera != null) {
            mCamera.release();
            mCamera = null;
        }
    }

    @Override
    public void onPictureTaken(byte[] bytes, Camera camera) {
        PreviewImageDialog dialog = new PreviewImageDialog(this, cropImage(bytes));
        dialog.show();

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialogInterface) {
                mPreview.refreshCamera(mCamera);
            }
        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
