
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WorkSituationList implements Parcelable
{

    @SerializedName("jt_type_id")
    @Expose
    private String jtTypeId;
    @SerializedName("jt_name")
    @Expose
    private String jtName;
    public final static Creator<WorkSituationList> CREATOR = new Creator<WorkSituationList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public WorkSituationList createFromParcel(Parcel in) {
            return new WorkSituationList(in);
        }

        public WorkSituationList[] newArray(int size) {
            return (new WorkSituationList[size]);
        }

    }
    ;

    protected WorkSituationList(Parcel in) {
        this.jtTypeId = ((String) in.readValue((String.class.getClassLoader())));
        this.jtName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public WorkSituationList() {
    }

    public String getJtTypeId() {
        return jtTypeId;
    }

    public void setJtTypeId(String jtTypeId) {
        this.jtTypeId = jtTypeId;
    }

    public String getJtName() {
        return jtName;
    }

    public void setJtName(String jtName) {
        this.jtName = jtName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(jtTypeId);
        dest.writeValue(jtName);
    }

    public int describeContents() {
        return  0;
    }

}
