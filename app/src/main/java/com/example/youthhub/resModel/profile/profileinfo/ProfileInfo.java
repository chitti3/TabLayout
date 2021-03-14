package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;

import com.example.youthhub.retrofit.ResponseWrapper;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ProfileInfo extends ResponseWrapper implements Parcelable {

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.cityName);
		dest.writeString(this.ythGenderName);
		dest.writeString(this.regionName);
		dest.writeString(this.intendedDestinationName);
	}

	public ProfileInfo() {
	}

	protected ProfileInfo(Parcel in) {
		this.cityName = in.readString();
		this.ythGenderName = in.readString();
		this.regionName = in.readString();
		this.intendedDestinationName = in.readString();
	}

	public static final Parcelable.Creator<ProfileInfo> CREATOR = new Parcelable.Creator<ProfileInfo>() {
		@Override
		public ProfileInfo createFromParcel(Parcel source) {
			return new ProfileInfo(source);
		}

		@Override
		public ProfileInfo[] newArray(int size) {
			return new ProfileInfo[size];
		}
	};
}