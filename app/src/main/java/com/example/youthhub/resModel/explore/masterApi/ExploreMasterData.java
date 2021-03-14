
package com.example.youthhub.resModel.explore.masterApi;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreMasterData implements Parcelable
{

    @SerializedName("rating")
    @Expose
    private List<Rating> rating = new ArrayList<>();
    @SerializedName("content_type")
    @Expose
    private List<ContentType> contentType = new ArrayList<>();
    @SerializedName("explore_tags")
    @Expose
    private List<ExploreTag> exploreTags = new ArrayList<>();
    @SerializedName("type")
    @Expose
    private List<Type> type = new ArrayList<>();
    public final static Creator<ExploreMasterData> CREATOR = new Creator<ExploreMasterData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreMasterData createFromParcel(Parcel in) {
            return new ExploreMasterData(in);
        }

        public ExploreMasterData[] newArray(int size) {
            return (new ExploreMasterData[size]);
        }

    }
    ;

    protected ExploreMasterData(Parcel in) {
        in.readList(this.rating, (com.example.youthhub.resModel.explore.masterApi.Rating.class.getClassLoader()));
        in.readList(this.contentType, (com.example.youthhub.resModel.explore.masterApi.ContentType.class.getClassLoader()));
        in.readList(this.exploreTags, (com.example.youthhub.resModel.explore.masterApi.ExploreTag.class.getClassLoader()));
        in.readList(this.type, (com.example.youthhub.resModel.explore.masterApi.Type.class.getClassLoader()));
    }

    public ExploreMasterData() {
    }

    public List<Rating> getRating() {
        return rating;
    }

    public void setRating(List<Rating> rating) {
        this.rating = rating;
    }

    public List<ContentType> getContentType() {
        return contentType;
    }

    public void setContentType(List<ContentType> contentType) {
        this.contentType = contentType;
    }

    public List<ExploreTag> getExploreTags() {
        return exploreTags;
    }

    public void setExploreTags(List<ExploreTag> exploreTags) {
        this.exploreTags = exploreTags;
    }

    public List<Type> getType() {
        return type;
    }

    public void setType(List<Type> type) {
        this.type = type;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(rating);
        dest.writeList(contentType);
        dest.writeList(exploreTags);
        dest.writeList(type);
    }

    public int describeContents() {
        return  0;
    }

}
