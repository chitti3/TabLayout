package com.example.youthhub.resModel.profile.attachcv.upload;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("file_name")
	private String fileName;

	public void setFileName(String fileName){
		this.fileName = fileName;
	}

	public String getFileName(){
		return fileName;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"file_name = '" + fileName + '\'' + 
			"}";
		}
}