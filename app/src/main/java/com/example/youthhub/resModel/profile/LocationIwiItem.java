package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class LocationIwiItem implements Parcelable {

	@SerializedName("iw_name")
	private String iwName;

	@SerializedName("iw_iwi_id")
	private String iwIwiId;

	public void setIwName(String iwName){
		this.iwName = iwName;
	}

	public String getIwName(){
		return iwName;
	}

	public void setIwIwiId(String iwIwiId){
		this.iwIwiId = iwIwiId;
	}

	public String getIwIwiId(){
		return iwIwiId;
	}

	@Override
 	public String toString(){
		return 
			iwName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.iwName);
		dest.writeString(this.iwIwiId);
	}

	public LocationIwiItem() {
	}

	protected LocationIwiItem(Parcel in) {
		this.iwName = in.readString();
		this.iwIwiId = in.readString();
	}

	public static final Parcelable.Creator<LocationIwiItem> CREATOR = new Parcelable.Creator<LocationIwiItem>() {
		@Override
		public LocationIwiItem createFromParcel(Parcel source) {
			return new LocationIwiItem(source);
		}

		@Override
		public LocationIwiItem[] newArray(int size) {
			return new LocationIwiItem[size];
		}
	};
}