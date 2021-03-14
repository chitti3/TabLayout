
package com.example.youthhub.resModel.explore.exploreDiscussion;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreDiscussion implements Parcelable
{

    @SerializedName("xf_feed_id")
    @Expose
    private String xfFeedId;
    @SerializedName("xf_um_user_id")
    @Expose
    private String xfUmUserId;
    @SerializedName("xf_xm_explore_id")
    @Expose
    private String xfXmExploreId;
    @SerializedName("xf_xt_topic_id")
    @Expose
    private String xfXtTopicId;
    @SerializedName("xf_type")
    @Expose
    private String xfType;
    @SerializedName("xf_message")
    @Expose
    private String xfMessage;
    @SerializedName("xf_parent_id")
    @Expose
    private String xfParentId;
    @SerializedName("xf_date")
    @Expose
    private String xfDate;
    @SerializedName("xf_updated_by")
    @Expose
    private String xfUpdatedBy;
    @SerializedName("xf_updated_on")
    @Expose
    private String xfUpdatedOn;
    @SerializedName("xf_active")
    @Expose
    private String xfActive;
    @SerializedName("xf_old_id")
    @Expose
    private String xfOldId;
    @SerializedName("um_name")
    @Expose
    private String umName;
    @SerializedName("um_code")
    @Expose
    private String umCode;
    @SerializedName("um_ut_type_id")
    @Expose
    private String umUtTypeId;
    @SerializedName("um_profile_picture")
    @Expose
    private String umProfilePicture;
    @SerializedName("username_code")
    @Expose
    private String usernameCode;
    public final static Creator<ExploreDiscussion> CREATOR = new Creator<ExploreDiscussion>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreDiscussion createFromParcel(Parcel in) {
            return new ExploreDiscussion(in);
        }

        public ExploreDiscussion[] newArray(int size) {
            return (new ExploreDiscussion[size]);
        }

    }
    ;

    protected ExploreDiscussion(Parcel in) {
        this.xfFeedId = ((String) in.readValue((String.class.getClassLoader())));
        this.xfUmUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.xfXmExploreId = ((String) in.readValue((String.class.getClassLoader())));
        this.xfXtTopicId = ((String) in.readValue((String.class.getClassLoader())));
        this.xfType = ((String) in.readValue((String.class.getClassLoader())));
        this.xfMessage = ((String) in.readValue((String.class.getClassLoader())));
        this.xfParentId = ((String) in.readValue((String.class.getClassLoader())));
        this.xfDate = ((String) in.readValue((String.class.getClassLoader())));
        this.xfUpdatedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.xfUpdatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.xfActive = ((String) in.readValue((String.class.getClassLoader())));
        this.xfOldId = ((String) in.readValue((String.class.getClassLoader())));
        this.umName = ((String) in.readValue((String.class.getClassLoader())));
        this.umCode = ((String) in.readValue((String.class.getClassLoader())));
        this.umUtTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.umProfilePicture = ((String) in.readValue((String.class.getClassLoader())));
        this.usernameCode = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExploreDiscussion() {
    }

    public String getXfFeedId() {
        return xfFeedId;
    }

    public void setXfFeedId(String xfFeedId) {
        this.xfFeedId = xfFeedId;
    }

    public String getXfUmUserId() {
        return xfUmUserId;
    }

    public void setXfUmUserId(String xfUmUserId) {
        this.xfUmUserId = xfUmUserId;
    }

    public String getXfXmExploreId() {
        return xfXmExploreId;
    }

    public void setXfXmExploreId(String xfXmExploreId) {
        this.xfXmExploreId = xfXmExploreId;
    }

    public String getXfXtTopicId() {
        return xfXtTopicId;
    }

    public void setXfXtTopicId(String xfXtTopicId) {
        this.xfXtTopicId = xfXtTopicId;
    }

    public String getXfType() {
        return xfType;
    }

    public void setXfType(String xfType) {
        this.xfType = xfType;
    }

    public String getXfMessage() {
        return xfMessage;
    }

    public void setXfMessage(String xfMessage) {
        this.xfMessage = xfMessage;
    }

    public String getXfParentId() {
        return xfParentId;
    }

    public void setXfParentId(String xfParentId) {
        this.xfParentId = xfParentId;
    }

    public String getXfDate() {
        return xfDate;
    }

    public void setXfDate(String xfDate) {
        this.xfDate = xfDate;
    }

    public String getXfUpdatedBy() {
        return xfUpdatedBy;
    }

    public void setXfUpdatedBy(String xfUpdatedBy) {
        this.xfUpdatedBy = xfUpdatedBy;
    }

    public String getXfUpdatedOn() {
        return xfUpdatedOn;
    }

    public void setXfUpdatedOn(String xfUpdatedOn) {
        this.xfUpdatedOn = xfUpdatedOn;
    }

    public String getXfActive() {
        return xfActive;
    }

    public void setXfActive(String xfActive) {
        this.xfActive = xfActive;
    }

    public String getXfOldId() {
        return xfOldId;
    }

    public void setXfOldId(String xfOldId) {
        this.xfOldId = xfOldId;
    }

    public String getUmName() {
        return umName;
    }

    public void setUmName(String umName) {
        this.umName = umName;
    }

    public String getUmCode() {
        return umCode;
    }

    public void setUmCode(String umCode) {
        this.umCode = umCode;
    }

    public String getUmUtTypeId() {
        return umUtTypeId;
    }

    public void setUmUtTypeId(String umUtTypeId) {
        this.umUtTypeId = umUtTypeId;
    }

    public String getUmProfilePicture() {
        return umProfilePicture;
    }

    public void setUmProfilePicture(String umProfilePicture) {
        this.umProfilePicture = umProfilePicture;
    }

    public String getUsernameCode() {
        return usernameCode;
    }

    public void setUsernameCode(String usernameCode) {
        this.usernameCode = usernameCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(xfFeedId);
        dest.writeValue(xfUmUserId);
        dest.writeValue(xfXmExploreId);
        dest.writeValue(xfXtTopicId);
        dest.writeValue(xfType);
        dest.writeValue(xfMessage);
        dest.writeValue(xfParentId);
        dest.writeValue(xfDate);
        dest.writeValue(xfUpdatedBy);
        dest.writeValue(xfUpdatedOn);
        dest.writeValue(xfActive);
        dest.writeValue(xfOldId);
        dest.writeValue(umName);
        dest.writeValue(umCode);
        dest.writeValue(umUtTypeId);
        dest.writeValue(umProfilePicture);
        dest.writeValue(usernameCode);
    }

    public int describeContents() {
        return  0;
    }

}
