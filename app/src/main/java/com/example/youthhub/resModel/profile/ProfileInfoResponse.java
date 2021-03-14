
package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileInfoResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private ProfileInfoData profileInfoData;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<ProfileInfoResponse> CREATOR = new Creator<ProfileInfoResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProfileInfoResponse createFromParcel(Parcel in) {
            return new ProfileInfoResponse(in);
        }

        public ProfileInfoResponse[] newArray(int size) {
            return (new ProfileInfoResponse[size]);
        }

    }
    ;

    protected ProfileInfoResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.profileInfoData = ((ProfileInfoData) in.readValue((ProfileInfoData.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ProfileInfoResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ProfileInfoData getProfileInfoData() {
        return profileInfoData;
    }

    public void setProfileInfoData(ProfileInfoData profileInfoData) {
        this.profileInfoData = profileInfoData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(profileInfoData);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
