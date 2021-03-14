package com.example.youthhub.resModel.profile.interest;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class InterestsItem{

	@SerializedName("inu_name")
	private String inuName;

	@SerializedName("inu_interest_id")
	private String inuInterestId;

	public void setInuName(String inuName){
		this.inuName = inuName;
	}

	public String getInuName(){
		return inuName;
	}

	public void setInuInterestId(String inuInterestId){
		this.inuInterestId = inuInterestId;
	}

	public String getInuInterestId(){
		return inuInterestId;
	}

	@Override
 	public String toString(){
		return 
			"InterestsItem{" + 
			"inu_name = '" + inuName + '\'' + 
			",inu_interest_id = '" + inuInterestId + '\'' + 
			"}";
		}
}