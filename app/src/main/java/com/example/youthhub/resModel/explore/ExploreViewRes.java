
package com.example.youthhub.resModel.explore;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreViewRes implements Parcelable
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
    private ExploreViewData exploreViewData;
    @SerializedName("status_img")
    @Expose
    private String status_img;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<ExploreViewRes> CREATOR = new Creator<ExploreViewRes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreViewRes createFromParcel(Parcel in) {
            return new ExploreViewRes(in);
        }

        public ExploreViewRes[] newArray(int size) {
            return (new ExploreViewRes[size]);
        }

    }
    ;

    protected ExploreViewRes(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nextpage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dataCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.exploreViewData = ((ExploreViewData) in.readValue((ExploreViewData.class.getClassLoader())));
        this.status_img = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExploreViewRes() {
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

    public ExploreViewData getExploreViewData() {
        return exploreViewData;
    }

    public void setExploreViewData(ExploreViewData exploreViewData) {
        this.exploreViewData = exploreViewData;
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(nextpage);
        dest.writeValue(dataCount);
        dest.writeValue(exploreViewData);
        dest.writeValue(status_img);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
