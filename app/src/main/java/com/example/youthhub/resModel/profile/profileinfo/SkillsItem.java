package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class SkillsItem implements Parcelable {

	@SerializedName("teu_provider_name")
	private String teuProviderName;

	@SerializedName("skm_skill_id")
	private String skmSkillId;

	@SerializedName("teu_provider_id")
	private String teuProviderId;

	@SerializedName("skm_name")
	private String skmName;

	@SerializedName("endorsed_by")
	private List<EndorsedByItem> endorsedBy;

	@SerializedName("teu_testimonial_id")
	private String teuTestimonialId;

	public void setTeuProviderName(String teuProviderName){
		this.teuProviderName = teuProviderName;
	}

	public String getTeuProviderName(){
		return teuProviderName;
	}

	public void setSkmSkillId(String skmSkillId){
		this.skmSkillId = skmSkillId;
	}

	public String getSkmSkillId(){
		return skmSkillId;
	}

	public void setTeuProviderId(String teuProviderId){
		this.teuProviderId = teuProviderId;
	}

	public String getTeuProviderId(){
		return teuProviderId;
	}

	public void setSkmName(String skmName){
		this.skmName = skmName;
	}

	public String getSkmName(){
		return skmName;
	}

	public void setEndorsedBy(List<EndorsedByItem> endorsedBy){
		this.endorsedBy = endorsedBy;
	}

	public List<EndorsedByItem> getEndorsedBy(){
		return endorsedBy;
	}

	public void setTeuTestimonialId(String teuTestimonialId){
		this.teuTestimonialId = teuTestimonialId;
	}

	public String getTeuTestimonialId(){
		return teuTestimonialId;
	}

	@Override
 	public String toString(){
		return 
			"SkillsItem{" + 
			"teu_provider_name = '" + teuProviderName + '\'' + 
			",skm_skill_id = '" + skmSkillId + '\'' + 
			",teu_provider_id = '" + teuProviderId + '\'' + 
			",skm_name = '" + skmName + '\'' + 
			",endorsed_by = '" + endorsedBy + '\'' + 
			",teu_testimonial_id = '" + teuTestimonialId + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.teuProviderName);
		dest.writeString(this.skmSkillId);
		dest.writeString(this.teuProviderId);
		dest.writeString(this.skmName);
		dest.writeList(this.endorsedBy);
		dest.writeString(this.teuTestimonialId);
	}

	public SkillsItem() {
	}

	protected SkillsItem(Parcel in) {
		this.teuProviderName = in.readString();
		this.skmSkillId = in.readString();
		this.teuProviderId = in.readString();
		this.skmName = in.readString();
		this.endorsedBy = new ArrayList<EndorsedByItem>();
		in.readList(this.endorsedBy, EndorsedByItem.class.getClassLoader());
		this.teuTestimonialId = in.readString();
	}

	public static final Parcelable.Creator<SkillsItem> CREATOR = new Parcelable.Creator<SkillsItem>() {
		@Override
		public SkillsItem createFromParcel(Parcel source) {
			return new SkillsItem(source);
		}

		@Override
		public SkillsItem[] newArray(int size) {
			return new SkillsItem[size];
		}
	};
}