
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IntendedDestinationList implements Parcelable
{

    @SerializedName("sm_status_id")
    @Expose
    private String smStatusId;
    @SerializedName("sm_name")
    @Expose
    private String smName;
    public final static Creator<IntendedDestinationList> CREATOR = new Creator<IntendedDestinationList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public IntendedDestinationList createFromParcel(Parcel in) {
            return new IntendedDestinationList(in);
        }

        public IntendedDestinationList[] newArray(int size) {
            return (new IntendedDestinationList[size]);
        }

    }
    ;

    protected IntendedDestinationList(Parcel in) {
        this.smStatusId = ((String) in.readValue((String.class.getClassLoader())));
        this.smName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public IntendedDestinationList() {
    }

    public String getSmStatusId() {
        return smStatusId;
    }

    public void setSmStatusId(String smStatusId) {
        this.smStatusId = smStatusId;
    }

    public String getSmName() {
        return smName;
    }

    public void setSmName(String smName) {
        this.smName = smName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(smStatusId);
        dest.writeValue(smName);
    }

    public int describeContents() {
        return  0;
    }

}
