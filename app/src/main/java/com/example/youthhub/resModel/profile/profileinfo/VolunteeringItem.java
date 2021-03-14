package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class VolunteeringItem implements Parcelable {

	@SerializedName("vou_provider_name")
	private String vouProviderName;

	@SerializedName("vou_end_date")
	private String vouEndDate;

	@SerializedName("vou_title")
	private String vouTitle;

	@SerializedName("vou_qualification_id")
	private String vouQualificationId;

	@SerializedName("vou_start_date")
	private String vouStartDate;

	@SerializedName("diff_month")
	private String diffMonth;

	@SerializedName("diff_year")
	private String diffYear;

	@SerializedName("vou_description")
	private String vouDescription;

	@SerializedName("vou_status")
	private String vouStatus;

	@SerializedName("voc_name")
	private String vocName;

	@SerializedName("vou_voc_category_id")
	private String vouVocCategoryId;

	public void setVouProviderName(String vouProviderName){
		this.vouProviderName = vouProviderName;
	}

	public String getVouProviderName(){
		return vouProviderName;
	}

	public void setVouEndDate(String vouEndDate){
		this.vouEndDate = vouEndDate;
	}

	public String getVouEndDate(){
		return vouEndDate;
	}

	public void setVouTitle(String vouTitle){
		this.vouTitle = vouTitle;
	}

	public String getVouTitle(){
		return vouTitle;
	}

	public void setVouQualificationId(String vouQualificationId){
		this.vouQualificationId = vouQualificationId;
	}

	public String getVouQualificationId(){
		return vouQualificationId;
	}

	public void setVouStartDate(String vouStartDate){
		this.vouStartDate = vouStartDate;
	}

	public String getVouStartDate(){
		return vouStartDate;
	}

	public void setDiffMonth(String diffMonth){
		this.diffMonth = diffMonth;
	}

	public String getDiffMonth(){
		return diffMonth;
	}

	public void setDiffYear(String diffYear){
		this.diffYear = diffYear;
	}

	public String getDiffYear(){
		return diffYear;
	}

	public void setVouDescription(String vouDescription){
		this.vouDescription = vouDescription;
	}

	public String getVouDescription(){
		return vouDescription;
	}

	public void setVouStatus(String vouStatus){
		this.vouStatus = vouStatus;
	}

	public String getVouStatus(){
		return vouStatus;
	}

	public void setVocName(String vocName){
		this.vocName = vocName;
	}

	public String getVocName(){
		return vocName;
	}

	public void setVouVocCategoryId(String vouVocCategoryId){
		this.vouVocCategoryId = vouVocCategoryId;
	}

	public String getVouVocCategoryId(){
		return vouVocCategoryId;
	}

	@Override
 	public String toString(){
		return 
			"VolunteeringItem{" + 
			"vou_provider_name = '" + vouProviderName + '\'' + 
			",vou_end_date = '" + vouEndDate + '\'' + 
			",vou_title = '" + vouTitle + '\'' + 
			",vou_qualification_id = '" + vouQualificationId + '\'' + 
			",vou_start_date = '" + vouStartDate + '\'' + 
			",diff_month = '" + diffMonth + '\'' + 
			",diff_year = '" + diffYear + '\'' + 
			",vou_description = '" + vouDescription + '\'' + 
			",vou_status = '" + vouStatus + '\'' + 
			",voc_name = '" + vocName + '\'' + 
			",vou_voc_category_id = '" + vouVocCategoryId + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.vouProviderName);
		dest.writeString(this.vouEndDate);
		dest.writeString(this.vouTitle);
		dest.writeString(this.vouQualificationId);
		dest.writeString(this.vouStartDate);
		dest.writeString(this.diffMonth);
		dest.writeString(this.diffYear);
		dest.writeString(this.vouDescription);
		dest.writeString(this.vouStatus);
		dest.writeString(this.vocName);
		dest.writeString(this.vouVocCategoryId);
	}

	public VolunteeringItem() {
	}

	protected VolunteeringItem(Parcel in) {
		this.vouProviderName = in.readString();
		this.vouEndDate = in.readString();
		this.vouTitle = in.readString();
		this.vouQualificationId = in.readString();
		this.vouStartDate = in.readString();
		this.diffMonth = in.readString();
		this.diffYear = in.readString();
		this.vouDescription = in.readString();
		this.vouStatus = in.readString();
		this.vocName = in.readString();
		this.vouVocCategoryId = in.readString();
	}

	public static final Parcelable.Creator<VolunteeringItem> CREATOR = new Parcelable.Creator<VolunteeringItem>() {
		@Override
		public VolunteeringItem createFromParcel(Parcel source) {
			return new VolunteeringItem(source);
		}

		@Override
		public VolunteeringItem[] newArray(int size) {
			return new VolunteeringItem[size];
		}
	};
}