package com.example.youthhub.resModel.profile.profileeducation.update;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class QualificationCategoryItem{

	@SerializedName("qac_category_id")
	private String qacCategoryId;

	@SerializedName("qac_name")
	private String qacName;

	public void setQacCategoryId(String qacCategoryId){
		this.qacCategoryId = qacCategoryId;
	}

	public String getQacCategoryId(){
		return qacCategoryId;
	}

	public void setQacName(String qacName){
		this.qacName = qacName;
	}

	public String getQacName(){
		return qacName;
	}

	@Override
 	public String toString(){
		return 
			"QualificationCategoryItem{" + 
			"qac_category_id = '" + qacCategoryId + '\'' + 
			",qac_name = '" + qacName + '\'' + 
			"}";
		}
}