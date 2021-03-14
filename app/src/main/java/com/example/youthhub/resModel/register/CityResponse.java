
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CityResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data_count")
    @Expose
    private Integer dataCount;
    @SerializedName("data")
    @Expose
    private CityData cityData;
    public final static Creator<CityResponse> CREATOR = new Creator<CityResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CityResponse createFromParcel(Parcel in) {
            return new CityResponse(in);
        }

        public CityResponse[] newArray(int size) {
            return (new CityResponse[size]);
        }

    }
    ;

    protected CityResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.dataCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cityData = ((CityData) in.readValue((CityData.class.getClassLoader())));
    }

    public CityResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public CityData getCityData() {
        return cityData;
    }

    public void setCityData(CityData cityData) {
        this.cityData = cityData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(dataCount);
        dest.writeValue(cityData);
    }

    public int describeContents() {
        return  0;
    }

}
