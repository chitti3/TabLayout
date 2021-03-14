package com.example.youthhub.resModel.connection.followunfollow;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class FollowUnfollowResponse implements Parcelable {

	@SerializedName("data")
	private Data data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"FollowUnfollowResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(this.data, flags);
		dest.writeString(this.message);
		dest.writeInt(this.status);
	}

	public FollowUnfollowResponse() {
	}

	protected FollowUnfollowResponse(Parcel in) {
		this.data = in.readParcelable(Data.class.getClassLoader());
		this.message = in.readString();
		this.status = in.readInt();
	}

	public static final Parcelable.Creator<FollowUnfollowResponse> CREATOR = new Parcelable.Creator<FollowUnfollowResponse>() {
		@Override
		public FollowUnfollowResponse createFromParcel(Parcel source) {
			return new FollowUnfollowResponse(source);
		}

		@Override
		public FollowUnfollowResponse[] newArray(int size) {
			return new FollowUnfollowResponse[size];
		}
	};
}