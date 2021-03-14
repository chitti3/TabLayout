package com.example.youthhub.resModel.connection.shared;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class SharedProfileResponse{

	@SerializedName("share_status")
	private int shareStatus;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setShareStatus(int shareStatus){
		this.shareStatus = shareStatus;
	}

	public int getShareStatus(){
		return shareStatus;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
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
			"SharedProfileResponse{" + 
			"share_status = '" + shareStatus + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}