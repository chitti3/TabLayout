
package com.example.youthhub.resModel.connection.conListMaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wishlist implements Parcelable
{

    @SerializedName("wit_tag_id")
    @Expose
    private String witTagId;
    @SerializedName("wit_name")
    @Expose
    private String witName;
    public final static Creator<Wishlist> CREATOR = new Creator<Wishlist>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Wishlist createFromParcel(Parcel in) {
            return new Wishlist(in);
        }

        public Wishlist[] newArray(int size) {
            return (new Wishlist[size]);
        }

    }
    ;

    protected Wishlist(Parcel in) {
        this.witTagId = ((String) in.readValue((String.class.getClassLoader())));
        this.witName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Wishlist() {
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
