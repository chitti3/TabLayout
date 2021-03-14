
package com.example.youthhub.resModel.post.postList;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EventList implements Parcelable
{

    @SerializedName("logo")
    @Expose
    private String logo;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("total_participants_going")
    @Expose
    private String totalParticipantsGoing;
    @SerializedName("region_name")
    @Expose
    private String regionName;
    @SerializedName("city_name")
    @Expose
    private String cityName;
    @SerializedName("detail")
    @Expose
    private String detail;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("contact_no")
    @Expose
    private String contactNo;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("status_name")
    @Expose
    private String statusName;
    @SerializedName("starttime")
    @Expose
    private String starttime;
    @SerializedName("endtime")
    @Expose
    private String endtime;
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
    private List<ParticipantOptionName> participantOptionName = null;
    @SerializedName("created_on")
    @Expose
    private String createdOn;
    @SerializedName("postby_user_code")
    @Expose
    private String postbyUserCode;
    @SerializedName("postby_user_type")
    @Expose
    private String postbyUserType;
    @SerializedName("postby_user_name")
    @Expose
    private String postbyUserName;
    public final static Creator<EventList> CREATOR = new Creator<EventList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EventList createFromParcel(Parcel in) {
            return new EventList(in);
        }

        public EventList[] newArray(int size) {
            return (new EventList[size]);
        }

    }
    ;

    protected EventList(Parcel in) {
        this.logo = ((String) in.readValue((String.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.code = ((String) in.readValue((String.class.getClassLoader())));
        this.startDate = ((String) in.readValue((String.class.getClassLoader())));
        this.endDate = ((String) in.readValue((String.class.getClassLoader())));
        this.startTime = ((String) in.readValue((String.class.getClassLoader())));
        this.endTime = ((String) in.readValue((String.class.getClassLoader())));
        this.totalParticipantsGoing = ((String) in.readValue((String.class.getClassLoader())));
        this.regionName = ((String) in.readValue((String.class.getClassLoader())));
        this.cityName = ((String) in.readValue((String.class.getClassLoader())));
        this.detail = ((String) in.readValue((String.class.getClassLoader())));
        this.address = ((String) in.readValue((String.class.getClassLoader())));
        this.contactNo = ((String) in.readValue((String.class.getClassLoader())));
        this.status = ((String) in.readValue((String.class.getClassLoader())));
        this.statusName = ((String) in.readValue((String.class.getClassLoader())));
        this.starttime = ((String) in.readValue((String.class.getClassLoader())));
        this.endtime = ((String) in.readValue((String.class.getClassLoader())));
        this.totalYouthhubParticipants = ((String) in.readValue((String.class.getClassLoader())));
        this.totalShadowtectParticipants = ((String) in.readValue((String.class.getClassLoader())));
        this.participantCurrentStatus = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.participantCurrentStatusName = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.participantOptionName, (com.example.youthhub.resModel.post.postList.ParticipantOptionName.class.getClassLoader()));
        this.createdOn = ((String) in.readValue((String.class.getClassLoader())));
        this.postbyUserCode = ((String) in.readValue((String.class.getClassLoader())));
        this.postbyUserType = ((String) in.readValue((String.class.getClassLoader())));
        this.postbyUserName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public EventList() {
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getTotalParticipantsGoing() {
        return totalParticipantsGoing;
    }

    public void setTotalParticipantsGoing(String totalParticipantsGoing) {
        this.totalParticipantsGoing = totalParticipantsGoing;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
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

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
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
        dest.writeValue(logo);
        dest.writeValue(title);
        dest.writeValue(code);
        dest.writeValue(startDate);
        dest.writeValue(endDate);
        dest.writeValue(startTime);
        dest.writeValue(endTime);
        dest.writeValue(totalParticipantsGoing);
        dest.writeValue(regionName);
        dest.writeValue(cityName);
        dest.writeValue(detail);
        dest.writeValue(address);
        dest.writeValue(contactNo);
        dest.writeValue(status);
        dest.writeValue(statusName);
        dest.writeValue(starttime);
        dest.writeValue(endtime);
        dest.writeValue(totalYouthhubParticipants);
        dest.writeValue(totalShadowtectParticipants);
        dest.writeValue(participantCurrentStatus);
        dest.writeValue(participantCurrentStatusName);
        dest.writeList(participantOptionName);
        dest.writeValue(createdOn);
        dest.writeValue(postbyUserCode);
        dest.writeValue(postbyUserType);
        dest.writeValue(postbyUserName);
    }

    public int describeContents() {
        return  0;
    }

}
