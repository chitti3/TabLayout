
package com.example.youthhub.resModel.register;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpMasterResponse implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private SignUpMasterData signUpMasterData;
    @SerializedName("error")
    @Expose
    private String error;
    public final static Creator<SignUpMasterResponse> CREATOR = new Creator<SignUpMasterResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SignUpMasterResponse createFromParcel(Parcel in) {
            return new SignUpMasterResponse(in);
        }

        public SignUpMasterResponse[] newArray(int size) {
            return (new SignUpMasterResponse[size]);
        }

    }
    ;

    protected SignUpMasterResponse(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.signUpMasterData = ((SignUpMasterData) in.readValue((SignUpMasterData.class.getClassLoader())));
        this.error = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SignUpMasterResponse() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public SignUpMasterData getSignUpMasterData() {
        return signUpMasterData;
    }

    public void setSignUpMasterData(SignUpMasterData signUpMasterData) {
        this.signUpMasterData = signUpMasterData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(signUpMasterData);
        dest.writeValue(error);
    }

    public int describeContents() {
        return  0;
    }

}
