
package com.example.youthhub.resModel.post.postList;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostListResponse implements Parcelable
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
    private PostListData postListData;
    @SerializedName("status_img")
    @Expose
    private String status_img;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<PostListResponse> CREATOR = new Creator<PostListResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PostListResponse createFromParcel(Parcel in) {
            return new PostListResponse(in);
        }

        public PostListResponse[] newArray(int size) {
            return (new PostListResponse[size]);
        }

    }
    ;

    protected PostListResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nextpage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dataCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.postListData = ((PostListData) in.readValue((PostListData.class.getClassLoader())));
        this.status_img = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PostListResponse() {
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

    public PostListData getPostListData() {
        return postListData;
    }

    public void setPostListData(PostListData postListData) {
        this.postListData = postListData;
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
        dest.writeValue(postListData);
        dest.writeValue(status_img);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
