
package com.example.youthhub.resModel.explore.topics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopicContent implements Parcelable
{

    @SerializedName("xc_content_id")
    @Expose
    private String xcContentId;
    @SerializedName("xc_xt_topic_id")
    @Expose
    private String xcXtTopicId;
    @SerializedName("xc_type")
    @Expose
    private String xcType;
    @SerializedName("xc_content")
    @Expose
    private String xcContent;
    @SerializedName("xc_display_order")
    @Expose
    private String xcDisplayOrder;
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
    public final static Creator<TopicContent> CREATOR = new Creator<TopicContent>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TopicContent createFromParcel(Parcel in) {
            return new TopicContent(in);
        }

        public TopicContent[] newArray(int size) {
            return (new TopicContent[size]);
        }

    }
    ;

    protected TopicContent(Parcel in) {
        this.xcContentId = ((String) in.readValue((String.class.getClassLoader())));
        this.xcXtTopicId = ((String) in.readValue((String.class.getClassLoader())));
        this.xcType = ((String) in.readValue((String.class.getClassLoader())));
        this.xcContent = ((String) in.readValue((String.class.getClassLoader())));
        this.xcDisplayOrder = ((String) in.readValue((String.class.getClassLoader())));
        this.isRead = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.coverpath = ((String) in.readValue((String.class.getClassLoader())));
        this.coverfile = ((String) in.readValue((String.class.getClassLoader())));
        this.videoId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TopicContent() {
    }

    public String getXcContentId() {
        return xcContentId;
    }

    public void setXcContentId(String xcContentId) {
        this.xcContentId = xcContentId;
    }

    public String getXcXtTopicId() {
        return xcXtTopicId;
    }

    public void setXcXtTopicId(String xcXtTopicId) {
        this.xcXtTopicId = xcXtTopicId;
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

    public String getXcDisplayOrder() {
        return xcDisplayOrder;
    }

    public void setXcDisplayOrder(String xcDisplayOrder) {
        this.xcDisplayOrder = xcDisplayOrder;
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

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(xcContentId);
        dest.writeValue(xcXtTopicId);
        dest.writeValue(xcType);
        dest.writeValue(xcContent);
        dest.writeValue(xcDisplayOrder);
        dest.writeValue(isRead);
        dest.writeValue(coverpath);
        dest.writeValue(coverfile);
        dest.writeValue(videoId);
    }

    public int describeContents() {
        return  0;
    }

}
