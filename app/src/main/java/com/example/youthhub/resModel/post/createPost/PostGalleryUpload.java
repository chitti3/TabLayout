
package com.example.youthhub.resModel.post.createPost;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostGalleryUpload implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("data")
    @Expose
    private PostGalleryData postGalleryData;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<PostGalleryUpload> CREATOR = new Creator<PostGalleryUpload>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PostGalleryUpload createFromParcel(Parcel in) {
            return new PostGalleryUpload(in);
        }

        public PostGalleryUpload[] newArray(int size) {
            return (new PostGalleryUpload[size]);
        }

    }
    ;

    protected PostGalleryUpload(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.postGalleryData = ((PostGalleryData) in.readValue((PostGalleryData.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PostGalleryUpload() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public PostGalleryData getPostGalleryData() {
        return postGalleryData;
    }

    public void setPostGalleryData(PostGalleryData postGalleryData) {
        this.postGalleryData = postGalleryData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(count);
        dest.writeValue(postGalleryData);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
