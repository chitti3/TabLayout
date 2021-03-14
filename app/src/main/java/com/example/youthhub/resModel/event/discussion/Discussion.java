
package com.example.youthhub.resModel.event.discussion;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Discussion implements Parcelable
{

    @SerializedName("efb_feed_id")
    @Expose
    private String efbFeedId;
    @SerializedName("efb_em_event_id")
    @Expose
    private String efbEmEventId;
    @SerializedName("efb_message")
    @Expose
    private String efbMessage;
    @SerializedName("efb_created_on")
    @Expose
    private String efbCreatedOn;
    @SerializedName("efb_um_user_id")
    @Expose
    private String efbUmUserId;
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
    public final static Creator<Discussion> CREATOR = new Creator<Discussion>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Discussion createFromParcel(Parcel in) {
            return new Discussion(in);
        }

        public Discussion[] newArray(int size) {
            return (new Discussion[size]);
        }

    }
    ;

    protected Discussion(Parcel in) {
        this.efbFeedId = ((String) in.readValue((String.class.getClassLoader())));
        this.efbEmEventId = ((String) in.readValue((String.class.getClassLoader())));
        this.efbMessage = ((String) in.readValue((String.class.getClassLoader())));
        this.efbCreatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.efbUmUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.umName = ((String) in.readValue((String.class.getClassLoader())));
        this.umCode = ((String) in.readValue((String.class.getClassLoader())));
        this.umUtTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.umProfilePicture = ((String) in.readValue((String.class.getClassLoader())));
        this.usernameCode = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Discussion() {
    }

    public String getEfbFeedId() {
        return efbFeedId;
    }

    public void setEfbFeedId(String efbFeedId) {
        this.efbFeedId = efbFeedId;
    }

    public String getEfbEmEventId() {
        return efbEmEventId;
    }

    public void setEfbEmEventId(String efbEmEventId) {
        this.efbEmEventId = efbEmEventId;
    }

    public String getEfbMessage() {
        return efbMessage;
    }

    public void setEfbMessage(String efbMessage) {
        this.efbMessage = efbMessage;
    }

    public String getEfbCreatedOn() {
        return efbCreatedOn;
    }

    public void setEfbCreatedOn(String efbCreatedOn) {
        this.efbCreatedOn = efbCreatedOn;
    }

    public String getEfbUmUserId() {
        return efbUmUserId;
    }

    public void setEfbUmUserId(String efbUmUserId) {
        this.efbUmUserId = efbUmUserId;
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
        dest.writeValue(efbFeedId);
        dest.writeValue(efbEmEventId);
        dest.writeValue(efbMessage);
        dest.writeValue(efbCreatedOn);
        dest.writeValue(efbUmUserId);
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
