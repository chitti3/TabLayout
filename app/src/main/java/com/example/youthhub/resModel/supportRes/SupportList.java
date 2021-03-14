
package com.example.youthhub.resModel.supportRes;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupportList implements Parcelable
{

    @SerializedName("hm_helpdesk_id")
    @Expose
    private String hmHelpdeskId;
    @SerializedName("hm_code")
    @Expose
    private String hmCode;
    @SerializedName("hm_subject")
    @Expose
    private String hmSubject;
    @SerializedName("hm_date")
    @Expose
    private String hmDate;
    @SerializedName("hm_active")
    @Expose
    private String hmActive;
    @SerializedName("hm_sm_status_id")
    @Expose
    private String hmSmStatusId;
    @SerializedName("hm_user_replies")
    @Expose
    private String hmUserReplies;
    @SerializedName("hm_admin_replies")
    @Expose
    private String hmAdminReplies;
    @SerializedName("hm_um_user_id")
    @Expose
    private String hmUmUserId;
    @SerializedName("um_ut_type_id")
    @Expose
    private String umUtTypeId;
    @SerializedName("unread_count")
    @Expose
    private String unreadCount;
    @SerializedName("read_status")
    @Expose
    private String readStatus;
    @SerializedName("hm_sm_status_name")
    @Expose
    private String hmSmStatusName;
    @SerializedName("is_save")
    @Expose
    private Integer isSave;
    public final static Creator<SupportList> CREATOR = new Creator<SupportList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SupportList createFromParcel(Parcel in) {
            return new SupportList(in);
        }

        public SupportList[] newArray(int size) {
            return (new SupportList[size]);
        }

    }
    ;

    protected SupportList(Parcel in) {
        this.hmHelpdeskId = ((String) in.readValue((String.class.getClassLoader())));
        this.hmCode = ((String) in.readValue((String.class.getClassLoader())));
        this.hmSubject = ((String) in.readValue((String.class.getClassLoader())));
        this.hmDate = ((String) in.readValue((String.class.getClassLoader())));
        this.hmActive = ((String) in.readValue((String.class.getClassLoader())));
        this.hmSmStatusId = ((String) in.readValue((String.class.getClassLoader())));
        this.hmUserReplies = ((String) in.readValue((String.class.getClassLoader())));
        this.hmAdminReplies = ((String) in.readValue((String.class.getClassLoader())));
        this.hmUmUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.umUtTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.unreadCount = ((String) in.readValue((String.class.getClassLoader())));
        this.readStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.hmSmStatusName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SupportList() {
    }

    public String getHmHelpdeskId() {
        return hmHelpdeskId;
    }

    public void setHmHelpdeskId(String hmHelpdeskId) {
        this.hmHelpdeskId = hmHelpdeskId;
    }

    public String getHmCode() {
        return hmCode;
    }

    public void setHmCode(String hmCode) {
        this.hmCode = hmCode;
    }

    public String getHmSubject() {
        return hmSubject;
    }

    public void setHmSubject(String hmSubject) {
        this.hmSubject = hmSubject;
    }

    public String getHmDate() {
        return hmDate;
    }

    public void setHmDate(String hmDate) {
        this.hmDate = hmDate;
    }

    public String getHmActive() {
        return hmActive;
    }

    public void setHmActive(String hmActive) {
        this.hmActive = hmActive;
    }

    public String getHmSmStatusId() {
        return hmSmStatusId;
    }

    public void setHmSmStatusId(String hmSmStatusId) {
        this.hmSmStatusId = hmSmStatusId;
    }

    public String getHmUserReplies() {
        return hmUserReplies;
    }

    public void setHmUserReplies(String hmUserReplies) {
        this.hmUserReplies = hmUserReplies;
    }

    public String getHmAdminReplies() {
        return hmAdminReplies;
    }

    public void setHmAdminReplies(String hmAdminReplies) {
        this.hmAdminReplies = hmAdminReplies;
    }

    public String getHmUmUserId() {
        return hmUmUserId;
    }

    public void setHmUmUserId(String hmUmUserId) {
        this.hmUmUserId = hmUmUserId;
    }

    public String getUmUtTypeId() {
        return umUtTypeId;
    }

    public void setUmUtTypeId(String umUtTypeId) {
        this.umUtTypeId = umUtTypeId;
    }

    public String getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(String unreadCount) {
        this.unreadCount = unreadCount;
    }

    public String getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(String readStatus) {
        this.readStatus = readStatus;
    }

    public String getHmSmStatusName() {
        return hmSmStatusName;
    }

    public void setHmSmStatusName(String hmSmStatusName) {
        this.hmSmStatusName = hmSmStatusName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(hmHelpdeskId);
        dest.writeValue(hmCode);
        dest.writeValue(hmSubject);
        dest.writeValue(hmDate);
        dest.writeValue(hmActive);
        dest.writeValue(hmSmStatusId);
        dest.writeValue(hmUserReplies);
        dest.writeValue(hmAdminReplies);
        dest.writeValue(hmUmUserId);
        dest.writeValue(umUtTypeId);
        dest.writeValue(unreadCount);
        dest.writeValue(readStatus);
        dest.writeValue(hmSmStatusName);
        dest.writeValue(isSave);
    }

    public int describeContents() {
        return  0;
    }
}
