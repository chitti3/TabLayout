
package com.example.youthhub.resModel.event.eventView;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Parcelable
{

    @SerializedName("eus_user_id")
    @Expose
    private String eusUserId;
    @SerializedName("eus_em_event_id")
    @Expose
    private String eusEmEventId;
    @SerializedName("eus_um_user_id")
    @Expose
    private String eusUmUserId;
    @SerializedName("eus_status")
    @Expose
    private String eusStatus;
    @SerializedName("eus_ticket")
    @Expose
    private String eusTicket;
    @SerializedName("eus_verified")
    @Expose
    private String eusVerified;
    @SerializedName("eus_created_by")
    @Expose
    private String eusCreatedBy;
    @SerializedName("eus_created_on")
    @Expose
    private String eusCreatedOn;
    @SerializedName("eus_updated_by")
    @Expose
    private String eusUpdatedBy;
    @SerializedName("eus_updated_on")
    @Expose
    private String eusUpdatedOn;
    @SerializedName("eus_active")
    @Expose
    private String eusActive;
    @SerializedName("eus_old_id")
    @Expose
    private String eusOldId;
    @SerializedName("um_code")
    @Expose
    private String umCode;
    @SerializedName("um_name")
    @Expose
    private String umName;
    @SerializedName("um_about_me")
    @Expose
    private String umAboutMe;
    @SerializedName("um_profile_picture")
    @Expose
    private String umProfilePicture;
    @SerializedName("um_ut_type_id")
    @Expose
    private String umUtTypeId;
    @SerializedName("ut_description")
    @Expose
    private String utDescription;
    @SerializedName("username_code")
    @Expose
    private String usernameCode;
    public final static Creator<Datum> CREATOR = new Creator<Datum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Datum createFromParcel(Parcel in) {
            return new Datum(in);
        }

        public Datum[] newArray(int size) {
            return (new Datum[size]);
        }

    }
    ;

    protected Datum(Parcel in) {
        this.eusUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.eusEmEventId = ((String) in.readValue((String.class.getClassLoader())));
        this.eusUmUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.eusStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.eusTicket = ((String) in.readValue((String.class.getClassLoader())));
        this.eusVerified = ((String) in.readValue((String.class.getClassLoader())));
        this.eusCreatedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.eusCreatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.eusUpdatedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.eusUpdatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.eusActive = ((String) in.readValue((String.class.getClassLoader())));
        this.eusOldId = ((String) in.readValue((String.class.getClassLoader())));
        this.umCode = ((String) in.readValue((String.class.getClassLoader())));
        this.umName = ((String) in.readValue((String.class.getClassLoader())));
        this.umAboutMe = ((String) in.readValue((String.class.getClassLoader())));
        this.umProfilePicture = ((String) in.readValue((String.class.getClassLoader())));
        this.umUtTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.utDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.usernameCode = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Datum() {
    }

    public String getEusUserId() {
        return eusUserId;
    }

    public void setEusUserId(String eusUserId) {
        this.eusUserId = eusUserId;
    }

    public String getEusEmEventId() {
        return eusEmEventId;
    }

    public void setEusEmEventId(String eusEmEventId) {
        this.eusEmEventId = eusEmEventId;
    }

    public String getEusUmUserId() {
        return eusUmUserId;
    }

    public void setEusUmUserId(String eusUmUserId) {
        this.eusUmUserId = eusUmUserId;
    }

    public String getEusStatus() {
        return eusStatus;
    }

    public void setEusStatus(String eusStatus) {
        this.eusStatus = eusStatus;
    }

    public String getEusTicket() {
        return eusTicket;
    }

    public void setEusTicket(String eusTicket) {
        this.eusTicket = eusTicket;
    }

    public String getEusVerified() {
        return eusVerified;
    }

    public void setEusVerified(String eusVerified) {
        this.eusVerified = eusVerified;
    }

    public String getEusCreatedBy() {
        return eusCreatedBy;
    }

    public void setEusCreatedBy(String eusCreatedBy) {
        this.eusCreatedBy = eusCreatedBy;
    }

    public String getEusCreatedOn() {
        return eusCreatedOn;
    }

    public void setEusCreatedOn(String eusCreatedOn) {
        this.eusCreatedOn = eusCreatedOn;
    }

    public String getEusUpdatedBy() {
        return eusUpdatedBy;
    }

    public void setEusUpdatedBy(String eusUpdatedBy) {
        this.eusUpdatedBy = eusUpdatedBy;
    }

    public String getEusUpdatedOn() {
        return eusUpdatedOn;
    }

    public void setEusUpdatedOn(String eusUpdatedOn) {
        this.eusUpdatedOn = eusUpdatedOn;
    }

    public String getEusActive() {
        return eusActive;
    }

    public void setEusActive(String eusActive) {
        this.eusActive = eusActive;
    }

    public String getEusOldId() {
        return eusOldId;
    }

    public void setEusOldId(String eusOldId) {
        this.eusOldId = eusOldId;
    }

    public String getUmCode() {
        return umCode;
    }

    public void setUmCode(String umCode) {
        this.umCode = umCode;
    }

    public String getUmName() {
        return umName;
    }

    public void setUmName(String umName) {
        this.umName = umName;
    }

    public String getUmAboutMe() {
        return umAboutMe;
    }

    public void setUmAboutMe(String umAboutMe) {
        this.umAboutMe = umAboutMe;
    }

    public String getUmProfilePicture() {
        return umProfilePicture;
    }

    public void setUmProfilePicture(String umProfilePicture) {
        this.umProfilePicture = umProfilePicture;
    }

    public String getUmUtTypeId() {
        return umUtTypeId;
    }

    public void setUmUtTypeId(String umUtTypeId) {
        this.umUtTypeId = umUtTypeId;
    }

    public String getUtDescription() {
        return utDescription;
    }

    public void setUtDescription(String utDescription) {
        this.utDescription = utDescription;
    }

    public String getUsernameCode() {
        return usernameCode;
    }

    public void setUsernameCode(String usernameCode) {
        this.usernameCode = usernameCode;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(eusUserId);
        dest.writeValue(eusEmEventId);
        dest.writeValue(eusUmUserId);
        dest.writeValue(eusStatus);
        dest.writeValue(eusTicket);
        dest.writeValue(eusVerified);
        dest.writeValue(eusCreatedBy);
        dest.writeValue(eusCreatedOn);
        dest.writeValue(eusUpdatedBy);
        dest.writeValue(eusUpdatedOn);
        dest.writeValue(eusActive);
        dest.writeValue(eusOldId);
        dest.writeValue(umCode);
        dest.writeValue(umName);
        dest.writeValue(umAboutMe);
        dest.writeValue(umProfilePicture);
        dest.writeValue(umUtTypeId);
        dest.writeValue(utDescription);
        dest.writeValue(usernameCode);
    }

    public int describeContents() {
        return  0;
    }

}
