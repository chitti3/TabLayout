
package com.example.youthhub.resModel.post.createPost;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JourneyList implements Parcelable
{

    @SerializedName("jum_journey_id")
    @Expose
    private String jumJourneyId;
    @SerializedName("jum_title")
    @Expose
    private String jumTitle;
    public final static Creator<JourneyList> CREATOR = new Creator<JourneyList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JourneyList createFromParcel(Parcel in) {
            return new JourneyList(in);
        }

        public JourneyList[] newArray(int size) {
            return (new JourneyList[size]);
        }

    }
    ;

    protected JourneyList(Parcel in) {
        this.jumJourneyId = ((String) in.readValue((String.class.getClassLoader())));
        this.jumTitle = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JourneyList() {
    }

    public String getJumJourneyId() {
        return jumJourneyId;
    }

    public void setJumJourneyId(String jumJourneyId) {
        this.jumJourneyId = jumJourneyId;
    }

    public String getJumTitle() {
        return jumTitle;
    }

    public void setJumTitle(String jumTitle) {
        this.jumTitle = jumTitle;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(jumJourneyId);
        dest.writeValue(jumTitle);
    }

    public int describeContents() {
        return  0;
    }

}
