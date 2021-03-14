
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpData implements Parcelable
{

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_code")
    @Expose
    private String userCode;
    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("user_name_code")
    @Expose
    private String userNameCode;
    @SerializedName("user_type_id")
    @Expose
    private String userTypeId;
    @SerializedName("user_type_code")
    @Expose
    private String userTypeCode;
    @SerializedName("user_type_name")
    @Expose
    private String userTypeName;
    @SerializedName("user_region_id")
    @Expose
    private String userRegionId;
    @SerializedName("user_region_name")
    @Expose
    private String userRegionName;
    @SerializedName("user_city_id")
    @Expose
    private String userCityId;
    @SerializedName("user_city_name")
    @Expose
    private String userCityName;
    @SerializedName("user_is_shadowtech")
    @Expose
    private String userIsShadowtech;
    @SerializedName("user_profile_pic")
    @Expose
    private String userProfilePic;
    @SerializedName("user_cover_pic")
    @Expose
    private String userCoverPic;
    @SerializedName("user_medium_path")
    @Expose
    private String userMediumPath;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    @SerializedName("user_cover_path")
    @Expose
    private String userCoverPath;
    public final static Creator<SignUpData> CREATOR = new Creator<SignUpData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SignUpData createFromParcel(Parcel in) {
            return new SignUpData(in);
        }

        public SignUpData[] newArray(int size) {
            return (new SignUpData[size]);
        }

    }
    ;

    protected SignUpData(Parcel in) {
        this.userId = ((String) in.readValue((String.class.getClassLoader())));
        this.userCode = ((String) in.readValue((String.class.getClassLoader())));
        this.userName = ((String) in.readValue((String.class.getClassLoader())));
        this.userNameCode = ((String) in.readValue((String.class.getClassLoader())));
        this.userTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.userTypeCode = ((String) in.readValue((String.class.getClassLoader())));
        this.userTypeName = ((String) in.readValue((String.class.getClassLoader())));
        this.userRegionId = ((String) in.readValue((String.class.getClassLoader())));
        this.userRegionName = ((String) in.readValue((String.class.getClassLoader())));
        this.userCityId = ((String) in.readValue((String.class.getClassLoader())));
        this.userCityName = ((String) in.readValue((String.class.getClassLoader())));
        this.userIsShadowtech = ((String) in.readValue((String.class.getClassLoader())));
        this.userProfilePic = ((String) in.readValue((String.class.getClassLoader())));
        this.userCoverPic = ((String) in.readValue((String.class.getClassLoader())));
        this.userMediumPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userCoverPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SignUpData() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserNameCode() {
        return userNameCode;
    }

    public void setUserNameCode(String userNameCode) {
        this.userNameCode = userNameCode;
    }

    public String getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(String userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeCode() {
        return userTypeCode;
    }

    public void setUserTypeCode(String userTypeCode) {
        this.userTypeCode = userTypeCode;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    public String getUserRegionId() {
        return userRegionId;
    }

    public void setUserRegionId(String userRegionId) {
        this.userRegionId = userRegionId;
    }

    public String getUserRegionName() {
        return userRegionName;
    }

    public void setUserRegionName(String userRegionName) {
        this.userRegionName = userRegionName;
    }

    public String getUserCityId() {
        return userCityId;
    }

    public void setUserCityId(String userCityId) {
        this.userCityId = userCityId;
    }

    public String getUserCityName() {
        return userCityName;
    }

    public void setUserCityName(String userCityName) {
        this.userCityName = userCityName;
    }

    public String getUserIsShadowtech() {
        return userIsShadowtech;
    }

    public void setUserIsShadowtech(String userIsShadowtech) {
        this.userIsShadowtech = userIsShadowtech;
    }

    public String getUserProfilePic() {
        return userProfilePic;
    }

    public void setUserProfilePic(String userProfilePic) {
        this.userProfilePic = userProfilePic;
    }

    public String getUserCoverPic() {
        return userCoverPic;
    }

    public void setUserCoverPic(String userCoverPic) {
        this.userCoverPic = userCoverPic;
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

    public String getUserCoverPath() {
        return userCoverPath;
    }

    public void setUserCoverPath(String userCoverPath) {
        this.userCoverPath = userCoverPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userId);
        dest.writeValue(userCode);
        dest.writeValue(userName);
        dest.writeValue(userNameCode);
        dest.writeValue(userTypeId);
        dest.writeValue(userTypeCode);
        dest.writeValue(userTypeName);
        dest.writeValue(userRegionId);
        dest.writeValue(userRegionName);
        dest.writeValue(userCityId);
        dest.writeValue(userCityName);
        dest.writeValue(userIsShadowtech);
        dest.writeValue(userProfilePic);
        dest.writeValue(userCoverPic);
        dest.writeValue(userMediumPath);
        dest.writeValue(userThumbnailPath);
        dest.writeValue(userCoverPath);
    }

    public int describeContents() {
        return  0;
    }

}
