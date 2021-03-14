package com.example.youthhub.resModel.profile.profileexperience.add.updatemaster;

import java.util.List;
import javax.annotation.Generated;

import com.example.youthhub.resModel.profile.profileinfo.EmuResponsibilitiesItem;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ExperienceItem{

	@SerializedName("emu_status")
	private String emuStatus;

	@SerializedName("end_date")
	private String endDate;

	@SerializedName("is_inprogress")
	private int isInprogress;

	@SerializedName("emu_responsibilities")
	private List<EmuResponsibilitiesItem> emuResponsibilities;

	@SerializedName("emu_ica_category_id")
	private String emuIcaCategoryId;

	@SerializedName("emu_isc_sub_category_id")
	private String emuIscSubCategoryId;

	@SerializedName("emu_employer_name")
	private String emuEmployerName;

	@SerializedName("emu_jt_type_id")
	private String emuJtTypeId;

	@SerializedName("emu_description")
	private String emuDescription;

	@SerializedName("emu_employment_id")
	private String emuEmploymentId;

	@SerializedName("emu_end_month")
	private String emuEndMonth;

	@SerializedName("emu_start_month")
	private String emuStartMonth;

	@SerializedName("emu_ica_category_name")
	private String emuIcaCategoryName;

	@SerializedName("emu_isc_sub_category_name")
	private String emuIscSubCategoryName;

	@SerializedName("emu_jt_type_name")
	private String emuJtTypeName;

	@SerializedName("emu_start_year")
	private String emuStartYear;

	@SerializedName("emu_end_year")
	private String emuEndYear;

	@SerializedName("emu_designation")
	private String emuDesignation;

	@SerializedName("start_date")
	private String startDate;

	public void setEmuStatus(String emuStatus){
		this.emuStatus = emuStatus;
	}

	public String getEmuStatus(){
		return emuStatus;
	}

	public void setEndDate(String endDate){
		this.endDate = endDate;
	}

	public String getEndDate(){
		return endDate;
	}

	public void setIsInprogress(int isInprogress){
		this.isInprogress = isInprogress;
	}

	public int getIsInprogress(){
		return isInprogress;
	}

	public void setEmuResponsibilities(List<EmuResponsibilitiesItem> emuResponsibilities){
		this.emuResponsibilities = emuResponsibilities;
	}

	public List<EmuResponsibilitiesItem> getEmuResponsibilities(){
		return emuResponsibilities;
	}

	public void setEmuIcaCategoryId(String emuIcaCategoryId){
		this.emuIcaCategoryId = emuIcaCategoryId;
	}

	public String getEmuIcaCategoryId(){
		return emuIcaCategoryId;
	}

	public void setEmuIscSubCategoryId(String emuIscSubCategoryId){
		this.emuIscSubCategoryId = emuIscSubCategoryId;
	}

	public String getEmuIscSubCategoryId(){
		return emuIscSubCategoryId;
	}

	public void setEmuEmployerName(String emuEmployerName){
		this.emuEmployerName = emuEmployerName;
	}

	public String getEmuEmployerName(){
		return emuEmployerName;
	}

	public void setEmuJtTypeId(String emuJtTypeId){
		this.emuJtTypeId = emuJtTypeId;
	}

	public String getEmuJtTypeId(){
		return emuJtTypeId;
	}

	public void setEmuDescription(String emuDescription){
		this.emuDescription = emuDescription;
	}

	public String getEmuDescription(){
		return emuDescription;
	}

	public void setEmuEmploymentId(String emuEmploymentId){
		this.emuEmploymentId = emuEmploymentId;
	}

	public String getEmuEmploymentId(){
		return emuEmploymentId;
	}

	public void setEmuEndMonth(String emuEndMonth){
		this.emuEndMonth = emuEndMonth;
	}

	public String getEmuEndMonth(){
		return emuEndMonth;
	}

	public void setEmuStartMonth(String emuStartMonth){
		this.emuStartMonth = emuStartMonth;
	}

	public String getEmuStartMonth(){
		return emuStartMonth;
	}

	public void setEmuIcaCategoryName(String emuIcaCategoryName){
		this.emuIcaCategoryName = emuIcaCategoryName;
	}

	public String getEmuIcaCategoryName(){
		return emuIcaCategoryName;
	}

	public void setEmuIscSubCategoryName(String emuIscSubCategoryName){
		this.emuIscSubCategoryName = emuIscSubCategoryName;
	}

	public String getEmuIscSubCategoryName(){
		return emuIscSubCategoryName;
	}

	public void setEmuJtTypeName(String emuJtTypeName){
		this.emuJtTypeName = emuJtTypeName;
	}

	public String getEmuJtTypeName(){
		return emuJtTypeName;
	}

	public void setEmuStartYear(String emuStartYear){
		this.emuStartYear = emuStartYear;
	}

	public String getEmuStartYear(){
		return emuStartYear;
	}

	public void setEmuEndYear(String emuEndYear){
		this.emuEndYear = emuEndYear;
	}

	public String getEmuEndYear(){
		return emuEndYear;
	}

	public void setEmuDesignation(String emuDesignation){
		this.emuDesignation = emuDesignation;
	}

	public String getEmuDesignation(){
		return emuDesignation;
	}

	public void setStartDate(String startDate){
		this.startDate = startDate;
	}

	public String getStartDate(){
		return startDate;
	}

	@Override
 	public String toString(){
		return 
			"ExperienceItem{" + 
			"emu_status = '" + emuStatus + '\'' + 
			",end_date = '" + endDate + '\'' + 
			",is_inprogress = '" + isInprogress + '\'' + 
			",emu_responsibilities = '" + emuResponsibilities + '\'' + 
			",emu_ica_category_id = '" + emuIcaCategoryId + '\'' + 
			",emu_isc_sub_category_id = '" + emuIscSubCategoryId + '\'' + 
			",emu_employer_name = '" + emuEmployerName + '\'' + 
			",emu_jt_type_id = '" + emuJtTypeId + '\'' + 
			",emu_description = '" + emuDescription + '\'' + 
			",emu_employment_id = '" + emuEmploymentId + '\'' + 
			",emu_end_month = '" + emuEndMonth + '\'' + 
			",emu_start_month = '" + emuStartMonth + '\'' + 
			",emu_ica_category_name = '" + emuIcaCategoryName + '\'' + 
			",emu_isc_sub_category_name = '" + emuIscSubCategoryName + '\'' + 
			",emu_jt_type_name = '" + emuJtTypeName + '\'' + 
			",emu_start_year = '" + emuStartYear + '\'' + 
			",emu_end_year = '" + emuEndYear + '\'' + 
			",emu_designation = '" + emuDesignation + '\'' + 
			",start_date = '" + startDate + '\'' + 
			"}";
		}
}