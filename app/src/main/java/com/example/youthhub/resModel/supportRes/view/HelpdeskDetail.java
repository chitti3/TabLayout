
package com.example.youthhub.resModel.supportRes.view;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HelpdeskDetail implements Parcelable
{

    @SerializedName("hd_is_read")
    @Expose
    private String hdIsRead;
    @SerializedName("hm_code")
    @Expose
    private String hmCode;
    @SerializedName("hd_active")
    @Expose
    private String hdActive;
    @SerializedName("hd_message")
    @Expose
    private String hdMessage;
    @SerializedName("hd_created_on")
    @Expose
    private String hdCreatedOn;
    @SerializedName("hd_file")
    @Expose
    private String hdFile;
    @SerializedName("hd_hm_helpdesk_id")
    @Expose
    private String hdHmHelpdeskId;
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
    @SerializedName("um_name_code")
    @Expose
    private String umNameCode;
    @SerializedName("is_pic_exist")
    @Expose
    private Integer isPicExist;
    @SerializedName("is_file_exist")
    @Expose
    private Integer isFileExist;
    public final static Creator<HelpdeskDetail> CREATOR = new Creator<HelpdeskDetail>() {


        @SuppressWarnings({
            "unchecked"
        })
        public HelpdeskDetail createFromParcel(Parcel in) {
            return new HelpdeskDetail(in);
        }

        public HelpdeskDetail[] newArray(int size) {
            return (new HelpdeskDetail[size]);
        }

    }
    ;

    protected HelpdeskDetail(Parcel in) {
        this.hdIsRead = ((String) in.readValue((String.class.getClassLoader())));
        this.hmCode = ((String) in.readValue((String.class.getClassLoader())));
        this.hdActive = ((String) in.readValue((String.class.getClassLoader())));
        this.hdMessage = ((String) in.readValue((String.class.getClassLoader())));
        this.hdCreatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.hdFile = ((String) in.readValue((String.class.getClassLoader())));
        this.hdHmHelpdeskId = ((String) in.readValue((String.class.getClassLoader())));
        this.umName = ((String) in.readValue((String.class.getClassLoader())));
        this.umCode = ((String) in.readValue((String.class.getClassLoader())));
        this.umUtTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.umProfilePicture = ((String) in.readValue((String.class.getClassLoader())));
        this.umNameCode = ((String) in.readValue((String.class.getClassLoader())));
        this.isPicExist = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isFileExist = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public HelpdeskDetail() {
    }

    public String getHdIsRead() {
        return hdIsRead;
    }

    public void setHdIsRead(String hdIsRead) {
        this.hdIsRead = hdIsRead;
    }

    public String getHmCode() {
        return hmCode;
    }

    public void setHmCode(String hmCode) {
        this.hmCode = hmCode;
    }

    public String getHdActive() {
        return hdActive;
    }

    public void setHdActive(String hdActive) {
        this.hdActive = hdActive;
    }

    public String getHdMessage() {
        return hdMessage;
    }

    public void setHdMessage(String hdMessage) {
        this.hdMessage = hdMessage;
    }

    public String getHdCreatedOn() {
        return hdCreatedOn;
    }

    public void setHdCreatedOn(String hdCreatedOn) {
        this.hdCreatedOn = hdCreatedOn;
    }

    public String getHdFile() {
        return hdFile;
    }

    public void setHdFile(String hdFile) {
        this.hdFile = hdFile;
    }

    public String getHdHmHelpdeskId() {
        return hdHmHelpdeskId;
    }

    public void setHdHmHelpdeskId(String hdHmHelpdeskId) {
        this.hdHmHelpdeskId = hdHmHelpdeskId;
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

    public String getUmNameCode() {
        return umNameCode;
    }

    public void setUmNameCode(String umNameCode) {
        this.umNameCode = umNameCode;
    }

    public Integer getIsPicExist() {
        return isPicExist;
    }

    public void setIsPicExist(Integer isPicExist) {
        this.isPicExist = isPicExist;
    }

    public Integer getIsFileExist() {
        return isFileExist;
    }

    public void setIsFileExist(Integer isFileExist) {
        this.isFileExist = isFileExist;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(hdIsRead);
        dest.writeValue(hmCode);
        dest.writeValue(hdActive);
        dest.writeValue(hdMessage);
        dest.writeValue(hdCreatedOn);
        dest.writeValue(hdFile);
        dest.writeValue(hdHmHelpdeskId);
        dest.writeValue(umName);
        dest.writeValue(umCode);
        dest.writeValue(umUtTypeId);
        dest.writeValue(umProfilePicture);
        dest.writeValue(umNameCode);
        dest.writeValue(isPicExist);
        dest.writeValue(isFileExist);
    }

    public int describeContents() {
        return  0;
    }

}
