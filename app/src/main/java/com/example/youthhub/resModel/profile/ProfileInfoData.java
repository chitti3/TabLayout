
package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileInfoData implements Parcelable
{

    @SerializedName("login_user_id")
    @Expose
    private String loginUserId;
    @SerializedName("profile_user_id")
    @Expose
    private String profileUserId;
    @SerializedName("profile_user_type")
    @Expose
    private String profileUserType;
    @SerializedName("following_count")
    @Expose
    private Integer followingCount;
    @SerializedName("follower_count")
    @Expose
    private Integer followerCount;
    @SerializedName("posts_count")
    @Expose
    private Integer postsCount;
    @SerializedName("profile_info")
    @Expose
    private ProfileInfo profileInfo;
    @SerializedName("user_medium_path")
    @Expose
    private String userMediumPath;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    @SerializedName("user_cover_path")
    @Expose
    private String userCoverPath;
    public final static Creator<ProfileInfoData> CREATOR = new Creator<ProfileInfoData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProfileInfoData createFromParcel(Parcel in) {
            return new ProfileInfoData(in);
        }

        public ProfileInfoData[] newArray(int size) {
            return (new ProfileInfoData[size]);
        }

    }
    ;

    protected ProfileInfoData(Parcel in) {
        this.loginUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.profileUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.profileUserType = ((String) in.readValue((String.class.getClassLoader())));
        this.followingCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.followerCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.postsCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.profileInfo = ((ProfileInfo) in.readValue((ProfileInfo.class.getClassLoader())));
        this.userMediumPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userCoverPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ProfileInfoData() {
    }

    public String getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(String loginUserId) {
        this.loginUserId = loginUserId;
    }

    public String getProfileUserId() {
        return profileUserId;
    }

    public void setProfileUserId(String profileUserId) {
        this.profileUserId = profileUserId;
    }

    public String getProfileUserType() {
        return profileUserType;
    }

    public void setProfileUserType(String profileUserType) {
        this.profileUserType = profileUserType;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }

    public Integer getPostsCount() {
        return postsCount;
    }

    public void setPostsCount(Integer postsCount) {
        this.postsCount = postsCount;
    }

    public ProfileInfo getProfileInfo() {
        return profileInfo;
    }

    public void setProfileInfo(ProfileInfo profileInfo) {
        this.profileInfo = profileInfo;
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
        dest.writeValue(loginUserId);
        dest.writeValue(profileUserId);
        dest.writeValue(profileUserType);
        dest.writeValue(followingCount);
        dest.writeValue(followerCount);
        dest.writeValue(postsCount);
        dest.writeValue(profileInfo);
        dest.writeValue(userMediumPath);
        dest.writeValue(userThumbnailPath);
        dest.writeValue(userCoverPath);
    }

    public int describeContents() {
        return  0;
    }

}
