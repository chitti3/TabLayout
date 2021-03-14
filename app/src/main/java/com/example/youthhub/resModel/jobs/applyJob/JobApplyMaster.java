
package com.example.youthhub.resModel.jobs.applyJob;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobApplyMaster implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private JobApplyMasterData jobApplyMasterData;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<JobApplyMaster> CREATOR = new Creator<JobApplyMaster>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobApplyMaster createFromParcel(Parcel in) {
            return new JobApplyMaster(in);
        }

        public JobApplyMaster[] newArray(int size) {
            return (new JobApplyMaster[size]);
        }

    }
    ;

    protected JobApplyMaster(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.jobApplyMasterData = ((JobApplyMasterData) in.readValue((JobApplyMasterData.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobApplyMaster() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public JobApplyMasterData getJobApplyMasterData() {
        return jobApplyMasterData;
    }

    public void setJobApplyMasterData(JobApplyMasterData jobApplyMasterData) {
        this.jobApplyMasterData = jobApplyMasterData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(jobApplyMasterData);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
