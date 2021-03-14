
package com.example.youthhub.resModel.connection.conListMaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Service implements Parcelable
{

    @SerializedName("ogc_category_id")
    @Expose
    private String ogcCategoryId;
    @SerializedName("ogc_name")
    @Expose
    private String ogcName;
    public final static Creator<Service> CREATOR = new Creator<Service>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Service createFromParcel(Parcel in) {
            return new Service(in);
        }

        public Service[] newArray(int size) {
            return (new Service[size]);
        }

    }
    ;

    protected Service(Parcel in) {
        this.ogcCategoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.ogcName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Service() {
    }

    public String getOgcCategoryId() {
        return ogcCategoryId;
    }

    public void setOgcCategoryId(String ogcCategoryId) {
        this.ogcCategoryId = ogcCategoryId;
    }

    public String getOgcName() {
        return ogcName;
    }

    public void setOgcName(String ogcName) {
        this.ogcName = ogcName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ogcCategoryId);
        dest.writeValue(ogcName);
    }

    public int describeContents() {
        return  0;
    }

}
