package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class LanguageItem implements Parcelable {

	@SerializedName("lau_sequence_id")
	private String lauSequenceId;

	@SerializedName("lau_lam_language_id")
	private String lauLamLanguageId;

	@SerializedName("lam_name")
	private String lamName;

	public void setLauSequenceId(String lauSequenceId){
		this.lauSequenceId = lauSequenceId;
	}

	public String getLauSequenceId(){
		return lauSequenceId;
	}

	public void setLauLamLanguageId(String lauLamLanguageId){
		this.lauLamLanguageId = lauLamLanguageId;
	}

	public String getLauLamLanguageId(){
		return lauLamLanguageId;
	}

	public void setLamName(String lamName){
		this.lamName = lamName;
	}

	public String getLamName(){
		return lamName;
	}

	@Override
 	public String toString(){
		return 
			"LanguageItem{" + 
			"lau_sequence_id = '" + lauSequenceId + '\'' + 
			",lau_lam_language_id = '" + lauLamLanguageId + '\'' + 
			",lam_name = '" + lamName + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.lauSequenceId);
		dest.writeString(this.lauLamLanguageId);
		dest.writeString(this.lamName);
	}

	public LanguageItem() {
	}

	protected LanguageItem(Parcel in) {
		this.lauSequenceId = in.readString();
		this.lauLamLanguageId = in.readString();
		this.lamName = in.readString();
	}

	public static final Parcelable.Creator<LanguageItem> CREATOR = new Parcelable.Creator<LanguageItem>() {
		@Override
		public LanguageItem createFromParcel(Parcel source) {
			return new LanguageItem(source);
		}

		@Override
		public LanguageItem[] newArray(int size) {
			return new LanguageItem[size];
		}
	};
}