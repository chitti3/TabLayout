
package com.example.youthhub.resModel.event.eventView;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParticipantListResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("nextpage")
    @Expose
    private Integer nextpage;
    @SerializedName("data")
    @Expose
    private ParticipantData participantData;
    public final static Creator<ParticipantListResponse> CREATOR = new Creator<ParticipantListResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ParticipantListResponse createFromParcel(Parcel in) {
            return new ParticipantListResponse(in);
        }

        public ParticipantListResponse[] newArray(int size) {
            return (new ParticipantListResponse[size]);
        }

    }
    ;

    protected ParticipantListResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.nextpage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.participantData = ((ParticipantData) in.readValue((ParticipantData.class.getClassLoader())));
    }

    public ParticipantListResponse() {
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

    public ParticipantData getParticipantData() {
        return participantData;
    }

    public void setParticipantData(ParticipantData participantData) {
        this.participantData = participantData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(nextpage);
        dest.writeValue(participantData);
    }

    public int describeContents() {
        return  0;
    }

}
