package com.example.youthhub.resModel.profile.profilemaster;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class OrganizationCategoryResponse implements Parcelable {

	@SerializedName("ogc_category_id")
	private String ogcCategoryId;

	@SerializedName("ogc_name")
	private String ogcName;

	public void setOgcCategoryId(String ogcCategoryId){
		this.ogcCategoryId = ogcCategoryId;
	}

	public String getOgcCategoryId(){
		return ogcCategoryId;
	}

	public void setOgcName(String ogcName){
		this.ogcName = ogcName;
	}

	public String getOgcName(){
		return ogcName;
	}

	@Override
 	public String toString(){
		return
				ogcName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.ogcCategoryId);
		dest.writeString(this.ogcName);
	}

	public OrganizationCategoryResponse() {
	}

	protected OrganizationCategoryResponse(Parcel in) {
		this.ogcCategoryId = in.readString();
		this.ogcName = in.readString();
	}

	public static final Parcelable.Creator<OrganizationCategoryResponse> CREATOR = new Parcelable.Creator<OrganizationCategoryResponse>() {
		@Override
		public OrganizationCategoryResponse createFromParcel(Parcel source) {
			return new OrganizationCategoryResponse(source);
		}

		@Override
		public OrganizationCategoryResponse[] newArray(int size) {
			return new OrganizationCategoryResponse[size];
		}
	};
}