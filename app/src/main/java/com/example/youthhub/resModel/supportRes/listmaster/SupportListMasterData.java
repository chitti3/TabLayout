
package com.example.youthhub.resModel.supportRes.listmaster;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupportListMasterData implements Parcelable
{

    @SerializedName("status_type")
    @Expose
    private List<FilterSubcategory> filterSubcategory = new ArrayList<>();
    public final static Creator<SupportListMasterData> CREATOR = new Creator<SupportListMasterData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SupportListMasterData createFromParcel(Parcel in) {
            return new SupportListMasterData(in);
        }

        public SupportListMasterData[] newArray(int size) {
            return (new SupportListMasterData[size]);
        }

    }
    ;

    protected SupportListMasterData(Parcel in) {
        in.readList(this.filterSubcategory, (FilterSubcategory.class.getClassLoader()));
    }

    public SupportListMasterData() {
    }

    public List<FilterSubcategory> getFilterSubcategory() {
        return filterSubcategory;
    }

    public void setFilterSubcategory(List<FilterSubcategory> filterSubcategory) {
        this.filterSubcategory = filterSubcategory;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(filterSubcategory);
    }

    public int describeContents() {
        return  0;
    }

}
