
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegionList implements Parcelable
{

    @SerializedName("re_region_id")
    @Expose
    private String reRegionId;
    @SerializedName("re_name")
    @Expose
    private String reName;
    public final static Creator<RegionList> CREATOR = new Creator<RegionList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RegionList createFromParcel(Parcel in) {
            return new RegionList(in);
        }

        public RegionList[] newArray(int size) {
            return (new RegionList[size]);
        }

    }
    ;

    protected RegionList(Parcel in) {
        this.reRegionId = ((String) in.readValue((String.class.getClassLoader())));
        this.reName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public RegionList() {
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
