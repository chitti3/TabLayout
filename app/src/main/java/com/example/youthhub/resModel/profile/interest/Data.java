package com.example.youthhub.resModel.profile.interest;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("interests")
	private List<com.example.youthhub.resModel.profile.profileinfo.InterestsItem> interests;

	public void setInterests(List<com.example.youthhub.resModel.profile.profileinfo.InterestsItem> interests){
		this.interests = interests;
	}

	public List<com.example.youthhub.resModel.profile.profileinfo.InterestsItem> getInterests(){
		return interests;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"interests = '" + interests + '\'' + 
			"}";
		}
}