package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class InterestsItem implements Parcelable {

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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.inuName);
		dest.writeString(this.inuInterestId);
	}

	public InterestsItem() {
	}

	protected InterestsItem(Parcel in) {
		this.inuName = in.readString();
		this.inuInterestId = in.readString();
	}

	public static final Parcelable.Creator<InterestsItem> CREATOR = new Parcelable.Creator<InterestsItem>() {
		@Override
		public InterestsItem createFromParcel(Parcel source) {
			return new InterestsItem(source);
		}

		@Override
		public InterestsItem[] newArray(int size) {
			return new InterestsItem[size];
		}
	};
}