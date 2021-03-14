
package com.example.youthhub.resModel.explore.exploreDiscussion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreDiscussionAdd implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private ExploreAddData exploreAddData;
    @SerializedName("status_img")
    @Expose
    private String statusImg;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<ExploreDiscussionAdd> CREATOR = new Creator<ExploreDiscussionAdd>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreDiscussionAdd createFromParcel(Parcel in) {
            return new ExploreDiscussionAdd(in);
        }

        public ExploreDiscussionAdd[] newArray(int size) {
            return (new ExploreDiscussionAdd[size]);
        }

    }
    ;

    protected ExploreDiscussionAdd(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.exploreAddData = ((ExploreAddData) in.readValue((ExploreAddData.class.getClassLoader())));
        this.statusImg = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExploreDiscussionAdd() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ExploreAddData getExploreAddData() {
        return exploreAddData;
    }

    public void setExploreAddData(ExploreAddData exploreAddData) {
        this.exploreAddData = exploreAddData;
    }

    public String getStatusImg() {
        return statusImg;
    }

    public void setStatusImg(String statusImg) {
        this.statusImg = statusImg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(exploreAddData);
        dest.writeValue(statusImg);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
