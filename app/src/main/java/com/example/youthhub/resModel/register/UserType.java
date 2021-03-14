
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserType implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("teams_url")
    @Expose
    private String teamsUrl;
    public final static Creator<UserType> CREATOR = new Creator<UserType>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserType createFromParcel(Parcel in) {
            return new UserType(in);
        }

        public UserType[] newArray(int size) {
            return (new UserType[size]);
        }

    }
    ;

    protected UserType(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.teamsUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UserType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamsUrl() {
        return teamsUrl;
    }

    public void setTeamsUrl(String teamsUrl) {
        this.teamsUrl = teamsUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(teamsUrl);
    }

    public int describeContents() {
        return  0;
    }

}
