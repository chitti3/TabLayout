
package com.example.youthhub.resModel.jobs.applyJob;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cv implements Parcelable
{

    @SerializedName("ucv_cv_id")
    @Expose
    private String ucvCvId;
    @SerializedName("ucv_title")
    @Expose
    private String ucvTitle;
    public final static Creator<Cv> CREATOR = new Creator<Cv>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Cv createFromParcel(Parcel in) {
            return new Cv(in);
        }

        public Cv[] newArray(int size) {
            return (new Cv[size]);
        }

    }
    ;

    protected Cv(Parcel in) {
        this.ucvCvId = ((String) in.readValue((String.class.getClassLoader())));
        this.ucvTitle = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Cv() {
    }

    public String getUcvCvId() {
        return ucvCvId;
    }

    public void setUcvCvId(String ucvCvId) {
        this.ucvCvId = ucvCvId;
    }

    public String getUcvTitle() {
        return ucvTitle;
    }

    public void setUcvTitle(String ucvTitle) {
        this.ucvTitle = ucvTitle;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ucvCvId);
        dest.writeValue(ucvTitle);
    }

    public int describeContents() {
        return  0;
    }

    @NonNull
    @Override
    public String toString() {
        return ucvTitle;
    }
}
