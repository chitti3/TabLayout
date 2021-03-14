
package com.example.youthhub.resModel.jobs.applyJob;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobApplyMasterData implements Parcelable
{

    @SerializedName("cvs")
    @Expose
    private List<Cv> cvs = new ArrayList<>();
    @SerializedName("salary_range")
    @Expose
    private SalaryRange salaryRange;
    @SerializedName("is_trademe_job")
    @Expose
    private Integer isTrademeJob;
    @SerializedName("apply_link")
    @Expose
    private String applyLink;
    public final static Creator<JobApplyMasterData> CREATOR = new Creator<JobApplyMasterData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobApplyMasterData createFromParcel(Parcel in) {
            return new JobApplyMasterData(in);
        }

        public JobApplyMasterData[] newArray(int size) {
            return (new JobApplyMasterData[size]);
        }

    }
    ;

    protected JobApplyMasterData(Parcel in) {
        in.readList(this.cvs, (com.example.youthhub.resModel.jobs.applyJob.Cv.class.getClassLoader()));
        this.salaryRange = ((SalaryRange) in.readValue((SalaryRange.class.getClassLoader())));
        this.isTrademeJob = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.applyLink = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobApplyMasterData() {
    }

    public List<Cv> getCvs() {
        return cvs;
    }

    public void setCvs(List<Cv> cvs) {
        this.cvs = cvs;
    }

    public SalaryRange getSalaryRange() {
        return salaryRange;
    }

    public void setSalaryRange(SalaryRange salaryRange) {
        this.salaryRange = salaryRange;
    }

    public Integer getIsTrademeJob() {
        return isTrademeJob;
    }

    public void setIsTrademeJob(Integer isTrademeJob) {
        this.isTrademeJob = isTrademeJob;
    }

    public String getApplyLink() {
        return applyLink;
    }

    public void setApplyLink(String applyLink) {
        this.applyLink = applyLink;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(cvs);
        dest.writeValue(salaryRange);
        dest.writeValue(isTrademeJob);
        dest.writeValue(applyLink);
    }

    public int describeContents() {
        return  0;
    }

}
