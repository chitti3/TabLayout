package com.example.youthhub.resModel.post.likepost;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class LikeResponse implements Parcelable {

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
			"LikeResponse{" +
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

	public LikeResponse() {
	}

	protected LikeResponse(Parcel in) {
		this.data = in.readParcelable(Data.class.getClassLoader());
		this.message = in.readString();
		this.status = in.readInt();
	}

	public static final Parcelable.Creator<LikeResponse> CREATOR = new Parcelable.Creator<LikeResponse>() {
		@Override
		public LikeResponse createFromParcel(Parcel source) {
			return new LikeResponse(source);
		}

		@Override
		public LikeResponse[] newArray(int size) {
			return new LikeResponse[size];
		}
	};
}