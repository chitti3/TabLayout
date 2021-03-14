package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class OrganisationDataItem implements Parcelable {

	@SerializedName("ogm_name")
	private String ogmName;

	@SerializedName("ogm_organisation_id")
	private String ogmOrganisationId;

	public void setOgmName(String ogmName){
		this.ogmName = ogmName;
	}

	public String getOgmName(){
		return ogmName;
	}

	public void setOgmOrganisationId(String ogmOrganisationId){
		this.ogmOrganisationId = ogmOrganisationId;
	}

	public String getOgmOrganisationId(){
		return ogmOrganisationId;
	}

	@Override
 	public String toString(){
		return 
			ogmName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.ogmName);
		dest.writeString(this.ogmOrganisationId);
	}

	public OrganisationDataItem() {
	}

	protected OrganisationDataItem(Parcel in) {
		this.ogmName = in.readString();
		this.ogmOrganisationId = in.readString();
	}

	public static final Parcelable.Creator<OrganisationDataItem> CREATOR = new Parcelable.Creator<OrganisationDataItem>() {
		@Override
		public OrganisationDataItem createFromParcel(Parcel source) {
			return new OrganisationDataItem(source);
		}

		@Override
		public OrganisationDataItem[] newArray(int size) {
			return new OrganisationDataItem[size];
		}
	};
}