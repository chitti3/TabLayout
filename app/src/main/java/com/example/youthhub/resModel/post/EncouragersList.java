
package com.example.youthhub.resModel.post;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EncouragersList implements Parcelable
{

    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("um_profile_picture")
    @Expose
    private String umProfilePicture;
    @SerializedName("user_code")
    @Expose
    private String userCode;
    @SerializedName("about_me")
    @Expose
    private String aboutMe;
    @SerializedName("user_type_id")
    @Expose
    private String userTypeId;
    @SerializedName("pfe_feed_id")
    @Expose
    private String pfeFeedId;
    @SerializedName("pfe_pm_post_id")
    @Expose
    private String pfePmPostId;
    @SerializedName("post_code")
    @Expose
    private String postCode;
    @SerializedName("pfe_type")
    @Expose
    private String pfeType;
    @SerializedName("pfe_created_on")
    @Expose
    private String pfeCreatedOn;
    @SerializedName("pfe_active")
    @Expose
    private String pfeActive;
    @SerializedName("username_code")
    @Expose
    private String usernameCode;
    @SerializedName("is_pic_exist")
    @Expose
    private Integer isPicExist;
    @SerializedName("region_name")
    @Expose
    private String regionName;
    @SerializedName("is_follow")
    @Expose
    private Integer isFollow;
    public final static Creator<EncouragersList> CREATOR = new Creator<EncouragersList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EncouragersList createFromParcel(Parcel in) {
            return new EncouragersList(in);
        }

        public EncouragersList[] newArray(int size) {
            return (new EncouragersList[size]);
        }

    }
    ;

    protected EncouragersList(Parcel in) {
        this.userName = ((String) in.readValue((String.class.getClassLoader())));
        this.umProfilePicture = ((String) in.readValue((String.class.getClassLoader())));
        this.userCode = ((String) in.readValue((String.class.getClassLoader())));
        this.aboutMe = ((String) in.readValue((String.class.getClassLoader())));
        this.userTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.pfeFeedId = ((String) in.readValue((String.class.getClassLoader())));
        this.pfePmPostId = ((String) in.readValue((String.class.getClassLoader())));
        this.postCode = ((String) in.readValue((String.class.getClassLoader())));
        this.pfeType = ((String) in.readValue((String.class.getClassLoader())));
        this.pfeCreatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.pfeActive = ((String) in.readValue((String.class.getClassLoader())));
        this.usernameCode = ((String) in.readValue((String.class.getClassLoader())));
        this.isPicExist = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.regionName = ((String) in.readValue((String.class.getClassLoader())));
        this.isFollow = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public EncouragersList() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUmProfilePicture() {
        return umProfilePicture;
    }

    public void setUmProfilePicture(String umProfilePicture) {
        this.umProfilePicture = umProfilePicture;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getPfeFeedId() {
        return pfeFeedId;
    }

    public void setPfeFeedId(String pfeFeedId) {
        this.pfeFeedId = pfeFeedId;
    }

    public String getPfePmPostId() {
        return pfePmPostId;
    }

    public void setPfePmPostId(String pfePmPostId) {
        this.pfePmPostId = pfePmPostId;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPfeType() {
        return pfeType;
    }

    public void setPfeType(String pfeType) {
        this.pfeType = pfeType;
    }

    public String getPfeCreatedOn() {
        return pfeCreatedOn;
    }

    public void setPfeCreatedOn(String pfeCreatedOn) {
        this.pfeCreatedOn = pfeCreatedOn;
    }

    public String getPfeActive() {
        return pfeActive;
    }

    public void setPfeActive(String pfeActive) {
        this.pfeActive = pfeActive;
    }

    public String getUsernameCode() {
        return usernameCode;
    }

    public void setUsernameCode(String usernameCode) {
        this.usernameCode = usernameCode;
    }

    public Integer getIsPicExist() {
        return isPicExist;
    }

    public void setIsPicExist(Integer isPicExist) {
        this.isPicExist = isPicExist;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Integer getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(Integer isFollow) {
        this.isFollow = isFollow;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userName);
        dest.writeValue(umProfilePicture);
        dest.writeValue(userCode);
        dest.writeValue(aboutMe);
        dest.writeValue(userTypeId);
        dest.writeValue(pfeFeedId);
        dest.writeValue(pfePmPostId);
        dest.writeValue(postCode);
        dest.writeValue(pfeType);
        dest.writeValue(pfeCreatedOn);
        dest.writeValue(pfeActive);
        dest.writeValue(usernameCode);
        dest.writeValue(isPicExist);
        dest.writeValue(regionName);
        dest.writeValue(isFollow);
    }

    public int describeContents() {
        return  0;
    }

}
