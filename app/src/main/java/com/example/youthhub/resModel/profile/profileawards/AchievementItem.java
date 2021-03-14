package com.example.youthhub.resModel.profile.profileawards;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class AchievementItem{

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
}