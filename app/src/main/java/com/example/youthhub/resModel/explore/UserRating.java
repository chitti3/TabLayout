
package com.example.youthhub.resModel.explore;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRating implements Parcelable
{

    @SerializedName("xr_rarting_id")
    @Expose
    private String xrRartingId;
    @SerializedName("xr_rate")
    @Expose
    private String xrRate;
    public final static Creator<UserRating> CREATOR = new Creator<UserRating>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserRating createFromParcel(Parcel in) {
            return new UserRating(in);
        }

        public UserRating[] newArray(int size) {
            return (new UserRating[size]);
        }

    }
    ;

    protected UserRating(Parcel in) {
        this.xrRartingId = ((String) in.readValue((String.class.getClassLoader())));
        this.xrRate = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserRating() {
    }

    public String getXrRartingId() {
        return xrRartingId;
    }

    public void setXrRartingId(String xrRartingId) {
        this.xrRartingId = xrRartingId;
    }

    public String getXrRate() {
        return xrRate;
    }

    public void setXrRate(String xrRate) {
        this.xrRate = xrRate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(xrRartingId);
        dest.writeValue(xrRate);
    }

    public int describeContents() {
        return  0;
    }

}
