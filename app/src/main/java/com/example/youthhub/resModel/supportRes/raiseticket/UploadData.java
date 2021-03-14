
package com.example.youthhub.resModel.supportRes.raiseticket;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UploadData implements Parcelable
{

    @SerializedName("file_name")
    @Expose
    private String fileName;
    public final static Creator<UploadData> CREATOR = new Creator<UploadData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UploadData createFromParcel(Parcel in) {
            return new UploadData(in);
        }

        public UploadData[] newArray(int size) {
            return (new UploadData[size]);
        }

    }
    ;

    protected UploadData(Parcel in) {
        this.fileName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public UploadData() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(fileName);
    }

    public int describeContents() {
        return  0;
    }

}
