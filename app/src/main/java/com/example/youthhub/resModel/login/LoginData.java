
package com.example.youthhub.resModel.login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginData implements Parcelable
{

    @SerializedName("email")
    @Expose
    private String email;
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
    @SerializedName("user_points")
    @Expose
    private String user_points;
    @SerializedName("user_level_name")
    @Expose
    private String user_level_name;
    @SerializedName("user_level")
    @Expose
    private String user_level;

    public LoginData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public int describeContents() {
        return 0;
    }

    public String getUser_points() {
        return user_points;
    }

    public void setUser_points(String user_points) {
        this.user_points = user_points;
    }

    public String getUser_level_name() {
        return user_level_name;
    }

    public void setUser_level_name(String user_level_name) {
        this.user_level_name = user_level_name;
    }

    public String getUser_level() {
        return user_level;
    }

    public void setUser_level(String user_level) {
        this.user_level = user_level;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.email);
        dest.writeString(this.userId);
        dest.writeString(this.userCode);
        dest.writeString(this.userName);
        dest.writeString(this.userNameCode);
        dest.writeString(this.userTypeId);
        dest.writeString(this.userTypeCode);
        dest.writeString(this.userTypeName);
        dest.writeString(this.userRegionId);
        dest.writeString(this.userRegionName);
        dest.writeString(this.userCityId);
        dest.writeString(this.userCityName);
        dest.writeString(this.userIsShadowtech);
        dest.writeString(this.userProfilePic);
        dest.writeString(this.userCoverPic);
        dest.writeString(this.userMediumPath);
        dest.writeString(this.userThumbnailPath);
        dest.writeString(this.userCoverPath);
        dest.writeString(this.user_points);
        dest.writeString(this.user_level_name);
        dest.writeString(this.user_level);
    }

    protected LoginData(Parcel in) {
        this.email = in.readString();
        this.userId = in.readString();
        this.userCode = in.readString();
        this.userName = in.readString();
        this.userNameCode = in.readString();
        this.userTypeId = in.readString();
        this.userTypeCode = in.readString();
        this.userTypeName = in.readString();
        this.userRegionId = in.readString();
        this.userRegionName = in.readString();
        this.userCityId = in.readString();
        this.userCityName = in.readString();
        this.userIsShadowtech = in.readString();
        this.userProfilePic = in.readString();
        this.userCoverPic = in.readString();
        this.userMediumPath = in.readString();
        this.userThumbnailPath = in.readString();
        this.userCoverPath = in.readString();
        this.user_points = in.readString();
        this.user_level_name = in.readString();
        this.user_level = in.readString();
    }

    public static final Creator<LoginData> CREATOR = new Creator<LoginData>() {
        @Override
        public LoginData createFromParcel(Parcel source) {
            return new LoginData(source);
        }

        @Override
        public LoginData[] newArray(int size) {
            return new LoginData[size];
        }
    };
}
