
package com.example.youthhub.resModel.jobs.listmaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobCitylist implements Parcelable
{

    @SerializedName("ci_city_id")
    @Expose
    private String ciCityId;
    @SerializedName("ci_name")
    @Expose
    private String ciName;
    public final static Creator<JobCitylist> CREATOR = new Creator<JobCitylist>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobCitylist createFromParcel(Parcel in) {
            return new JobCitylist(in);
        }

        public JobCitylist[] newArray(int size) {
            return (new JobCitylist[size]);
        }

    }
    ;

    protected JobCitylist(Parcel in) {
        this.ciCityId = ((String) in.readValue((String.class.getClassLoader())));
        this.ciName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobCitylist() {
    }

    public String getCiCityId() {
        return ciCityId;
    }

    public void setCiCityId(String ciCityId) {
        this.ciCityId = ciCityId;
    }

    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ciCityId);
        dest.writeValue(ciName);
    }

    public int describeContents() {
        return  0;
    }

    @NonNull
    @Override
    public String toString() {
        return ciName;
    }

}
