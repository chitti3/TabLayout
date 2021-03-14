package com.example.youthhub.resModel.profile.profilemaster;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class BusinessCategory implements Parcelable {

	@SerializedName("ica_category_id")
	private String icaCategoryId;

	@SerializedName("ica_name")
	private String icaName;

	public void setIcaCategoryId(String icaCategoryId){
		this.icaCategoryId = icaCategoryId;
	}

	public String getIcaCategoryId(){
		return icaCategoryId;
	}

	public void setIcaName(String icaName){
		this.icaName = icaName;
	}

	public String getIcaName(){
		return icaName;
	}

	@Override
 	public String toString(){
		return 
			icaName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.icaCategoryId);
		dest.writeString(this.icaName);
	}

	public BusinessCategory() {
	}

	protected BusinessCategory(Parcel in) {
		this.icaCategoryId = in.readString();
		this.icaName = in.readString();
	}

	public static final Parcelable.Creator<BusinessCategory> CREATOR = new Parcelable.Creator<BusinessCategory>() {
		@Override
		public BusinessCategory createFromParcel(Parcel source) {
			return new BusinessCategory(source);
		}

		@Override
		public BusinessCategory[] newArray(int size) {
			return new BusinessCategory[size];
		}
	};
}