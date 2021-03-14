package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class LicenceTypeItem implements Parcelable {

	@SerializedName("lt_name")
	private String ltName;

	@SerializedName("lt_type_id")
	private String ltTypeId;

	public void setLtName(String ltName){
		this.ltName = ltName;
	}

	public String getLtName(){
		return ltName;
	}

	public void setLtTypeId(String ltTypeId){
		this.ltTypeId = ltTypeId;
	}

	public String getLtTypeId(){
		return ltTypeId;
	}

	@Override
 	public String toString(){
		return 
			ltName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.ltName);
		dest.writeString(this.ltTypeId);
	}

	public LicenceTypeItem() {
	}

	protected LicenceTypeItem(Parcel in) {
		this.ltName = in.readString();
		this.ltTypeId = in.readString();
	}

	public static final Parcelable.Creator<LicenceTypeItem> CREATOR = new Parcelable.Creator<LicenceTypeItem>() {
		@Override
		public LicenceTypeItem createFromParcel(Parcel source) {
			return new LicenceTypeItem(source);
		}

		@Override
		public LicenceTypeItem[] newArray(int size) {
			return new LicenceTypeItem[size];
		}
	};
}