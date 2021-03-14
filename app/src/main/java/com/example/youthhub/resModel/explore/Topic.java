
package com.example.youthhub.resModel.explore;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Topic implements Parcelable
{

    @SerializedName("xt_topic_id")
    @Expose
    private String xtTopicId;
    @SerializedName("xt_xm_explore_id")
    @Expose
    private String xtXmExploreId;
    @SerializedName("xt_title")
    @Expose
    private String xtTitle;
    @SerializedName("xt_created_on")
    @Expose
    private String xtCreatedOn;
    @SerializedName("xc_type")
    @Expose
    private String xcType;
    @SerializedName("xc_content")
    @Expose
    private String xcContent;
    @SerializedName("is_read")
    @Expose
    private Integer isRead;
    @SerializedName("coverpath")
    @Expose
    private String coverpath;
    @SerializedName("coverfile")
    @Expose
    private String coverfile;
    @SerializedName("video_id")
    @Expose
    private String videoId;
    @SerializedName("um_name")
    @Expose
    private String umName;
    public final static Creator<Topic> CREATOR = new Creator<Topic>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Topic createFromParcel(Parcel in) {
            return new Topic(in);
        }

        public Topic[] newArray(int size) {
            return (new Topic[size]);
        }

    }
    ;

    protected Topic(Parcel in) {
        this.xtTopicId = ((String) in.readValue((String.class.getClassLoader())));
        this.xtXmExploreId = ((String) in.readValue((String.class.getClassLoader())));
        this.xtTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.xtCreatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.xcType = ((String) in.readValue((String.class.getClassLoader())));
        this.xcContent = ((String) in.readValue((String.class.getClassLoader())));
        this.isRead = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.coverpath = ((String) in.readValue((String.class.getClassLoader())));
        this.coverfile = ((String) in.readValue((String.class.getClassLoader())));
        this.videoId = ((String) in.readValue((String.class.getClassLoader())));
        this.umName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Topic() {
    }

    public String getXtTopicId() {
        return xtTopicId;
    }

    public void setXtTopicId(String xtTopicId) {
        this.xtTopicId = xtTopicId;
    }

    public String getXtXmExploreId() {
        return xtXmExploreId;
    }

    public void setXtXmExploreId(String xtXmExploreId) {
        this.xtXmExploreId = xtXmExploreId;
    }

    public String getXtTitle() {
        return xtTitle;
    }

    public void setXtTitle(String xtTitle) {
        this.xtTitle = xtTitle;
    }

    public String getXtCreatedOn() {
        return xtCreatedOn;
    }

    public void setXtCreatedOn(String xtCreatedOn) {
        this.xtCreatedOn = xtCreatedOn;
    }

    public String getXcType() {
        return xcType;
    }

    public void setXcType(String xcType) {
        this.xcType = xcType;
    }

    public String getXcContent() {
        return xcContent;
    }

    public void setXcContent(String xcContent) {
        this.xcContent = xcContent;
    }

    public Integer getIsRead() {
        return isRead;
    }

    public void setIsRead(Integer isRead) {
        this.isRead = isRead;
    }

    public String getCoverpath() {
        return coverpath;
    }

    public void setCoverpath(String coverpath) {
        this.coverpath = coverpath;
    }

    public String getCoverfile() {
        return coverfile;
    }

    public void setCoverfile(String coverfile) {
        this.coverfile = coverfile;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getUmName() {
        return umName;
    }

    public void setUmName(String umName) {
        this.umName = umName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(xtTopicId);
        dest.writeValue(xtXmExploreId);
        dest.writeValue(xtTitle);
        dest.writeValue(xtCreatedOn);
        dest.writeValue(xcType);
        dest.writeValue(xcContent);
        dest.writeValue(isRead);
        dest.writeValue(coverpath);
        dest.writeValue(coverfile);
        dest.writeValue(videoId);
        dest.writeValue(umName);
    }

    public int describeContents() {
        return  0;
    }

}
