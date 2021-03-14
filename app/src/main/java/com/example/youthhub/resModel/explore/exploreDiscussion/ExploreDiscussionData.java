
package com.example.youthhub.resModel.explore.exploreDiscussion;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreDiscussionData implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("discussions")
    @Expose
    private List<ExploreDiscussion> exploreDiscussions = new ArrayList<>();
    @SerializedName("user_medium_path")
    @Expose
    private String userMediumPath;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    public final static Creator<ExploreDiscussionData> CREATOR = new Creator<ExploreDiscussionData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreDiscussionData createFromParcel(Parcel in) {
            return new ExploreDiscussionData(in);
        }

        public ExploreDiscussionData[] newArray(int size) {
            return (new ExploreDiscussionData[size]);
        }

    }
    ;

    protected ExploreDiscussionData(Parcel in) {
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.exploreDiscussions, (ExploreDiscussion.class.getClassLoader()));
        this.userMediumPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExploreDiscussionData() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ExploreDiscussion> getExploreDiscussions() {
        return exploreDiscussions;
    }

    public void setExploreDiscussions(List<ExploreDiscussion> exploreDiscussions) {
        this.exploreDiscussions = exploreDiscussions;
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
        dest.writeValue(count);
        dest.writeList(exploreDiscussions);
        dest.writeValue(userMediumPath);
        dest.writeValue(userThumbnailPath);
    }

    public int describeContents() {
        return  0;
    }

}
