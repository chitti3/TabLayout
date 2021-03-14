
package com.example.youthhub.resModel.event.discussion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiscussionListResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("nextpage")
    @Expose
    private Integer nextpage;
    @SerializedName("data")
    @Expose
    private DiscussionData discussionData;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status_img")
    @Expose
    private String status_img;
    public final static Creator<DiscussionListResponse> CREATOR = new Creator<DiscussionListResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DiscussionListResponse createFromParcel(Parcel in) {
            return new DiscussionListResponse(in);
        }

        public DiscussionListResponse[] newArray(int size) {
            return (new DiscussionListResponse[size]);
        }

    }
    ;

    protected DiscussionListResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nextpage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.discussionData = ((DiscussionData) in.readValue((DiscussionData.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.status_img = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DiscussionListResponse() {
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

    public DiscussionData getDiscussionData() {
        return discussionData;
    }

    public void setDiscussionData(DiscussionData discussionData) {
        this.discussionData = discussionData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus_img() {
        return status_img;
    }

    public void setStatus_img(String status_img) {
        this.status_img = status_img;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(nextpage);
        dest.writeValue(discussionData);
        dest.writeValue(message);
        dest.writeValue(status_img);
    }

    public int describeContents() {
        return  0;
    }

}
