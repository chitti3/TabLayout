package com.example.youthhub.resModel.profile.profilemaster.titlequalification;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class QualificationTitleItem{

	@SerializedName("qam_title")
	private String qamTitle;

	@SerializedName("qam_qualification_id")
	private String qamQualificationId;

	public void setQamTitle(String qamTitle){
		this.qamTitle = qamTitle;
	}

	public String getQamTitle(){
		return qamTitle;
	}

	public void setQamQualificationId(String qamQualificationId){
		this.qamQualificationId = qamQualificationId;
	}

	public String getQamQualificationId(){
		return qamQualificationId;
	}

	@Override
 	public String toString(){
		return 
			qamTitle;
		}
}