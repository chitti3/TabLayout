
package com.example.youthhub.resModel.post.createPost;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostGalleryData implements Parcelable
{

    @SerializedName("gallery_code")
    @Expose
    private Long galleryCode;
    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("posterfilename")
    @Expose
    private String posterfilename;
    @SerializedName("filenameuploadfield")
    @Expose
    private String filenameuploadfield;
    @SerializedName("path_source")
    @Expose
    private String pathSource;
    @SerializedName("path_large")
    @Expose
    private String pathLarge;
    @SerializedName("path_medium")
    @Expose
    private String pathMedium;
    @SerializedName("path_thumb")
    @Expose
    private String pathThumb;
    @SerializedName("vid_path")
    @Expose
    private String vidPath;
    @SerializedName("vid_poster_path")
    @Expose
    private String vidPosterPath;
    public final static Creator<PostGalleryData> CREATOR = new Creator<PostGalleryData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PostGalleryData createFromParcel(Parcel in) {
            return new PostGalleryData(in);
        }

        public PostGalleryData[] newArray(int size) {
            return (new PostGalleryData[size]);
        }

    }
    ;

    protected PostGalleryData(Parcel in) {
        this.galleryCode = ((Long) in.readValue((Long.class.getClassLoader())));
        this.filename = ((String) in.readValue((String.class.getClassLoader())));
        this.posterfilename = ((String) in.readValue((String.class.getClassLoader())));
        this.filenameuploadfield = ((String) in.readValue((String.class.getClassLoader())));
        this.pathSource = ((String) in.readValue((String.class.getClassLoader())));
        this.pathLarge = ((String) in.readValue((String.class.getClassLoader())));
        this.pathMedium = ((String) in.readValue((String.class.getClassLoader())));
        this.pathThumb = ((String) in.readValue((String.class.getClassLoader())));
        this.vidPath = ((String) in.readValue((String.class.getClassLoader())));
        this.vidPosterPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PostGalleryData() {
    }

    public Long getGalleryCode() {
        return galleryCode;
    }

    public void setGalleryCode(Long galleryCode) {
        this.galleryCode = galleryCode;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPosterfilename() {
        return posterfilename;
    }

    public void setPosterfilename(String posterfilename) {
        this.posterfilename = posterfilename;
    }

    public String getFilenameuploadfield() {
        return filenameuploadfield;
    }

    public void setFilenameuploadfield(String filenameuploadfield) {
        this.filenameuploadfield = filenameuploadfield;
    }

    public String getPathSource() {
        return pathSource;
    }

    public void setPathSource(String pathSource) {
        this.pathSource = pathSource;
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

    public String getVidPath() {
        return vidPath;
    }

    public void setVidPath(String vidPath) {
        this.vidPath = vidPath;
    }

    public String getVidPosterPath() {
        return vidPosterPath;
    }

    public void setVidPosterPath(String vidPosterPath) {
        this.vidPosterPath = vidPosterPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(galleryCode);
        dest.writeValue(filename);
        dest.writeValue(posterfilename);
        dest.writeValue(filenameuploadfield);
        dest.writeValue(pathSource);
        dest.writeValue(pathLarge);
        dest.writeValue(pathMedium);
        dest.writeValue(pathThumb);
        dest.writeValue(vidPath);
        dest.writeValue(vidPosterPath);
    }

    public int describeContents() {
        return  0;
    }

}
