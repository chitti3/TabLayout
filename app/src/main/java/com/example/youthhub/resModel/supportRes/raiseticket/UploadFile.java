
package com.example.youthhub.resModel.supportRes.raiseticket;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UploadFile implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private UploadData data;
    public final static Creator<UploadFile> CREATOR = new Creator<UploadFile>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UploadFile createFromParcel(Parcel in) {
            return new UploadFile(in);
        }

        public UploadFile[] newArray(int size) {
            return (new UploadFile[size]);
        }

    }
    ;

    protected UploadFile(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.data = ((UploadData) in.readValue((UploadData.class.getClassLoader())));
    }

    public UploadFile() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public UploadData getData() {
        return data;
    }

    public void setData(UploadData data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(data);
    }

    public int describeContents() {
        return  0;
    }

}
