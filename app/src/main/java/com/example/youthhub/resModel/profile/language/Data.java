package com.example.youthhub.resModel.profile.language;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("language")
	private List<com.example.youthhub.resModel.profile.profileinfo.LanguageItem> language;

	public void setLanguage(List<com.example.youthhub.resModel.profile.profileinfo.LanguageItem> language){
		this.language = language;
	}

	public List<com.example.youthhub.resModel.profile.profileinfo.LanguageItem> getLanguage(){
		return language;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"language = '" + language + '\'' + 
			"}";
		}
}