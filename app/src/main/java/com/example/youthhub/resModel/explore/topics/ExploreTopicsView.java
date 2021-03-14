
package com.example.youthhub.resModel.explore.topics;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreTopicsView implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private ExploreTopicsData exploreTopicsData;
    @SerializedName("status_img")
    @Expose
    private String status_img;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<ExploreTopicsView> CREATOR = new Creator<ExploreTopicsView>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreTopicsView createFromParcel(Parcel in) {
            return new ExploreTopicsView(in);
        }

        public ExploreTopicsView[] newArray(int size) {
            return (new ExploreTopicsView[size]);
        }

    }
    ;

    protected ExploreTopicsView(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.exploreTopicsData = ((ExploreTopicsData) in.readValue((ExploreTopicsData.class.getClassLoader())));
        this.status_img = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExploreTopicsView() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ExploreTopicsData getExploreTopicsData() {
        return exploreTopicsData;
    }

    public void setExploreTopicsData(ExploreTopicsData exploreTopicsData) {
        this.exploreTopicsData = exploreTopicsData;
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
        dest.writeValue(exploreTopicsData);
        dest.writeValue(status_img);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
