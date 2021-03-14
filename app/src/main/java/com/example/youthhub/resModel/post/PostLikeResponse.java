
package com.example.youthhub.resModel.post;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostLikeResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data_count")
    @Expose
    private Integer dataCount;
    @SerializedName("data")
    @Expose
    private PostLikeData postLikeData;
    @SerializedName("status_img")
    @Expose
    private String statusImg;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<PostLikeResponse> CREATOR = new Creator<PostLikeResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PostLikeResponse createFromParcel(Parcel in) {
            return new PostLikeResponse(in);
        }

        public PostLikeResponse[] newArray(int size) {
            return (new PostLikeResponse[size]);
        }

    }
    ;

    protected PostLikeResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dataCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.postLikeData = ((PostLikeData) in.readValue((PostLikeData.class.getClassLoader())));
        this.statusImg = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PostLikeResponse() {
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

    public PostLikeData getPostLikeData() {
        return postLikeData;
    }

    public void setPostLikeData(PostLikeData postLikeData) {
        this.postLikeData = postLikeData;
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
        dest.writeValue(postLikeData);
        dest.writeValue(statusImg);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
