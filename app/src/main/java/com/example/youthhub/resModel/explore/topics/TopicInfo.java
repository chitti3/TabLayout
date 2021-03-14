
package com.example.youthhub.resModel.explore.topics;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopicInfo implements Parcelable
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
    @SerializedName("xt_created_by")
    @Expose
    private String xtCreatedBy;
    @SerializedName("xt_updated_on")
    @Expose
    private String xtUpdatedOn;
    @SerializedName("xt_updated_by")
    @Expose
    private String xtUpdatedBy;
    @SerializedName("xt_active")
    @Expose
    private String xtActive;
    @SerializedName("xt_old_id")
    @Expose
    private String xtOldId;
    @SerializedName("xc_type")
    @Expose
    private String xcType;
    @SerializedName("xc_content")
    @Expose
    private String xcContent;
    @SerializedName("xvh_xt_topic_id")
    @Expose
    private String xvhXtTopicId;
    public final static Creator<TopicInfo> CREATOR = new Creator<TopicInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public TopicInfo createFromParcel(Parcel in) {
            return new TopicInfo(in);
        }

        public TopicInfo[] newArray(int size) {
            return (new TopicInfo[size]);
        }

    }
    ;

    protected TopicInfo(Parcel in) {
        this.xtTopicId = ((String) in.readValue((String.class.getClassLoader())));
        this.xtXmExploreId = ((String) in.readValue((String.class.getClassLoader())));
        this.xtTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.xtCreatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.xtCreatedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.xtUpdatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.xtUpdatedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.xtActive = ((String) in.readValue((String.class.getClassLoader())));
        this.xtOldId = ((String) in.readValue((String.class.getClassLoader())));
        this.xcType = ((String) in.readValue((String.class.getClassLoader())));
        this.xcContent = ((String) in.readValue((String.class.getClassLoader())));
        this.xvhXtTopicId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public TopicInfo() {
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

    public String getXtCreatedBy() {
        return xtCreatedBy;
    }

    public void setXtCreatedBy(String xtCreatedBy) {
        this.xtCreatedBy = xtCreatedBy;
    }

    public String getXtUpdatedOn() {
        return xtUpdatedOn;
    }

    public void setXtUpdatedOn(String xtUpdatedOn) {
        this.xtUpdatedOn = xtUpdatedOn;
    }

    public String getXtUpdatedBy() {
        return xtUpdatedBy;
    }

    public void setXtUpdatedBy(String xtUpdatedBy) {
        this.xtUpdatedBy = xtUpdatedBy;
    }

    public String getXtActive() {
        return xtActive;
    }

    public void setXtActive(String xtActive) {
        this.xtActive = xtActive;
    }

    public String getXtOldId() {
        return xtOldId;
    }

    public void setXtOldId(String xtOldId) {
        this.xtOldId = xtOldId;
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

    public String getXvhXtTopicId() {
        return xvhXtTopicId;
    }

    public void setXvhXtTopicId(String xvhXtTopicId) {
        this.xvhXtTopicId = xvhXtTopicId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(xtTopicId);
        dest.writeValue(xtXmExploreId);
        dest.writeValue(xtTitle);
        dest.writeValue(xtCreatedOn);
        dest.writeValue(xtCreatedBy);
        dest.writeValue(xtUpdatedOn);
        dest.writeValue(xtUpdatedBy);
        dest.writeValue(xtActive);
        dest.writeValue(xtOldId);
        dest.writeValue(xcType);
        dest.writeValue(xcContent);
        dest.writeValue(xvhXtTopicId);
    }

    public int describeContents() {
        return  0;
    }

}
