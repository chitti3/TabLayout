
package com.example.youthhub.resModel.jobs.applyJob;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SalaryRange implements Parcelable
{

    @SerializedName("min_range")
    @Expose
    private Integer minRange;
    @SerializedName("max_range")
    @Expose
    private Integer maxRange;
    public final static Creator<SalaryRange> CREATOR = new Creator<SalaryRange>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SalaryRange createFromParcel(Parcel in) {
            return new SalaryRange(in);
        }

        public SalaryRange[] newArray(int size) {
            return (new SalaryRange[size]);
        }

    }
    ;

    protected SalaryRange(Parcel in) {
        this.minRange = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.maxRange = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public SalaryRange() {
    }

    public Integer getMinRange() {
        return minRange;
    }

    public void setMinRange(Integer minRange) {
        this.minRange = minRange;
    }

    public Integer getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(Integer maxRange) {
        this.maxRange = maxRange;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(minRange);
        dest.writeValue(maxRange);
    }

    public int describeContents() {
        return  0;
    }

}
