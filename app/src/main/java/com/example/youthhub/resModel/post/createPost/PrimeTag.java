
package com.example.youthhub.resModel.post.createPost;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrimeTag implements Parcelable
{

    @SerializedName("tg_name")
    @Expose
    private String tgName;
    @SerializedName("tg_tag_id")
    @Expose
    private String tgTagId;
    @SerializedName("tg_icon")
    @Expose
    private String tgIcon;
    public final static Creator<PrimeTag> CREATOR = new Creator<PrimeTag>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PrimeTag createFromParcel(Parcel in) {
            return new PrimeTag(in);
        }

        public PrimeTag[] newArray(int size) {
            return (new PrimeTag[size]);
        }

    }
    ;

    protected PrimeTag(Parcel in) {
        this.tgName = ((String) in.readValue((String.class.getClassLoader())));
        this.tgTagId = ((String) in.readValue((String.class.getClassLoader())));
        this.tgIcon = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PrimeTag() {
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

    public String getTgIcon() {
        return tgIcon;
    }

    public void setTgIcon(String tgIcon) {
        this.tgIcon = tgIcon;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(tgName);
        dest.writeValue(tgTagId);
        dest.writeValue(tgIcon);
    }

    public int describeContents() {
        return  0;
    }

}
