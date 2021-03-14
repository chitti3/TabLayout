
package com.example.youthhub.resModel.connection.conListMaster;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConnCityData implements Parcelable
{

    @SerializedName("cities")
    @Expose
    private List<City> cities = new ArrayList<>();
    public final static Creator<ConnCityData> CREATOR = new Creator<ConnCityData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ConnCityData createFromParcel(Parcel in) {
            return new ConnCityData(in);
        }

        public ConnCityData[] newArray(int size) {
            return (new ConnCityData[size]);
        }

    }
    ;

    protected ConnCityData(Parcel in) {
        in.readList(this.cities, (City.class.getClassLoader()));
    }

    public ConnCityData() {
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(cities);
    }

    public int describeContents() {
        return  0;
    }

}
