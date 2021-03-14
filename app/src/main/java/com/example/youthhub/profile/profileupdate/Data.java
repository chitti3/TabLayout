package com.example.youthhub.profile.profileupdate;

import javax.annotation.Generated;

import com.example.youthhub.resModel.profile.ProfileInfoMaster;
import com.example.youthhub.resModel.profile.YouthInfo;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("user_medium_path")
	private String userMediumPath;

	@SerializedName("profile_user_id")
	private String profileUserId;

	@SerializedName("following_count")
	private int followingCount;

	@SerializedName("profile_user_type")
	private String profileUserType;

	@SerializedName("login_user_id")
	private String loginUserId;

	@SerializedName("profile_info")
	private static YouthInfo profileInfo;

	@SerializedName("user_thumbnail_path")
	private String userThumbnailPath;

	@SerializedName("follower_count")
	private int followerCount;

	@SerializedName("user_cover_path")
	private String userCoverPath;

	@SerializedName("posts_count")
	private int postsCount;

	public void setUserMediumPath(String userMediumPath){
		this.userMediumPath = userMediumPath;
	}

	public String getUserMediumPath(){
		return userMediumPath;
	}

	public void setProfileUserId(String profileUserId){
		this.profileUserId = profileUserId;
	}

	public String getProfileUserId(){
		return profileUserId;
	}

	public void setFollowingCount(int followingCount){
		this.followingCount = followingCount;
	}

	public int getFollowingCount(){
		return followingCount;
	}

	public void setProfileUserType(String profileUserType){
		this.profileUserType = profileUserType;
	}

	public String getProfileUserType(){
		return profileUserType;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setProfileInfo(YouthInfo profileInfo){
		this.profileInfo = profileInfo;
	}

	public static YouthInfo getProfileInfo(){
		return profileInfo;
	}

	public void setUserThumbnailPath(String userThumbnailPath){
		this.userThumbnailPath = userThumbnailPath;
	}

	public String getUserThumbnailPath(){
		return userThumbnailPath;
	}

	public void setFollowerCount(int followerCount){
		this.followerCount = followerCount;
	}

	public int getFollowerCount(){
		return followerCount;
	}

	public void setUserCoverPath(String userCoverPath){
		this.userCoverPath = userCoverPath;
	}

	public String getUserCoverPath(){
		return userCoverPath;
	}

	public void setPostsCount(int postsCount){
		this.postsCount = postsCount;
	}

	public int getPostsCount(){
		return postsCount;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"user_medium_path = '" + userMediumPath + '\'' + 
			",profile_user_id = '" + profileUserId + '\'' + 
			",following_count = '" + followingCount + '\'' + 
			",profile_user_type = '" + profileUserType + '\'' + 
			",login_user_id = '" + loginUserId + '\'' + 
			",profile_info = '" + profileInfo + '\'' + 
			",user_thumbnail_path = '" + userThumbnailPath + '\'' + 
			",follower_count = '" + followerCount + '\'' + 
			",user_cover_path = '" + userCoverPath + '\'' + 
			",posts_count = '" + postsCount + '\'' + 
			"}";
		}
}