
package com.example.youthhub.resModel.event.eventView;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventViewResponse implements Parcelable {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private EventViewData eventViewData;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status_img")
    @Expose
    private String status_img;
    public final static Creator<EventViewResponse> CREATOR = new Creator<EventViewResponse>() {


        @SuppressWarnings({
                "unchecked"
        })
        public EventViewResponse createFromParcel(Parcel in) {
            return new EventViewResponse(in);
        }

        public EventViewResponse[] newArray(int size) {
            return (new EventViewResponse[size]);
        }

    };

    protected EventViewResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.eventViewData = ((EventViewData) in.readValue((EventViewData.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
        this.status_img = ((String) in.readValue((String.class.getClassLoader())));
    }

    public EventViewResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public EventViewData getEventViewData() {
        return eventViewData;
    }

    public void setEventViewData(EventViewData eventViewData) {
        this.eventViewData = eventViewData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus_img() {
        return status_img;
    }

    public void setStatus_img(String status_img) {
        this.status_img = status_img;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(eventViewData);
        dest.writeValue(message);
        dest.writeValue(status_img);
    }

    public int describeContents() {
        return 0;
    }

}
