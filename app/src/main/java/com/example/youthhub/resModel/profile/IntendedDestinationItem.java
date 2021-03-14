package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class IntendedDestinationItem implements Parcelable {

	@SerializedName("sm_status_id")
	private String smStatusId;

	@SerializedName("sm_name")
	private String smName;

	public void setSmStatusId(String smStatusId){
		this.smStatusId = smStatusId;
	}

	public String getSmStatusId(){
		return smStatusId;
	}

	public void setSmName(String smName){
		this.smName = smName;
	}

	public String getSmName(){
		return smName;
	}

	@Override
 	public String toString(){
		return 
			smName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.smStatusId);
		dest.writeString(this.smName);
	}

	public IntendedDestinationItem() {
	}

	protected IntendedDestinationItem(Parcel in) {
		this.smStatusId = in.readString();
		this.smName = in.readString();
	}

	public static final Parcelable.Creator<IntendedDestinationItem> CREATOR = new Parcelable.Creator<IntendedDestinationItem>() {
		@Override
		public IntendedDestinationItem createFromParcel(Parcel source) {
			return new IntendedDestinationItem(source);
		}

		@Override
		public IntendedDestinationItem[] newArray(int size) {
			return new IntendedDestinationItem[size];
		}
	};
}