
package com.example.youthhub.resModel.explore.masterApi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreTag implements Parcelable
{

    @SerializedName("tg_name")
    @Expose
    private String tgName;
    @SerializedName("tg_tag_id")
    @Expose
    private String tgTagId;
    public final static Creator<ExploreTag> CREATOR = new Creator<ExploreTag>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreTag createFromParcel(Parcel in) {
            return new ExploreTag(in);
        }

        public ExploreTag[] newArray(int size) {
            return (new ExploreTag[size]);
        }

    }
    ;

    protected ExploreTag(Parcel in) {
        this.tgName = ((String) in.readValue((String.class.getClassLoader())));
        this.tgTagId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ExploreTag() {
    }

    public String getTgName() {
        return tgName;
    }

    public void setTgName(String tgName) {
        this.tgName = tgName;
    }

    public String getTgTagId() {
        return tgTagId;
    }

    public void setTgTagId(String tgTagId) {
        this.tgTagId = tgTagId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tgName);
        dest.writeValue(tgTagId);
    }

    public int describeContents() {
        return  0;
    }

}
