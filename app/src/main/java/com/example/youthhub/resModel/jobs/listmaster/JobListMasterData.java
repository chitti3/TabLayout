
package com.example.youthhub.resModel.jobs.listmaster;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobListMasterData implements Parcelable
{

    @SerializedName("job_regionslist")
    @Expose
    private List<JobRegionslist> jobRegionslist = new ArrayList<>();
    @SerializedName("job_citylist")
    @Expose
    private List<JobCitylist> jobCitylist = new ArrayList<>();
    @SerializedName("job_categories")
    @Expose
    private List<JobCategory> jobCategories = new ArrayList<>();
    @SerializedName("job_subcategories")
    @Expose
    private List<JobSubcategory> jobSubcategories = new ArrayList<>();
    @SerializedName("job_types")
    @Expose
    private List<JobType> jobTypes = new ArrayList<>();
    @SerializedName("job_salary_type")
    @Expose
    private List<JobSalaryType> jobSalaryType = new ArrayList<>();
    @SerializedName("job_salary_for_hr")
    @Expose
    private List<JobSalaryForHr> jobSalaryForHr = new ArrayList<>();
    @SerializedName("job_salary_for_yr")
    @Expose
    private List<JobSalaryForYr> jobSalaryForYr = new ArrayList<>();
    public final static Creator<JobListMasterData> CREATOR = new Creator<JobListMasterData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobListMasterData createFromParcel(Parcel in) {
            return new JobListMasterData(in);
        }

        public JobListMasterData[] newArray(int size) {
            return (new JobListMasterData[size]);
        }

    }
    ;

    protected JobListMasterData(Parcel in) {
        in.readList(this.jobRegionslist, (com.example.youthhub.resModel.jobs.listmaster.JobRegionslist.class.getClassLoader()));
        in.readList(this.jobCitylist, (com.example.youthhub.resModel.jobs.listmaster.JobCitylist.class.getClassLoader()));
        in.readList(this.jobCategories, (com.example.youthhub.resModel.jobs.listmaster.JobCategory.class.getClassLoader()));
        in.readList(this.jobSubcategories, (com.example.youthhub.resModel.jobs.listmaster.JobSubcategory.class.getClassLoader()));
        in.readList(this.jobTypes, (com.example.youthhub.resModel.jobs.listmaster.JobType.class.getClassLoader()));
        in.readList(this.jobSalaryType, (com.example.youthhub.resModel.jobs.listmaster.JobSalaryType.class.getClassLoader()));
        in.readList(this.jobSalaryForHr, (com.example.youthhub.resModel.jobs.listmaster.JobSalaryForHr.class.getClassLoader()));
        in.readList(this.jobSalaryForYr, (com.example.youthhub.resModel.jobs.listmaster.JobSalaryForYr.class.getClassLoader()));
    }

    public JobListMasterData() {
    }

    public List<JobRegionslist> getJobRegionslist() {
        return jobRegionslist;
    }

    public void setJobRegionslist(List<JobRegionslist> jobRegionslist) {
        this.jobRegionslist = jobRegionslist;
    }

    public List<JobCitylist> getJobCitylist() {
        return jobCitylist;
    }

    public void setJobCitylist(List<JobCitylist> jobCitylist) {
        this.jobCitylist = jobCitylist;
    }

    public List<JobCategory> getJobCategories() {
        return jobCategories;
    }

    public void setJobCategories(List<JobCategory> jobCategories) {
        this.jobCategories = jobCategories;
    }

    public List<JobSubcategory> getJobSubcategories() {
        return jobSubcategories;
    }

    public void setJobSubcategories(List<JobSubcategory> jobSubcategories) {
        this.jobSubcategories = jobSubcategories;
    }

    public List<JobType> getJobTypes() {
        return jobTypes;
    }

    public void setJobTypes(List<JobType> jobTypes) {
        this.jobTypes = jobTypes;
    }

    public List<JobSalaryType> getJobSalaryType() {
        return jobSalaryType;
    }

    public void setJobSalaryType(List<JobSalaryType> jobSalaryType) {
        this.jobSalaryType = jobSalaryType;
    }

    public List<JobSalaryForHr> getJobSalaryForHr() {
        return jobSalaryForHr;
    }

    public void setJobSalaryForHr(List<JobSalaryForHr> jobSalaryForHr) {
        this.jobSalaryForHr = jobSalaryForHr;
    }

    public List<JobSalaryForYr> getJobSalaryForYr() {
        return jobSalaryForYr;
    }

    public void setJobSalaryForYr(List<JobSalaryForYr> jobSalaryForYr) {
        this.jobSalaryForYr = jobSalaryForYr;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(jobRegionslist);
        dest.writeList(jobCitylist);
        dest.writeList(jobCategories);
        dest.writeList(jobSubcategories);
        dest.writeList(jobTypes);
        dest.writeList(jobSalaryType);
        dest.writeList(jobSalaryForHr);
        dest.writeList(jobSalaryForYr);
    }

    public int describeContents() {
        return  0;
    }

}
