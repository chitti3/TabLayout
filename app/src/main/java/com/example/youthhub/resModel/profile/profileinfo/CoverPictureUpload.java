package com.example.youthhub.resModel.profile.profileinfo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoverPictureUpload {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("data")
    @Expose
    private ProfileCoverUploadData profileCoverUploadData;
    @SerializedName("message")
    @Expose
    private String message;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ProfileCoverUploadData getProfileCoverUploadData() {
        return profileCoverUploadData;
    }

    public void setProfileCoverUploadData(ProfileCoverUploadData profileCoverUploadData) {
        this.profileCoverUploadData = profileCoverUploadData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
