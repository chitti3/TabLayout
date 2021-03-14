package com.example.youthhub.resModel.profile.visualjourney.journeyprofileupload;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("path_medium")
	private String pathMedium;

	@SerializedName("filename")
	private String filename;

	@SerializedName("filenameuploadfield")
	private String filenameuploadfield;

	@SerializedName("path_thumb")
	private String pathThumb;

	public void setPathMedium(String pathMedium){
		this.pathMedium = pathMedium;
	}

	public String getPathMedium(){
		return pathMedium;
	}

	public void setFilename(String filename){
		this.filename = filename;
	}

	public String getFilename(){
		return filename;
	}

	public void setFilenameuploadfield(String filenameuploadfield){
		this.filenameuploadfield = filenameuploadfield;
	}

	public String getFilenameuploadfield(){
		return filenameuploadfield;
	}

	public void setPathThumb(String pathThumb){
		this.pathThumb = pathThumb;
	}

	public String getPathThumb(){
		return pathThumb;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"path_medium = '" + pathMedium + '\'' + 
			",filename = '" + filename + '\'' + 
			",filenameuploadfield = '" + filenameuploadfield + '\'' + 
			",path_thumb = '" + pathThumb + '\'' + 
			"}";
		}
}