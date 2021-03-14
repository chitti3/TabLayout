package com.example.youthhub.resModel.profile.profileeducation.update;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class OrganisationCategoryItem{

	@SerializedName("ogc_category_id")
	private String ogcCategoryId;

	@SerializedName("ogc_name")
	private String ogcName;

	public void setOgcCategoryId(String ogcCategoryId){
		this.ogcCategoryId = ogcCategoryId;
	}

	public String getOgcCategoryId(){
		return ogcCategoryId;
	}

	public void setOgcName(String ogcName){
		this.ogcName = ogcName;
	}

	public String getOgcName(){
		return ogcName;
	}

	@Override
 	public String toString(){
		return 
			"OrganisationCategoryItem{" + 
			"ogc_category_id = '" + ogcCategoryId + '\'' + 
			",ogc_name = '" + ogcName + '\'' + 
			"}";
		}
}