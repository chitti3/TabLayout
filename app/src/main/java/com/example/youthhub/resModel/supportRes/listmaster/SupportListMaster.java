
package com.example.youthhub.resModel.supportRes.listmaster;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupportListMaster implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private SupportListMasterData supportListMasterData;
    public final static Creator<SupportListMaster> CREATOR = new Creator<SupportListMaster>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SupportListMaster createFromParcel(Parcel in) {
            return new SupportListMaster(in);
        }

        public SupportListMaster[] newArray(int size) {
            return (new SupportListMaster[size]);
        }

    }
    ;

    protected SupportListMaster(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.supportListMasterData = ((SupportListMasterData) in.readValue((SupportListMasterData.class.getClassLoader())));
    }

    public SupportListMaster() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SupportListMasterData getSupportListMasterData() {
        return supportListMasterData;
    }

    public void setSupportListMasterData(SupportListMasterData supportListMasterData) {
        this.supportListMasterData = supportListMasterData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(supportListMasterData);
    }

    public int describeContents() {
        return  0;
    }

}
