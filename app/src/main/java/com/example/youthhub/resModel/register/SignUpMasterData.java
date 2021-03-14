
package com.example.youthhub.resModel.register;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SignUpMasterData implements Parcelable
{

    @SerializedName("user_type")
    @Expose
    private List<UserType> userType = null;
    @SerializedName("privacy_policy_url")
    @Expose
    private String privacyPolicyUrl;
    public final static Creator<SignUpMasterData> CREATOR = new Creator<SignUpMasterData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SignUpMasterData createFromParcel(Parcel in) {
            return new SignUpMasterData(in);
        }

        public SignUpMasterData[] newArray(int size) {
            return (new SignUpMasterData[size]);
        }

    }
    ;

    protected SignUpMasterData(Parcel in) {
        in.readList(this.userType, (com.example.youthhub.resModel.register.UserType.class.getClassLoader()));
        this.privacyPolicyUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SignUpMasterData() {
    }

    public List<UserType> getUserType() {
        return userType;
    }

    public void setUserType(List<UserType> userType) {
        this.userType = userType;
    }

    public String getPrivacyPolicyUrl() {
        return privacyPolicyUrl;
    }

    public void setPrivacyPolicyUrl(String privacyPolicyUrl) {
        this.privacyPolicyUrl = privacyPolicyUrl;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(userType);
        dest.writeValue(privacyPolicyUrl);
    }

    public int describeContents() {
        return  0;
    }

}
