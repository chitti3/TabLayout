
package com.example.youthhub.resModel.myjobs;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyJobsList implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data_count")
    @Expose
    private Integer dataCount;
    @SerializedName("status_img")
    @Expose
    private String status_img;  @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private MyJobsData myJobsData;


    public MyJobsList() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public MyJobsData getMyJobsData() {
        return myJobsData;
    }

    public void setMyJobsData(MyJobsData myJobsData) {
        this.myJobsData = myJobsData;
    }

    public String getStatus_img() {
        return status_img;
    }

    public void setStatus_img(String status_img) {
        this.status_img = status_img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.status);
        dest.writeValue(this.dataCount);
        dest.writeString(this.status_img);
        dest.writeString(this.message);
        dest.writeParcelable(this.myJobsData, flags);
    }

    protected MyJobsList(Parcel in) {
        this.status = (Integer) in.readValue(Integer.class.getClassLoader());
        this.dataCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.status_img = in.readString();
        this.message = in.readString();
        this.myJobsData = in.readParcelable(MyJobsData.class.getClassLoader());
    }

    public static final Creator<MyJobsList> CREATOR = new Creator<MyJobsList>() {
        @Override
        public MyJobsList createFromParcel(Parcel source) {
            return new MyJobsList(source);
        }

        @Override
        public MyJobsList[] newArray(int size) {
            return new MyJobsList[size];
        }
    };
}
