
package com.example.youthhub.resModel.jobs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobInfo implements Parcelable
{

    @SerializedName("jm_job_id")
    @Expose
    private String jmJobId;
    @SerializedName("jm_code")
    @Expose
    private String jmCode;
    @SerializedName("jm_type")
    @Expose
    private String jmType;
    @SerializedName("jm_um_user_id")
    @Expose
    private String jmUmUserId;
    @SerializedName("jm_title")
    @Expose
    private String jmTitle;
    @SerializedName("jm_ica_category_id")
    @Expose
    private String jmIcaCategoryId;
    @SerializedName("jm_isc_sub_category_id")
    @Expose
    private String jmIscSubCategoryId;
    @SerializedName("jm_jt_type_id")
    @Expose
    private String jmJtTypeId;
    @SerializedName("jm_short_description")
    @Expose
    private String jmShortDescription;
    @SerializedName("jm_full_description")
    @Expose
    private String jmFullDescription;
    @SerializedName("jm_requirement_details")
    @Expose
    private String jmRequirementDetails;
    @SerializedName("jm_start_date")
    @Expose
    private String jmStartDate;
    @SerializedName("jm_end_date")
    @Expose
    private String jmEndDate;
    @SerializedName("jm_work_type")
    @Expose
    private String jmWorkType;
    @SerializedName("jm_work_hour")
    @Expose
    private String jmWorkHour;
    @SerializedName("jm_salary_type")
    @Expose
    private String jmSalaryType;
    @SerializedName("jm_salary_from")
    @Expose
    private String jmSalaryFrom;
    @SerializedName("jm_salary_to")
    @Expose
    private String jmSalaryTo;
    @SerializedName("jm_salary_display")
    @Expose
    private String jmSalaryDisplay;
    @SerializedName("jm_payment")
    @Expose
    private String jmPayment;
    @SerializedName("jm_payment_display")
    @Expose
    private String jmPaymentDisplay;
    @SerializedName("jm_vacancies")
    @Expose
    private String jmVacancies;
    @SerializedName("jm_shu_url_id")
    @Expose
    private String jmShuUrlId;
    @SerializedName("jm_contact_name")
    @Expose
    private String jmContactName;
    @SerializedName("jm_contact_email")
    @Expose
    private String jmContactEmail;
    @SerializedName("jm_contact_phone")
    @Expose
    private String jmContactPhone;
    @SerializedName("jm_alternate_contact_name")
    @Expose
    private String jmAlternateContactName;
    @SerializedName("jm_alternate_contact_email")
    @Expose
    private String jmAlternateContactEmail;
    @SerializedName("jm_alternate_contact_phone")
    @Expose
    private String jmAlternateContactPhone;
    @SerializedName("jm_question")
    @Expose
    private String jmQuestion;
    @SerializedName("jm_trademe_id")
    @Expose
    private String jmTrademeId;
    @SerializedName("jm_apply_link")
    @Expose
    private String jmApplyLink;
    @SerializedName("jm_jtm_code")
    @Expose
    private String jmJtmCode;
    @SerializedName("jm_featured")
    @Expose
    private String jmFeatured;
    @SerializedName("jm_status")
    @Expose
    private String jmStatus;
    @SerializedName("jm_created_by")
    @Expose
    private String jmCreatedBy;
    @SerializedName("jm_created_on")
    @Expose
    private String jmCreatedOn;
    @SerializedName("jm_updated_by")
    @Expose
    private String jmUpdatedBy;
    @SerializedName("jm_updated_on")
    @Expose
    private String jmUpdatedOn;
    @SerializedName("jm_active")
    @Expose
    private String jmActive;
    @SerializedName("jm_old_id")
    @Expose
    private String jmOldId;
    @SerializedName("jlo_location_id")
    @Expose
    private String jloLocationId;
    @SerializedName("jlo_jm_job_id")
    @Expose
    private String jloJmJobId;
    @SerializedName("jlo_type")
    @Expose
    private String jloType;
    @SerializedName("jlo_re_region_id")
    @Expose
    private String jloReRegionId;
    @SerializedName("jlo_ci_city_id")
    @Expose
    private String jloCiCityId;
    @SerializedName("jlo_su_suburb_id")
    @Expose
    private String jloSuSuburbId;
    @SerializedName("jlo_address")
    @Expose
    private String jloAddress;
    @SerializedName("jlo_lattitude")
    @Expose
    private String jloLattitude;
    @SerializedName("jlo_longitude")
    @Expose
    private String jloLongitude;
    @SerializedName("jlo_active")
    @Expose
    private String jloActive;
    @SerializedName("jlo_old_id")
    @Expose
    private String jloOldId;
    @SerializedName("ica_name")
    @Expose
    private String icaName;
    @SerializedName("isc_name")
    @Expose
    private String iscName;
    @SerializedName("region_name")
    @Expose
    private String regionName;
    @SerializedName("city_name")
    @Expose
    private String cityName;
    @SerializedName("suburb_name")
    @Expose
    private String suburbName;
    @SerializedName("um_user_id")
    @Expose
    private String umUserId;
    @SerializedName("post_by")
    @Expose
    private String postBy;
    @SerializedName("post_by_code")
    @Expose
    private String postByCode;
    @SerializedName("post_by_user_type")
    @Expose
    private String postByUserType;
    @SerializedName("post_by_profile_pic")
    @Expose
    private String postByProfilePic;
    @SerializedName("jm_salary_type_name")
    @Expose
    private String jmSalaryTypeName;
    @SerializedName("jm_jt_type_name")
    @Expose
    private String jmJtTypeName;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("is_applied")
    @Expose
    private Integer isApplied;
    @SerializedName("is_view")
    @Expose
    private Integer isView;
    @SerializedName("is_save")
    @Expose
    private Integer isSave;
    @SerializedName("jobs_logo_path")
    @Expose
    private String jobsLogoPath;
    public final static Creator<JobInfo> CREATOR = new Creator<JobInfo>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobInfo createFromParcel(Parcel in) {
            return new JobInfo(in);
        }

        public JobInfo[] newArray(int size) {
            return (new JobInfo[size]);
        }

    }
    ;

    protected JobInfo(Parcel in) {
        this.jmJobId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmCode = ((String) in.readValue((String.class.getClassLoader())));
        this.jmType = ((String) in.readValue((String.class.getClassLoader())));
        this.jmUmUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.jmIcaCategoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmIscSubCategoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmJtTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmShortDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.jmFullDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.jmRequirementDetails = ((String) in.readValue((String.class.getClassLoader())));
        this.jmStartDate = ((String) in.readValue((String.class.getClassLoader())));
        this.jmEndDate = ((String) in.readValue((String.class.getClassLoader())));
        this.jmWorkType = ((String) in.readValue((String.class.getClassLoader())));
        this.jmWorkHour = ((String) in.readValue((String.class.getClassLoader())));
        this.jmSalaryType = ((String) in.readValue((String.class.getClassLoader())));
        this.jmSalaryFrom = ((String) in.readValue((String.class.getClassLoader())));
        this.jmSalaryTo = ((String) in.readValue((String.class.getClassLoader())));
        this.jmSalaryDisplay = ((String) in.readValue((String.class.getClassLoader())));
        this.jmPayment = ((String) in.readValue((String.class.getClassLoader())));
        this.jmPaymentDisplay = ((String) in.readValue((String.class.getClassLoader())));
        this.jmVacancies = ((String) in.readValue((String.class.getClassLoader())));
        this.jmShuUrlId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmContactName = ((String) in.readValue((String.class.getClassLoader())));
        this.jmContactEmail = ((String) in.readValue((String.class.getClassLoader())));
        this.jmContactPhone = ((String) in.readValue((String.class.getClassLoader())));
        this.jmAlternateContactName = ((String) in.readValue((String.class.getClassLoader())));
        this.jmAlternateContactEmail = ((String) in.readValue((String.class.getClassLoader())));
        this.jmAlternateContactPhone = ((String) in.readValue((String.class.getClassLoader())));
        this.jmQuestion = ((String) in.readValue((String.class.getClassLoader())));
        this.jmTrademeId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmApplyLink = ((String) in.readValue((String.class.getClassLoader())));
        this.jmJtmCode = ((String) in.readValue((String.class.getClassLoader())));
        this.jmFeatured = ((String) in.readValue((String.class.getClassLoader())));
        this.jmStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.jmCreatedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.jmCreatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.jmUpdatedBy = ((String) in.readValue((String.class.getClassLoader())));
        this.jmUpdatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.jmActive = ((String) in.readValue((String.class.getClassLoader())));
        this.jmOldId = ((String) in.readValue((String.class.getClassLoader())));
        this.jloLocationId = ((String) in.readValue((String.class.getClassLoader())));
        this.jloJmJobId = ((String) in.readValue((String.class.getClassLoader())));
        this.jloType = ((String) in.readValue((String.class.getClassLoader())));
        this.jloReRegionId = ((String) in.readValue((String.class.getClassLoader())));
        this.jloCiCityId = ((String) in.readValue((String.class.getClassLoader())));
        this.jloSuSuburbId = ((String) in.readValue((String.class.getClassLoader())));
        this.jloAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.jloLattitude = ((String) in.readValue((String.class.getClassLoader())));
        this.jloLongitude = ((String) in.readValue((String.class.getClassLoader())));
        this.jloActive = ((String) in.readValue((String.class.getClassLoader())));
        this.jloOldId = ((String) in.readValue((String.class.getClassLoader())));
        this.icaName = ((String) in.readValue((String.class.getClassLoader())));
        this.iscName = ((String) in.readValue((String.class.getClassLoader())));
        this.regionName = ((String) in.readValue((String.class.getClassLoader())));
        this.cityName = ((String) in.readValue((String.class.getClassLoader())));
        this.suburbName = ((String) in.readValue((String.class.getClassLoader())));
        this.umUserId = ((String) in.readValue((String.class.getClassLoader())));
        this.postBy = ((String) in.readValue((String.class.getClassLoader())));
        this.postByCode = ((String) in.readValue((String.class.getClassLoader())));
        this.postByUserType = ((String) in.readValue((String.class.getClassLoader())));
        this.postByProfilePic = ((String) in.readValue((String.class.getClassLoader())));
        this.jmSalaryTypeName = ((String) in.readValue((String.class.getClassLoader())));
        this.jmJtTypeName = ((String) in.readValue((String.class.getClassLoader())));
        this.createdOn = ((String) in.readValue((String.class.getClassLoader())));
        this.isApplied = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isView = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isSave = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.jobsLogoPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobInfo() {
    }

    public String getJmJobId() {
        return jmJobId;
    }

    public void setJmJobId(String jmJobId) {
        this.jmJobId = jmJobId;
    }

    public String getJmCode() {
        return jmCode;
    }

    public void setJmCode(String jmCode) {
        this.jmCode = jmCode;
    }

    public String getJmType() {
        return jmType;
    }

    public void setJmType(String jmType) {
        this.jmType = jmType;
    }

    public String getJmUmUserId() {
        return jmUmUserId;
    }

    public void setJmUmUserId(String jmUmUserId) {
        this.jmUmUserId = jmUmUserId;
    }

    public String getJmTitle() {
        return jmTitle;
    }

    public void setJmTitle(String jmTitle) {
        this.jmTitle = jmTitle;
    }

    public String getJmIcaCategoryId() {
        return jmIcaCategoryId;
    }

    public void setJmIcaCategoryId(String jmIcaCategoryId) {
        this.jmIcaCategoryId = jmIcaCategoryId;
    }

    public String getJmIscSubCategoryId() {
        return jmIscSubCategoryId;
    }

    public void setJmIscSubCategoryId(String jmIscSubCategoryId) {
        this.jmIscSubCategoryId = jmIscSubCategoryId;
    }

    public String getJmJtTypeId() {
        return jmJtTypeId;
    }

    public void setJmJtTypeId(String jmJtTypeId) {
        this.jmJtTypeId = jmJtTypeId;
    }

    public String getJmShortDescription() {
        return jmShortDescription;
    }

    public void setJmShortDescription(String jmShortDescription) {
        this.jmShortDescription = jmShortDescription;
    }

    public String getJmFullDescription() {
        return jmFullDescription;
    }

    public void setJmFullDescription(String jmFullDescription) {
        this.jmFullDescription = jmFullDescription;
    }

    public String getJmRequirementDetails() {
        return jmRequirementDetails;
    }

    public void setJmRequirementDetails(String jmRequirementDetails) {
        this.jmRequirementDetails = jmRequirementDetails;
    }

    public String getJmStartDate() {
        return jmStartDate;
    }

    public void setJmStartDate(String jmStartDate) {
        this.jmStartDate = jmStartDate;
    }

    public String getJmEndDate() {
        return jmEndDate;
    }

    public void setJmEndDate(String jmEndDate) {
        this.jmEndDate = jmEndDate;
    }

    public String getJmWorkType() {
        return jmWorkType;
    }

    public void setJmWorkType(String jmWorkType) {
        this.jmWorkType = jmWorkType;
    }

    public String getJmWorkHour() {
        return jmWorkHour;
    }

    public void setJmWorkHour(String jmWorkHour) {
        this.jmWorkHour = jmWorkHour;
    }

    public String getJmSalaryType() {
        return jmSalaryType;
    }

    public void setJmSalaryType(String jmSalaryType) {
        this.jmSalaryType = jmSalaryType;
    }

    public String getJmSalaryFrom() {
        return jmSalaryFrom;
    }

    public void setJmSalaryFrom(String jmSalaryFrom) {
        this.jmSalaryFrom = jmSalaryFrom;
    }

    public String getJmSalaryTo() {
        return jmSalaryTo;
    }

    public void setJmSalaryTo(String jmSalaryTo) {
        this.jmSalaryTo = jmSalaryTo;
    }

    public String getJmSalaryDisplay() {
        return jmSalaryDisplay;
    }

    public void setJmSalaryDisplay(String jmSalaryDisplay) {
        this.jmSalaryDisplay = jmSalaryDisplay;
    }

    public String getJmPayment() {
        return jmPayment;
    }

    public void setJmPayment(String jmPayment) {
        this.jmPayment = jmPayment;
    }

    public String getJmPaymentDisplay() {
        return jmPaymentDisplay;
    }

    public void setJmPaymentDisplay(String jmPaymentDisplay) {
        this.jmPaymentDisplay = jmPaymentDisplay;
    }

    public String getJmVacancies() {
        return jmVacancies;
    }

    public void setJmVacancies(String jmVacancies) {
        this.jmVacancies = jmVacancies;
    }

    public String getJmShuUrlId() {
        return jmShuUrlId;
    }

    public void setJmShuUrlId(String jmShuUrlId) {
        this.jmShuUrlId = jmShuUrlId;
    }

    public String getJmContactName() {
        return jmContactName;
    }

    public void setJmContactName(String jmContactName) {
        this.jmContactName = jmContactName;
    }

    public String getJmContactEmail() {
        return jmContactEmail;
    }

    public void setJmContactEmail(String jmContactEmail) {
        this.jmContactEmail = jmContactEmail;
    }

    public String getJmContactPhone() {
        return jmContactPhone;
    }

    public void setJmContactPhone(String jmContactPhone) {
        this.jmContactPhone = jmContactPhone;
    }

    public String getJmAlternateContactName() {
        return jmAlternateContactName;
    }

    public void setJmAlternateContactName(String jmAlternateContactName) {
        this.jmAlternateContactName = jmAlternateContactName;
    }

    public String getJmAlternateContactEmail() {
        return jmAlternateContactEmail;
    }

    public void setJmAlternateContactEmail(String jmAlternateContactEmail) {
        this.jmAlternateContactEmail = jmAlternateContactEmail;
    }

    public String getJmAlternateContactPhone() {
        return jmAlternateContactPhone;
    }

    public void setJmAlternateContactPhone(String jmAlternateContactPhone) {
        this.jmAlternateContactPhone = jmAlternateContactPhone;
    }

    public String getJmQuestion() {
        return jmQuestion;
    }

    public void setJmQuestion(String jmQuestion) {
        this.jmQuestion = jmQuestion;
    }

    public String getJmTrademeId() {
        return jmTrademeId;
    }

    public void setJmTrademeId(String jmTrademeId) {
        this.jmTrademeId = jmTrademeId;
    }

    public String getJmApplyLink() {
        return jmApplyLink;
    }

    public void setJmApplyLink(String jmApplyLink) {
        this.jmApplyLink = jmApplyLink;
    }

    public String getJmJtmCode() {
        return jmJtmCode;
    }

    public void setJmJtmCode(String jmJtmCode) {
        this.jmJtmCode = jmJtmCode;
    }

    public String getJmFeatured() {
        return jmFeatured;
    }

    public void setJmFeatured(String jmFeatured) {
        this.jmFeatured = jmFeatured;
    }

    public String getJmStatus() {
        return jmStatus;
    }

    public void setJmStatus(String jmStatus) {
        this.jmStatus = jmStatus;
    }

    public String getJmCreatedBy() {
        return jmCreatedBy;
    }

    public void setJmCreatedBy(String jmCreatedBy) {
        this.jmCreatedBy = jmCreatedBy;
    }

    public String getJmCreatedOn() {
        return jmCreatedOn;
    }

    public void setJmCreatedOn(String jmCreatedOn) {
        this.jmCreatedOn = jmCreatedOn;
    }

    public String getJmUpdatedBy() {
        return jmUpdatedBy;
    }

    public void setJmUpdatedBy(String jmUpdatedBy) {
        this.jmUpdatedBy = jmUpdatedBy;
    }

    public String getJmUpdatedOn() {
        return jmUpdatedOn;
    }

    public void setJmUpdatedOn(String jmUpdatedOn) {
        this.jmUpdatedOn = jmUpdatedOn;
    }

    public String getJmActive() {
        return jmActive;
    }

    public void setJmActive(String jmActive) {
        this.jmActive = jmActive;
    }

    public String getJmOldId() {
        return jmOldId;
    }

    public void setJmOldId(String jmOldId) {
        this.jmOldId = jmOldId;
    }

    public String getJloLocationId() {
        return jloLocationId;
    }

    public void setJloLocationId(String jloLocationId) {
        this.jloLocationId = jloLocationId;
    }

    public String getJloJmJobId() {
        return jloJmJobId;
    }

    public void setJloJmJobId(String jloJmJobId) {
        this.jloJmJobId = jloJmJobId;
    }

    public String getJloType() {
        return jloType;
    }

    public void setJloType(String jloType) {
        this.jloType = jloType;
    }

    public String getJloReRegionId() {
        return jloReRegionId;
    }

    public void setJloReRegionId(String jloReRegionId) {
        this.jloReRegionId = jloReRegionId;
    }

    public String getJloCiCityId() {
        return jloCiCityId;
    }

    public void setJloCiCityId(String jloCiCityId) {
        this.jloCiCityId = jloCiCityId;
    }

    public String getJloSuSuburbId() {
        return jloSuSuburbId;
    }

    public void setJloSuSuburbId(String jloSuSuburbId) {
        this.jloSuSuburbId = jloSuSuburbId;
    }

    public String getJloAddress() {
        return jloAddress;
    }

    public void setJloAddress(String jloAddress) {
        this.jloAddress = jloAddress;
    }

    public String getJloLattitude() {
        return jloLattitude;
    }

    public void setJloLattitude(String jloLattitude) {
        this.jloLattitude = jloLattitude;
    }

    public String getJloLongitude() {
        return jloLongitude;
    }

    public void setJloLongitude(String jloLongitude) {
        this.jloLongitude = jloLongitude;
    }

    public String getJloActive() {
        return jloActive;
    }

    public void setJloActive(String jloActive) {
        this.jloActive = jloActive;
    }

    public String getJloOldId() {
        return jloOldId;
    }

    public void setJloOldId(String jloOldId) {
        this.jloOldId = jloOldId;
    }

    public String getIcaName() {
        return icaName;
    }

    public void setIcaName(String icaName) {
        this.icaName = icaName;
    }

    public String getIscName() {
        return iscName;
    }

    public void setIscName(String iscName) {
        this.iscName = iscName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSuburbName() {
        return suburbName;
    }

    public void setSuburbName(String suburbName) {
        this.suburbName = suburbName;
    }

    public String getUmUserId() {
        return umUserId;
    }

    public void setUmUserId(String umUserId) {
        this.umUserId = umUserId;
    }

    public String getPostBy() {
        return postBy;
    }

    public void setPostBy(String postBy) {
        this.postBy = postBy;
    }

    public String getPostByCode() {
        return postByCode;
    }

    public void setPostByCode(String postByCode) {
        this.postByCode = postByCode;
    }

    public String getPostByUserType() {
        return postByUserType;
    }

    public void setPostByUserType(String postByUserType) {
        this.postByUserType = postByUserType;
    }

    public String getPostByProfilePic() {
        return postByProfilePic;
    }

    public void setPostByProfilePic(String postByProfilePic) {
        this.postByProfilePic = postByProfilePic;
    }

    public String getJmSalaryTypeName() {
        return jmSalaryTypeName;
    }

    public void setJmSalaryTypeName(String jmSalaryTypeName) {
        this.jmSalaryTypeName = jmSalaryTypeName;
    }

    public String getJmJtTypeName() {
        return jmJtTypeName;
    }

    public void setJmJtTypeName(String jmJtTypeName) {
        this.jmJtTypeName = jmJtTypeName;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getIsApplied() {
        return isApplied;
    }

    public void setIsApplied(Integer isApplied) {
        this.isApplied = isApplied;
    }

    public Integer getIsView() {
        return isView;
    }

    public void setIsView(Integer isView) {
        this.isView = isView;
    }

    public Integer getIsSave() {
        return isSave;
    }

    public void setIsSave(Integer isSave) {
        this.isSave = isSave;
    }

    public String getJobsLogoPath() {
        return jobsLogoPath;
    }

    public void setJobsLogoPath(String jobsLogoPath) {
        this.jobsLogoPath = jobsLogoPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(jmJobId);
        dest.writeValue(jmCode);
        dest.writeValue(jmType);
        dest.writeValue(jmUmUserId);
        dest.writeValue(jmTitle);
        dest.writeValue(jmIcaCategoryId);
        dest.writeValue(jmIscSubCategoryId);
        dest.writeValue(jmJtTypeId);
        dest.writeValue(jmShortDescription);
        dest.writeValue(jmFullDescription);
        dest.writeValue(jmRequirementDetails);
        dest.writeValue(jmStartDate);
        dest.writeValue(jmEndDate);
        dest.writeValue(jmWorkType);
        dest.writeValue(jmWorkHour);
        dest.writeValue(jmSalaryType);
        dest.writeValue(jmSalaryFrom);
        dest.writeValue(jmSalaryTo);
        dest.writeValue(jmSalaryDisplay);
        dest.writeValue(jmPayment);
        dest.writeValue(jmPaymentDisplay);
        dest.writeValue(jmVacancies);
        dest.writeValue(jmShuUrlId);
        dest.writeValue(jmContactName);
        dest.writeValue(jmContactEmail);
        dest.writeValue(jmContactPhone);
        dest.writeValue(jmAlternateContactName);
        dest.writeValue(jmAlternateContactEmail);
        dest.writeValue(jmAlternateContactPhone);
        dest.writeValue(jmQuestion);
        dest.writeValue(jmTrademeId);
        dest.writeValue(jmApplyLink);
        dest.writeValue(jmJtmCode);
        dest.writeValue(jmFeatured);
        dest.writeValue(jmStatus);
        dest.writeValue(jmCreatedBy);
        dest.writeValue(jmCreatedOn);
        dest.writeValue(jmUpdatedBy);
        dest.writeValue(jmUpdatedOn);
        dest.writeValue(jmActive);
        dest.writeValue(jmOldId);
        dest.writeValue(jloLocationId);
        dest.writeValue(jloJmJobId);
        dest.writeValue(jloType);
        dest.writeValue(jloReRegionId);
        dest.writeValue(jloCiCityId);
        dest.writeValue(jloSuSuburbId);
        dest.writeValue(jloAddress);
        dest.writeValue(jloLattitude);
        dest.writeValue(jloLongitude);
        dest.writeValue(jloActive);
        dest.writeValue(jloOldId);
        dest.writeValue(icaName);
        dest.writeValue(iscName);
        dest.writeValue(regionName);
        dest.writeValue(cityName);
        dest.writeValue(suburbName);
        dest.writeValue(umUserId);
        dest.writeValue(postBy);
        dest.writeValue(postByCode);
        dest.writeValue(postByUserType);
        dest.writeValue(postByProfilePic);
        dest.writeValue(jmSalaryTypeName);
        dest.writeValue(jmJtTypeName);
        dest.writeValue(createdOn);
        dest.writeValue(isApplied);
        dest.writeValue(isView);
        dest.writeValue(isSave);
        dest.writeValue(jobsLogoPath);
    }

    public int describeContents() {
        return  0;
    }

}
