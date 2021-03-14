
package com.example.youthhub.resModel.post.postList;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobsList implements Parcelable
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
    @SerializedName("jm_apply_link")
    @Expose
    private String jmApplyLink;
    @SerializedName("jm_title")
    @Expose
    private String jmTitle;
    @SerializedName("jm_full_description")
    @Expose
    private String jmFullDescription;
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
    @SerializedName("jm_vacancies")
    @Expose
    private String jmVacancies;
    @SerializedName("jm_contact_detail")
    @Expose
    private String jmContactDetail;
    @SerializedName("jm_created_on")
    @Expose
    private String jmCreatedOn;
    @SerializedName("jm_jt_type_id")
    @Expose
    private String jmJtTypeId;
    @SerializedName("jm_ica_category_id")
    @Expose
    private String jmIcaCategoryId;
    @SerializedName("jm_requirement_details")
    @Expose
    private String jmRequirementDetails;
    @SerializedName("jlo_address")
    @Expose
    private String jloAddress;
    @SerializedName("jlo_re_region_id")
    @Expose
    private String jloReRegionId;
    @SerializedName("jm_type_name")
    @Expose
    private String jmTypeName;
    @SerializedName("jm_ica_category_name")
    @Expose
    private String jmIcaCategoryName;
    @SerializedName("jm_isc_sub_category_id")
    @Expose
    private String jmIscSubCategoryId;
    @SerializedName("jm_isc_sub_category_name")
    @Expose
    private String jmIscSubCategoryName;
    @SerializedName("jlo_re_region_name")
    @Expose
    private String jloReRegionName;
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
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("jobs_logo_path")
    @Expose
    private String jobsLogoPath;
    public final static Creator<JobsList> CREATOR = new Creator<JobsList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobsList createFromParcel(Parcel in) {
            return new JobsList(in);
        }

        public JobsList[] newArray(int size) {
            return (new JobsList[size]);
        }

    }
    ;

    protected JobsList(Parcel in) {
        this.jmJobId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmCode = ((String) in.readValue((String.class.getClassLoader())));
        this.jmType = ((String) in.readValue((String.class.getClassLoader())));
        this.jmApplyLink = ((String) in.readValue((String.class.getClassLoader())));
        this.jmTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.jmFullDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.jmStartDate = ((String) in.readValue((String.class.getClassLoader())));
        this.jmEndDate = ((String) in.readValue((String.class.getClassLoader())));
        this.jmWorkType = ((String) in.readValue((String.class.getClassLoader())));
        this.jmWorkHour = ((String) in.readValue((String.class.getClassLoader())));
        this.jmSalaryType = ((String) in.readValue((String.class.getClassLoader())));
        this.jmSalaryFrom = ((String) in.readValue((String.class.getClassLoader())));
        this.jmSalaryTo = ((String) in.readValue((String.class.getClassLoader())));
        this.jmVacancies = ((String) in.readValue((String.class.getClassLoader())));
        this.jmContactDetail = ((String) in.readValue((String.class.getClassLoader())));
        this.jmCreatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.jmJtTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmIcaCategoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmRequirementDetails = ((String) in.readValue((String.class.getClassLoader())));
        this.jloAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.jloReRegionId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmTypeName = ((String) in.readValue((String.class.getClassLoader())));
        this.jmIcaCategoryName = ((String) in.readValue((String.class.getClassLoader())));
        this.jmIscSubCategoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmIscSubCategoryName = ((String) in.readValue((String.class.getClassLoader())));
        this.jloReRegionName = ((String) in.readValue((String.class.getClassLoader())));
        this.postBy = ((String) in.readValue((String.class.getClassLoader())));
        this.postByCode = ((String) in.readValue((String.class.getClassLoader())));
        this.postByUserType = ((String) in.readValue((String.class.getClassLoader())));
        this.postByProfilePic = ((String) in.readValue((String.class.getClassLoader())));
        this.jmSalaryTypeName = ((String) in.readValue((String.class.getClassLoader())));
        this.createdOn = ((String) in.readValue((String.class.getClassLoader())));
        this.jobsLogoPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobsList() {
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

    public String getJmApplyLink() {
        return jmApplyLink;
    }

    public void setJmApplyLink(String jmApplyLink) {
        this.jmApplyLink = jmApplyLink;
    }

    public String getJmTitle() {
        return jmTitle;
    }

    public void setJmTitle(String jmTitle) {
        this.jmTitle = jmTitle;
    }

    public String getJmFullDescription() {
        return jmFullDescription;
    }

    public void setJmFullDescription(String jmFullDescription) {
        this.jmFullDescription = jmFullDescription;
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

    public String getJmVacancies() {
        return jmVacancies;
    }

    public void setJmVacancies(String jmVacancies) {
        this.jmVacancies = jmVacancies;
    }

    public String getJmContactDetail() {
        return jmContactDetail;
    }

    public void setJmContactDetail(String jmContactDetail) {
        this.jmContactDetail = jmContactDetail;
    }

    public String getJmCreatedOn() {
        return jmCreatedOn;
    }

    public void setJmCreatedOn(String jmCreatedOn) {
        this.jmCreatedOn = jmCreatedOn;
    }

    public String getJmJtTypeId() {
        return jmJtTypeId;
    }

    public void setJmJtTypeId(String jmJtTypeId) {
        this.jmJtTypeId = jmJtTypeId;
    }

    public String getJmIcaCategoryId() {
        return jmIcaCategoryId;
    }

    public void setJmIcaCategoryId(String jmIcaCategoryId) {
        this.jmIcaCategoryId = jmIcaCategoryId;
    }

    public String getJmRequirementDetails() {
        return jmRequirementDetails;
    }

    public void setJmRequirementDetails(String jmRequirementDetails) {
        this.jmRequirementDetails = jmRequirementDetails;
    }

    public String getJloAddress() {
        return jloAddress;
    }

    public void setJloAddress(String jloAddress) {
        this.jloAddress = jloAddress;
    }

    public String getJloReRegionId() {
        return jloReRegionId;
    }

    public void setJloReRegionId(String jloReRegionId) {
        this.jloReRegionId = jloReRegionId;
    }

    public String getJmTypeName() {
        return jmTypeName;
    }

    public void setJmTypeName(String jmTypeName) {
        this.jmTypeName = jmTypeName;
    }

    public String getJmIcaCategoryName() {
        return jmIcaCategoryName;
    }

    public void setJmIcaCategoryName(String jmIcaCategoryName) {
        this.jmIcaCategoryName = jmIcaCategoryName;
    }

    public String getJmIscSubCategoryId() {
        return jmIscSubCategoryId;
    }

    public void setJmIscSubCategoryId(String jmIscSubCategoryId) {
        this.jmIscSubCategoryId = jmIscSubCategoryId;
    }

    public String getJmIscSubCategoryName() {
        return jmIscSubCategoryName;
    }

    public void setJmIscSubCategoryName(String jmIscSubCategoryName) {
        this.jmIscSubCategoryName = jmIscSubCategoryName;
    }

    public String getJloReRegionName() {
        return jloReRegionName;
    }

    public void setJloReRegionName(String jloReRegionName) {
        this.jloReRegionName = jloReRegionName;
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

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
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
        dest.writeValue(jmApplyLink);
        dest.writeValue(jmTitle);
        dest.writeValue(jmFullDescription);
        dest.writeValue(jmStartDate);
        dest.writeValue(jmEndDate);
        dest.writeValue(jmWorkType);
        dest.writeValue(jmWorkHour);
        dest.writeValue(jmSalaryType);
        dest.writeValue(jmSalaryFrom);
        dest.writeValue(jmSalaryTo);
        dest.writeValue(jmVacancies);
        dest.writeValue(jmContactDetail);
        dest.writeValue(jmCreatedOn);
        dest.writeValue(jmJtTypeId);
        dest.writeValue(jmIcaCategoryId);
        dest.writeValue(jmRequirementDetails);
        dest.writeValue(jloAddress);
        dest.writeValue(jloReRegionId);
        dest.writeValue(jmTypeName);
        dest.writeValue(jmIcaCategoryName);
        dest.writeValue(jmIscSubCategoryId);
        dest.writeValue(jmIscSubCategoryName);
        dest.writeValue(jloReRegionName);
        dest.writeValue(postBy);
        dest.writeValue(postByCode);
        dest.writeValue(postByUserType);
        dest.writeValue(postByProfilePic);
        dest.writeValue(jmSalaryTypeName);
        dest.writeValue(createdOn);
        dest.writeValue(jobsLogoPath);
    }

    public int describeContents() {
        return  0;
    }

}
