package com.example.youthhub.resModel.profile.profileexperience.add.updatemaster;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class BusinessCategoryListItem{

	@SerializedName("ica_category_id")
	private String icaCategoryId;

	@SerializedName("ica_name")
	private String icaName;

	public void setIcaCategoryId(String icaCategoryId){
		this.icaCategoryId = icaCategoryId;
	}

	public String getIcaCategoryId(){
		return icaCategoryId;
	}

	public void setIcaName(String icaName){
		this.icaName = icaName;
	}

	public String getIcaName(){
		return icaName;
	}

	@Override
 	public String toString(){
		return 
			"BusinessCategoryListItem{" + 
			"ica_category_id = '" + icaCategoryId + '\'' + 
			",ica_name = '" + icaName + '\'' + 
			"}";
		}
}