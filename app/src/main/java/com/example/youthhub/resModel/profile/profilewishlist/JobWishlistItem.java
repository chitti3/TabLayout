package com.example.youthhub.resModel.profile.profilewishlist;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class JobWishlistItem implements Parcelable {

	@SerializedName("wit_name")
	private String witName;

	@SerializedName("wiu_wishlist_id")
	private String wiuWishlistId;

	public void setWitName(String witName){
		this.witName = witName;
	}

	public String getWitName(){
		return witName;
	}

	public void setWiuWishlistId(String wiuWishlistId){
		this.wiuWishlistId = wiuWishlistId;
	}

	public String getWiuWishlistId(){
		return wiuWishlistId;
	}

	@Override
 	public String toString(){
		return 
			"JobWishlistItem{" + 
			"wit_name = '" + witName + '\'' + 
			",wiu_wishlist_id = '" + wiuWishlistId + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.witName);
		dest.writeString(this.wiuWishlistId);
	}

	public JobWishlistItem() {
	}

	protected JobWishlistItem(Parcel in) {
		this.witName = in.readString();
		this.wiuWishlistId = in.readString();
	}

	public static final Parcelable.Creator<JobWishlistItem> CREATOR = new Parcelable.Creator<JobWishlistItem>() {
		@Override
		public JobWishlistItem createFromParcel(Parcel source) {
			return new JobWishlistItem(source);
		}

		@Override
		public JobWishlistItem[] newArray(int size) {
			return new JobWishlistItem[size];
		}
	};
}