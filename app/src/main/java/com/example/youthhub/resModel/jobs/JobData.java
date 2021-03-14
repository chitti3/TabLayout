
package com.example.youthhub.resModel.jobs;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobData implements Parcelable
{

    @SerializedName("questions")
    @Expose
    private List<Object> questions = new ArrayList<>();
    @SerializedName("applied")
    @Expose
    private Object applied;
    @SerializedName("viewer")
    @Expose
    private Viewer viewer;
    @SerializedName("job_info")
    @Expose
    private JobInfo jobInfo;
    public final static Creator<JobData> CREATOR = new Creator<JobData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobData createFromParcel(Parcel in) {
            return new JobData(in);
        }

        public JobData[] newArray(int size) {
            return (new JobData[size]);
        }

    }
    ;

    protected JobData(Parcel in) {
        in.readList(this.questions, (Object.class.getClassLoader()));
        this.applied = ((Object) in.readValue((Object.class.getClassLoader())));
        this.viewer = ((Viewer) in.readValue((Viewer.class.getClassLoader())));
        this.jobInfo = ((JobInfo) in.readValue((JobInfo.class.getClassLoader())));
    }

    public JobData() {
    }

    public List<Object> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Object> questions) {
        this.questions = questions;
    }

    public Object getApplied() {
        return applied;
    }

    public void setApplied(Object applied) {
        this.applied = applied;
    }

    public Viewer getViewer() {
        return viewer;
    }

    public void setViewer(Viewer viewer) {
        this.viewer = viewer;
    }

    public JobInfo getJobInfo() {
        return jobInfo;
    }

    public void setJobInfo(JobInfo jobInfo) {
        this.jobInfo = jobInfo;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(questions);
        dest.writeValue(applied);
        dest.writeValue(viewer);
        dest.writeValue(jobInfo);
    }

    public int describeContents() {
        return  0;
    }

}
