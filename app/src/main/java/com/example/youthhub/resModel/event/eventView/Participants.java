
package com.example.youthhub.resModel.event.eventView;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Participants implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("data")
    @Expose
    private List<Datum> data = new ArrayList<>();
    public final static Creator<Participants> CREATOR = new Creator<Participants>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Participants createFromParcel(Parcel in) {
            return new Participants(in);
        }

        public Participants[] newArray(int size) {
            return (new Participants[size]);
        }

    }
    ;

    protected Participants(Parcel in) {
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.data, (Datum.class.getClassLoader()));
    }

    public Participants() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeList(data);
    }

    public int describeContents() {
        return  0;
    }

}
