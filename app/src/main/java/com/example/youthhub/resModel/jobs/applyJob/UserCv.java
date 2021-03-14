
package com.example.youthhub.resModel.jobs.applyJob;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserCv implements Parcelable
{

    @SerializedName("ucv_cv_id")
    @Expose
    private Integer ucvCvId;
    @SerializedName("ucv_type")
    @Expose
    private String ucvType;
    @SerializedName("ucv_title")
    @Expose
    private String ucvTitle;
    @SerializedName("ucv_file_name")
    @Expose
    private String ucvFileName;
    @SerializedName("ucv_created_on")
    @Expose
    private String ucvCreatedOn;
    @SerializedName("ucv_type_name")
    @Expose
    private String ucvTypeName;
    public final static Creator<UserCv> CREATOR = new Creator<UserCv>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserCv createFromParcel(Parcel in) {
            return new UserCv(in);
        }

        public UserCv[] newArray(int size) {
            return (new UserCv[size]);
        }

    }
    ;

    protected UserCv(Parcel in) {
        this.ucvCvId = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ucvType = ((String) in.readValue((String.class.getClassLoader())));
        this.ucvTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.ucvFileName = ((String) in.readValue((String.class.getClassLoader())));
        this.ucvCreatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.ucvTypeName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserCv() {
    }

    public Integer getUcvCvId() {
        return ucvCvId;
    }

    public void setUcvCvId(Integer ucvCvId) {
        this.ucvCvId = ucvCvId;
    }

    public String getUcvType() {
        return ucvType;
    }

    public void setUcvType(String ucvType) {
        this.ucvType = ucvType;
    }

    public String getUcvTitle() {
        return ucvTitle;
    }

    public void setUcvTitle(String ucvTitle) {
        this.ucvTitle = ucvTitle;
    }

    public String getUcvFileName() {
        return ucvFileName;
    }

    public void setUcvFileName(String ucvFileName) {
        this.ucvFileName = ucvFileName;
    }

    public String getUcvCreatedOn() {
        return ucvCreatedOn;
    }

    public void setUcvCreatedOn(String ucvCreatedOn) {
        this.ucvCreatedOn = ucvCreatedOn;
    }

    public String getUcvTypeName() {
        return ucvTypeName;
    }

    public void setUcvTypeName(String ucvTypeName) {
        this.ucvTypeName = ucvTypeName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ucvCvId);
        dest.writeValue(ucvType);
        dest.writeValue(ucvTitle);
        dest.writeValue(ucvFileName);
        dest.writeValue(ucvCreatedOn);
        dest.writeValue(ucvTypeName);
    }

    public int describeContents() {
        return  0;
    }

}
