package com.example.youthhub.resModel.profile.profileexperience.add.update;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class EmuResponsibilitiesItem{

	@SerializedName("name")
	private String name;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"EmuResponsibilitiesItem{" + 
			"name = '" + name + '\'' + 
			"}";
		}
}