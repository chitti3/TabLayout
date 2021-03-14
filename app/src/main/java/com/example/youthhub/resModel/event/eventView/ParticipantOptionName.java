
package com.example.youthhub.resModel.event.eventView;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ParticipantOptionName implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<ParticipantOptionName> CREATOR = new Creator<ParticipantOptionName>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ParticipantOptionName createFromParcel(Parcel in) {
            return new ParticipantOptionName(in);
        }

        public ParticipantOptionName[] newArray(int size) {
            return (new ParticipantOptionName[size]);
        }

    }
    ;

    protected ParticipantOptionName(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ParticipantOptionName() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
