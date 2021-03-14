package com.example.youthhub.resModel.profile.technicalskill;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("technical_skills")
	private List<com.example.youthhub.resModel.profile.profileinfo.TechnicalSkillsItem> technicalSkills;

	public void setTechnicalSkills(List<com.example.youthhub.resModel.profile.profileinfo.TechnicalSkillsItem> technicalSkills){
		this.technicalSkills = technicalSkills;
	}

	public List<com.example.youthhub.resModel.profile.profileinfo.TechnicalSkillsItem> getTechnicalSkills(){
		return technicalSkills;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"technical_skills = '" + technicalSkills + '\'' + 
			"}";
		}
}