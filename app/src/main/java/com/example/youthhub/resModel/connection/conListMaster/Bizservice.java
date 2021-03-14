
package com.example.youthhub.resModel.connection.conListMaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bizservice implements Parcelable
{

    @SerializedName("ica_category_id")
    @Expose
    private String icaCategoryId;
    @SerializedName("ica_name")
    @Expose
    private String icaName;
    public final static Creator<Bizservice> CREATOR = new Creator<Bizservice>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Bizservice createFromParcel(Parcel in) {
            return new Bizservice(in);
        }

        public Bizservice[] newArray(int size) {
            return (new Bizservice[size]);
        }

    }
    ;

    protected Bizservice(Parcel in) {
        this.icaCategoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.icaName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Bizservice() {
    }

    public String getIcaCategoryId() {
        return icaCategoryId;
    }

    public void setIcaCategoryId(String icaCategoryId) {
        this.icaCategoryId = icaCategoryId;
    }

    public String getIcaName() {
        return icaName;
    }

    public void setIcaName(String icaName) {
        this.icaName = icaName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(icaCategoryId);
        dest.writeValue(icaName);
    }

    public int describeContents() {
        return  0;
    }

}
