
package com.example.youthhub.resModel.post;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostLikeData implements Parcelable
{

    @SerializedName("encouragers_list")
    @Expose
    private List<EncouragersList> encouragersList = new ArrayList<>();
    @SerializedName("user_medium_path")
    @Expose
    private String userMediumPath;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    public final static Creator<PostLikeData> CREATOR = new Creator<PostLikeData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PostLikeData createFromParcel(Parcel in) {
            return new PostLikeData(in);
        }

        public PostLikeData[] newArray(int size) {
            return (new PostLikeData[size]);
        }

    }
    ;

    protected PostLikeData(Parcel in) {
        in.readList(this.encouragersList, (EncouragersList.class.getClassLoader()));
        this.userMediumPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PostLikeData() {
    }

    public List<EncouragersList> getEncouragersList() {
        return encouragersList;
    }

    public void setEncouragersList(List<EncouragersList> encouragersList) {
        this.encouragersList = encouragersList;
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
        dest.writeList(encouragersList);
        dest.writeValue(userMediumPath);
        dest.writeValue(userThumbnailPath);
    }

    public int describeContents() {
        return  0;
    }

}
