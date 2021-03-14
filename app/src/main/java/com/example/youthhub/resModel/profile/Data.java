package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data implements Parcelable {

	@SerializedName("residency_status_master")
	private List<ResidencyStatusMasterItem> residencyStatusMaster;

	@SerializedName("intended_destination")
	private List<IntendedDestinationItem> intendedDestination;

	@SerializedName("region_list")
	private List<RegionListItem> regionList;

	@SerializedName("visa_type_master")
	private List<VisaTypeMasterItem> visaTypeMaster;

	@SerializedName("gender_master")
	private List<GenderMasterItem> genderMaster;

	@SerializedName("work_status_master")
	private List<WorkStatusMasterItem> workStatusMaster;

	@SerializedName("work_availability_timing_master")
	private List<WorkAvailabilityTimingMasterItem> workAvailabilityTimingMaster;

	@SerializedName("workinfo_tooltip")
	private String workinfoTooltip;

	@SerializedName("communications_tooltip")
	private String communicationsTooltip;

	@SerializedName("licence_type")
	private List<LicenceTypeItem> licenceType;

	@SerializedName("profile_user_id")
	private String profileUserId;

	@SerializedName("location_ethnicity")
	private List<LocationEthnicityItem> locationEthnicity;

	@SerializedName("profile_user_type")
	private String profileUserType;

	@SerializedName("organisation_data")
	private List<OrganisationDataItem> organisationData;

	@SerializedName("youth_info")
	private YouthInfo youthInfo;

	@SerializedName("login_user_id")
	private String loginUserId;

	@SerializedName("location_iwi")
	private List<LocationIwiItem> locationIwi;

	@SerializedName("work_experience_master")
	private List<WorkExperienceMasterItem> workExperienceMaster;

	@SerializedName("city_list")
	private List<CityListItem> cityList;

	public void setResidencyStatusMaster(List<ResidencyStatusMasterItem> residencyStatusMaster){
		this.residencyStatusMaster = residencyStatusMaster;
	}

	public List<ResidencyStatusMasterItem> getResidencyStatusMaster(){
		return residencyStatusMaster;
	}

	public void setIntendedDestination(List<IntendedDestinationItem> intendedDestination){
		this.intendedDestination = intendedDestination;
	}

	public List<IntendedDestinationItem> getIntendedDestination(){
		return intendedDestination;
	}

	public void setRegionList(List<RegionListItem> regionList){
		this.regionList = regionList;
	}

	public List<RegionListItem> getRegionList(){
		return regionList;
	}

	public void setVisaTypeMaster(List<VisaTypeMasterItem> visaTypeMaster){
		this.visaTypeMaster = visaTypeMaster;
	}

	public List<VisaTypeMasterItem> getVisaTypeMaster(){
		return visaTypeMaster;
	}

	public void setGenderMaster(List<GenderMasterItem> genderMaster){
		this.genderMaster = genderMaster;
	}

	public List<GenderMasterItem> getGenderMaster(){
		return genderMaster;
	}

	public void setWorkStatusMaster(List<WorkStatusMasterItem> workStatusMaster){
		this.workStatusMaster = workStatusMaster;
	}

	public List<WorkStatusMasterItem> getWorkStatusMaster(){
		return workStatusMaster;
	}

	public void setWorkAvailabilityTimingMaster(List<WorkAvailabilityTimingMasterItem> workAvailabilityTimingMaster){
		this.workAvailabilityTimingMaster = workAvailabilityTimingMaster;
	}

	public List<WorkAvailabilityTimingMasterItem> getWorkAvailabilityTimingMaster(){
		return workAvailabilityTimingMaster;
	}

	public void setWorkinfoTooltip(String workinfoTooltip){
		this.workinfoTooltip = workinfoTooltip;
	}

	public String getWorkinfoTooltip(){
		return workinfoTooltip;
	}

	public void setCommunicationsTooltip(String communicationsTooltip){
		this.communicationsTooltip = communicationsTooltip;
	}

	public String getCommunicationsTooltip(){
		return communicationsTooltip;
	}

	public void setLicenceType(List<LicenceTypeItem> licenceType){
		this.licenceType = licenceType;
	}

	public List<LicenceTypeItem> getLicenceType(){
		return licenceType;
	}

	public void setProfileUserId(String profileUserId){
		this.profileUserId = profileUserId;
	}

	public String getProfileUserId(){
		return profileUserId;
	}

	public void setLocationEthnicity(List<LocationEthnicityItem> locationEthnicity){
		this.locationEthnicity = locationEthnicity;
	}

	public List<LocationEthnicityItem> getLocationEthnicity(){
		return locationEthnicity;
	}

	public void setProfileUserType(String profileUserType){
		this.profileUserType = profileUserType;
	}

	public String getProfileUserType(){
		return profileUserType;
	}

	public void setOrganisationData(List<OrganisationDataItem> organisationData){
		this.organisationData = organisationData;
	}

	public List<OrganisationDataItem> getOrganisationData(){
		return organisationData;
	}

	public void setYouthInfo(YouthInfo youthInfo){
		this.youthInfo = youthInfo;
	}

	public YouthInfo getYouthInfo(){
		return youthInfo;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setLocationIwi(List<LocationIwiItem> locationIwi){
		this.locationIwi = locationIwi;
	}

	public List<LocationIwiItem> getLocationIwi(){
		return locationIwi;
	}

	public void setWorkExperienceMaster(List<WorkExperienceMasterItem> workExperienceMaster){
		this.workExperienceMaster = workExperienceMaster;
	}

	public List<WorkExperienceMasterItem> getWorkExperienceMaster(){
		return workExperienceMaster;
	}

	public void setCityList(List<CityListItem> cityList){
		this.cityList = cityList;
	}

	public List<CityListItem> getCityList(){
		return cityList;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"residency_status_master = '" + residencyStatusMaster + '\'' + 
			",intended_destination = '" + intendedDestination + '\'' + 
			",region_list = '" + regionList + '\'' + 
			",visa_type_master = '" + visaTypeMaster + '\'' + 
			",gender_master = '" + genderMaster + '\'' + 
			",work_status_master = '" + workStatusMaster + '\'' + 
			",work_availability_timing_master = '" + workAvailabilityTimingMaster + '\'' + 
			",workinfo_tooltip = '" + workinfoTooltip + '\'' + 
			",communications_tooltip = '" + communicationsTooltip + '\'' + 
			",licence_type = '" + licenceType + '\'' + 
			",profile_user_id = '" + profileUserId + '\'' + 
			",location_ethnicity = '" + locationEthnicity + '\'' + 
			",profile_user_type = '" + profileUserType + '\'' + 
			",organisation_data = '" + organisationData + '\'' + 
			",youth_info = '" + youthInfo + '\'' + 
			",login_user_id = '" + loginUserId + '\'' + 
			",location_iwi = '" + locationIwi + '\'' + 
			",work_experience_master = '" + workExperienceMaster + '\'' + 
			",city_list = '" + cityList + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeList(this.residencyStatusMaster);
		dest.writeList(this.intendedDestination);
		dest.writeList(this.regionList);
		dest.writeList(this.visaTypeMaster);
		dest.writeList(this.genderMaster);
		dest.writeList(this.workStatusMaster);
		dest.writeList(this.workAvailabilityTimingMaster);
		dest.writeString(this.workinfoTooltip);
		dest.writeString(this.communicationsTooltip);
		dest.writeList(this.licenceType);
		dest.writeString(this.profileUserId);
		dest.writeList(this.locationEthnicity);
		dest.writeString(this.profileUserType);
		dest.writeList(this.organisationData);
		dest.writeParcelable(this.youthInfo, flags);
		dest.writeString(this.loginUserId);
		dest.writeList(this.locationIwi);
		dest.writeList(this.workExperienceMaster);
		dest.writeList(this.cityList);
	}

	public Data() {
	}

	protected Data(Parcel in) {
		this.residencyStatusMaster = new ArrayList<ResidencyStatusMasterItem>();
		in.readList(this.residencyStatusMaster, ResidencyStatusMasterItem.class.getClassLoader());
		this.intendedDestination = new ArrayList<IntendedDestinationItem>();
		in.readList(this.intendedDestination, IntendedDestinationItem.class.getClassLoader());
		this.regionList = new ArrayList<RegionListItem>();
		in.readList(this.regionList, RegionListItem.class.getClassLoader());
		this.visaTypeMaster = new ArrayList<VisaTypeMasterItem>();
		in.readList(this.visaTypeMaster, VisaTypeMasterItem.class.getClassLoader());
		this.genderMaster = new ArrayList<GenderMasterItem>();
		in.readList(this.genderMaster, GenderMasterItem.class.getClassLoader());
		this.workStatusMaster = new ArrayList<WorkStatusMasterItem>();
		in.readList(this.workStatusMaster, WorkStatusMasterItem.class.getClassLoader());
		this.workAvailabilityTimingMaster = new ArrayList<WorkAvailabilityTimingMasterItem>();
		in.readList(this.workAvailabilityTimingMaster, WorkAvailabilityTimingMasterItem.class.getClassLoader());
		this.workinfoTooltip = in.readString();
		this.communicationsTooltip = in.readString();
		this.licenceType = new ArrayList<LicenceTypeItem>();
		in.readList(this.licenceType, LicenceTypeItem.class.getClassLoader());
		this.profileUserId = in.readString();
		this.locationEthnicity = new ArrayList<LocationEthnicityItem>();
		in.readList(this.locationEthnicity, LocationEthnicityItem.class.getClassLoader());
		this.profileUserType = in.readString();
		this.organisationData = new ArrayList<OrganisationDataItem>();
		in.readList(this.organisationData, OrganisationDataItem.class.getClassLoader());
		this.youthInfo = in.readParcelable(YouthInfo.class.getClassLoader());
		this.loginUserId = in.readString();
		this.locationIwi = new ArrayList<LocationIwiItem>();
		in.readList(this.locationIwi, LocationIwiItem.class.getClassLoader());
		this.workExperienceMaster = new ArrayList<WorkExperienceMasterItem>();
		in.readList(this.workExperienceMaster, WorkExperienceMasterItem.class.getClassLoader());
		this.cityList = new ArrayList<CityListItem>();
		in.readList(this.cityList, CityListItem.class.getClassLoader());
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