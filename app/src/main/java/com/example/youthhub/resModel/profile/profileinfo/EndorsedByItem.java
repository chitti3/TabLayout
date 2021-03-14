package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class EndorsedByItem implements Parcelable {

	@SerializedName("code")
	private String code;

	@SerializedName("name")
	private String name;

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"EndorsedByItem{" + 
			"code = '" + code + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.code);
		dest.writeString(this.name);
	}

	public EndorsedByItem() {
	}

	protected EndorsedByItem(Parcel in) {
		this.code = in.readString();
		this.name = in.readString();
	}

	public static final Parcelable.Creator<EndorsedByItem> CREATOR = new Parcelable.Creator<EndorsedByItem>() {
		@Override
		public EndorsedByItem createFromParcel(Parcel source) {
			return new EndorsedByItem(source);
		}

		@Override
		public EndorsedByItem[] newArray(int size) {
			return new EndorsedByItem[size];
		}
	};
}