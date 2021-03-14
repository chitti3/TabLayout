package com.example.youthhub.resModel.profile.profileeducation.update;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("ncea_level")
	private List<NceaLevelItem> nceaLevel;

	@SerializedName("region_list")
	private List<RegionListItem> regionList;

	@SerializedName("education")
	private List<EducationItem> education;

	@SerializedName("qualification_category")
	private List<QualificationCategoryItem> qualificationCategory;

	@SerializedName("qualification_provider")
	private List<QualificationProviderItem> qualificationProvider;

	@SerializedName("organisation_category")
	private List<OrganisationCategoryItem> organisationCategory;

	public void setNceaLevel(List<NceaLevelItem> nceaLevel){
		this.nceaLevel = nceaLevel;
	}

	public List<NceaLevelItem> getNceaLevel(){
		return nceaLevel;
	}

	public void setRegionList(List<RegionListItem> regionList){
		this.regionList = regionList;
	}

	public List<RegionListItem> getRegionList(){
		return regionList;
	}

	public void setEducation(List<EducationItem> education){
		this.education = education;
	}

	public List<EducationItem> getEducation(){
		return education;
	}

	public void setQualificationCategory(List<QualificationCategoryItem> qualificationCategory){
		this.qualificationCategory = qualificationCategory;
	}

	public List<QualificationCategoryItem> getQualificationCategory(){
		return qualificationCategory;
	}

	public void setQualificationProvider(List<QualificationProviderItem> qualificationProvider){
		this.qualificationProvider = qualificationProvider;
	}

	public List<QualificationProviderItem> getQualificationProvider(){
		return qualificationProvider;
	}

	public void setOrganisationCategory(List<OrganisationCategoryItem> organisationCategory){
		this.organisationCategory = organisationCategory;
	}

	public List<OrganisationCategoryItem> getOrganisationCategory(){
		return organisationCategory;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"ncea_level = '" + nceaLevel + '\'' + 
			",region_list = '" + regionList + '\'' + 
			",education = '" + education + '\'' + 
			",qualification_category = '" + qualificationCategory + '\'' + 
			",qualification_provider = '" + qualificationProvider + '\'' + 
			",organisation_category = '" + organisationCategory + '\'' + 
			"}";
		}
}