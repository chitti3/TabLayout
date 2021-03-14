
package com.example.youthhub.resModel.supportRes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupportURL implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("nextpage")
    @Expose
    private Integer nextpage;
    @SerializedName("data_count")
    @Expose
    private Integer dataCount;
    @SerializedName("data")
    @Expose
    private SupportData data;
    @SerializedName("status_img")
    @Expose
    private String statusimg;
    @SerializedName("message")
    @Expose
    private String message;


    public static Creator<SupportURL> getCREATOR() {
        return CREATOR;
    }

    public final static Creator<SupportURL> CREATOR = new Creator<SupportURL>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SupportURL createFromParcel(Parcel in) {
            return new SupportURL(in);
        }

        public SupportURL[] newArray(int size) {
            return (new SupportURL[size]);
        }

    }
    ;

    protected SupportURL(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nextpage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dataCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.data = ((SupportData) in.readValue((SupportData.class.getClassLoader())));
        this.statusimg= (String) in.readValue((String.class.getClassLoader()));
        this.message= (String) in.readValue((String.class.getClassLoader()));
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatusimg() {
        return statusimg;
    }

    public void setStatusimg(String statusimg) {
        this.statusimg = statusimg;
    }

    public SupportURL() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNextpage() {
        return nextpage;
    }

    public void setNextpage(Integer nextpage) {
        this.nextpage = nextpage;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public SupportData getData() {
        return data;
    }

    public void setData(SupportData data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(nextpage);
        dest.writeValue(dataCount);
        dest.writeValue(data);
        dest.writeValue(statusimg);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
