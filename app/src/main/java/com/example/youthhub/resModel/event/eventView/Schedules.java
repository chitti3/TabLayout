
package com.example.youthhub.resModel.event.eventView;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Schedules implements Parcelable
{

    @SerializedName("is_change_schedule")
    @Expose
    private Integer isChangeSchedule;
    @SerializedName("data")
    @Expose
    private List<Object> data = new ArrayList<>();
    public final static Creator<Schedules> CREATOR = new Creator<Schedules>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Schedules createFromParcel(Parcel in) {
            return new Schedules(in);
        }

        public Schedules[] newArray(int size) {
            return (new Schedules[size]);
        }

    }
    ;

    protected Schedules(Parcel in) {
        this.isChangeSchedule = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.data, (Object.class.getClassLoader()));
    }

    public Schedules() {
    }

    public Integer getIsChangeSchedule() {
        return isChangeSchedule;
    }

    public void setIsChangeSchedule(Integer isChangeSchedule) {
        this.isChangeSchedule = isChangeSchedule;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(isChangeSchedule);
        dest.writeList(data);
    }

    public int describeContents() {
        return  0;
    }

}
