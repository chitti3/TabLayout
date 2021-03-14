package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class AchievementItem implements Parcelable {

	@SerializedName("acu_title")
	private String acuTitle;

	@SerializedName("acu_issued_year")
	private String acuIssuedYear;

	@SerializedName("acu_issued_month")
	private String acuIssuedMonth;

	@SerializedName("acu_achievement_id")
	private String acuAchievementId;

	@SerializedName("acu_occupation")
	private String acuOccupation;

	@SerializedName("acu_description")
	private String acuDescription;

	@SerializedName("acu_provider_name")
	private String acuProviderName;

	@SerializedName("issued_year")
	private String issuedYear;

	public void setAcuTitle(String acuTitle){
		this.acuTitle = acuTitle;
	}

	public String getAcuTitle(){
		return acuTitle;
	}

	public void setAcuIssuedYear(String acuIssuedYear){
		this.acuIssuedYear = acuIssuedYear;
	}

	public String getAcuIssuedYear(){
		return acuIssuedYear;
	}

	public void setAcuIssuedMonth(String acuIssuedMonth){
		this.acuIssuedMonth = acuIssuedMonth;
	}

	public String getAcuIssuedMonth(){
		return acuIssuedMonth;
	}

	public void setAcuAchievementId(String acuAchievementId){
		this.acuAchievementId = acuAchievementId;
	}

	public String getAcuAchievementId(){
		return acuAchievementId;
	}

	public void setAcuOccupation(String acuOccupation){
		this.acuOccupation = acuOccupation;
	}

	public String getAcuOccupation(){
		return acuOccupation;
	}

	public void setAcuDescription(String acuDescription){
		this.acuDescription = acuDescription;
	}

	public String getAcuDescription(){
		return acuDescription;
	}

	public void setAcuProviderName(String acuProviderName){
		this.acuProviderName = acuProviderName;
	}

	public String getAcuProviderName(){
		return acuProviderName;
	}

	public void setIssuedYear(String issuedYear){
		this.issuedYear = issuedYear;
	}

	public String getIssuedYear(){
		return issuedYear;
	}

	@Override
 	public String toString(){
		return 
			"AchievementItem{" + 
			"acu_title = '" + acuTitle + '\'' + 
			",acu_issued_year = '" + acuIssuedYear + '\'' + 
			",acu_issued_month = '" + acuIssuedMonth + '\'' + 
			",acu_achievement_id = '" + acuAchievementId + '\'' + 
			",acu_occupation = '" + acuOccupation + '\'' + 
			",acu_description = '" + acuDescription + '\'' + 
			",acu_provider_name = '" + acuProviderName + '\'' + 
			",issued_year = '" + issuedYear + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.acuTitle);
		dest.writeString(this.acuIssuedYear);
		dest.writeString(this.acuIssuedMonth);
		dest.writeString(this.acuAchievementId);
		dest.writeString(this.acuOccupation);
		dest.writeString(this.acuDescription);
		dest.writeString(this.acuProviderName);
		dest.writeString(this.issuedYear);
	}

	public AchievementItem() {
	}

	protected AchievementItem(Parcel in) {
		this.acuTitle = in.readString();
		this.acuIssuedYear = in.readString();
		this.acuIssuedMonth = in.readString();
		this.acuAchievementId = in.readString();
		this.acuOccupation = in.readString();
		this.acuDescription = in.readString();
		this.acuProviderName = in.readString();
		this.issuedYear = in.readString();
	}

	public static final Parcelable.Creator<AchievementItem> CREATOR = new Parcelable.Creator<AchievementItem>() {
		@Override
		public AchievementItem createFromParcel(Parcel source) {
			return new AchievementItem(source);
		}

		@Override
		public AchievementItem[] newArray(int size) {
			return new AchievementItem[size];
		}
	};
}