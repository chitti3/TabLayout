package com.example.youthhub.resModel.profile.profiletestmonial;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data implements Parcelable {

	@SerializedName("providers_title")
	private List<ProvidersTitleItem> providersTitle;

	public void setProvidersTitle(List<ProvidersTitleItem> providersTitle){
		this.providersTitle = providersTitle;
	}

	public List<ProvidersTitleItem> getProvidersTitle(){
		return providersTitle;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"providers_title = '" + providersTitle + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeList(this.providersTitle);
	}

	public Data() {
	}

	protected Data(Parcel in) {
		this.providersTitle = new ArrayList<ProvidersTitleItem>();
		in.readList(this.providersTitle, ProvidersTitleItem.class.getClassLoader());
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