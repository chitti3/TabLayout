package com.example.youthhub.resModel.profile.profilemaster.titlequalification;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class TitleQualificationResponse{

	@SerializedName("data")
	private Data data;

	@SerializedName("data_count")
	private int dataCount;

	@SerializedName("status")
	private int status;

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

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"TitleQualificationResponse{" + 
			"data = '" + data + '\'' + 
			",data_count = '" + dataCount + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}