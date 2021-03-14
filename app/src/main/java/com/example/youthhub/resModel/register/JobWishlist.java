
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class JobWishlist implements Parcelable
{

    @SerializedName("wit_tag_id")
    @Expose
    private String witTagId;
    @SerializedName("wit_name")
    @Expose
    private String witName;
    public final static Creator<JobWishlist> CREATOR = new Creator<JobWishlist>() {


        @SuppressWarnings({
            "unchecked"
        })
        public JobWishlist createFromParcel(Parcel in) {
            return new JobWishlist(in);
        }

        public JobWishlist[] newArray(int size) {
            return (new JobWishlist[size]);
        }

    }
    ;

    protected JobWishlist(Parcel in) {
        this.witTagId = ((String) in.readValue((String.class.getClassLoader())));
        this.witName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public JobWishlist() {
    }

    public String getWitTagId() {
        return witTagId;
    }

    public void setWitTagId(String witTagId) {
        this.witTagId = witTagId;
    }

    public String getWitName() {
        return witName;
    }

    public void setWitName(String witName) {
        this.witName = witName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(witTagId);
        dest.writeValue(witName);
    }

    public int describeContents() {
        return  0;
    }

}
