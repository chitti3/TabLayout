package com.example.youthhub.resModel.profile.profileexperience.add.updatemaster;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class JobTypeItem{

	@SerializedName("jt_name")
	private String jtName;

	@SerializedName("jt_type_id")
	private String jtTypeId;

	public void setJtName(String jtName){
		this.jtName = jtName;
	}

	public String getJtName(){
		return jtName;
	}

	public void setJtTypeId(String jtTypeId){
		this.jtTypeId = jtTypeId;
	}

	public String getJtTypeId(){
		return jtTypeId;
	}

	@Override
 	public String toString(){
		return 
			"JobTypeItem{" + 
			"jt_name = '" + jtName + '\'' + 
			",jt_type_id = '" + jtTypeId + '\'' + 
			"}";
		}
}