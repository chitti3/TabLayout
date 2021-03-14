
package com.example.youthhub.resModel.event.eventView;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventView implements Parcelable
{

    @SerializedName("event_logo")
    @Expose
    private String eventLogo;
    @SerializedName("event_title")
    @Expose
    private String eventTitle;
    @SerializedName("event_code")
    @Expose
    private String eventCode;
    @SerializedName("event_start_date")
    @Expose
    private String eventStartDate;
    @SerializedName("event_end_date")
    @Expose
    private String eventEndDate;
    @SerializedName("event_start_time")
    @Expose
    private String eventStartTime;
    @SerializedName("event_end_time")
    @Expose
    private String eventEndTime;
    @SerializedName("event_total_participants_going")
    @Expose
    private String eventTotalParticipantsGoing;
    @SerializedName("event_region_name")
    @Expose
    private String eventRegionName;
    @SerializedName("event_city_name")
    @Expose
    private String eventCityName;
    @SerializedName("event_detail")
    @Expose
    private String eventDetail;
    @SerializedName("event_address")
    @Expose
    private String eventAddress;
    @SerializedName("event_contact_name")
    @Expose
    private String eventContactName;
    @SerializedName("event_contact_email")
    @Expose
    private String eventContactEmail;
    @SerializedName("em_latitude")
    @Expose
    private String emLatitude;
    @SerializedName("em_longitude")
    @Expose
    private String emLongitude;
    @SerializedName("event_contact_no")
    @Expose
    private String eventContactNo;
    @SerializedName("event_type")
    @Expose
    private String eventType;
    @SerializedName("event_type_name")
    @Expose
    private String eventTypeName;
    @SerializedName("event_status")
    @Expose
    private String eventStatus;
    @SerializedName("event_status_name")
    @Expose
    private String eventStatusName;
    @SerializedName("event_starttime")
    @Expose
    private String eventStarttime;
    @SerializedName("event_endtime")
    @Expose
    private String eventEndtime;
    @SerializedName("total_youthhub_participants")
    @Expose
    private String totalYouthhubParticipants;
    @SerializedName("total_shadowtect_participants")
    @Expose
    private String totalShadowtectParticipants;
    @SerializedName("participant_current_status")
    @Expose
    private Integer participantCurrentStatus;
    @SerializedName("participant_current_status_name")
    @Expose
    private String participantCurrentStatusName;
    @SerializedName("participant_option_name")
    @Expose
    private List<ParticipantOptionName> participantOptionName = new ArrayList<>();
    @SerializedName("event_created_on")
    @Expose
    private String eventCreatedOn;
    @SerializedName("postby_user_code")
    @Expose
    private String postbyUserCode;
    @SerializedName("postby_user_type")
    @Expose
    private String postbyUserType;
    @SerializedName("postby_user_name")
    @Expose
    private String postbyUserName;
    public final static Creator<EventView> CREATOR = new Creator<EventView>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EventView createFromParcel(Parcel in) {
            return new EventView(in);
        }

        public EventView[] newArray(int size) {
            return (new EventView[size]);
        }

    }
    ;

    protected EventView(Parcel in) {
        this.eventLogo = ((String) in.readValue((String.class.getClassLoader())));
        this.eventTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.eventCode = ((String) in.readValue((String.class.getClassLoader())));
        this.eventStartDate = ((String) in.readValue((String.class.getClassLoader())));
        this.eventEndDate = ((String) in.readValue((String.class.getClassLoader())));
        this.eventStartTime = ((String) in.readValue((String.class.getClassLoader())));
        this.eventEndTime = ((String) in.readValue((String.class.getClassLoader())));
        this.eventTotalParticipantsGoing = ((String) in.readValue((String.class.getClassLoader())));
        this.eventRegionName = ((String) in.readValue((String.class.getClassLoader())));
        this.eventCityName = ((String) in.readValue((String.class.getClassLoader())));
        this.eventDetail = ((String) in.readValue((String.class.getClassLoader())));
        this.eventAddress = ((String) in.readValue((String.class.getClassLoader())));
        this.eventContactName = ((String) in.readValue((String.class.getClassLoader())));
        this.eventContactEmail = ((String) in.readValue((String.class.getClassLoader())));
        this.emLatitude = ((String) in.readValue((String.class.getClassLoader())));
        this.emLongitude = ((String) in.readValue((String.class.getClassLoader())));
        this.eventContactNo = ((String) in.readValue((String.class.getClassLoader())));
        this.eventType = ((String) in.readValue((String.class.getClassLoader())));
        this.eventTypeName = ((String) in.readValue((String.class.getClassLoader())));
        this.eventStatus = ((String) in.readValue((String.class.getClassLoader())));
        this.eventStatusName = ((String) in.readValue((String.class.getClassLoader())));
        this.eventStarttime = ((String) in.readValue((String.class.getClassLoader())));
        this.eventEndtime = ((String) in.readValue((String.class.getClassLoader())));
        this.totalYouthhubParticipants = ((String) in.readValue((String.class.getClassLoader())));
        this.totalShadowtectParticipants = ((String) in.readValue((String.class.getClassLoader())));
        this.participantCurrentStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.participantCurrentStatusName = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.participantOptionName, (com.example.youthhub.resModel.event.eventView.ParticipantOptionName.class.getClassLoader()));
        this.eventCreatedOn = ((String) in.readValue((String.class.getClassLoader())));
        this.postbyUserCode = ((String) in.readValue((String.class.getClassLoader())));
        this.postbyUserType = ((String) in.readValue((String.class.getClassLoader())));
        this.postbyUserName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public EventView() {
    }

    public String getEventLogo() {
        return eventLogo;
    }

    public void setEventLogo(String eventLogo) {
        this.eventLogo = eventLogo;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getEventTotalParticipantsGoing() {
        return eventTotalParticipantsGoing;
    }

    public void setEventTotalParticipantsGoing(String eventTotalParticipantsGoing) {
        this.eventTotalParticipantsGoing = eventTotalParticipantsGoing;
    }

    public String getEventRegionName() {
        return eventRegionName;
    }

    public void setEventRegionName(String eventRegionName) {
        this.eventRegionName = eventRegionName;
    }

    public String getEventCityName() {
        return eventCityName;
    }

    public void setEventCityName(String eventCityName) {
        this.eventCityName = eventCityName;
    }

    public String getEventDetail() {
        return eventDetail;
    }

    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }

    public String getEventAddress() {
        return eventAddress;
    }

    public void setEventAddress(String eventAddress) {
        this.eventAddress = eventAddress;
    }

    public String getEventContactName() {
        return eventContactName;
    }

    public void setEventContactName(String eventContactName) {
        this.eventContactName = eventContactName;
    }

    public String getEventContactEmail() {
        return eventContactEmail;
    }

    public void setEventContactEmail(String eventContactEmail) {
        this.eventContactEmail = eventContactEmail;
    }

    public String getEmLatitude() {
        return emLatitude;
    }

    public void setEmLatitude(String emLatitude) {
        this.emLatitude = emLatitude;
    }

    public String getEmLongitude() {
        return emLongitude;
    }

    public void setEmLongitude(String emLongitude) {
        this.emLongitude = emLongitude;
    }

    public String getEventContactNo() {
        return eventContactNo;
    }

    public void setEventContactNo(String eventContactNo) {
        this.eventContactNo = eventContactNo;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventTypeName() {
        return eventTypeName;
    }

    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    public String getEventStatusName() {
        return eventStatusName;
    }

    public void setEventStatusName(String eventStatusName) {
        this.eventStatusName = eventStatusName;
    }

    public String getEventStarttime() {
        return eventStarttime;
    }

    public void setEventStarttime(String eventStarttime) {
        this.eventStarttime = eventStarttime;
    }

    public String getEventEndtime() {
        return eventEndtime;
    }

    public void setEventEndtime(String eventEndtime) {
        this.eventEndtime = eventEndtime;
    }

    public String getTotalYouthhubParticipants() {
        return totalYouthhubParticipants;
    }

    public void setTotalYouthhubParticipants(String totalYouthhubParticipants) {
        this.totalYouthhubParticipants = totalYouthhubParticipants;
    }

    public String getTotalShadowtectParticipants() {
        return totalShadowtectParticipants;
    }

    public void setTotalShadowtectParticipants(String totalShadowtectParticipants) {
        this.totalShadowtectParticipants = totalShadowtectParticipants;
    }

    public Integer getParticipantCurrentStatus() {
        return participantCurrentStatus;
    }

    public void setParticipantCurrentStatus(Integer participantCurrentStatus) {
        this.participantCurrentStatus = participantCurrentStatus;
    }

    public String getParticipantCurrentStatusName() {
        return participantCurrentStatusName;
    }

    public void setParticipantCurrentStatusName(String participantCurrentStatusName) {
        this.participantCurrentStatusName = participantCurrentStatusName;
    }

    public List<ParticipantOptionName> getParticipantOptionName() {
        return participantOptionName;
    }

    public void setParticipantOptionName(List<ParticipantOptionName> participantOptionName) {
        this.participantOptionName = participantOptionName;
    }

    public String getEventCreatedOn() {
        return eventCreatedOn;
    }

    public void setEventCreatedOn(String eventCreatedOn) {
        this.eventCreatedOn = eventCreatedOn;
    }

    public String getPostbyUserCode() {
        return postbyUserCode;
    }

    public void setPostbyUserCode(String postbyUserCode) {
        this.postbyUserCode = postbyUserCode;
    }

    public String getPostbyUserType() {
        return postbyUserType;
    }

    public void setPostbyUserType(String postbyUserType) {
        this.postbyUserType = postbyUserType;
    }

    public String getPostbyUserName() {
        return postbyUserName;
    }

    public void setPostbyUserName(String postbyUserName) {
        this.postbyUserName = postbyUserName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(eventLogo);
        dest.writeValue(eventTitle);
        dest.writeValue(eventCode);
        dest.writeValue(eventStartDate);
        dest.writeValue(eventEndDate);
        dest.writeValue(eventStartTime);
        dest.writeValue(eventEndTime);
        dest.writeValue(eventTotalParticipantsGoing);
        dest.writeValue(eventRegionName);
        dest.writeValue(eventCityName);
        dest.writeValue(eventDetail);
        dest.writeValue(eventAddress);
        dest.writeValue(eventContactName);
        dest.writeValue(eventContactEmail);
        dest.writeValue(emLatitude);
        dest.writeValue(emLongitude);
        dest.writeValue(eventContactNo);
        dest.writeValue(eventType);
        dest.writeValue(eventTypeName);
        dest.writeValue(eventStatus);
        dest.writeValue(eventStatusName);
        dest.writeValue(eventStarttime);
        dest.writeValue(eventEndtime);
        dest.writeValue(totalYouthhubParticipants);
        dest.writeValue(totalShadowtectParticipants);
        dest.writeValue(participantCurrentStatus);
        dest.writeValue(participantCurrentStatusName);
        dest.writeList(participantOptionName);
        dest.writeValue(eventCreatedOn);
        dest.writeValue(postbyUserCode);
        dest.writeValue(postbyUserType);
        dest.writeValue(postbyUserName);
    }

    public int describeContents() {
        return  0;
    }

}
