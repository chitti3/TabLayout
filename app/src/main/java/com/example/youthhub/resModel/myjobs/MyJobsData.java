
package com.example.youthhub.resModel.myjobs;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MyJobsData implements Parcelable
{

    @SerializedName("type_master")
    @Expose
    private List<TypeMaster> typeMaster = new ArrayList<>();
    @SerializedName("status")
    @Expose
    private Status status;
    @SerializedName("jobs")
    @Expose
    private List<MyJobs> myJobs = new ArrayList<>();
    public final static Creator<MyJobsData> CREATOR = new Creator<MyJobsData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MyJobsData createFromParcel(Parcel in) {
            return new MyJobsData(in);
        }

        public MyJobsData[] newArray(int size) {
            return (new MyJobsData[size]);
        }

    }
    ;

    protected MyJobsData(Parcel in) {
        in.readList(this.typeMaster, (com.example.youthhub.resModel.myjobs.TypeMaster.class.getClassLoader()));
        this.status = ((Status) in.readValue((Status.class.getClassLoader())));
        in.readList(this.myJobs, (MyJobs.class.getClassLoader()));
    }

    public MyJobsData() {
    }

    public List<TypeMaster> getTypeMaster() {
        return typeMaster;
    }

    public void setTypeMaster(List<TypeMaster> typeMaster) {
        this.typeMaster = typeMaster;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<MyJobs> getMyJobs() {
        return myJobs;
    }

    public void setMyJobs(List<MyJobs> myJobs) {
        this.myJobs = myJobs;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(typeMaster);
        dest.writeValue(status);
        dest.writeList(myJobs);
    }

    public int describeContents() {
        return  0;
    }

}
