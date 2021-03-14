
package com.example.youthhub.resModel.event.gallery;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GalleryData implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("gallery_type")
    @Expose
    private String galleryType;
    @SerializedName("gallery")
    @Expose
    private List<Gallery> gallery = new ArrayList<>();
    @SerializedName("path_large")
    @Expose
    private String pathLarge;
    @SerializedName("path_medium")
    @Expose
    private String pathMedium;
    @SerializedName("path_thumb")
    @Expose
    private String pathThumb;
    @SerializedName("path_video")
    @Expose
    private String pathVideo;
    @SerializedName("path_video_poster")
    @Expose
    private String pathVideoPoster;
    public final static Creator<GalleryData> CREATOR = new Creator<GalleryData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GalleryData createFromParcel(Parcel in) {
            return new GalleryData(in);
        }

        public GalleryData[] newArray(int size) {
            return (new GalleryData[size]);
        }

    }
    ;

    protected GalleryData(Parcel in) {
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.galleryType = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.gallery, (com.example.youthhub.resModel.event.gallery.Gallery.class.getClassLoader()));
        this.pathLarge = ((String) in.readValue((String.class.getClassLoader())));
        this.pathMedium = ((String) in.readValue((String.class.getClassLoader())));
        this.pathThumb = ((String) in.readValue((String.class.getClassLoader())));
        this.pathVideo = ((String) in.readValue((String.class.getClassLoader())));
        this.pathVideoPoster = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GalleryData() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getGalleryType() {
        return galleryType;
    }

    public void setGalleryType(String galleryType) {
        this.galleryType = galleryType;
    }

    public List<Gallery> getGallery() {
        return gallery;
    }

    public void setGallery(List<Gallery> gallery) {
        this.gallery = gallery;
    }

    public String getPathLarge() {
        return pathLarge;
    }

    public void setPathLarge(String pathLarge) {
        this.pathLarge = pathLarge;
    }

    public String getPathMedium() {
        return pathMedium;
    }

    public void setPathMedium(String pathMedium) {
        this.pathMedium = pathMedium;
    }

    public String getPathThumb() {
        return pathThumb;
    }

    public void setPathThumb(String pathThumb) {
        this.pathThumb = pathThumb;
    }

    public String getPathVideo() {
        return pathVideo;
    }

    public void setPathVideo(String pathVideo) {
        this.pathVideo = pathVideo;
    }

    public String getPathVideoPoster() {
        return pathVideoPoster;
    }

    public void setPathVideoPoster(String pathVideoPoster) {
        this.pathVideoPoster = pathVideoPoster;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeValue(galleryType);
        dest.writeList(gallery);
        dest.writeValue(pathLarge);
        dest.writeValue(pathMedium);
        dest.writeValue(pathThumb);
        dest.writeValue(pathVideo);
        dest.writeValue(pathVideoPoster);
    }

    public int describeContents() {
        return  0;
    }

}
