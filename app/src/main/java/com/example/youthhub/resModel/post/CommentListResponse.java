
package com.example.youthhub.resModel.post;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommentListResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data_count")
    @Expose
    private Integer dataCount;
    @SerializedName("data")
    @Expose
    private CommentListData commentListData;
    @SerializedName("status_img")
    @Expose
    private String statusImg;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<CommentListResponse> CREATOR = new Creator<CommentListResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CommentListResponse createFromParcel(Parcel in) {
            return new CommentListResponse(in);
        }

        public CommentListResponse[] newArray(int size) {
            return (new CommentListResponse[size]);
        }

    }
    ;

    protected CommentListResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dataCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.commentListData = ((CommentListData) in.readValue((CommentListData.class.getClassLoader())));
        this.statusImg = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CommentListResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public CommentListData getCommentListData() {
        return commentListData;
    }

    public void setCommentListData(CommentListData commentListData) {
        this.commentListData = commentListData;
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
        dest.writeValue(dataCount);
        dest.writeValue(commentListData);
        dest.writeValue(statusImg);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
