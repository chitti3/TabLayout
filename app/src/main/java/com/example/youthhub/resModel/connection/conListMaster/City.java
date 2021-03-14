
package com.example.youthhub.resModel.connection.conListMaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City implements Parcelable
{

    @SerializedName("ci_city_id")
    @Expose
    private String ciCityId;
    @SerializedName("ci_name")
    @Expose
    private String ciName;
    public final static Creator<City> CREATOR = new Creator<City>() {


        @SuppressWarnings({
            "unchecked"
        })
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        public City[] newArray(int size) {
            return (new City[size]);
        }

    }
    ;

    protected City(Parcel in) {
        this.ciCityId = ((String) in.readValue((String.class.getClassLoader())));
        this.ciName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public City() {
    }

    public String getCiCityId() {
        return ciCityId;
    }

    public void setCiCityId(String ciCityId) {
        this.ciCityId = ciCityId;
    }

    public String getCiName() {
        return ciName;
    }

    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ciCityId);
        dest.writeValue(ciName);
    }

    public int describeContents() {
        return  0;
    }

}
