
package com.example.youthhub.resModel.event;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventData implements Parcelable
{

    @SerializedName("event_count")
    @Expose
    private Integer eventCount;
    @SerializedName("event_list")
    @Expose
    private List<EventList> eventList = new ArrayList<>();
    @SerializedName("event_logo_path")
    @Expose
    private String eventLogoPath;
    public final static Creator<EventData> CREATOR = new Creator<EventData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EventData createFromParcel(Parcel in) {
            return new EventData(in);
        }

        public EventData[] newArray(int size) {
            return (new EventData[size]);
        }

    }
    ;

    protected EventData(Parcel in) {
        this.eventCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.eventList, (com.example.youthhub.resModel.event.EventList.class.getClassLoader()));
        this.eventLogoPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public EventData() {
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public List<EventList> getEventList() {
        return eventList;
    }

    public void setEventList(List<EventList> eventList) {
        this.eventList = eventList;
    }

    public String getEventLogoPath() {
        return eventLogoPath;
    }

    public void setEventLogoPath(String eventLogoPath) {
        this.eventLogoPath = eventLogoPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(eventCount);
        dest.writeList(eventList);
        dest.writeValue(eventLogoPath);
    }

    public int describeContents() {
        return  0;
    }

}
