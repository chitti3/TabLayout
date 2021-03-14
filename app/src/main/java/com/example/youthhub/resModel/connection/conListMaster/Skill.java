
package com.example.youthhub.resModel.connection.conListMaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Skill implements Parcelable
{

    @SerializedName("skm_skill_id")
    @Expose
    private String skmSkillId;
    @SerializedName("skm_name")
    @Expose
    private String skmName;
    public final static Creator<Skill> CREATOR = new Creator<Skill>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Skill createFromParcel(Parcel in) {
            return new Skill(in);
        }

        public Skill[] newArray(int size) {
            return (new Skill[size]);
        }

    }
    ;

    protected Skill(Parcel in) {
        this.skmSkillId = ((String) in.readValue((String.class.getClassLoader())));
        this.skmName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Skill() {
    }

    public String getSkmSkillId() {
        return skmSkillId;
    }

    public void setSkmSkillId(String skmSkillId) {
        this.skmSkillId = skmSkillId;
    }

    public String getSkmName() {
        return skmName;
    }

    public void setSkmName(String skmName) {
        this.skmName = skmName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(skmSkillId);
        dest.writeValue(skmName);
    }

    public int describeContents() {
        return  0;
    }

}
