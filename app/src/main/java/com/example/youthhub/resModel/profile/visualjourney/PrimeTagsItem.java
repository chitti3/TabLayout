package com.example.youthhub.resModel.profile.visualjourney;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class PrimeTagsItem{

	@SerializedName("tg_name")
	private String tgName;

	@SerializedName("tg_icon")
	private String tgIcon;

	@SerializedName("tg_tag_id")
	private String tgTagId;

	public void setTgName(String tgName){
		this.tgName = tgName;
	}

	public String getTgName(){
		return tgName;
	}

	public void setTgIcon(String tgIcon){
		this.tgIcon = tgIcon;
	}

	public String getTgIcon(){
		return tgIcon;
	}

	public void setTgTagId(String tgTagId){
		this.tgTagId = tgTagId;
	}

	public String getTgTagId(){
		return tgTagId;
	}

	@Override
 	public String toString(){
		return 
			"PrimeTagsItem{" + 
			"tg_name = '" + tgName + '\'' + 
			",tg_icon = '" + tgIcon + '\'' + 
			",tg_tag_id = '" + tgTagId + '\'' + 
			"}";
		}
}