package com.example.youthhub.dashBoard.createPost;

import android.graphics.Bitmap;

public class PostImageModel {

    private String galleryCode;
    private Bitmap bitmap;

    public String getGalleryCode() {
        return galleryCode;
    }

    public void setGalleryCode(String galleryCode) {
        this.galleryCode = galleryCode;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}