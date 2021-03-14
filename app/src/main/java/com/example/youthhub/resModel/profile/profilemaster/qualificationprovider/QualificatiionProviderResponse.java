package com.example.youthhub.resModel.profile.profilemaster.qualificationprovider;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class QualificatiionProviderResponse implements Parcelable {

	@SerializedName("data")
	private Data data;

	@SerializedName("data_count")
	private int dataCount;

	@SerializedName("status")
	private int status;

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
			"QualificatiionProviderResponse{" + 
			"data = '" + data + '\'' + 
			",data_count = '" + dataCount + '\'' + 
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
		dest.writeInt(this.dataCount);
		dest.writeInt(this.status);
	}

	public QualificatiionProviderResponse() {
	}

	protected QualificatiionProviderResponse(Parcel in) {
		this.data = in.readParcelable(Data.class.getClassLoader());
		this.dataCount = in.readInt();
		this.status = in.readInt();
	}

	public static final Parcelable.Creator<QualificatiionProviderResponse> CREATOR = new Parcelable.Creator<QualificatiionProviderResponse>() {
		@Override
		public QualificatiionProviderResponse createFromParcel(Parcel source) {
			return new QualificatiionProviderResponse(source);
		}

		@Override
		public QualificatiionProviderResponse[] newArray(int size) {
			return new QualificatiionProviderResponse[size];
		}
	};
}