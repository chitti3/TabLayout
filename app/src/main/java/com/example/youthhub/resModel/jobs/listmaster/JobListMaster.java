
package com.example.youthhub.resModel.jobs.listmaster;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobListMaster implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private JobListMasterData jobListMasterData;
    public final static Creator<JobListMaster> CREATOR = new Creator<JobListMaster>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobListMaster createFromParcel(Parcel in) {
            return new JobListMaster(in);
        }

        public JobListMaster[] newArray(int size) {
            return (new JobListMaster[size]);
        }

    }
    ;

    protected JobListMaster(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.jobListMasterData = ((JobListMasterData) in.readValue((JobListMasterData.class.getClassLoader())));
    }

    public JobListMaster() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public JobListMasterData getJobListMasterData() {
        return jobListMasterData;
    }

    public void setJobListMasterData(JobListMasterData jobListMasterData) {
        this.jobListMasterData = jobListMasterData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(jobListMasterData);
    }

    public int describeContents() {
        return  0;
    }

}
