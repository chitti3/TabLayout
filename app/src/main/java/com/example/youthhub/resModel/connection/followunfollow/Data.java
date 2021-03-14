package com.example.youthhub.resModel.connection.followunfollow;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data implements Parcelable {

	@SerializedName("point_score_msg")
	private String pointScoreMsg;

	public void setPointScoreMsg(String pointScoreMsg){
		this.pointScoreMsg = pointScoreMsg;
	}

	public String getPointScoreMsg(){
		return pointScoreMsg;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"point_score_msg = '" + pointScoreMsg + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.pointScoreMsg);
	}

	public Data() {
	}

	protected Data(Parcel in) {
		this.pointScoreMsg = in.readString();
	}

	public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
		@Override
		public Data createFromParcel(Parcel source) {
			return new Data(source);
		}

		@Override
		public Data[] newArray(int size) {
			return new Data[size];
		}
	};
}