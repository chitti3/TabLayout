package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class CityListItem implements Parcelable {

	@SerializedName("ci_name")
	private String ciName;

	@SerializedName("ci_city_id")
	private String ciCityId;

	public void setCiName(String ciName){
		this.ciName = ciName;
	}

	public String getCiName(){
		return ciName;
	}

	public void setCiCityId(String ciCityId){
		this.ciCityId = ciCityId;
	}

	public String getCiCityId(){
		return ciCityId;
	}

	@Override
 	public String toString(){
		return 
			ciName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.ciName);
		dest.writeString(this.ciCityId);
	}

	public CityListItem() {
	}

	protected CityListItem(Parcel in) {
		this.ciName = in.readString();
		this.ciCityId = in.readString();
	}

	public static final Parcelable.Creator<CityListItem> CREATOR = new Parcelable.Creator<CityListItem>() {
		@Override
		public CityListItem createFromParcel(Parcel source) {
			return new CityListItem(source);
		}

		@Override
		public CityListItem[] newArray(int size) {
			return new CityListItem[size];
		}
	};
}