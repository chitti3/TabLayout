
package com.example.youthhub.resModel.jobs.applyJob;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FileUploadData implements Parcelable
{

    @SerializedName("file_name")
    @Expose
    private String fileName;
    public final static Creator<FileUploadData> CREATOR = new Creator<FileUploadData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FileUploadData createFromParcel(Parcel in) {
            return new FileUploadData(in);
        }

        public FileUploadData[] newArray(int size) {
            return (new FileUploadData[size]);
        }

    }
    ;

    protected FileUploadData(Parcel in) {
        this.fileName = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FileUploadData() {
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
