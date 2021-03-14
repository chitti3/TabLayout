
package com.example.youthhub.resModel.connection.conListMaster;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConnCityRes implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private ConnCityData connCityData;
    public final static Creator<ConnCityRes> CREATOR = new Creator<ConnCityRes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ConnCityRes createFromParcel(Parcel in) {
            return new ConnCityRes(in);
        }

        public ConnCityRes[] newArray(int size) {
            return (new ConnCityRes[size]);
        }

    }
    ;

    protected ConnCityRes(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.connCityData = ((ConnCityData) in.readValue((ConnCityData.class.getClassLoader())));
    }

    public ConnCityRes() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ConnCityData getConnCityData() {
        return connCityData;
    }

    public void setConnCityData(ConnCityData connCityData) {
        this.connCityData = connCityData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(connCityData);
    }

    public int describeContents() {
        return  0;
    }

}
