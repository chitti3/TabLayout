
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private SignUpData signUpData;
    @SerializedName("access-key")
    @Expose
    private String accessKey;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<SignUpResponse> CREATOR = new Creator<SignUpResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SignUpResponse createFromParcel(Parcel in) {
            return new SignUpResponse(in);
        }

        public SignUpResponse[] newArray(int size) {
            return (new SignUpResponse[size]);
        }

    }
    ;

    protected SignUpResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.signUpData = ((SignUpData) in.readValue((SignUpData.class.getClassLoader())));
        this.accessKey = ((String) in.readValue((String.class.getClassLoader())));
        this.token = ((String) in.readValue((String.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SignUpResponse() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SignUpData getSignUpData() {
        return signUpData;
    }

    public void setSignUpData(SignUpData signUpData) {
        this.signUpData = signUpData;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(signUpData);
        dest.writeValue(accessKey);
        dest.writeValue(token);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
