
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EthnicityList implements Parcelable
{

    @SerializedName("et_ethnicity_id")
    @Expose
    private String etEthnicityId;
    @SerializedName("et_name")
    @Expose
    private String etName;
    public final static Creator<EthnicityList> CREATOR = new Creator<EthnicityList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public EthnicityList createFromParcel(Parcel in) {
            return new EthnicityList(in);
        }

        public EthnicityList[] newArray(int size) {
            return (new EthnicityList[size]);
        }

    }
    ;

    protected EthnicityList(Parcel in) {
        this.etEthnicityId = ((String) in.readValue((String.class.getClassLoader())));
        this.etName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public EthnicityList() {
    }

    public String getEtEthnicityId() {
        return etEthnicityId;
    }

    public void setEtEthnicityId(String etEthnicityId) {
        this.etEthnicityId = etEthnicityId;
    }

    public String getEtName() {
        return etName;
    }

    public void setEtName(String etName) {
        this.etName = etName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(etEthnicityId);
        dest.writeValue(etName);
    }

    public int describeContents() {
        return  0;
    }

}
