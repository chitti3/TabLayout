package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

public class ProfileDeleteResonse implements Parcelable {


    private String message;

    private int status;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public int getStatus ()
    {
        return status;
    }

    public void setStatus (int status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", status = "+status+"]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.message);
        dest.writeInt(this.status);
    }

    public ProfileDeleteResonse() {
    }

    protected ProfileDeleteResonse(Parcel in) {
        this.message = in.readString();
        this.status = in.readInt();
    }

    public static final Parcelable.Creator<ProfileDeleteResonse> CREATOR = new Parcelable.Creator<ProfileDeleteResonse>() {
        @Override
        public ProfileDeleteResonse createFromParcel(Parcel source) {
            return new ProfileDeleteResonse(source);
        }

        @Override
        public ProfileDeleteResonse[] newArray(int size) {
            return new ProfileDeleteResonse[size];
        }
    };
}
