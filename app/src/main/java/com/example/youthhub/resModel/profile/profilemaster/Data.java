package com.example.youthhub.resModel.profile.profilemaster;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data implements Parcelable {

	@SerializedName("wishlist")
	private List<WishlistItem> wishlist;

	@SerializedName("business_category_list")
	private List<BusinessCategory> businessCategoryList;

	@SerializedName("job_type")
	private List<JobType> jobType;

	@SerializedName("languages")
	private List<LanguageResponse> languages;

	@SerializedName("proficiency")
	private List<ProficiencyResponse> proficiency;

	@SerializedName("volunteering_category")
	private List<VolunteerngCategoryResponse> volunteering_category;

	@SerializedName("region_list")
	private List<RegionResponse> region_list;

	@SerializedName("organisation_category")
	private List<OrganizationCategoryResponse> organisation_category;

	@SerializedName("qualification_category")
	private List<QualificationCategoryResponse> qualification_category;

	@SerializedName("ncea_level")
	private List<NceaResponse> ncea_level;

	public List<LanguageResponse> getLanguages() {
		return languages;
	}

	public void setLanguages(List<LanguageResponse> languages) {
		this.languages = languages;
	}

	public List<VolunteerngCategoryResponse> getVolunteering_category() {
		return volunteering_category;
	}

	public void setVolunteering_category(List<VolunteerngCategoryResponse> volunteering_category) {
		this.volunteering_category = volunteering_category;
	}

	public List<ProficiencyResponse> getProficiency() {
		return proficiency;
	}

	public void setProficiency(List<ProficiencyResponse> proficiency) {
		this.proficiency = proficiency;
	}

	public List<RegionResponse> getRegion_list() {
		return region_list;
	}

	public void setRegion_list(List<RegionResponse> region_list) {
		this.region_list = region_list;
	}

	public List<OrganizationCategoryResponse> getOrganisation_category() {
		return organisation_category;
	}

	public void setOrganisation_category(List<OrganizationCategoryResponse> organisation_category) {
		this.organisation_category = organisation_category;
	}

	public List<QualificationCategoryResponse> getQualification_category() {
		return qualification_category;
	}

	public void setQualification_category(List<QualificationCategoryResponse> qualification_category) {
		this.qualification_category = qualification_category;
	}

	public List<NceaResponse> getNcea_level() {
		return ncea_level;
	}

	public void setNcea_level(List<NceaResponse> ncea_level) {
		this.ncea_level = ncea_level;
	}

	public void setWishlist(List<WishlistItem> wishlist) {
		this.wishlist = wishlist;
	}

	public List<WishlistItem> getWishlist() {
		return wishlist;
	}

	public List<BusinessCategory> getBusinessCategoryList() {
		return businessCategoryList;
	}

	public void setBusinessCategoryList(List<BusinessCategory> businessCategoryList) {
		this.businessCategoryList = businessCategoryList;
	}

	public List<JobType> getJobType() {
		return jobType;
	}

	public void setJobType(List<JobType> jobType) {
		this.jobType = jobType;
	}

	@Override
	public String toString() {
		return
				"Data{" +
						"wishlist = '" + wishlist + '\'' +
						"}";
	}


	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeTypedList(this.wishlist);
		dest.writeTypedList(this.businessCategoryList);
		dest.writeTypedList(this.jobType);
		dest.writeTypedList(this.languages);
		dest.writeTypedList(this.volunteering_category);
		dest.writeTypedList(this.region_list);
		dest.writeTypedList(this.organisation_category);
		dest.writeTypedList(this.qualification_category);
		dest.writeTypedList(this.ncea_level);
	}

	public Data() {
	}

	protected Data(Parcel in) {
		this.wishlist = in.createTypedArrayList(WishlistItem.CREATOR);
		this.businessCategoryList = in.createTypedArrayList(BusinessCategory.CREATOR);
		this.jobType = in.createTypedArrayList(JobType.CREATOR);
		this.languages = in.createTypedArrayList(LanguageResponse.CREATOR);
		this.volunteering_category = in.createTypedArrayList(VolunteerngCategoryResponse.CREATOR);
		this.region_list = in.createTypedArrayList(RegionResponse.CREATOR);
		this.organisation_category = in.createTypedArrayList(OrganizationCategoryResponse.CREATOR);
		this.qualification_category = in.createTypedArrayList(QualificationCategoryResponse.CREATOR);
		this.ncea_level = in.createTypedArrayList(NceaResponse.CREATOR);
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