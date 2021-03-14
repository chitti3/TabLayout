
package com.example.youthhub.resModel.connection.conListMaster;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConnectionListMasterData implements Parcelable
{

    @SerializedName("user_type")
    @Expose
    private List<UserType> userType = new ArrayList<>();
    @SerializedName("region")
    @Expose
    private List<Region> region = new ArrayList<>();
    @SerializedName("city")
    @Expose
    private List<City> city = new ArrayList<>();
    @SerializedName("service")
    @Expose
    private List<Service> service = new ArrayList<>();
    @SerializedName("bizservice")
    @Expose
    private List<Bizservice> bizservice = new ArrayList<>();
    @SerializedName("tag")
    @Expose
    private List<Tag> tag = new ArrayList<>();
    @SerializedName("wishlist")
    @Expose
    private List<Wishlist> wishlist = new ArrayList<>();
    @SerializedName("skills")
    @Expose
    private List<Skill> skills = new ArrayList<>();
    public final static Creator<ConnectionListMasterData> CREATOR = new Creator<ConnectionListMasterData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ConnectionListMasterData createFromParcel(Parcel in) {
            return new ConnectionListMasterData(in);
        }

        public ConnectionListMasterData[] newArray(int size) {
            return (new ConnectionListMasterData[size]);
        }

    }
    ;

    protected ConnectionListMasterData(Parcel in) {
        in.readList(this.userType, (com.example.youthhub.resModel.connection.conListMaster.UserType.class.getClassLoader()));
        in.readList(this.region, (com.example.youthhub.resModel.connection.conListMaster.Region.class.getClassLoader()));
        in.readList(this.city, (City.class.getClassLoader()));
        in.readList(this.service, (com.example.youthhub.resModel.connection.conListMaster.Service.class.getClassLoader()));
        in.readList(this.bizservice, (com.example.youthhub.resModel.connection.conListMaster.Bizservice.class.getClassLoader()));
        in.readList(this.tag, (com.example.youthhub.resModel.connection.conListMaster.Tag.class.getClassLoader()));
        in.readList(this.wishlist, (com.example.youthhub.resModel.connection.conListMaster.Wishlist.class.getClassLoader()));
        in.readList(this.skills, (com.example.youthhub.resModel.connection.conListMaster.Skill.class.getClassLoader()));
    }

    public ConnectionListMasterData() {
    }

    public List<UserType> getUserType() {
        return userType;
    }

    public void setUserType(List<UserType> userType) {
        this.userType = userType;
    }

    public List<Region> getRegion() {
        return region;
    }

    public void setRegion(List<Region> region) {
        this.region = region;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    public List<Service> getService() {
        return service;
    }

    public void setService(List<Service> service) {
        this.service = service;
    }

    public List<Bizservice> getBizservice() {
        return bizservice;
    }

    public void setBizservice(List<Bizservice> bizservice) {
        this.bizservice = bizservice;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    public List<Wishlist> getWishlist() {
        return wishlist;
    }

    public void setWishlist(List<Wishlist> wishlist) {
        this.wishlist = wishlist;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(userType);
        dest.writeList(region);
        dest.writeList(city);
        dest.writeList(service);
        dest.writeList(bizservice);
        dest.writeList(tag);
        dest.writeList(wishlist);
        dest.writeList(skills);
    }

    public int describeContents() {
        return  0;
    }

}
