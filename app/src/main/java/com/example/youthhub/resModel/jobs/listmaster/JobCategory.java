
package com.example.youthhub.resModel.jobs.listmaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobCategory implements Parcelable
{

    @SerializedName("ica_category_id")
    @Expose
    private String icaCategoryId;
    @SerializedName("ica_name")
    @Expose
    private String icaName;
    public final static Creator<JobCategory> CREATOR = new Creator<JobCategory>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobCategory createFromParcel(Parcel in) {
            return new JobCategory(in);
        }

        public JobCategory[] newArray(int size) {
            return (new JobCategory[size]);
        }

    }
    ;

    protected JobCategory(Parcel in) {
        this.icaCategoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.icaName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobCategory() {
    }

    public String getIcaCategoryId() {
        return icaCategoryId;
    }

    public void setIcaCategoryId(String icaCategoryId) {
        this.icaCategoryId = icaCategoryId;
    }

    public String getIcaName() {
        return icaName;
    }

    public void setIcaName(String icaName) {
        this.icaName = icaName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(icaCategoryId);
        dest.writeValue(icaName);
    }

    public int describeContents() {
        return  0;
    }

    @NonNull
    @Override
    public String toString() {
        return icaName;
    }
}
