
package com.example.youthhub.resModel.event.gallery;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GalleryResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("nextpage")
    @Expose
    private Integer nextpage;
    @SerializedName("data")
    @Expose
    private GalleryData galleryData;
    @SerializedName("status_img")
    @Expose
    private String status_img;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<GalleryResponse> CREATOR = new Creator<GalleryResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GalleryResponse createFromParcel(Parcel in) {
            return new GalleryResponse(in);
        }

        public GalleryResponse[] newArray(int size) {
            return (new GalleryResponse[size]);
        }

    }
    ;

    protected GalleryResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nextpage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.galleryData = ((GalleryData) in.readValue((GalleryData.class.getClassLoader())));
        this.status_img = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GalleryResponse() {
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

    public GalleryData getGalleryData() {
        return galleryData;
    }

    public void setGalleryData(GalleryData galleryData) {
        this.galleryData = galleryData;
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
        dest.writeValue(galleryData);
        dest.writeValue(status_img);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
