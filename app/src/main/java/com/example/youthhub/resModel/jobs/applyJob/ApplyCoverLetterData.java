
package com.example.youthhub.resModel.jobs.applyJob;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApplyCoverLetterData implements Parcelable
{

    @SerializedName("user_cv")
    @Expose
    private UserCv userCv;
    public final static Creator<ApplyCoverLetterData> CREATOR = new Creator<ApplyCoverLetterData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ApplyCoverLetterData createFromParcel(Parcel in) {
            return new ApplyCoverLetterData(in);
        }

        public ApplyCoverLetterData[] newArray(int size) {
            return (new ApplyCoverLetterData[size]);
        }

    }
    ;

    protected ApplyCoverLetterData(Parcel in) {
        this.userCv = ((UserCv) in.readValue((UserCv.class.getClassLoader())));
    }

    public ApplyCoverLetterData() {
    }

    public UserCv getUserCv() {
        return userCv;
    }

    public void setUserCv(UserCv userCv) {
        this.userCv = userCv;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userCv);
    }

    public int describeContents() {
        return  0;
    }

}
