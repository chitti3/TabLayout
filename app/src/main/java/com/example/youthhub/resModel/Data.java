package com.example.youthhub.resModel;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("point_score_msg")
	private String pointScoreMsg;

	public void setPointScoreMsg(String pointScoreMsg){
		this.pointScoreMsg = pointScoreMsg;
	}

	public String getPointScoreMsg(){
		return pointScoreMsg;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"point_score_msg = '" + pointScoreMsg + '\'' + 
			"}";
		}
}