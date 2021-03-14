package com.example.youthhub.resModel.profile.profilemaster.titlequalification;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("qualification_title")
	private List<QualificationTitleItem> qualificationTitle;

	public void setQualificationTitle(List<QualificationTitleItem> qualificationTitle){
		this.qualificationTitle = qualificationTitle;
	}

	public List<QualificationTitleItem> getQualificationTitle(){
		return qualificationTitle;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"qualification_title = '" + qualificationTitle + '\'' + 
			"}";
		}
}