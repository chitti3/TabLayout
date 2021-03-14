
package com.example.youthhub.resModel.connection.conListMaster;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConnectionListMaster implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private ConnectionListMasterData data;
    public final static Creator<ConnectionListMaster> CREATOR = new Creator<ConnectionListMaster>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ConnectionListMaster createFromParcel(Parcel in) {
            return new ConnectionListMaster(in);
        }

        public ConnectionListMaster[] newArray(int size) {
            return (new ConnectionListMaster[size]);
        }

    }
    ;

    protected ConnectionListMaster(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.data = ((ConnectionListMasterData) in.readValue((ConnectionListMasterData.class.getClassLoader())));
    }

    public ConnectionListMaster() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ConnectionListMasterData getData() {
        return data;
    }

    public void setData(ConnectionListMasterData connectionListMasterData) {
        this.data = connectionListMasterData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(data);
    }

    public int describeContents() {
        return  0;
    }

}
