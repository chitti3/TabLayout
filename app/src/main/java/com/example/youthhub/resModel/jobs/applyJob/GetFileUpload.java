
package com.example.youthhub.resModel.jobs.applyJob;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetFileUpload implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private FileUploadData fileUploadData;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<GetFileUpload> CREATOR = new Creator<GetFileUpload>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GetFileUpload createFromParcel(Parcel in) {
            return new GetFileUpload(in);
        }

        public GetFileUpload[] newArray(int size) {
            return (new GetFileUpload[size]);
        }

    }
    ;

    protected GetFileUpload(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.fileUploadData = ((FileUploadData) in.readValue((FileUploadData.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public GetFileUpload() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public FileUploadData getFileUploadData() {
        return fileUploadData;
    }

    public void setFileUploadData(FileUploadData fileUploadData) {
        this.fileUploadData = fileUploadData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(fileUploadData);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
