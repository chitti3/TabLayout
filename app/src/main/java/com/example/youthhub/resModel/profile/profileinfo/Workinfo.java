package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Workinfo implements Parcelable {

	@SerializedName("licence_type")
	private String licenceType;

	@SerializedName("work_availability")
	private String workAvailability;

	@SerializedName("workinfo_tooltip")
	private String workinfoTooltip;

	@SerializedName("work_availability_hour")
	private String workAvailabilityHour;

	@SerializedName("work_experience")
	private double workExperience;

	public void setLicenceType(String licenceType){
		this.licenceType = licenceType;
	}

	public String getLicenceType(){
		return licenceType;
	}

	public void setWorkAvailability(String workAvailability){
		this.workAvailability = workAvailability;
	}

	public String getWorkAvailability(){
		return workAvailability;
	}

	public void setWorkinfoTooltip(String workinfoTooltip){
		this.workinfoTooltip = workinfoTooltip;
	}

	public String getWorkinfoTooltip(){
		return workinfoTooltip;
	}

	public void setWorkAvailabilityHour(String workAvailabilityHour){
		this.workAvailabilityHour = workAvailabilityHour;
	}

	public String getWorkAvailabilityHour(){
		return workAvailabilityHour;
	}

	public void setWorkExperience(double workExperience){
		this.workExperience = workExperience;
	}

	public double getWorkExperience(){
		return workExperience;
	}

	@Override
 	public String toString(){
		return 
			"Workinfo{" + 
			"licence_type = '" + licenceType + '\'' + 
			",work_availability = '" + workAvailability + '\'' + 
			",workinfo_tooltip = '" + workinfoTooltip + '\'' + 
			",work_availability_hour = '" + workAvailabilityHour + '\'' + 
			",work_experience = '" + workExperience + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.licenceType);
		dest.writeString(this.workAvailability);
		dest.writeString(this.workinfoTooltip);
		dest.writeString(this.workAvailabilityHour);
		dest.writeDouble(this.workExperience);
	}

	public Workinfo() {
	}

	protected Workinfo(Parcel in) {
		this.licenceType = in.readString();
		this.workAvailability = in.readString();
		this.workinfoTooltip = in.readString();
		this.workAvailabilityHour = in.readString();
		this.workExperience = in.readDouble();
	}

	public static final Parcelable.Creator<Workinfo> CREATOR = new Parcelable.Creator<Workinfo>() {
		@Override
		public Workinfo createFromParcel(Parcel source) {
			return new Workinfo(source);
		}

		@Override
		public Workinfo[] newArray(int size) {
			return new Workinfo[size];
		}
	};
}