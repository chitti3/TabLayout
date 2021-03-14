
package com.example.youthhub.resModel.myjobs;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyJobs implements Parcelable
{

    @SerializedName("jm_job_id")
    @Expose
    private String jmJobId;
    @SerializedName("jm_title")
    @Expose
    private String jmTitle;
    @SerializedName("jm_code")
    @Expose
    private String jmCode;
    @SerializedName("jm_end_date")
    @Expose
    private String jmEndDate;
    @SerializedName("jap_date")
    @Expose
    private String japDate;
    @SerializedName("jap_sm_status_id")
    @Expose
    private String japSmStatusId;
    @SerializedName("re_name")
    @Expose
    private String reName;
    @SerializedName("um_name")
    @Expose
    private String umName;
    @SerializedName("live_status")
    @Expose
    private String liveStatus;
    @SerializedName("job_status")
    @Expose
    private String jobStatus;
    public final static Creator<MyJobs> CREATOR = new Creator<MyJobs>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MyJobs createFromParcel(Parcel in) {
            return new MyJobs(in);
        }

        public MyJobs[] newArray(int size) {
            return (new MyJobs[size]);
        }

    }
    ;

    protected MyJobs(Parcel in) {
        this.jmJobId = ((String) in.readValue((String.class.getClassLoader())));
        this.jmTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.jmCode = ((String) in.readValue((String.class.getClassLoader())));
        this.jmEndDate = ((String) in.readValue((String.class.getClassLoader())));
        this.japDate = ((String) in.readValue((String.class.getClassLoader())));
        this.japSmStatusId = ((String) in.readValue((String.class.getClassLoader())));
        this.reName = ((String) in.readValue((String.class.getClassLoader())));
        this.umName = ((String) in.readValue((String.class.getClassLoader())));
        this.liveStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.jobStatus = ((String) in.readValue((String.class.getClassLoader())));
    }

    public MyJobs() {
    }

    public String getJmJobId() {
        return jmJobId;
    }

    public void setJmJobId(String jmJobId) {
        this.jmJobId = jmJobId;
    }

    public String getJmTitle() {
        return jmTitle;
    }

    public void setJmTitle(String jmTitle) {
        this.jmTitle = jmTitle;
    }

    public String getJmCode() {
        return jmCode;
    }

    public void setJmCode(String jmCode) {
        this.jmCode = jmCode;
    }

    public String getJmEndDate() {
        return jmEndDate;
    }

    public void setJmEndDate(String jmEndDate) {
        this.jmEndDate = jmEndDate;
    }

    public String getJapDate() {
        return japDate;
    }

    public void setJapDate(String japDate) {
        this.japDate = japDate;
    }

    public String getJapSmStatusId() {
        return japSmStatusId;
    }

    public void setJapSmStatusId(String japSmStatusId) {
        this.japSmStatusId = japSmStatusId;
    }

    public String getReName() {
        return reName;
    }

    public void setReName(String reName) {
        this.reName = reName;
    }

    public String getUmName() {
        return umName;
    }

    public void setUmName(String umName) {
        this.umName = umName;
    }

    public String getLiveStatus() {
        return liveStatus;
    }

    public void setLiveStatus(String liveStatus) {
        this.liveStatus = liveStatus;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(jmJobId);
        dest.writeValue(jmTitle);
        dest.writeValue(jmCode);
        dest.writeValue(jmEndDate);
        dest.writeValue(japDate);
        dest.writeValue(japSmStatusId);
        dest.writeValue(reName);
        dest.writeValue(umName);
        dest.writeValue(liveStatus);
        dest.writeValue(jobStatus);
    }

    public int describeContents() {
        return  0;
    }

}
