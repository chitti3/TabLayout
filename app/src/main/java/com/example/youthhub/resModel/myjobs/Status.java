
package com.example.youthhub.resModel.myjobs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Status implements Parcelable
{

    @SerializedName("total_applications")
    @Expose
    private String totalApplications;
    @SerializedName("total_applied")
    @Expose
    private String totalApplied;
    @SerializedName("total_shortlist")
    @Expose
    private Integer totalShortlist;
    @SerializedName("total_interview")
    @Expose
    private String totalInterview;
    @SerializedName("total_selected")
    @Expose
    private String totalSelected;
    @SerializedName("total_declined")
    @Expose
    private String totalDeclined;
    public final static Creator<Status> CREATOR = new Creator<Status>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Status createFromParcel(Parcel in) {
            return new Status(in);
        }

        public Status[] newArray(int size) {
            return (new Status[size]);
        }

    }
            ;

    protected Status(Parcel in) {
        this.totalApplications = ((String) in.readValue((String.class.getClassLoader())));
        this.totalApplied = ((String) in.readValue((String.class.getClassLoader())));
        this.totalShortlist = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.totalInterview=((String) in.readValue((String.class.getClassLoader())));
        this.totalSelected = ((String) in.readValue((String.class.getClassLoader())));
        this.totalDeclined = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Status() {
    }

    public String getTotalApplications() {
        return totalApplications;
    }

    public void setTotalApplications(String totalApplications) {
        this.totalApplications = totalApplications;
    }

    public String getTotalApplied() {
        return totalApplied;
    }

    public void setTotalApplied(String totalApplied) {
        this.totalApplied = totalApplied;
    }

    public Integer getTotalShortlist() {
        return totalShortlist;
    }

    public String getTotalInterview() {
        return totalInterview;
    }

    public void setTotalInterview(String totalInterview) {
        this.totalInterview = totalInterview;
    }

    public void setTotalShortlist(Integer totalShortlist) {
        this.totalShortlist = totalShortlist;
    }

    public String getTotalSelected() {
        return totalSelected;
    }

    public void setTotalSelected(String totalSelected) {
        this.totalSelected = totalSelected;
    }

    public String getTotalDeclined() {
        return totalDeclined;
    }

    public void setTotalDeclined(String totalDeclined) {
        this.totalDeclined = totalDeclined;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalApplications);
        dest.writeValue(totalApplied);
        dest.writeValue(totalShortlist);
        dest.writeValue(totalInterview);
        dest.writeValue(totalSelected);
        dest.writeValue(totalDeclined);
    }

    public int describeContents() {
        return  0;
    }

}
