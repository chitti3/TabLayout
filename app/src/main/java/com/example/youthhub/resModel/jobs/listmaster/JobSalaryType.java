
package com.example.youthhub.resModel.jobs.listmaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobSalaryType implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<JobSalaryType> CREATOR = new Creator<JobSalaryType>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobSalaryType createFromParcel(Parcel in) {
            return new JobSalaryType(in);
        }

        public JobSalaryType[] newArray(int size) {
            return (new JobSalaryType[size]);
        }

    }
    ;

    protected JobSalaryType(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobSalaryType() {
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
