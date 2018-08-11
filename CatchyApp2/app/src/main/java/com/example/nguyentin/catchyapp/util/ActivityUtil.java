package com.example.nguyentin.catchyapp.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;

/**
 * Create by DavidSon Nguyen
 */

public class ActivityUtil {
    /**
     * Launching activity
     * @param currentActivity current Activity
     * @param T The component class that is to be used for the intent
     */
    public static void launchActivity(@NonNull Activity currentActivity, @NonNull Class<?> T){
        Intent intent = new Intent(currentActivity.getApplicationContext(), T);
        if (intent != null) {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            currentActivity.finish();
            currentActivity.startActivity(intent);
        }
    }

    /**
     * Launching activity
     * @param currentActivity current Activity
     * @param T The component class that is to be used for the intent
     * @param isFinished true if you want to finish current Activity
     */
    public static void launchActivity(@NonNull Activity currentActivity, @NonNull Class<?> T, boolean isFinished){
        Intent intent = new Intent(currentActivity.getApplicationContext(), T);
        if (intent != null) {
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            if (isFinished) {
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                currentActivity.finish();
            }
            currentActivity.startActivity(intent);
        }
    }

    /**
     * Launching activity
     * @param currentActivity current Activity
     * @param T The component class that is to be used for the intent
     * @param name The name of the extra data, with package prefix
     * @param data id of TVChannel
     */
    public static void launchActivity(@NonNull Activity currentActivity, @NonNull Class<?> T, String name, Parcelable data){
        Intent intent = new Intent(currentActivity.getApplicationContext(), T);
        if (intent != null) {
            intent.putExtra(name, data);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            currentActivity.startActivity(intent);
            currentActivity.finish();
        }
    }

    /**
     * Launching activity
     * @param currentActivity current Activity
     * @param T The component class that is to be used for the intent
     * @param isFinished true if you want to finish current Activity
     * @param name The name of the extra data, with package prefix
     * @param data id of TVChannel
     */
    public static void launchActivity(@NonNull Activity currentActivity, @NonNull Class<?> T, boolean isFinished, String name, Parcelable data){
        Intent intent = new Intent(currentActivity.getApplicationContext(), T);
        if (intent != null) {
            intent.putExtra(name, data);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            if (isFinished) {
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                currentActivity.finish();
            }
            currentActivity.startActivity(intent);
        }
    }
}
