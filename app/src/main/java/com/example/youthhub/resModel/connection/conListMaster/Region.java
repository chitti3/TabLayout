
package com.example.youthhub.resModel.connection.conListMaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Region implements Parcelable
{

    @SerializedName("re_region_id")
    @Expose
    private String reRegionId;
    @SerializedName("re_name")
    @Expose
    private String reName;
    public final static Creator<Region> CREATOR = new Creator<Region>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Region createFromParcel(Parcel in) {
            return new Region(in);
        }

        public Region[] newArray(int size) {
            return (new Region[size]);
        }

    }
    ;

    protected Region(Parcel in) {
        this.reRegionId = ((String) in.readValue((String.class.getClassLoader())));
        this.reName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Region() {
    }

    public String getReRegionId() {
        return reRegionId;
    }

    public void setReRegionId(String reRegionId) {
        this.reRegionId = reRegionId;
    }

    public String getReName() {
        return reName;
    }

    public void setReName(String reName) {
        this.reName = reName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(reRegionId);
        dest.writeValue(reName);
    }

    public int describeContents() {
        return  0;
    }

}
