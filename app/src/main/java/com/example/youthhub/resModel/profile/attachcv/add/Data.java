package com.example.youthhub.resModel.profile.attachcv.add;

import javax.annotation.Generated;

import com.example.youthhub.resModel.profile.profileinfo.UserCvItem;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("user_cv")
	private UserCvItem userCv;

	public void setUserCv(UserCvItem userCv){
		this.userCv = userCv;
	}

	public UserCvItem getUserCv(){
		return userCv;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"user_cv = '" + userCv + '\'' + 
			"}";
		}
}