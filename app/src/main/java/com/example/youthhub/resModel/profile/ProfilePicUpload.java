
package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfilePicUpload implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("data")
    @Expose
    private ProfilePicUploadData profilePicUploadData;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<ProfilePicUpload> CREATOR = new Creator<ProfilePicUpload>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProfilePicUpload createFromParcel(Parcel in) {
            return new ProfilePicUpload(in);
        }

        public ProfilePicUpload[] newArray(int size) {
            return (new ProfilePicUpload[size]);
        }

    }
    ;

    protected ProfilePicUpload(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.profilePicUploadData = ((ProfilePicUploadData) in.readValue((ProfilePicUploadData.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ProfilePicUpload() {
    }

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

    public ProfilePicUploadData getProfilePicUploadData() {
        return profilePicUploadData;
    }

    public void setProfilePicUploadData(ProfilePicUploadData profilePicUploadData) {
        this.profilePicUploadData = profilePicUploadData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(count);
        dest.writeValue(profilePicUploadData);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
