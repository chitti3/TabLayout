package com.example.youthhub.resModel.profile.profilemaster;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class WishlistItem implements Parcelable {

	@SerializedName("wit_name")
	private String witName;

	@SerializedName("wit_tag_id")
	private String witTagId;

	public void setWitName(String witName){
		this.witName = witName;
	}

	public String getWitName(){
		return witName;
	}

	public void setWitTagId(String witTagId){
		this.witTagId = witTagId;
	}

	public String getWitTagId(){
		return witTagId;
	}

	@Override
 	public String toString(){
		return 
			witName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.witName);
		dest.writeString(this.witTagId);
	}

	public WishlistItem() {
	}

	protected WishlistItem(Parcel in) {
		this.witName = in.readString();
		this.witTagId = in.readString();
	}

	public static final Parcelable.Creator<WishlistItem> CREATOR = new Parcelable.Creator<WishlistItem>() {
		@Override
		public WishlistItem createFromParcel(Parcel source) {
			return new WishlistItem(source);
		}

		@Override
		public WishlistItem[] newArray(int size) {
			return new WishlistItem[size];
		}
	};
}