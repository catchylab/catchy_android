package com.example.nguyentin.catchyapp.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;

import java.io.ByteArrayOutputStream;

import static android.graphics.Bitmap.CompressFormat.PNG;

/**
 * Created by DavidSonNguyen on 1/31/2018.
 */

/**
 * Class for fit bitmap
 */
public class OperateBitmap {
    public static final double IMAGE_SIZE = 400;
    /**
     *
     * @param bitmap Bitmap
     * @return String to save in sharepreference
     */
    public static String getString(Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(PNG, 100, baos);

        byte[] b = baos.toByteArray();
        String imageEncoded = Base64.encodeToString(b, Base64.DEFAULT);
        return imageEncoded;
    }

    /**
     *
     * @param input String
     * @return Bitmap
     */
    public static Bitmap getBitmap(String input){
        byte[] decodedByte = Base64.decode(input, 0);
        return BitmapFactory.decodeByteArray(decodedByte, 0, decodedByte.length);
    }

    /**
     * Make bitmap smaller source
     * @param bitmap Bitmap
     * @return Bitmap with smaller size
     */
    public static Bitmap resize(Bitmap bitmap){
        double multi = 1;
        double orient;
        if (bitmap.getHeight() > bitmap.getWidth()){
            orient = bitmap.getWidth();
        }else {
            orient = bitmap.getHeight();
        }

        if (orient > IMAGE_SIZE){
            multi = IMAGE_SIZE / orient;
        }

        Bitmap b = Bitmap.createScaledBitmap(bitmap, (int)(bitmap.getWidth() * multi), (int)(bitmap.getHeight() * multi), true);
        Log.d("ASDFG", b.getWidth() + "x" + b.getHeight());
        return b;
    }
}