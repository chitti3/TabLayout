package com.example.youthhub.resModel.profile.follower;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ProfileFollowerResponse{

	@SerializedName("nextpage")
	private int nextpage;

	@SerializedName("data")
	private Data data;

	@SerializedName("status")
	private int status;

	@SerializedName("message")
	private String  message;	@SerializedName("status_img")
	private String  status_img;

	public String getStatus_img() {
		return status_img;
	}

	public void setStatus_img(String status_img) {
		this.status_img = status_img;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setNextpage(int nextpage){
		this.nextpage = nextpage;
	}

	public int getNextpage(){
		return nextpage;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
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
			"ProfileFollowerResponse{" + 
			"nextpage = '" + nextpage + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}