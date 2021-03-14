package com.example.youthhub.resModel.profile.profilemaster;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class LanguageResponse implements Parcelable {

	@SerializedName("lam_language_id")
	private String lamLanguageId;

	@SerializedName("lam_name")
	private String lamName;

	public void setLamLanguageId(String lamLanguageId){
		this.lamLanguageId = lamLanguageId;
	}

	public String getLamLanguageId(){
		return lamLanguageId;
	}

	public void setLamName(String lamName){
		this.lamName = lamName;
	}

	public String getLamName(){
		return lamName;
	}

	@Override
 	public String toString(){
		return
				lamName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.lamLanguageId);
		dest.writeString(this.lamName);
	}

	public LanguageResponse() {
	}

	protected LanguageResponse(Parcel in) {
		this.lamLanguageId = in.readString();
		this.lamName = in.readString();
	}

	public static final Parcelable.Creator<LanguageResponse> CREATOR = new Parcelable.Creator<LanguageResponse>() {
		@Override
		public LanguageResponse createFromParcel(Parcel source) {
			return new LanguageResponse(source);
		}

		@Override
		public LanguageResponse[] newArray(int size) {
			return new LanguageResponse[size];
		}
	};
}