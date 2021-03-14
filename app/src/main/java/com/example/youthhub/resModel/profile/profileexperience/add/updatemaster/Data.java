package com.example.youthhub.resModel.profile.profileexperience.add.updatemaster;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("job_type")
	private List<JobTypeItem> jobType;

	@SerializedName("business_category_list")
	private List<BusinessCategoryListItem> businessCategoryList;

	@SerializedName("experience")
	private List<ExperienceItem> experience;

	@SerializedName("bizsubtype_list")
	private List<BizsubtypeListItem> bizsubtypeList;

	public void setJobType(List<JobTypeItem> jobType){
		this.jobType = jobType;
	}

	public List<JobTypeItem> getJobType(){
		return jobType;
	}

	public void setBusinessCategoryList(List<BusinessCategoryListItem> businessCategoryList){
		this.businessCategoryList = businessCategoryList;
	}

	public List<BusinessCategoryListItem> getBusinessCategoryList(){
		return businessCategoryList;
	}

	public void setExperience(List<ExperienceItem> experience){
		this.experience = experience;
	}

	public List<ExperienceItem> getExperience(){
		return experience;
	}

	public void setBizsubtypeList(List<BizsubtypeListItem> bizsubtypeList){
		this.bizsubtypeList = bizsubtypeList;
	}

	public List<BizsubtypeListItem> getBizsubtypeList(){
		return bizsubtypeList;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"job_type = '" + jobType + '\'' + 
			",business_category_list = '" + businessCategoryList + '\'' + 
			",experience = '" + experience + '\'' + 
			",bizsubtype_list = '" + bizsubtypeList + '\'' + 
			"}";
		}
}