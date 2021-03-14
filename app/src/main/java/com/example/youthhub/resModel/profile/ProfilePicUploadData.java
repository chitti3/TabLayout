
package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfilePicUploadData implements Parcelable
{

    @SerializedName("filename")
    @Expose
    private String filename;
    @SerializedName("path_large")
    @Expose
    private String pathLarge;
    @SerializedName("path_medium")
    @Expose
    private String pathMedium;
    @SerializedName("path_thumb")
    @Expose
    private String pathThumb;
    public final static Creator<ProfilePicUploadData> CREATOR = new Creator<ProfilePicUploadData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProfilePicUploadData createFromParcel(Parcel in) {
            return new ProfilePicUploadData(in);
        }

        public ProfilePicUploadData[] newArray(int size) {
            return (new ProfilePicUploadData[size]);
        }

    }
    ;

    protected ProfilePicUploadData(Parcel in) {
        this.filename = ((String) in.readValue((String.class.getClassLoader())));
        this.pathLarge = ((String) in.readValue((String.class.getClassLoader())));
        this.pathMedium = ((String) in.readValue((String.class.getClassLoader())));
        this.pathThumb = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ProfilePicUploadData() {
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(filename);
        dest.writeValue(pathLarge);
        dest.writeValue(pathMedium);
        dest.writeValue(pathThumb);
    }

    public int describeContents() {
        return  0;
    }

}
