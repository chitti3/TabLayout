package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class TestimonialsItem implements Parcelable {

	@SerializedName("teu_provider_name")
	private String teuProviderName;

	@SerializedName("teu_created_on")
	private String teuCreatedOn;

	@SerializedName("teu_provider_id")
	private String teuProviderId;

	@SerializedName("teu_provider_title")
	private String teuProviderTitle;

	@SerializedName("skm_name")
	private String skmName;

	@SerializedName("teu_provider_email")
	private String teuProviderEmail;

	@SerializedName("teu_testimonial_id")
	private String teuTestimonialId;

	@SerializedName("teu_provider_phone")
	private String teuProviderPhone;

	@SerializedName("teu_provider_message")
	private String teuProviderMessage;

	@SerializedName("teu_provider_company")
	private String teuProviderCompany;

	public void setTeuProviderName(String teuProviderName){
		this.teuProviderName = teuProviderName;
	}

	public String getTeuProviderName(){
		return teuProviderName;
	}

	public void setTeuCreatedOn(String teuCreatedOn){
		this.teuCreatedOn = teuCreatedOn;
	}

	public String getTeuCreatedOn(){
		return teuCreatedOn;
	}

	public void setTeuProviderId(String teuProviderId){
		this.teuProviderId = teuProviderId;
	}

	public String getTeuProviderId(){
		return teuProviderId;
	}

	public void setTeuProviderTitle(String teuProviderTitle){
		this.teuProviderTitle = teuProviderTitle;
	}

	public String getTeuProviderTitle(){
		return teuProviderTitle;
	}

	public void setSkmName(String skmName){
		this.skmName = skmName;
	}

	public String getSkmName(){
		return skmName;
	}

	public void setTeuProviderEmail(String teuProviderEmail){
		this.teuProviderEmail = teuProviderEmail;
	}

	public String getTeuProviderEmail(){
		return teuProviderEmail;
	}

	public void setTeuTestimonialId(String teuTestimonialId){
		this.teuTestimonialId = teuTestimonialId;
	}

	public String getTeuTestimonialId(){
		return teuTestimonialId;
	}

	public void setTeuProviderPhone(String teuProviderPhone){
		this.teuProviderPhone = teuProviderPhone;
	}

	public String getTeuProviderPhone(){
		return teuProviderPhone;
	}

	public void setTeuProviderMessage(String teuProviderMessage){
		this.teuProviderMessage = teuProviderMessage;
	}

	public String getTeuProviderMessage(){
		return teuProviderMessage;
	}

	public void setTeuProviderCompany(String teuProviderCompany){
		this.teuProviderCompany = teuProviderCompany;
	}

	public String getTeuProviderCompany(){
		return teuProviderCompany;
	}

	@Override
 	public String toString(){
		return 
			"TestimonialsItem{" + 
			"teu_provider_name = '" + teuProviderName + '\'' + 
			",teu_created_on = '" + teuCreatedOn + '\'' + 
			",teu_provider_id = '" + teuProviderId + '\'' + 
			",teu_provider_title = '" + teuProviderTitle + '\'' + 
			",skm_name = '" + skmName + '\'' + 
			",teu_provider_email = '" + teuProviderEmail + '\'' + 
			",teu_testimonial_id = '" + teuTestimonialId + '\'' + 
			",teu_provider_phone = '" + teuProviderPhone + '\'' + 
			",teu_provider_message = '" + teuProviderMessage + '\'' + 
			",teu_provider_company = '" + teuProviderCompany + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.teuProviderName);
		dest.writeString(this.teuCreatedOn);
		dest.writeString(this.teuProviderId);
		dest.writeString(this.teuProviderTitle);
		dest.writeString(this.skmName);
		dest.writeString(this.teuProviderEmail);
		dest.writeString(this.teuTestimonialId);
		dest.writeString(this.teuProviderPhone);
		dest.writeString(this.teuProviderMessage);
		dest.writeString(this.teuProviderCompany);
	}

	public TestimonialsItem() {
	}

	protected TestimonialsItem(Parcel in) {
		this.teuProviderName = in.readString();
		this.teuCreatedOn = in.readString();
		this.teuProviderId = in.readString();
		this.teuProviderTitle = in.readString();
		this.skmName = in.readString();
		this.teuProviderEmail = in.readString();
		this.teuTestimonialId = in.readString();
		this.teuProviderPhone = in.readString();
		this.teuProviderMessage = in.readString();
		this.teuProviderCompany = in.readString();
	}

	public static final Parcelable.Creator<TestimonialsItem> CREATOR = new Parcelable.Creator<TestimonialsItem>() {
		@Override
		public TestimonialsItem createFromParcel(Parcel source) {
			return new TestimonialsItem(source);
		}

		@Override
		public TestimonialsItem[] newArray(int size) {
			return new TestimonialsItem[size];
		}
	};
}