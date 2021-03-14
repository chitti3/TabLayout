package com.example.youthhub.resModel.profile.profilemaster;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class QualificationCategoryResponse implements Parcelable {

	@SerializedName("qac_category_id")
	private String qacCategoryId;

	@SerializedName("qac_name")
	private String qacName;

	public void setQacCategoryId(String qacCategoryId){
		this.qacCategoryId = qacCategoryId;
	}

	public String getQacCategoryId(){
		return qacCategoryId;
	}

	public void setQacName(String qacName){
		this.qacName = qacName;
	}

	public String getQacName(){
		return qacName;
	}

	@Override
 	public String toString(){
		return
				qacName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.qacCategoryId);
		dest.writeString(this.qacName);
	}

	public QualificationCategoryResponse() {
	}

	protected QualificationCategoryResponse(Parcel in) {
		this.qacCategoryId = in.readString();
		this.qacName = in.readString();
	}

	public static final Parcelable.Creator<QualificationCategoryResponse> CREATOR = new Parcelable.Creator<QualificationCategoryResponse>() {
		@Override
		public QualificationCategoryResponse createFromParcel(Parcel source) {
			return new QualificationCategoryResponse(source);
		}

		@Override
		public QualificationCategoryResponse[] newArray(int size) {
			return new QualificationCategoryResponse[size];
		}
	};
}