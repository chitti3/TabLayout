package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class LocationEthnicityItem implements Parcelable {

	@SerializedName("subethnicity")
	private Subethnicity subethnicity;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public void setSubethnicity(Subethnicity subethnicity){
		this.subethnicity = subethnicity;
	}

	public Subethnicity getSubethnicity(){
		return subethnicity;
	}

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
		dest.writeParcelable(this.subethnicity, flags);
		dest.writeString(this.name);
		dest.writeString(this.id);
	}

	public LocationEthnicityItem() {
	}

	protected LocationEthnicityItem(Parcel in) {
		this.subethnicity = in.readParcelable(Subethnicity.class.getClassLoader());
		this.name = in.readString();
		this.id = in.readString();
	}

	public static final Parcelable.Creator<LocationEthnicityItem> CREATOR = new Parcelable.Creator<LocationEthnicityItem>() {
		@Override
		public LocationEthnicityItem createFromParcel(Parcel source) {
			return new LocationEthnicityItem(source);
		}

		@Override
		public LocationEthnicityItem[] newArray(int size) {
			return new LocationEthnicityItem[size];
		}
	};
}