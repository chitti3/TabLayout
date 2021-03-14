package com.example.youthhub.resModel.profile.profileexperience.add;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("experience")
	private List<com.example.youthhub.resModel.profile.profileinfo.ExperienceItem> experience;

	public void setExperience(List<com.example.youthhub.resModel.profile.profileinfo.ExperienceItem> experience){
		this.experience = experience;
	}

	public List<com.example.youthhub.resModel.profile.profileinfo.ExperienceItem> getExperience(){
		return experience;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"experience = '" + experience + '\'' + 
			"}";
		}
}