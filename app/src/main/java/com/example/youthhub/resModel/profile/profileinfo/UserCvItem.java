package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class UserCvItem implements Parcelable {

	@SerializedName("ucv_cv_id")
	private String ucvCvId;

	@SerializedName("ucv_created_on")
	private String ucvCreatedOn;

	@SerializedName("ucv_title")
	private String ucvTitle;

	@SerializedName("ucv_type_name")
	private String ucvTypeName;

	@SerializedName("ucv_type")
	private String ucvType;

	@SerializedName("ucv_file_name")
	private String ucvFileName;

	public void setUcvCvId(String ucvCvId){
		this.ucvCvId = ucvCvId;
	}

	public String getUcvCvId(){
		return ucvCvId;
	}

	public void setUcvCreatedOn(String ucvCreatedOn){
		this.ucvCreatedOn = ucvCreatedOn;
	}

	public String getUcvCreatedOn(){
		return ucvCreatedOn;
	}

	public void setUcvTitle(String ucvTitle){
		this.ucvTitle = ucvTitle;
	}

	public String getUcvTitle(){
		return ucvTitle;
	}

	public void setUcvTypeName(String ucvTypeName){
		this.ucvTypeName = ucvTypeName;
	}

	public String getUcvTypeName(){
		return ucvTypeName;
	}

	public void setUcvType(String ucvType){
		this.ucvType = ucvType;
	}

	public String getUcvType(){
		return ucvType;
	}

	public void setUcvFileName(String ucvFileName){
		this.ucvFileName = ucvFileName;
	}

	public String getUcvFileName(){
		return ucvFileName;
	}

	@Override
 	public String toString(){
		return 
			"UserCvItem{" + 
			"ucv_cv_id = '" + ucvCvId + '\'' + 
			",ucv_created_on = '" + ucvCreatedOn + '\'' + 
			",ucv_title = '" + ucvTitle + '\'' + 
			",ucv_type_name = '" + ucvTypeName + '\'' + 
			",ucv_type = '" + ucvType + '\'' + 
			",ucv_file_name = '" + ucvFileName + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.ucvCvId);
		dest.writeString(this.ucvCreatedOn);
		dest.writeString(this.ucvTitle);
		dest.writeString(this.ucvTypeName);
		dest.writeString(this.ucvType);
		dest.writeString(this.ucvFileName);
	}

	public UserCvItem() {
	}

	protected UserCvItem(Parcel in) {
		this.ucvCvId = in.readString();
		this.ucvCreatedOn = in.readString();
		this.ucvTitle = in.readString();
		this.ucvTypeName = in.readString();
		this.ucvType = in.readString();
		this.ucvFileName = in.readString();
	}

	public static final Parcelable.Creator<UserCvItem> CREATOR = new Parcelable.Creator<UserCvItem>() {
		@Override
		public UserCvItem createFromParcel(Parcel source) {
			return new UserCvItem(source);
		}

		@Override
		public UserCvItem[] newArray(int size) {
			return new UserCvItem[size];
		}
	};
}