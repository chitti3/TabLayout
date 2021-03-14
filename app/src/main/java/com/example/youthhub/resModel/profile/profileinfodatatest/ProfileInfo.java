package com.example.youthhub.resModel.profile.profileinfodatatest;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ProfileInfo{

	@SerializedName("city_name")
	private String cityName;

	@SerializedName("yth_gender_name")
	private String ythGenderName;

	@SerializedName("region_name")
	private String regionName;

	@SerializedName("intended_destination_name")
	private String intendedDestinationName;

	public void setCityName(String cityName){
		this.cityName = cityName;
	}

	public String getCityName(){
		return cityName;
	}

	public void setYthGenderName(String ythGenderName){
		this.ythGenderName = ythGenderName;
	}

	public String getYthGenderName(){
		return ythGenderName;
	}

	public void setRegionName(String regionName){
		this.regionName = regionName;
	}

	public String getRegionName(){
		return regionName;
	}

	public void setIntendedDestinationName(String intendedDestinationName){
		this.intendedDestinationName = intendedDestinationName;
	}

	public String getIntendedDestinationName(){
		return intendedDestinationName;
	}

	@Override
 	public String toString(){
		return 
			"ProfileInfo{" + 
			"city_name = '" + cityName + '\'' + 
			",yth_gender_name = '" + ythGenderName + '\'' + 
			",region_name = '" + regionName + '\'' + 
			",intended_destination_name = '" + intendedDestinationName + '\'' + 
			"}";
		}
}