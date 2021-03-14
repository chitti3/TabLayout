
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentQualificationTypeList implements Parcelable
{

    @SerializedName("ogm_organisation_id")
    @Expose
    private String ogmOrganisationId;
    @SerializedName("ogm_name")
    @Expose
    private String ogmName;
    public final static Creator<CurrentQualificationTypeList> CREATOR = new Creator<CurrentQualificationTypeList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CurrentQualificationTypeList createFromParcel(Parcel in) {
            return new CurrentQualificationTypeList(in);
        }

        public CurrentQualificationTypeList[] newArray(int size) {
            return (new CurrentQualificationTypeList[size]);
        }

    }
    ;

    protected CurrentQualificationTypeList(Parcel in) {
        this.ogmOrganisationId = ((String) in.readValue((String.class.getClassLoader())));
        this.ogmName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CurrentQualificationTypeList() {
    }

    public String getOgmOrganisationId() {
        return ogmOrganisationId;
    }

    public void setOgmOrganisationId(String ogmOrganisationId) {
        this.ogmOrganisationId = ogmOrganisationId;
    }

    public String getOgmName() {
        return ogmName;
    }

    public void setOgmName(String ogmName) {
        this.ogmName = ogmName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(ogmOrganisationId);
        dest.writeValue(ogmName);
    }

    public int describeContents() {
        return  0;
    }

}
