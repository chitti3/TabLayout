package com.example.youthhub.resModel.profile.visualjourney.journeyprofileupload;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class JourneyProfileUploadResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("gallery_code")
	private int galleryCode;

	@SerializedName("count")
	private int count;

	@SerializedName("status")
	private int status;

	@SerializedName("message")
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setGalleryCode(int galleryCode){
		this.galleryCode = galleryCode;
	}

	public int getGalleryCode(){
		return galleryCode;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"JourneyProfileUploadResponse{" + 
			"data = '" + data + '\'' + 
			",gallery_code = '" + galleryCode + '\'' + 
			",count = '" + count + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}