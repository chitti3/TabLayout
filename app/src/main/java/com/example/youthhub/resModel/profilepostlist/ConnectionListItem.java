package com.example.youthhub.resModel.profilepostlist;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ConnectionListItem{

	@SerializedName("subtitle2")
	private String subtitle2;

	@SerializedName("subtitle1")
	private String subtitle1;

	@SerializedName("is_follow")
	private int isFollow;

	@SerializedName("profile")
	private String profile;

	@SerializedName("usertype")
	private String usertype;

	@SerializedName("userid")
	private String userid;

	@SerializedName("about_me")
	private String aboutMe;

	@SerializedName("chat_id")
	private int chatId;

	@SerializedName("username_code")
	private String usernameCode;

	@SerializedName("region_name")
	private String regionName;

	@SerializedName("usercode")
	private String usercode;

	@SerializedName("username")
	private String username;

	@SerializedName("is_pic_exist")
	private int isPicExist;

	public void setSubtitle2(String subtitle2){
		this.subtitle2 = subtitle2;
	}

	public String getSubtitle2(){
		return subtitle2;
	}

	public void setSubtitle1(String subtitle1){
		this.subtitle1 = subtitle1;
	}

	public String getSubtitle1(){
		return subtitle1;
	}

	public void setIsFollow(int isFollow){
		this.isFollow = isFollow;
	}

	public int getIsFollow(){
		return isFollow;
	}

	public void setProfile(String profile){
		this.profile = profile;
	}

	public String getProfile(){
		return profile;
	}

	public void setUsertype(String usertype){
		this.usertype = usertype;
	}

	public String getUsertype(){
		return usertype;
	}

	public void setUserid(String userid){
		this.userid = userid;
	}

	public String getUserid(){
		return userid;
	}

	public void setAboutMe(String aboutMe){
		this.aboutMe = aboutMe;
	}

	public String getAboutMe(){
		return aboutMe;
	}

	public void setChatId(int chatId){
		this.chatId = chatId;
	}

	public int getChatId(){
		return chatId;
	}

	public void setUsernameCode(String usernameCode){
		this.usernameCode = usernameCode;
	}

	public String getUsernameCode(){
		return usernameCode;
	}

	public void setRegionName(String regionName){
		this.regionName = regionName;
	}

	public String getRegionName(){
		return regionName;
	}

	public void setUsercode(String usercode){
		this.usercode = usercode;
	}

	public String getUsercode(){
		return usercode;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
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
			"ConnectionListItem{" + 
			"subtitle2 = '" + subtitle2 + '\'' + 
			",subtitle1 = '" + subtitle1 + '\'' + 
			",is_follow = '" + isFollow + '\'' + 
			",profile = '" + profile + '\'' + 
			",usertype = '" + usertype + '\'' + 
			",userid = '" + userid + '\'' + 
			",about_me = '" + aboutMe + '\'' + 
			",chat_id = '" + chatId + '\'' + 
			",username_code = '" + usernameCode + '\'' + 
			",region_name = '" + regionName + '\'' + 
			",usercode = '" + usercode + '\'' + 
			",username = '" + username + '\'' + 
			",is_pic_exist = '" + isPicExist + '\'' + 
			"}";
		}
}