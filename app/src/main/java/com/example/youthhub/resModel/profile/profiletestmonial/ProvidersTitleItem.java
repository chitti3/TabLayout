package com.example.youthhub.resModel.profile.profiletestmonial;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ProvidersTitleItem implements Parcelable {

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			name;
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.name);
		dest.writeString(this.id);
	}

	public ProvidersTitleItem() {
	}

	protected ProvidersTitleItem(Parcel in) {
		this.name = in.readString();
		this.id = in.readString();
	}

	public static final Parcelable.Creator<ProvidersTitleItem> CREATOR = new Parcelable.Creator<ProvidersTitleItem>() {
		@Override
		public ProvidersTitleItem createFromParcel(Parcel source) {
			return new ProvidersTitleItem(source);
		}

		@Override
		public ProvidersTitleItem[] newArray(int size) {
			return new ProvidersTitleItem[size];
		}
	};
}