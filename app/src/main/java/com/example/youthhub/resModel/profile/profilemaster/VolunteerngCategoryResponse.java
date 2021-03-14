package com.example.youthhub.resModel.profile.profilemaster;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class VolunteerngCategoryResponse implements Parcelable {

	@SerializedName("voc_category_id")
	private String vocCategoryId;

	@SerializedName("voc_name")
	private String vocName;

	public void setVocCategoryId(String vocCategoryId){
		this.vocCategoryId = vocCategoryId;
	}

	public String getVocCategoryId(){
		return vocCategoryId;
	}

	public void setVocName(String vocName){
		this.vocName = vocName;
	}

	public String getVocName(){
		return vocName;
	}

	@Override
 	public String toString(){
		return
				vocName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.vocCategoryId);
		dest.writeString(this.vocName);
	}

	public VolunteerngCategoryResponse() {
	}

	protected VolunteerngCategoryResponse(Parcel in) {
		this.vocCategoryId = in.readString();
		this.vocName = in.readString();
	}

	public static final Parcelable.Creator<VolunteerngCategoryResponse> CREATOR = new Parcelable.Creator<VolunteerngCategoryResponse>() {
		@Override
		public VolunteerngCategoryResponse createFromParcel(Parcel source) {
			return new VolunteerngCategoryResponse(source);
		}

		@Override
		public VolunteerngCategoryResponse[] newArray(int size) {
			return new VolunteerngCategoryResponse[size];
		}
	};
}