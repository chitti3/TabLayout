
package com.example.youthhub.resModel.jobs.listmaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobRegionslist implements Parcelable
{

    @SerializedName("re_region_id")
    @Expose
    private String reRegionId;
    @SerializedName("re_name")
    @Expose
    private String reName;
    public final static Creator<JobRegionslist> CREATOR = new Creator<JobRegionslist>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobRegionslist createFromParcel(Parcel in) {
            return new JobRegionslist(in);
        }

        public JobRegionslist[] newArray(int size) {
            return (new JobRegionslist[size]);
        }

    }
    ;

    protected JobRegionslist(Parcel in) {
        this.reRegionId = ((String) in.readValue((String.class.getClassLoader())));
        this.reName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobRegionslist() {
    }

    public String getReRegionId() {
        return reRegionId;
    }

    public void setReRegionId(String reRegionId) {
        this.reRegionId = reRegionId;
    }

    public String getReName() {
        return reName;
    }

    public void setReName(String reName) {
        this.reName = reName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(reRegionId);
        dest.writeValue(reName);
    }

    public int describeContents() {
        return  0;
    }

    @NonNull
    @Override
    public String toString() {
        return reName;
    }

}
