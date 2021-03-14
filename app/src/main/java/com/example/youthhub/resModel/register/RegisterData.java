
package com.example.youthhub.resModel.register;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterData implements Parcelable
{

    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("register_id")
    @Expose
    private String registerId;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("gender_list")
    @Expose
    private List<GenderList> genderList = new ArrayList<>();
    @SerializedName("region_list")
    @Expose
    private List<RegionList> regionList = new ArrayList<>();
    @SerializedName("current_qualification_type_list")
    @Expose
    private List<CurrentQualificationTypeList> currentQualificationTypeList = new ArrayList<>();
    @SerializedName("iwi_list")
    @Expose
    private List<IwiList> iwiList = new ArrayList<>();
    @SerializedName("work_experience_list")
    @Expose
    private List<WorkExperienceList> workExperienceList = new ArrayList<>();
    @SerializedName("ethnicity_list")
    @Expose
    private List<EthnicityList> ethnicityList = new ArrayList<>();
    @SerializedName("work_situation_list")
    @Expose
    private List<WorkSituationList> workSituationList = new ArrayList<>();
    @SerializedName("intended_destination_list")
    @Expose
    private List<IntendedDestinationList> intendedDestinationList = new ArrayList<>();
    @SerializedName("job_wishlist")
    @Expose
    private List<JobWishlist> jobWishlist = new ArrayList<>();
    @SerializedName("licence_type_list")
    @Expose
    private List<LicenceTypeList> licenceTypeList = new ArrayList<>();
    public final static Creator<RegisterData> CREATOR = new Creator<RegisterData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RegisterData createFromParcel(Parcel in) {
            return new RegisterData(in);
        }

        public RegisterData[] newArray(int size) {
            return (new RegisterData[size]);
        }

    }
    ;

    protected RegisterData(Parcel in) {
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.registerId = ((String) in.readValue((String.class.getClassLoader())));
        this.userType = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.genderList, (com.example.youthhub.resModel.register.GenderList.class.getClassLoader()));
        in.readList(this.regionList, (com.example.youthhub.resModel.register.RegionList.class.getClassLoader()));
        in.readList(this.currentQualificationTypeList, (CurrentQualificationTypeList.class.getClassLoader()));
        in.readList(this.iwiList, (com.example.youthhub.resModel.register.IwiList.class.getClassLoader()));
        in.readList(this.workExperienceList, (com.example.youthhub.resModel.register.WorkExperienceList.class.getClassLoader()));
        in.readList(this.ethnicityList, (com.example.youthhub.resModel.register.EthnicityList.class.getClassLoader()));
        in.readList(this.workSituationList, (com.example.youthhub.resModel.register.WorkSituationList.class.getClassLoader()));
        in.readList(this.intendedDestinationList, (com.example.youthhub.resModel.register.IntendedDestinationList.class.getClassLoader()));
        in.readList(this.jobWishlist, (com.example.youthhub.resModel.register.JobWishlist.class.getClassLoader()));
        in.readList(this.licenceTypeList, (com.example.youthhub.resModel.register.LicenceTypeList.class.getClassLoader()));
    }

    public RegisterData() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public List<GenderList> getGenderList() {
        return genderList;
    }

    public void setGenderList(List<GenderList> genderList) {
        this.genderList = genderList;
    }

    public List<RegionList> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<RegionList> regionList) {
        this.regionList = regionList;
    }

    public List<CurrentQualificationTypeList> getCurrentQualificationTypeList() {
        return currentQualificationTypeList;
    }

    public void setCurrentQualificationTypeList(List<CurrentQualificationTypeList> currentQualificationTypeList) {
        this.currentQualificationTypeList = currentQualificationTypeList;
    }

    public List<IwiList> getIwiList() {
        return iwiList;
    }

    public void setIwiList(List<IwiList> iwiList) {
        this.iwiList = iwiList;
    }

    public List<WorkExperienceList> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperienceList> workExperienceList) {
        this.workExperienceList = workExperienceList;
    }

    public List<EthnicityList> getEthnicityList() {
        return ethnicityList;
    }

    public void setEthnicityList(List<EthnicityList> ethnicityList) {
        this.ethnicityList = ethnicityList;
    }

    public List<WorkSituationList> getWorkSituationList() {
        return workSituationList;
    }

    public void setWorkSituationList(List<WorkSituationList> workSituationList) {
        this.workSituationList = workSituationList;
    }

    public List<IntendedDestinationList> getIntendedDestinationList() {
        return intendedDestinationList;
    }

    public void setIntendedDestinationList(List<IntendedDestinationList> intendedDestinationList) {
        this.intendedDestinationList = intendedDestinationList;
    }

    public List<JobWishlist> getJobWishlist() {
        return jobWishlist;
    }

    public void setJobWishlist(List<JobWishlist> jobWishlist) {
        this.jobWishlist = jobWishlist;
    }

    public List<LicenceTypeList> getLicenceTypeList() {
        return licenceTypeList;
    }

    public void setLicenceTypeList(List<LicenceTypeList> licenceTypeList) {
        this.licenceTypeList = licenceTypeList;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(email);
        dest.writeValue(registerId);
        dest.writeValue(userType);
        dest.writeList(genderList);
        dest.writeList(regionList);
        dest.writeList(currentQualificationTypeList);
        dest.writeList(iwiList);
        dest.writeList(workExperienceList);
        dest.writeList(ethnicityList);
        dest.writeList(workSituationList);
        dest.writeList(intendedDestinationList);
        dest.writeList(jobWishlist);
        dest.writeList(licenceTypeList);
    }

    public int describeContents() {
        return  0;
    }

}
