
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LicenceTypeList implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<LicenceTypeList> CREATOR = new Creator<LicenceTypeList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LicenceTypeList createFromParcel(Parcel in) {
            return new LicenceTypeList(in);
        }

        public LicenceTypeList[] newArray(int size) {
            return (new LicenceTypeList[size]);
        }

    }
    ;

    protected LicenceTypeList(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public LicenceTypeList() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
