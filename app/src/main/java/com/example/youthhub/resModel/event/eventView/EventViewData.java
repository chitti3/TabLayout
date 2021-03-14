
package com.example.youthhub.resModel.event.eventView;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventViewData implements Parcelable
{

    @SerializedName("event_view")
    @Expose
    private EventView eventView;
    @SerializedName("user_participant")
    @Expose
    private UserParticipant userParticipant;
    @SerializedName("schedules")
    @Expose
    private Schedules schedules;
    @SerializedName("register_val")
    @Expose
    private String registerVal;
    @SerializedName("register")
    @Expose
    private Object register;
    @SerializedName("event_logo_path")
    @Expose
    private String eventLogoPath;
    public final static Creator<EventViewData> CREATOR = new Creator<EventViewData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EventViewData createFromParcel(Parcel in) {
            return new EventViewData(in);
        }

        public EventViewData[] newArray(int size) {
            return (new EventViewData[size]);
        }

    }
    ;

    protected EventViewData(Parcel in) {
        this.eventView = ((EventView) in.readValue((EventView.class.getClassLoader())));
        this.userParticipant = ((UserParticipant) in.readValue((UserParticipant.class.getClassLoader())));
        this.schedules = ((Schedules) in.readValue((Schedules.class.getClassLoader())));
        this.registerVal = ((String) in.readValue((String.class.getClassLoader())));
        this.register = ((Object) in.readValue((Object.class.getClassLoader())));
        this.eventLogoPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public EventViewData() {
    }

    public EventView getEventView() {
        return eventView;
    }

    public void setEventView(EventView eventView) {
        this.eventView = eventView;
    }

    public UserParticipant getUserParticipant() {
        return userParticipant;
    }

    public void setUserParticipant(UserParticipant userParticipant) {
        this.userParticipant = userParticipant;
    }

    public Schedules getSchedules() {
        return schedules;
    }

    public void setSchedules(Schedules schedules) {
        this.schedules = schedules;
    }

    public String getRegisterVal() {
        return registerVal;
    }

    public void setRegisterVal(String registerVal) {
        this.registerVal = registerVal;
    }

    public Object getRegister() {
        return register;
    }

    public void setRegister(Object register) {
        this.register = register;
    }

    public String getEventLogoPath() {
        return eventLogoPath;
    }

    public void setEventLogoPath(String eventLogoPath) {
        this.eventLogoPath = eventLogoPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(eventView);
        dest.writeValue(userParticipant);
        dest.writeValue(schedules);
        dest.writeValue(registerVal);
        dest.writeValue(register);
        dest.writeValue(eventLogoPath);
    }

    public int describeContents() {
        return  0;
    }

}
