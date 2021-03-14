
package com.example.youthhub.resModel.post.postList;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GalleryList implements Parcelable
{

    @SerializedName("pga_gallery_id")
    @Expose
    private String pgaGalleryId;
    @SerializedName("pga_image")
    @Expose
    private String pgaImage;
    @SerializedName("pga_video")
    @Expose
    private String pgaVideo;
    @SerializedName("pga_video_poster")
    @Expose
    private String pgaVideoPoster;
    @SerializedName("pga_type")
    @Expose
    private String pgaType;
    @SerializedName("pga_um_user_id")
    @Expose
    private String pgaUmUserId;
    @SerializedName("pga_video_id")
    @Expose
    private String pgaVideoId;
    public final static Creator<GalleryList> CREATOR = new Creator<GalleryList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GalleryList createFromParcel(Parcel in) {
            return new GalleryList(in);
        }

        public GalleryList[] newArray(int size) {
            return (new GalleryList[size]);
        }

    }
    ;

    protected GalleryList(Parcel in) {
        this.pgaGalleryId = ((String) in.readValue((String.class.getClassLoader())));
        this.pgaImage = ((String) in.readValue((String.class.getClassLoader())));
        this.pgaVideo = ((String) in.readValue((String.class.getClassLoader())));
        this.pgaVideoPoster = ((String) in.readValue((String.class.getClassLoader())));
        this.pgaType = ((String) in.readValue((String.class.getClassLoader())));
        this.pgaUmUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.pgaVideoId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GalleryList() {
    }

    public String getPgaGalleryId() {
        return pgaGalleryId;
    }

    public void setPgaGalleryId(String pgaGalleryId) {
        this.pgaGalleryId = pgaGalleryId;
    }

    public String getPgaImage() {
        return pgaImage;
    }

    public void setPgaImage(String pgaImage) {
        this.pgaImage = pgaImage;
    }

    public String getPgaVideo() {
        return pgaVideo;
    }

    public void setPgaVideo(String pgaVideo) {
        this.pgaVideo = pgaVideo;
    }

    public String getPgaVideoPoster() {
        return pgaVideoPoster;
    }

    public void setPgaVideoPoster(String pgaVideoPoster) {
        this.pgaVideoPoster = pgaVideoPoster;
    }

    public String getPgaType() {
        return pgaType;
    }

    public void setPgaType(String pgaType) {
        this.pgaType = pgaType;
    }

    public String getPgaUmUserId() {
        return pgaUmUserId;
    }

    public void setPgaUmUserId(String pgaUmUserId) {
        this.pgaUmUserId = pgaUmUserId;
    }

    public String getPgaVideoId() {
        return pgaVideoId;
    }

    public void setPgaVideoId(String pgaVideoId) {
        this.pgaVideoId = pgaVideoId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pgaGalleryId);
        dest.writeValue(pgaImage);
        dest.writeValue(pgaVideo);
        dest.writeValue(pgaVideoPoster);
        dest.writeValue(pgaType);
        dest.writeValue(pgaUmUserId);
        dest.writeValue(pgaVideoId);
    }

    public int describeContents() {
        return  0;
    }

}
