
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private RegisterData registerData;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<RegisterResponse> CREATOR = new Creator<RegisterResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RegisterResponse createFromParcel(Parcel in) {
            return new RegisterResponse(in);
        }

        public RegisterResponse[] newArray(int size) {
            return (new RegisterResponse[size]);
        }

    }
    ;

    protected RegisterResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.registerData = ((RegisterData) in.readValue((RegisterData.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public RegisterResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public RegisterData getRegisterData() {
        return registerData;
    }

    public void setRegisterData(RegisterData registerData) {
        this.registerData = registerData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(registerData);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
