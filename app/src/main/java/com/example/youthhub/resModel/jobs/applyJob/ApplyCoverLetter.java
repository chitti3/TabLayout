
package com.example.youthhub.resModel.jobs.applyJob;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApplyCoverLetter implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private ApplyCoverLetterData applyCoverLetterData;
    public final static Creator<ApplyCoverLetter> CREATOR = new Creator<ApplyCoverLetter>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ApplyCoverLetter createFromParcel(Parcel in) {
            return new ApplyCoverLetter(in);
        }

        public ApplyCoverLetter[] newArray(int size) {
            return (new ApplyCoverLetter[size]);
        }

    }
    ;

    protected ApplyCoverLetter(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.applyCoverLetterData = ((ApplyCoverLetterData) in.readValue((ApplyCoverLetterData.class.getClassLoader())));
    }

    public ApplyCoverLetter() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApplyCoverLetterData getApplyCoverLetterData() {
        return applyCoverLetterData;
    }

    public void setApplyCoverLetterData(ApplyCoverLetterData applyCoverLetterData) {
        this.applyCoverLetterData = applyCoverLetterData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(message);
        dest.writeValue(applyCoverLetterData);
    }

    public int describeContents() {
        return  0;
    }

}
