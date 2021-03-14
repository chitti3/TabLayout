
package com.example.youthhub.resModel.explore.exploreDiscussion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreDiscussionList implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("nextpage")
    @Expose
    private Integer nextpage;
    @SerializedName("data")
    @Expose
    private ExploreDiscussionData exploreDiscussionData;
    @SerializedName("status_img")
    @Expose
    private String statusImg;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<ExploreDiscussionList> CREATOR = new Creator<ExploreDiscussionList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreDiscussionList createFromParcel(Parcel in) {
            return new ExploreDiscussionList(in);
        }

        public ExploreDiscussionList[] newArray(int size) {
            return (new ExploreDiscussionList[size]);
        }

    }
    ;

    protected ExploreDiscussionList(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nextpage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.exploreDiscussionData = ((ExploreDiscussionData) in.readValue((ExploreDiscussionData.class.getClassLoader())));
        this.statusImg = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExploreDiscussionList() {
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

    public ExploreDiscussionData getExploreDiscussionData() {
        return exploreDiscussionData;
    }

    public void setExploreDiscussionData(ExploreDiscussionData exploreDiscussionData) {
        this.exploreDiscussionData = exploreDiscussionData;
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
        dest.writeValue(nextpage);
        dest.writeValue(exploreDiscussionData);
        dest.writeValue(statusImg);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
