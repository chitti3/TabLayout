package com.example.youthhub.resModel.profile.profilewishlist;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data implements Parcelable {

	@SerializedName("job_wishlist")
	private List<com.example.youthhub.resModel.profile.profileinfo.JobWishlistItem> jobWishlist;

	@SerializedName("add_wishlist_status")
	private boolean addWishlistStatus;

	public void setJobWishlist(List<com.example.youthhub.resModel.profile.profileinfo.JobWishlistItem> jobWishlist){
		this.jobWishlist = jobWishlist;
	}

	public List<com.example.youthhub.resModel.profile.profileinfo.JobWishlistItem> getJobWishlist(){
		return jobWishlist;
	}

	public void setAddWishlistStatus(boolean addWishlistStatus){
		this.addWishlistStatus = addWishlistStatus;
	}

	public boolean isAddWishlistStatus(){
		return addWishlistStatus;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"job_wishlist = '" + jobWishlist + '\'' + 
			",add_wishlist_status = '" + addWishlistStatus + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeList(this.jobWishlist);
		dest.writeByte(this.addWishlistStatus ? (byte) 1 : (byte) 0);
	}

	public Data() {
	}

	protected Data(Parcel in) {
		this.jobWishlist = new ArrayList<com.example.youthhub.resModel.profile.profileinfo.JobWishlistItem>();
		in.readList(this.jobWishlist, JobWishlistItem.class.getClassLoader());
		this.addWishlistStatus = in.readByte() != 0;
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