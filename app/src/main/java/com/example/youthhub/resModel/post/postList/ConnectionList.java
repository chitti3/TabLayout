
package com.example.youthhub.resModel.post.postList;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConnectionList implements Parcelable
{

    @SerializedName("userid")
    @Expose
    private String userid;
    @SerializedName("usercode")
    @Expose
    private String usercode;
    @SerializedName("about_me")
    @Expose
    private String aboutMe;
    @SerializedName("usertype")
    @Expose
    private String usertype;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("region_name")
    @Expose
    private String regionName;
    @SerializedName("profile")
    @Expose
    private String profile;
    @SerializedName("subtitle1")
    @Expose
    private String subtitle1;
    @SerializedName("subtitle2")
    @Expose
    private String subtitle2;
    @SerializedName("username_code")
    @Expose
    private String usernameCode;
    @SerializedName("is_pic_exist")
    @Expose
    private Integer isPicExist;
    @SerializedName("is_follow")
    @Expose
    private Integer isFollow;
    @SerializedName("chat_id")
    @Expose
    private Integer chatId;
    public final static Creator<ConnectionList> CREATOR = new Creator<ConnectionList>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ConnectionList createFromParcel(Parcel in) {
            return new ConnectionList(in);
        }

        public ConnectionList[] newArray(int size) {
            return (new ConnectionList[size]);
        }

    }
    ;

    protected ConnectionList(Parcel in) {
        this.userid = ((String) in.readValue((String.class.getClassLoader())));
        this.usercode = ((String) in.readValue((String.class.getClassLoader())));
        this.aboutMe = ((String) in.readValue((String.class.getClassLoader())));
        this.usertype = ((String) in.readValue((String.class.getClassLoader())));
        this.username = ((String) in.readValue((String.class.getClassLoader())));
        this.regionName = ((String) in.readValue((String.class.getClassLoader())));
        this.profile = ((String) in.readValue((String.class.getClassLoader())));
        this.subtitle1 = ((String) in.readValue((String.class.getClassLoader())));
        this.subtitle2 = ((String) in.readValue((String.class.getClassLoader())));
        this.usernameCode = ((String) in.readValue((String.class.getClassLoader())));
        this.isPicExist = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isFollow = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.chatId = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public ConnectionList() {
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getSubtitle1() {
        return subtitle1;
    }

    public void setSubtitle1(String subtitle1) {
        this.subtitle1 = subtitle1;
    }

    public String getSubtitle2() {
        return subtitle2;
    }

    public void setSubtitle2(String subtitle2) {
        this.subtitle2 = subtitle2;
    }

    public String getUsernameCode() {
        return usernameCode;
    }

    public void setUsernameCode(String usernameCode) {
        this.usernameCode = usernameCode;
    }

    public Integer getIsPicExist() {
        return isPicExist;
    }

    public void setIsPicExist(Integer isPicExist) {
        this.isPicExist = isPicExist;
    }

    public Integer getIsFollow() {
        return isFollow;
    }

    public void setIsFollow(Integer isFollow) {
        this.isFollow = isFollow;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(userid);
        dest.writeValue(usercode);
        dest.writeValue(aboutMe);
        dest.writeValue(usertype);
        dest.writeValue(username);
        dest.writeValue(regionName);
        dest.writeValue(profile);
        dest.writeValue(subtitle1);
        dest.writeValue(subtitle2);
        dest.writeValue(usernameCode);
        dest.writeValue(isPicExist);
        dest.writeValue(isFollow);
        dest.writeValue(chatId);
    }

    public int describeContents() {
        return  0;
    }

}
