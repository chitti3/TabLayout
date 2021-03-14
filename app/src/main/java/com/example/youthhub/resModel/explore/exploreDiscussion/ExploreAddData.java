
package com.example.youthhub.resModel.explore.exploreDiscussion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreAddData implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("discussions")
    @Expose
    private ExploreDiscussion discussion;
    @SerializedName("user_medium_path")
    @Expose
    private String userMediumPath;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    public final static Creator<ExploreAddData> CREATOR = new Creator<ExploreAddData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreAddData createFromParcel(Parcel in) {
            return new ExploreAddData(in);
        }

        public ExploreAddData[] newArray(int size) {
            return (new ExploreAddData[size]);
        }

    }
    ;

    protected ExploreAddData(Parcel in) {
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.discussion = ((ExploreDiscussion) in.readValue((ExploreDiscussion.class.getClassLoader())));
        this.userMediumPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExploreAddData() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ExploreDiscussion getExploreDiscussions() {
        return discussion;
    }

    public void setExploreDiscussions(ExploreDiscussion discussions) {
        this.discussion = discussions;
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
        dest.writeValue(discussion);
        dest.writeValue(userMediumPath);
        dest.writeValue(userThumbnailPath);
    }

    public int describeContents() {
        return  0;
    }

}
