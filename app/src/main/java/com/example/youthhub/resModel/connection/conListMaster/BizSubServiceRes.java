
package com.example.youthhub.resModel.connection.conListMaster;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BizSubServiceRes implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private BizSubServiceData bizSubServiceData;
    public final static Creator<BizSubServiceRes> CREATOR = new Creator<BizSubServiceRes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BizSubServiceRes createFromParcel(Parcel in) {
            return new BizSubServiceRes(in);
        }

        public BizSubServiceRes[] newArray(int size) {
            return (new BizSubServiceRes[size]);
        }

    }
    ;

    protected BizSubServiceRes(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.bizSubServiceData = ((BizSubServiceData) in.readValue((BizSubServiceData.class.getClassLoader())));
    }

    public BizSubServiceRes() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BizSubServiceData getBizSubServiceData() {
        return bizSubServiceData;
    }

    public void setBizSubServiceData(BizSubServiceData bizSubServiceData) {
        this.bizSubServiceData = bizSubServiceData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(bizSubServiceData);
    }

    public int describeContents() {
        return  0;
    }

}
