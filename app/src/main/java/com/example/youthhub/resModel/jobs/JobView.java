
package com.example.youthhub.resModel.jobs;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobView implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private JobData jobData;
    @SerializedName("status_img")
    @Expose
    private String statusImg;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<JobView> CREATOR = new Creator<JobView>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobView createFromParcel(Parcel in) {
            return new JobView(in);
        }

        public JobView[] newArray(int size) {
            return (new JobView[size]);
        }

    }
    ;

    protected JobView(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.jobData = ((JobData) in.readValue((JobData.class.getClassLoader())));
        this.statusImg = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobView() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public JobData getJobData() {
        return jobData;
    }

    public void setJobData(JobData jobData) {
        this.jobData = jobData;
    }

    public String getStatusImg() {
        return statusImg;
    }

    public void setStatusImg(String statusImg) {
        this.statusImg = statusImg;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(jobData);
        dest.writeValue(statusImg);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
