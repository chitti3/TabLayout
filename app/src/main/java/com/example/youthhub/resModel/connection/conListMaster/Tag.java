
package com.example.youthhub.resModel.connection.conListMaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tag implements Parcelable
{

    @SerializedName("tg_tag_id")
    @Expose
    private String tgTagId;
    @SerializedName("tg_name")
    @Expose
    private String tgName;
    public final static Creator<Tag> CREATOR = new Creator<Tag>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Tag createFromParcel(Parcel in) {
            return new Tag(in);
        }

        public Tag[] newArray(int size) {
            return (new Tag[size]);
        }

    }
    ;

    protected Tag(Parcel in) {
        this.tgTagId = ((String) in.readValue((String.class.getClassLoader())));
        this.tgName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Tag() {
    }

    public String getTgTagId() {
        return tgTagId;
    }

    public void setTgTagId(String tgTagId) {
        this.tgTagId = tgTagId;
    }

    public String getTgName() {
        return tgName;
    }

    public void setTgName(String tgName) {
        this.tgName = tgName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tgTagId);
        dest.writeValue(tgName);
    }

    public int describeContents() {
        return  0;
    }

}
