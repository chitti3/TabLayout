package com.example.youthhub.resModel.profile.milestone;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ProfileMilestoneListResponse implements Parcelable {

	@SerializedName("nextpage")
	private int nextpage;

	@SerializedName("data")
	private Data data;

	@SerializedName("data_count")
	private int dataCount;

	@SerializedName("status")
	private int status;

	@SerializedName("message")
	private String message;

	@SerializedName("status_img")
	private String status_img;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus_img() {
		return status_img;
	}

	public void setStatus_img(String status_img) {
		this.status_img = status_img;
	}

	public void setNextpage(int nextpage){
		this.nextpage = nextpage;
	}

	public int getNextpage(){
		return nextpage;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setDataCount(int dataCount){
		this.dataCount = dataCount;
	}

	public int getDataCount(){
		return dataCount;
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
			"ProfileMilestoneListResponse{" + 
			"nextpage = '" + nextpage + '\'' + 
			",data = '" + data + '\'' + 
			",data_count = '" + dataCount + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}

	public ProfileMilestoneListResponse() {
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(this.nextpage);
		dest.writeParcelable(this.data, flags);
		dest.writeInt(this.dataCount);
		dest.writeInt(this.status);
		dest.writeString(this.message);
		dest.writeString(this.status_img);
	}

	protected ProfileMilestoneListResponse(Parcel in) {
		this.nextpage = in.readInt();
		this.data = in.readParcelable(Data.class.getClassLoader());
		this.dataCount = in.readInt();
		this.status = in.readInt();
		this.message = in.readString();
		this.status_img = in.readString();
	}

	public static final Creator<ProfileMilestoneListResponse> CREATOR = new Creator<ProfileMilestoneListResponse>() {
		@Override
		public ProfileMilestoneListResponse createFromParcel(Parcel source) {
			return new ProfileMilestoneListResponse(source);
		}

		@Override
		public ProfileMilestoneListResponse[] newArray(int size) {
			return new ProfileMilestoneListResponse[size];
		}
	};
}