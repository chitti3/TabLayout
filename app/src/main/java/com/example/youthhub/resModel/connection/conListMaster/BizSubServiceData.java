
package com.example.youthhub.resModel.connection.conListMaster;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BizSubServiceData implements Parcelable
{

    @SerializedName("biz_subservice")
    @Expose
    private List<BizSubservice> bizSubservice = null;
    public final static Creator<BizSubServiceData> CREATOR = new Creator<BizSubServiceData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BizSubServiceData createFromParcel(Parcel in) {
            return new BizSubServiceData(in);
        }

        public BizSubServiceData[] newArray(int size) {
            return (new BizSubServiceData[size]);
        }

    }
    ;

    protected BizSubServiceData(Parcel in) {
        in.readList(this.bizSubservice, (BizSubservice.class.getClassLoader()));
    }

    public BizSubServiceData() {
    }

    public List<BizSubservice> getBizSubservice() {
        return bizSubservice;
    }

    public void setBizSubservice(List<BizSubservice> bizSubservice) {
        this.bizSubservice = bizSubservice;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(bizSubservice);
    }

    public int describeContents() {
        return  0;
    }

}
