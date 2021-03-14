package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class TechnicalSkillsItem implements Parcelable {

	@SerializedName("sku_level")
	private String skuLevel;

	@SerializedName("sku_sequence_id")
	private String skuSequenceId;

	@SerializedName("sku_name")
	private String skuName;

	public void setSkuLevel(String skuLevel){
		this.skuLevel = skuLevel;
	}

	public String getSkuLevel(){
		return skuLevel;
	}

	public void setSkuSequenceId(String skuSequenceId){
		this.skuSequenceId = skuSequenceId;
	}

	public String getSkuSequenceId(){
		return skuSequenceId;
	}

	public void setSkuName(String skuName){
		this.skuName = skuName;
	}

	public String getSkuName(){
		return skuName;
	}

	@Override
 	public String toString(){
		return 
			"TechnicalSkillsItem{" + 
			"sku_level = '" + skuLevel + '\'' + 
			",sku_sequence_id = '" + skuSequenceId + '\'' + 
			",sku_name = '" + skuName + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.skuLevel);
		dest.writeString(this.skuSequenceId);
		dest.writeString(this.skuName);
	}

	public TechnicalSkillsItem() {
	}

	protected TechnicalSkillsItem(Parcel in) {
		this.skuLevel = in.readString();
		this.skuSequenceId = in.readString();
		this.skuName = in.readString();
	}

	public static final Parcelable.Creator<TechnicalSkillsItem> CREATOR = new Parcelable.Creator<TechnicalSkillsItem>() {
		@Override
		public TechnicalSkillsItem createFromParcel(Parcel source) {
			return new TechnicalSkillsItem(source);
		}

		@Override
		public TechnicalSkillsItem[] newArray(int size) {
			return new TechnicalSkillsItem[size];
		}
	};
}