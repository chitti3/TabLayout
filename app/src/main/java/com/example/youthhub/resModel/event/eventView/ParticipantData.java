
package com.example.youthhub.resModel.event.eventView;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParticipantData implements Parcelable
{

    @SerializedName("participants")
    @Expose
    private Participants participants;
    @SerializedName("user_medium_path")
    @Expose
    private String userMediumPath;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    public final static Creator<ParticipantData> CREATOR = new Creator<ParticipantData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ParticipantData createFromParcel(Parcel in) {
            return new ParticipantData(in);
        }

        public ParticipantData[] newArray(int size) {
            return (new ParticipantData[size]);
        }

    }
    ;

    protected ParticipantData(Parcel in) {
        this.participants = ((Participants) in.readValue((Participants.class.getClassLoader())));
        this.userMediumPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ParticipantData() {
    }

    public Participants getParticipants() {
        return participants;
    }

    public void setParticipants(Participants participants) {
        this.participants = participants;
    }

    public String getUserMediumPath() {
        return userMediumPath;
    }

    public void setUserMediumPath(String userMediumPath) {
        this.userMediumPath = userMediumPath;
    }

    public String getUserThumbnailPath() {
        return userThumbnailPath;
    }

    public void setUserThumbnailPath(String userThumbnailPath) {
        this.userThumbnailPath = userThumbnailPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(participants);
        dest.writeValue(userMediumPath);
        dest.writeValue(userThumbnailPath);
    }

    public int describeContents() {
        return  0;
    }

}
