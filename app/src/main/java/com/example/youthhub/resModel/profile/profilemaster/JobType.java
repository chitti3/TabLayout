package com.example.youthhub.resModel.profile.profilemaster;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class JobType implements Parcelable {

	@SerializedName("jt_name")
	private String jtName;

	@SerializedName("jt_type_id")
	private String jtTypeId;

	public void setJtName(String jtName){
		this.jtName = jtName;
	}

	public String getJtName(){
		return jtName;
	}

	public void setJtTypeId(String jtTypeId){
		this.jtTypeId = jtTypeId;
	}

	public String getJtTypeId(){
		return jtTypeId;
	}

	@Override
 	public String toString(){
		return 
			jtName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.jtName);
		dest.writeString(this.jtTypeId);
	}

	public JobType() {
	}

	protected JobType(Parcel in) {
		this.jtName = in.readString();
		this.jtTypeId = in.readString();
	}

	public static final Parcelable.Creator<JobType> CREATOR = new Parcelable.Creator<JobType>() {
		@Override
		public JobType createFromParcel(Parcel source) {
			return new JobType(source);
		}

		@Override
		public JobType[] newArray(int size) {
			return new JobType[size];
		}
	};
}