
package com.example.youthhub.resModel.jobs.listmaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobSubcategory implements Parcelable
{

    @SerializedName("isc_sub_category_id")
    @Expose
    private String iscSubCategoryId;
    @SerializedName("isc_name")
    @Expose
    private String iscName;
    public final static Creator<JobSubcategory> CREATOR = new Creator<JobSubcategory>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobSubcategory createFromParcel(Parcel in) {
            return new JobSubcategory(in);
        }

        public JobSubcategory[] newArray(int size) {
            return (new JobSubcategory[size]);
        }

    }
    ;

    protected JobSubcategory(Parcel in) {
        this.iscSubCategoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.iscName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobSubcategory() {
    }

    public String getIscSubCategoryId() {
        return iscSubCategoryId;
    }

    public void setIscSubCategoryId(String iscSubCategoryId) {
        this.iscSubCategoryId = iscSubCategoryId;
    }

    public String getIscName() {
        return iscName;
    }

    public void setIscName(String iscName) {
        this.iscName = iscName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(iscSubCategoryId);
        dest.writeValue(iscName);
    }

    public int describeContents() {
        return  0;
    }

    @NonNull
    @Override
    public String toString() {
        return iscName;
    }

}
