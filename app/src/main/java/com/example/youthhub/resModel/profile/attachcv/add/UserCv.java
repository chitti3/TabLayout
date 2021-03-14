package com.example.youthhub.resModel.profile.attachcv.add;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class UserCv{

	@SerializedName("ucv_cv_id")
	private int ucvCvId;

	@SerializedName("ucv_created_on")
	private String ucvCreatedOn;

	@SerializedName("ucv_title")
	private String ucvTitle;

	@SerializedName("ucv_type_name")
	private String ucvTypeName;

	@SerializedName("ucv_type")
	private String ucvType;

	@SerializedName("ucv_file_name")
	private String ucvFileName;

	public void setUcvCvId(int ucvCvId){
		this.ucvCvId = ucvCvId;
	}

	public int getUcvCvId(){
		return ucvCvId;
	}

	public void setUcvCreatedOn(String ucvCreatedOn){
		this.ucvCreatedOn = ucvCreatedOn;
	}

	public String getUcvCreatedOn(){
		return ucvCreatedOn;
	}

	public void setUcvTitle(String ucvTitle){
		this.ucvTitle = ucvTitle;
	}

	public String getUcvTitle(){
		return ucvTitle;
	}

	public void setUcvTypeName(String ucvTypeName){
		this.ucvTypeName = ucvTypeName;
	}

	public String getUcvTypeName(){
		return ucvTypeName;
	}

	public void setUcvType(String ucvType){
		this.ucvType = ucvType;
	}

	public String getUcvType(){
		return ucvType;
	}

	public void setUcvFileName(String ucvFileName){
		this.ucvFileName = ucvFileName;
	}

	public String getUcvFileName(){
		return ucvFileName;
	}

	@Override
 	public String toString(){
		return 
			"UserCv{" + 
			"ucv_cv_id = '" + ucvCvId + '\'' + 
			",ucv_created_on = '" + ucvCreatedOn + '\'' + 
			",ucv_title = '" + ucvTitle + '\'' + 
			",ucv_type_name = '" + ucvTypeName + '\'' + 
			",ucv_type = '" + ucvType + '\'' + 
			",ucv_file_name = '" + ucvFileName + '\'' + 
			"}";
		}
}