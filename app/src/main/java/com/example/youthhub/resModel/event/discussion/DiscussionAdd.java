
package com.example.youthhub.resModel.event.discussion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiscussionAdd implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private DiscussionAddData discussionAddData;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status_img")
    @Expose
    private String status_img;
    public final static Creator<DiscussionAdd> CREATOR = new Creator<DiscussionAdd>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DiscussionAdd createFromParcel(Parcel in) {
            return new DiscussionAdd(in);
        }

        public DiscussionAdd[] newArray(int size) {
            return (new DiscussionAdd[size]);
        }

    }
    ;

    protected DiscussionAdd(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.discussionAddData = ((DiscussionAddData) in.readValue((DiscussionAddData.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.status_img = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DiscussionAdd() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public DiscussionAddData getDiscussionAddData() {
        return discussionAddData;
    }

    public void setDiscussionAddData(DiscussionAddData discussionAddData) {
        this.discussionAddData = discussionAddData;
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
        dest.writeValue(discussionAddData);
        dest.writeValue(message);
        dest.writeValue(status_img);
    }

    public int describeContents() {
        return  0;
    }

}
