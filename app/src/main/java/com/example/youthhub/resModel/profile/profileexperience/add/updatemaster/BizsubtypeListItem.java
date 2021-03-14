package com.example.youthhub.resModel.profile.profileexperience.add.updatemaster;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class BizsubtypeListItem{

	@SerializedName("isc_name")
	private String iscName;

	@SerializedName("isc_sub_category_id")
	private String iscSubCategoryId;

	public void setIscName(String iscName){
		this.iscName = iscName;
	}

	public String getIscName(){
		return iscName;
	}

	public void setIscSubCategoryId(String iscSubCategoryId){
		this.iscSubCategoryId = iscSubCategoryId;
	}

	public String getIscSubCategoryId(){
		return iscSubCategoryId;
	}

	@Override
 	public String toString(){
		return 
			"BizsubtypeListItem{" + 
			"isc_name = '" + iscName + '\'' + 
			",isc_sub_category_id = '" + iscSubCategoryId + '\'' + 
			"}";
		}
}