
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class IwiList implements Parcelable
{

    @SerializedName("iw_iwi_id")
    @Expose
    private String iwIwiId;
    @SerializedName("iw_name")
    @Expose
    private String iwName;
    public final static Creator<IwiList> CREATOR = new Creator<IwiList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public IwiList createFromParcel(Parcel in) {
            return new IwiList(in);
        }

        public IwiList[] newArray(int size) {
            return (new IwiList[size]);
        }

    }
    ;

    protected IwiList(Parcel in) {
        this.iwIwiId = ((String) in.readValue((String.class.getClassLoader())));
        this.iwName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public IwiList() {
    }

    public String getIwIwiId() {
        return iwIwiId;
    }

    public void setIwIwiId(String iwIwiId) {
        this.iwIwiId = iwIwiId;
    }

    public String getIwName() {
        return iwName;
    }

    public void setIwName(String iwName) {
        this.iwName = iwName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(iwIwiId);
        dest.writeValue(iwName);
    }

    public int describeContents() {
        return  0;
    }

}
