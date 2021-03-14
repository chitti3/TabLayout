
package com.example.youthhub.resModel.jobs;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobsData implements Parcelable
{

    @SerializedName("jobs_count")
    @Expose
    private Integer jobsCount;
    @SerializedName("jobs_list")
    @Expose
    private List<JobsList> jobsList = null;
    public final static Creator<JobsData> CREATOR = new Creator<JobsData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobsData createFromParcel(Parcel in) {
            return new JobsData(in);
        }

        public JobsData[] newArray(int size) {
            return (new JobsData[size]);
        }

    }
    ;

    protected JobsData(Parcel in) {
        this.jobsCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.jobsList, (com.example.youthhub.resModel.jobs.JobsList.class.getClassLoader()));
    }

    public JobsData() {
    }

    public Integer getJobsCount() {
        return jobsCount;
    }

    public void setJobsCount(Integer jobsCount) {
        this.jobsCount = jobsCount;
    }

    public List<JobsList> getJobsList() {
        return jobsList;
    }

    public void setJobsList(List<JobsList> jobsList) {
        this.jobsList = jobsList;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(jobsCount);
        dest.writeList(jobsList);
    }

    public int describeContents() {
        return  0;
    }

}
