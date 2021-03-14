
package com.example.youthhub.resModel.connection.conListMaster;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BizSubservice implements Parcelable
{

    @SerializedName("isc_sub_category_id")
    @Expose
    private String iscSubCategoryId;
    @SerializedName("isc_name")
    @Expose
    private String iscName;
    public final static Creator<BizSubservice> CREATOR = new Creator<BizSubservice>() {


        @SuppressWarnings({
            "unchecked"
        })
        public BizSubservice createFromParcel(Parcel in) {
            return new BizSubservice(in);
        }

        public BizSubservice[] newArray(int size) {
            return (new BizSubservice[size]);
        }

    }
    ;

    protected BizSubservice(Parcel in) {
        this.iscSubCategoryId = ((String) in.readValue((String.class.getClassLoader())));
        this.iscName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public BizSubservice() {
    }

    public String getIscSubCategoryId() {
        return iscSubCategoryId;
    }

    public void setIscSubCategoryId(String iscSubCategoryId) {
        this.iscSubCategoryId = iscSubCategoryId;
    }

    public String getIscName() {
        return iscName;
    }

    public void setIscName(String iscName) {
        this.iscName = iscName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(iscSubCategoryId);
        dest.writeValue(iscName);
    }

    public int describeContents() {
        return  0;
    }

}
