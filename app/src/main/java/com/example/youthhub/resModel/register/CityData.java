
package com.example.youthhub.resModel.register;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityData implements Parcelable
{

    @SerializedName("city_list")
    @Expose
    private List<CityList> cityList = new ArrayList<>();
    public final static Creator<CityData> CREATOR = new Creator<CityData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CityData createFromParcel(Parcel in) {
            return new CityData(in);
        }

        public CityData[] newArray(int size) {
            return (new CityData[size]);
        }

    }
    ;

    protected CityData(Parcel in) {
        in.readList(this.cityList, (CityList.class.getClassLoader()));
    }

    public CityData() {
    }

    public List<CityList> getCityList() {
        return cityList;
    }

    public void setCityList(List<CityList> cityList) {
        this.cityList = cityList;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(cityList);
    }

    public int describeContents() {
        return  0;
    }

}
