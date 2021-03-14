package com.example.youthhub.resModel.profile.profilemaster.qualificationprovider;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data implements Parcelable {

	@SerializedName("qualification_provider")
	private List<QualificationProviderItem> qualificationProvider;

	public void setQualificationProvider(List<QualificationProviderItem> qualificationProvider){
		this.qualificationProvider = qualificationProvider;
	}

	public List<QualificationProviderItem> getQualificationProvider(){
		return qualificationProvider;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"qualification_provider = '" + qualificationProvider + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeList(this.qualificationProvider);
	}

	public Data() {
	}

	protected Data(Parcel in) {
		this.qualificationProvider = new ArrayList<QualificationProviderItem>();
		in.readList(this.qualificationProvider, QualificationProviderItem.class.getClassLoader());
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