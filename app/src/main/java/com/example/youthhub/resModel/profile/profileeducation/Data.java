package com.example.youthhub.resModel.profile.profileeducation;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("education")
	private List<com.example.youthhub.resModel.profile.profileinfo.EducationItem> education;

	public void setEducation(List<com.example.youthhub.resModel.profile.profileinfo.EducationItem> education){
		this.education = education;
	}

	public List<com.example.youthhub.resModel.profile.profileinfo.EducationItem> getEducation(){
		return education;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"education = '" + education + '\'' + 
			"}";
		}
}