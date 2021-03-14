package com.example.youthhub.resModel.profile.profileinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileCoverUploadData {
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("cover_photo")
    @Expose
    private String cover_photo;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getCover_photo() {
        return cover_photo;
    }

    public void setCover_photo(String cover_photo) {
        this.cover_photo = cover_photo;
    }
    @Override
    public String toString()
    {
        return "ClassPojo [filename = "+filename+", cover_photo = "+cover_photo+"]";
    }
}
