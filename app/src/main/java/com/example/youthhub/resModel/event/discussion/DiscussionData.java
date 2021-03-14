
package com.example.youthhub.resModel.event.discussion;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiscussionData implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("discussions")
    @Expose
    private List<Discussion> discussions = new ArrayList<>();
    @SerializedName("user_medium_path")
    @Expose
    private String userMediumPath;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    public final static Creator<DiscussionData> CREATOR = new Creator<DiscussionData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DiscussionData createFromParcel(Parcel in) {
            return new DiscussionData(in);
        }

        public DiscussionData[] newArray(int size) {
            return (new DiscussionData[size]);
        }

    }
    ;

    protected DiscussionData(Parcel in) {
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.discussions, (com.example.youthhub.resModel.event.discussion.Discussion.class.getClassLoader()));
        this.userMediumPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public DiscussionData() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Discussion> getDiscussions() {
        return discussions;
    }

    public void setDiscussions(List<Discussion> discussions) {
        this.discussions = discussions;
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
        dest.writeList(discussions);
        dest.writeValue(userMediumPath);
        dest.writeValue(userThumbnailPath);
    }

    public int describeContents() {
        return  0;
    }

}
