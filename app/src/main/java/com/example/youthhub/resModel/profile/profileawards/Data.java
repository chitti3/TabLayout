package com.example.youthhub.resModel.profile.profileawards;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("achievement")
	private List<com.example.youthhub.resModel.profile.profileinfo.AchievementItem> achievement;

	public void setAchievement(List<com.example.youthhub.resModel.profile.profileinfo.AchievementItem> achievement){
		this.achievement = achievement;
	}

	public List<com.example.youthhub.resModel.profile.profileinfo.AchievementItem> getAchievement(){
		return achievement;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"achievement = '" + achievement + '\'' + 
			"}";
		}
}