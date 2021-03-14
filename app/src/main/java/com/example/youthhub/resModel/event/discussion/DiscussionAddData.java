
package com.example.youthhub.resModel.event.discussion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiscussionAddData implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("discussions")
    @Expose
    private Discussion discussion;
    @SerializedName("user_medium_path")
    @Expose
    private String userMediumPath;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    public final static Creator<DiscussionAddData> CREATOR = new Creator<DiscussionAddData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DiscussionAddData createFromParcel(Parcel in) {
            return new DiscussionAddData(in);
        }

        public DiscussionAddData[] newArray(int size) {
            return (new DiscussionAddData[size]);
        }

    }
    ;

    protected DiscussionAddData(Parcel in) {
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.discussion = ((Discussion) in.readValue((Discussion.class.getClassLoader())));
        this.userMediumPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DiscussionAddData() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Discussion getDiscussions() {
        return discussion;
    }

    public void setDiscussions(Discussion discussions) {
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
