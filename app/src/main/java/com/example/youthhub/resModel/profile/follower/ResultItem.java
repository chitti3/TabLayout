package com.example.youthhub.resModel.profile.follower;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ResultItem{

	@SerializedName("is_follow")
	private int isFollow;

	@SerializedName("user_code")
	private String userCode;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("username_code")
	private String usernameCode;

	@SerializedName("usertype")
	private String usertype;

	@SerializedName("region_name")
	private String regionName;

	@SerializedName("user_profile")
	private String userProfile;

	@SerializedName("username")
	private String username;

	@SerializedName("about_me")
	private String aboutMe;

	@SerializedName("is_pic_exist")
	private int isPicExist;

	public void setIsFollow(int isFollow){
		this.isFollow = isFollow;
	}

	public int getIsFollow(){
		return isFollow;
	}

	public void setUserCode(String userCode){
		this.userCode = userCode;
	}

	public String getUserCode(){
		return userCode;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setUsernameCode(String usernameCode){
		this.usernameCode = usernameCode;
	}

	public String getUsernameCode(){
		return usernameCode;
	}

	public void setUsertype(String usertype){
		this.usertype = usertype;
	}

	public String getUsertype(){
		return usertype;
	}

	public void setRegionName(String regionName){
		this.regionName = regionName;
	}

	public String getRegionName(){
		return regionName;
	}

	public void setUserProfile(String userProfile){
		this.userProfile = userProfile;
	}

	public String getUserProfile(){
		return userProfile;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	public void setAboutMe(String aboutMe){
		this.aboutMe = aboutMe;
	}

	public String getAboutMe(){
		return aboutMe;
	}

	public void setIsPicExist(int isPicExist){
		this.isPicExist = isPicExist;
	}

	public int getIsPicExist(){
		return isPicExist;
	}

	@Override
 	public String toString(){
		return 
			"ResultItem{" + 
			"is_follow = '" + isFollow + '\'' + 
			",user_code = '" + userCode + '\'' + 
			",user_id = '" + userId + '\'' + 
			",username_code = '" + usernameCode + '\'' + 
			",usertype = '" + usertype + '\'' + 
			",region_name = '" + regionName + '\'' + 
			",user_profile = '" + userProfile + '\'' + 
			",username = '" + username + '\'' + 
			",about_me = '" + aboutMe + '\'' + 
			",is_pic_exist = '" + isPicExist + '\'' + 
			"}";
		}
}