package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ResidencyStatusMasterItem implements Parcelable {

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			name;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.name);
		dest.writeString(this.id);
	}

	public ResidencyStatusMasterItem() {
	}

	protected ResidencyStatusMasterItem(Parcel in) {
		this.name = in.readString();
		this.id = in.readString();
	}

	public static final Parcelable.Creator<ResidencyStatusMasterItem> CREATOR = new Parcelable.Creator<ResidencyStatusMasterItem>() {
		@Override
		public ResidencyStatusMasterItem createFromParcel(Parcel source) {
			return new ResidencyStatusMasterItem(source);
		}

		@Override
		public ResidencyStatusMasterItem[] newArray(int size) {
			return new ResidencyStatusMasterItem[size];
		}
	};
}