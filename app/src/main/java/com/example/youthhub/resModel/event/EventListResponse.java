
package com.example.youthhub.resModel.event;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventListResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("nextpage")
    @Expose
    private Integer nextpage;
    @SerializedName("data")
    @Expose
    private EventData eventData;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status_img")
    @Expose
    private String status_img;
    public final static Creator<EventListResponse> CREATOR = new Creator<EventListResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EventListResponse createFromParcel(Parcel in) {
            return new EventListResponse(in);
        }

        public EventListResponse[] newArray(int size) {
            return (new EventListResponse[size]);
        }

    }
    ;

    protected EventListResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nextpage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.eventData = ((EventData) in.readValue((EventData.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.status_img = ((String) in.readValue((String.class.getClassLoader())));
    }

    public EventListResponse() {
    }

    public String getStatus_img() {
        return status_img;
    }

    public void setStatus_img(String status_img) {
        this.status_img = status_img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNextpage() {
        return nextpage;
    }

    public void setNextpage(Integer nextpage) {
        this.nextpage = nextpage;
    }

    public EventData getEventData() {
        return eventData;
    }

    public void setEventData(EventData eventData) {
        this.eventData = eventData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(nextpage);
        dest.writeValue(eventData);
        dest.writeValue(message);
        dest.writeValue(status_img);
    }

    public int describeContents() {
        return  0;
    }

}
