package com.example.youthhub.utils;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;

public class Utils{
    public static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 123;
    public static final int REQUEST_CODE_ASK_PERMISSIONS = 2909;
    public String encodedBase64;
    long length;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static boolean checkExtPermission(final Context context) {
        int currentAPIVersion = Build.VERSION.SDK_INT;
        if (currentAPIVersion >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED||ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
                    alertBuilder.setCancelable(true);
                    alertBuilder.setTitle("Permission necessary");
                    alertBuilder.setMessage("External storage permission is necessary");
                    alertBuilder.setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
                        public void onClick(DialogInterface dialog, int which) {
                            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                        }
                    });
                    AlertDialog alert = alertBuilder.create();
                    alert.show();
                } else {
                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CAMERA}, MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                }
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }
    public static boolean checkSMSPermission(final Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            // Marshmallow+
            Log.e("Test", "Marshmallow+");

            String receiveSms = Manifest.permission.RECEIVE_SMS;
            int hasPermission = 0;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                hasPermission =  ContextCompat.checkSelfPermission(context,
                        Manifest.permission.RECEIVE_SMS);
            }
            String[] permissions = new String[]{receiveSms};
            if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    Log.e("Test", "Doesnot have Permission");

                    ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.RECEIVE_SMS}, REQUEST_CODE_ASK_PERMISSIONS);
                }
            } else {
                // Phew - we already have permission!
                Log.e("Test", "Already Permitted");

            }

        } else {
            // Pre-Marshmallow
            Log.e("Test", "Pre Marshmallow");
            // Var.share = getPreferences(MODE_PRIVATE);
            // TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);

        }
        return true;
    }

    public String ImageCompress(String ImagePath){
        File file = new File(ImagePath);
        length = file.length();
        length = length/1024;
        Log.e("Image Size ",String.valueOf(length));
        if(length> 2048){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Bitmap bitmap = BitmapFactory.decodeFile(ImagePath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 10, baos);
            byte[] imageBytes = baos.toByteArray();
            encodedBase64 = Base64.encodeToString(imageBytes, Base64.DEFAULT);
            return encodedBase64;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeFile(ImagePath);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 10, baos);
        byte[] imageBytes = baos.toByteArray();
        encodedBase64 = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedBase64;


    }
    public byte[] ImageCompress2(String ImagePath){
        File file = new File(ImagePath);
        length = file.length();
        length = length/1024;
        Log.e("Image Size ",String.valueOf(length));
        if(length> 2048){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Bitmap bitmap = BitmapFactory.decodeFile(ImagePath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 10, baos);
            byte[] imageBytes = baos.toByteArray();
            encodedBase64 = Base64.encodeToString(imageBytes, Base64.DEFAULT);
            return imageBytes;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Bitmap bitmap = BitmapFactory.decodeFile(ImagePath);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 10, baos);
        byte[] imageBytes = baos.toByteArray();
        encodedBase64 = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return imageBytes;


    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            deleteDir(dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
            return dir.delete();
        } else if (dir != null && dir.isFile()) {
            return dir.delete();
        } else {
            return false;
        }
    }

    public static float dpToPixel(float dp,Activity activity) {
        DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
        return dp * (metrics.densityDpi/160f);
    }

}