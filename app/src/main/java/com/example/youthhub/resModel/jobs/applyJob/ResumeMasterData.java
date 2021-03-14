
package com.example.youthhub.resModel.jobs.applyJob;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResumeMasterData implements Parcelable
{

    @SerializedName("type_master")
    @Expose
    private List<ResumeTypeMaster> resumeTypeMaster = new ArrayList<>();
    public final static Creator<ResumeMasterData> CREATOR = new Creator<ResumeMasterData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ResumeMasterData createFromParcel(Parcel in) {
            return new ResumeMasterData(in);
        }

        public ResumeMasterData[] newArray(int size) {
            return (new ResumeMasterData[size]);
        }

    }
    ;

    protected ResumeMasterData(Parcel in) {
        in.readList(this.resumeTypeMaster, (ResumeTypeMaster.class.getClassLoader()));
    }

    public ResumeMasterData() {
    }

    public List<ResumeTypeMaster> getResumeTypeMaster() {
        return resumeTypeMaster;
    }

    public void setResumeTypeMaster(List<ResumeTypeMaster> resumeTypeMaster) {
        this.resumeTypeMaster = resumeTypeMaster;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(resumeTypeMaster);
    }

    public int describeContents() {
        return  0;
    }

}
