
package com.example.youthhub.resModel.event.gallery;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Gallery implements Parcelable
{

    @SerializedName("ega_gallery_id")
    @Expose
    private String egaGalleryId;
    @SerializedName("ega_em_event_id")
    @Expose
    private String egaEmEventId;
    @SerializedName("ega_type")
    @Expose
    private String egaType;
    @SerializedName("ega_image")
    @Expose
    private String egaImage;
    @SerializedName("ega_video")
    @Expose
    private String egaVideo;
    @SerializedName("ega_video_poster")
    @Expose
    private String egaVideoPoster;
    @SerializedName("ega_title")
    @Expose
    private String egaTitle;
    public final static Creator<Gallery> CREATOR = new Creator<Gallery>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Gallery createFromParcel(Parcel in) {
            return new Gallery(in);
        }

        public Gallery[] newArray(int size) {
            return (new Gallery[size]);
        }

    }
    ;

    protected Gallery(Parcel in) {
        this.egaGalleryId = ((String) in.readValue((String.class.getClassLoader())));
        this.egaEmEventId = ((String) in.readValue((String.class.getClassLoader())));
        this.egaType = ((String) in.readValue((String.class.getClassLoader())));
        this.egaImage = ((String) in.readValue((String.class.getClassLoader())));
        this.egaVideo = ((String) in.readValue((String.class.getClassLoader())));
        this.egaVideoPoster = ((String) in.readValue((String.class.getClassLoader())));
        this.egaTitle = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Gallery() {
    }

    public String getEgaGalleryId() {
        return egaGalleryId;
    }

    public void setEgaGalleryId(String egaGalleryId) {
        this.egaGalleryId = egaGalleryId;
    }

    public String getEgaEmEventId() {
        return egaEmEventId;
    }

    public void setEgaEmEventId(String egaEmEventId) {
        this.egaEmEventId = egaEmEventId;
    }

    public String getEgaType() {
        return egaType;
    }

    public void setEgaType(String egaType) {
        this.egaType = egaType;
    }

    public String getEgaImage() {
        return egaImage;
    }

    public void setEgaImage(String egaImage) {
        this.egaImage = egaImage;
    }

    public String getEgaVideo() {
        return egaVideo;
    }

    public void setEgaVideo(String egaVideo) {
        this.egaVideo = egaVideo;
    }

    public String getEgaVideoPoster() {
        return egaVideoPoster;
    }

    public void setEgaVideoPoster(String egaVideoPoster) {
        this.egaVideoPoster = egaVideoPoster;
    }

    public String getEgaTitle() {
        return egaTitle;
    }

    public void setEgaTitle(String egaTitle) {
        this.egaTitle = egaTitle;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(egaGalleryId);
        dest.writeValue(egaEmEventId);
        dest.writeValue(egaType);
        dest.writeValue(egaImage);
        dest.writeValue(egaVideo);
        dest.writeValue(egaVideoPoster);
        dest.writeValue(egaTitle);
    }

    public int describeContents() {
        return  0;
    }

}
