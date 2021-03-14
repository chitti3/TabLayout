
package com.example.youthhub.resModel.explore;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreViewData implements Parcelable
{

    @SerializedName("is_relatedexplore")
    @Expose
    private Integer isRelatedexplore;
    @SerializedName("exploredetail")
    @Expose
    private Exploredetail exploredetail;
    @SerializedName("user_rating")
    @Expose
    private UserRating userRating;
    @SerializedName("relatedexplore")
    @Expose
    private List<Relatedexplore> relatedexplore = new ArrayList<>();
    @SerializedName("topics")
    @Expose
    private List<Topic> topics = new ArrayList<>();
    public final static Creator<ExploreViewData> CREATOR = new Creator<ExploreViewData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreViewData createFromParcel(Parcel in) {
            return new ExploreViewData(in);
        }

        public ExploreViewData[] newArray(int size) {
            return (new ExploreViewData[size]);
        }

    }
    ;

    protected ExploreViewData(Parcel in) {
        this.isRelatedexplore = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.exploredetail = ((Exploredetail) in.readValue((Exploredetail.class.getClassLoader())));
        this.userRating = ((UserRating) in.readValue((UserRating.class.getClassLoader())));
        in.readList(this.relatedexplore, (Relatedexplore.class.getClassLoader()));
        in.readList(this.topics, (Topic.class.getClassLoader()));
    }

    public ExploreViewData() {
    }

    public Integer getIsRelatedexplore() {
        return isRelatedexplore;
    }

    public void setIsRelatedexplore(Integer isRelatedexplore) {
        this.isRelatedexplore = isRelatedexplore;
    }

    public Exploredetail getExploredetail() {
        return exploredetail;
    }

    public void setExploredetail(Exploredetail exploredetail) {
        this.exploredetail = exploredetail;
    }

    public UserRating getUserRating() {
        return userRating;
    }

    public void setUserRating(UserRating userRating) {
        this.userRating = userRating;
    }

    public List<Relatedexplore> getRelatedexplore() {
        return relatedexplore;
    }

    public void setRelatedexplore(List<Relatedexplore> relatedexplore) {
        this.relatedexplore = relatedexplore;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(isRelatedexplore);
        dest.writeValue(exploredetail);
        dest.writeValue(userRating);
        dest.writeList(relatedexplore);
        dest.writeList(topics);
    }

    public int describeContents() {
        return  0;
    }

}
