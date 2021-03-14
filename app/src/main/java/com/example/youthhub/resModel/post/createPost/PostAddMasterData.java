
package com.example.youthhub.resModel.post.createPost;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostAddMasterData implements Parcelable
{

    @SerializedName("tags")
    @Expose
    private List<Tag> tags = new ArrayList<>();
    @SerializedName("prime_tags")
    @Expose
    private List<PrimeTag> primeTags = new ArrayList<>();
    @SerializedName("journey_lists")
    @Expose
    private List<JourneyList> journeyLists = new ArrayList<>();
    @SerializedName("post_type")
    @Expose
    private List<PostType> postType = new ArrayList<>();
    @SerializedName("prime_tags_path")
    @Expose
    private String primeTagsPath;
    public final static Creator<PostAddMasterData> CREATOR = new Creator<PostAddMasterData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PostAddMasterData createFromParcel(Parcel in) {
            return new PostAddMasterData(in);
        }

        public PostAddMasterData[] newArray(int size) {
            return (new PostAddMasterData[size]);
        }

    }
    ;

    protected PostAddMasterData(Parcel in) {
        in.readList(this.tags, (com.example.youthhub.resModel.post.createPost.Tag.class.getClassLoader()));
        in.readList(this.primeTags, (com.example.youthhub.resModel.post.createPost.PrimeTag.class.getClassLoader()));
        in.readList(this.journeyLists, (com.example.youthhub.resModel.post.createPost.JourneyList.class.getClassLoader()));
        in.readList(this.postType, (com.example.youthhub.resModel.post.createPost.PostType.class.getClassLoader()));
        this.primeTagsPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public PostAddMasterData() {
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public List<PrimeTag> getPrimeTags() {
        return primeTags;
    }

    public void setPrimeTags(List<PrimeTag> primeTags) {
        this.primeTags = primeTags;
    }

    public List<JourneyList> getJourneyLists() {
        return journeyLists;
    }

    public void setJourneyLists(List<JourneyList> journeyLists) {
        this.journeyLists = journeyLists;
    }

    public List<PostType> getPostType() {
        return postType;
    }

    public void setPostType(List<PostType> postType) {
        this.postType = postType;
    }

    public String getPrimeTagsPath() {
        return primeTagsPath;
    }

    public void setPrimeTagsPath(String primeTagsPath) {
        this.primeTagsPath = primeTagsPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(tags);
        dest.writeList(primeTags);
        dest.writeList(journeyLists);
        dest.writeList(postType);
        dest.writeValue(primeTagsPath);
    }

    public int describeContents() {
        return  0;
    }

}
