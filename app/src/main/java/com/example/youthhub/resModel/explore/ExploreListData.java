
package com.example.youthhub.resModel.explore;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreListData implements Parcelable
{

    @SerializedName("explorelist")
    @Expose
    private List<Explorelist> explorelist = new ArrayList<>();
    @SerializedName("user_medium_path")
    @Expose
    private String userMediumPath;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    public final static Creator<ExploreListData> CREATOR = new Creator<ExploreListData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreListData createFromParcel(Parcel in) {
            return new ExploreListData(in);
        }

        public ExploreListData[] newArray(int size) {
            return (new ExploreListData[size]);
        }

    }
    ;

    protected ExploreListData(Parcel in) {
        in.readList(this.explorelist, (com.example.youthhub.resModel.explore.Explorelist.class.getClassLoader()));
        this.userMediumPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExploreListData() {
    }

    public List<Explorelist> getExplorelist() {
        return explorelist;
    }

    public void setExplorelist(List<Explorelist> explorelist) {
        this.explorelist = explorelist;
    }

    public String getUserMediumPath() {
        return userMediumPath;
    }

    public void setUserMediumPath(String userMediumPath) {
        this.userMediumPath = userMediumPath;
    }

    public String getUserThumbnailPath() {
        return userThumbnailPath;
    }

    public void setUserThumbnailPath(String userThumbnailPath) {
        this.userThumbnailPath = userThumbnailPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(explorelist);
        dest.writeValue(userMediumPath);
        dest.writeValue(userThumbnailPath);
    }

    public int describeContents() {
        return  0;
    }

}
