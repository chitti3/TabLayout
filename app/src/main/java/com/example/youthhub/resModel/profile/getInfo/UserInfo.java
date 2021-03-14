package com.example.youthhub.resModel.profile.getInfo;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class UserInfo{

	@SerializedName("is_follow")
	private int isFollow;

	@SerializedName("um_level")
	private String umLevel;

	@SerializedName("um_points")
	private String umPoints;

	@SerializedName("chat_id")
	private int chatId;

	@SerializedName("um_level_img")
	private String umLevelImg;

	public void setIsFollow(int isFollow){
		this.isFollow = isFollow;
	}

	public int getIsFollow(){
		return isFollow;
	}

	public void setUmLevel(String umLevel){
		this.umLevel = umLevel;
	}

	public String getUmLevel(){
		return umLevel;
	}

	public void setUmPoints(String umPoints){
		this.umPoints = umPoints;
	}

	public String getUmPoints(){
		return umPoints;
	}

	public void setChatId(int chatId){
		this.chatId = chatId;
	}

	public int getChatId(){
		return chatId;
	}

	public void setUmLevelImg(String umLevelImg){
		this.umLevelImg = umLevelImg;
	}

	public String getUmLevelImg(){
		return umLevelImg;
	}

	@Override
 	public String toString(){
		return 
			"UserInfo{" + 
			"is_follow = '" + isFollow + '\'' + 
			",um_level = '" + umLevel + '\'' + 
			",um_points = '" + umPoints + '\'' + 
			",chat_id = '" + chatId + '\'' + 
			",um_level_img = '" + umLevelImg + '\'' + 
			"}";
		}
}