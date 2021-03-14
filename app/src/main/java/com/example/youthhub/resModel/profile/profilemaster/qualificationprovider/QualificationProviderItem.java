package com.example.youthhub.resModel.profile.profilemaster.qualificationprovider;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class QualificationProviderItem implements Parcelable {

	@SerializedName("qap_name")
	private String qapName;

	@SerializedName("qap_provider_id")
	private String qapProviderId;

	public void setQapName(String qapName){
		this.qapName = qapName;
	}

	public String getQapName(){
		return qapName;
	}

	public void setQapProviderId(String qapProviderId){
		this.qapProviderId = qapProviderId;
	}

	public String getQapProviderId(){
		return qapProviderId;
	}

	@Override
 	public String toString(){
		return 
			qapName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.qapName);
		dest.writeString(this.qapProviderId);
	}

	public QualificationProviderItem() {
	}

	protected QualificationProviderItem(Parcel in) {
		this.qapName = in.readString();
		this.qapProviderId = in.readString();
	}

	public static final Parcelable.Creator<QualificationProviderItem> CREATOR = new Parcelable.Creator<QualificationProviderItem>() {
		@Override
		public QualificationProviderItem createFromParcel(Parcel source) {
			return new QualificationProviderItem(source);
		}

		@Override
		public QualificationProviderItem[] newArray(int size) {
			return new QualificationProviderItem[size];
		}
	};
}