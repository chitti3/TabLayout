
package com.example.youthhub.resModel.jobs.listmaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobSalaryForHr implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<JobSalaryForHr> CREATOR = new Creator<JobSalaryForHr>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobSalaryForHr createFromParcel(Parcel in) {
            return new JobSalaryForHr(in);
        }

        public JobSalaryForHr[] newArray(int size) {
            return (new JobSalaryForHr[size]);
        }

    }
    ;

    protected JobSalaryForHr(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobSalaryForHr() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }

}
