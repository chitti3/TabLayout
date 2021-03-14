package com.example.youthhub.resModel.profilepostlist;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class PostDashboardListResponse{

	@SerializedName("nextpage")
	private int nextpage;

	@SerializedName("data")
	private Data data;

	@SerializedName("data_count")
	private int dataCount;

	@SerializedName("message")
	private String message;

	@SerializedName("status_img")
	private String status_img;

	@SerializedName("status")
	private int status;


	public String getStatus_img() {
		return status_img;
	}

	public void setStatus_img(String status_img) {
		this.status_img = status_img;
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

	public void setDataCount(int dataCount){
		this.dataCount = dataCount;
	}

	public int getDataCount(){
		return dataCount;
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
			"PostDashboardListResponse{" + 
			"nextpage = '" + nextpage + '\'' + 
			",data = '" + data + '\'' + 
			",data_count = '" + dataCount + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}