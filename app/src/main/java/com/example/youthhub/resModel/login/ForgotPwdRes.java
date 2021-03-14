
package com.example.youthhub.resModel.login;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForgotPwdRes implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<ForgotPwdRes> CREATOR = new Creator<ForgotPwdRes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ForgotPwdRes createFromParcel(Parcel in) {
            return new ForgotPwdRes(in);
        }

        public ForgotPwdRes[] newArray(int size) {
            return (new ForgotPwdRes[size]);
        }

    }
    ;

    protected ForgotPwdRes(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ForgotPwdRes() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
