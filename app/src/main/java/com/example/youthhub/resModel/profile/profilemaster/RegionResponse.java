package com.example.youthhub.resModel.profile.profilemaster;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class RegionResponse implements Parcelable {

	@SerializedName("re_name")
	private String reName;

	@SerializedName("re_region_id")
	private String reRegionId;

	public void setReName(String reName){
		this.reName = reName;
	}

	public String getReName(){
		return reName;
	}

	public void setReRegionId(String reRegionId){
		this.reRegionId = reRegionId;
	}

	public String getReRegionId(){
		return reRegionId;
	}

	@Override
 	public String toString(){
		return
				reName;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.reName);
		dest.writeString(this.reRegionId);
	}

	public RegionResponse() {
	}

	protected RegionResponse(Parcel in) {
		this.reName = in.readString();
		this.reRegionId = in.readString();
	}

	public static final Parcelable.Creator<RegionResponse> CREATOR = new Parcelable.Creator<RegionResponse>() {
		@Override
		public RegionResponse createFromParcel(Parcel source) {
			return new RegionResponse(source);
		}

		@Override
		public RegionResponse[] newArray(int size) {
			return new RegionResponse[size];
		}
	};
}