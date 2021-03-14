
package com.example.youthhub.resModel.jobs;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Viewer implements Parcelable
{

    @SerializedName("jvi_sequence_id")
    @Expose
    private String jviSequenceId;
    @SerializedName("jvi_date")
    @Expose
    private String jviDate;
    @SerializedName("jvi_total_visit")
    @Expose
    private String jviTotalVisit;
    @SerializedName("jvi_is_save")
    @Expose
    private String jviIsSave;
    public final static Creator<Viewer> CREATOR = new Creator<Viewer>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Viewer createFromParcel(Parcel in) {
            return new Viewer(in);
        }

        public Viewer[] newArray(int size) {
            return (new Viewer[size]);
        }

    }
    ;

    protected Viewer(Parcel in) {
        this.jviSequenceId = ((String) in.readValue((String.class.getClassLoader())));
        this.jviDate = ((String) in.readValue((String.class.getClassLoader())));
        this.jviTotalVisit = ((String) in.readValue((String.class.getClassLoader())));
        this.jviIsSave = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Viewer() {
    }

    public String getJviSequenceId() {
        return jviSequenceId;
    }

    public void setJviSequenceId(String jviSequenceId) {
        this.jviSequenceId = jviSequenceId;
    }

    public String getJviDate() {
        return jviDate;
    }

    public void setJviDate(String jviDate) {
        this.jviDate = jviDate;
    }

    public String getJviTotalVisit() {
        return jviTotalVisit;
    }

    public void setJviTotalVisit(String jviTotalVisit) {
        this.jviTotalVisit = jviTotalVisit;
    }

    public String getJviIsSave() {
        return jviIsSave;
    }

    public void setJviIsSave(String jviIsSave) {
        this.jviIsSave = jviIsSave;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(jviSequenceId);
        dest.writeValue(jviDate);
        dest.writeValue(jviTotalVisit);
        dest.writeValue(jviIsSave);
    }

    public int describeContents() {
        return  0;
    }

}
