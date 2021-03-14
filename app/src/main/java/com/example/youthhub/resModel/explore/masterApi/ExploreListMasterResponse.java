
package com.example.youthhub.resModel.explore.masterApi;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreListMasterResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private ExploreMasterData exploreMasterData;
    public final static Creator<ExploreListMasterResponse> CREATOR = new Creator<ExploreListMasterResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreListMasterResponse createFromParcel(Parcel in) {
            return new ExploreListMasterResponse(in);
        }

        public ExploreListMasterResponse[] newArray(int size) {
            return (new ExploreListMasterResponse[size]);
        }

    }
    ;

    protected ExploreListMasterResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.exploreMasterData = ((ExploreMasterData) in.readValue((ExploreMasterData.class.getClassLoader())));
    }

    public ExploreListMasterResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ExploreMasterData getExploreMasterData() {
        return exploreMasterData;
    }

    public void setExploreMasterData(ExploreMasterData exploreMasterData) {
        this.exploreMasterData = exploreMasterData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(exploreMasterData);
    }

    public int describeContents() {
        return  0;
    }

}
