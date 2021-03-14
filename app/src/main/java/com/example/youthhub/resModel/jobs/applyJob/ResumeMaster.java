
package com.example.youthhub.resModel.jobs.applyJob;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResumeMaster implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private ResumeMasterData resumeMasterData;
    public final static Creator<ResumeMaster> CREATOR = new Creator<ResumeMaster>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ResumeMaster createFromParcel(Parcel in) {
            return new ResumeMaster(in);
        }

        public ResumeMaster[] newArray(int size) {
            return (new ResumeMaster[size]);
        }

    }
    ;

    protected ResumeMaster(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.resumeMasterData = ((ResumeMasterData) in.readValue((ResumeMasterData.class.getClassLoader())));
    }

    public ResumeMaster() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ResumeMasterData getResumeMasterData() {
        return resumeMasterData;
    }

    public void setResumeMasterData(ResumeMasterData resumeMasterData) {
        this.resumeMasterData = resumeMasterData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(resumeMasterData);
    }

    public int describeContents() {
        return  0;
    }

}
