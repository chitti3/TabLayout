package com.example.youthhub.resModel.profile.volunteer.add.create.updatemaster;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class VolunteeringCategoryItem{

	@SerializedName("voc_category_id")
	private String vocCategoryId;

	@SerializedName("voc_name")
	private String vocName;

	public void setVocCategoryId(String vocCategoryId){
		this.vocCategoryId = vocCategoryId;
	}

	public String getVocCategoryId(){
		return vocCategoryId;
	}

	public void setVocName(String vocName){
		this.vocName = vocName;
	}

	public String getVocName(){
		return vocName;
	}

	@Override
 	public String toString(){
		return 
			"VolunteeringCategoryItem{" + 
			"voc_category_id = '" + vocCategoryId + '\'' + 
			",voc_name = '" + vocName + '\'' + 
			"}";
		}
}