package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class EmuResponsibilitiesItem implements Parcelable {

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.name);
	}

	public EmuResponsibilitiesItem() {
	}

	protected EmuResponsibilitiesItem(Parcel in) {
		this.name = in.readString();
	}

	public static final Parcelable.Creator<EmuResponsibilitiesItem> CREATOR = new Parcelable.Creator<EmuResponsibilitiesItem>() {
		@Override
		public EmuResponsibilitiesItem createFromParcel(Parcel source) {
			return new EmuResponsibilitiesItem(source);
		}

		@Override
		public EmuResponsibilitiesItem[] newArray(int size) {
			return new EmuResponsibilitiesItem[size];
		}
	};
}