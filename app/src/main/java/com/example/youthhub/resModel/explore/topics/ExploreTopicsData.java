
package com.example.youthhub.resModel.explore.topics;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExploreTopicsData implements Parcelable
{

    @SerializedName("exploredetail")
    @Expose
    private ExploreTopicDetail exploreTopicDetail;
    @SerializedName("is_topic_info")
    @Expose
    private Integer isTopicInfo;
    @SerializedName("topic_info")
    @Expose
    private TopicInfo topicInfo;
    @SerializedName("is_topic_content")
    @Expose
    private Integer isTopicContent;
    @SerializedName("topic_content")
    @Expose
    private List<TopicContent> topicContent = new ArrayList<>();
    public final static Creator<ExploreTopicsData> CREATOR = new Creator<ExploreTopicsData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ExploreTopicsData createFromParcel(Parcel in) {
            return new ExploreTopicsData(in);
        }

        public ExploreTopicsData[] newArray(int size) {
            return (new ExploreTopicsData[size]);
        }

    }
    ;

    protected ExploreTopicsData(Parcel in) {
        this.exploreTopicDetail = ((ExploreTopicDetail) in.readValue((ExploreTopicDetail.class.getClassLoader())));
        this.isTopicInfo = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.topicInfo = ((TopicInfo) in.readValue((TopicInfo.class.getClassLoader())));
        this.isTopicContent = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.topicContent, (com.example.youthhub.resModel.explore.topics.TopicContent.class.getClassLoader()));
    }

    public ExploreTopicsData() {
    }

    public ExploreTopicDetail getExploreTopicDetail() {
        return exploreTopicDetail;
    }

    public void setExploreTopicDetail(ExploreTopicDetail exploreTopicDetail) {
        this.exploreTopicDetail = exploreTopicDetail;
    }

    public Integer getIsTopicInfo() {
        return isTopicInfo;
    }

    public void setIsTopicInfo(Integer isTopicInfo) {
        this.isTopicInfo = isTopicInfo;
    }

    public TopicInfo getTopicInfo() {
        return topicInfo;
    }

    public void setTopicInfo(TopicInfo topicInfo) {
        this.topicInfo = topicInfo;
    }

    public Integer getIsTopicContent() {
        return isTopicContent;
    }

    public void setIsTopicContent(Integer isTopicContent) {
        this.isTopicContent = isTopicContent;
    }

    public List<TopicContent> getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(List<TopicContent> topicContent) {
        this.topicContent = topicContent;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(exploreTopicDetail);
        dest.writeValue(isTopicInfo);
        dest.writeValue(topicInfo);
        dest.writeValue(isTopicContent);
        dest.writeList(topicContent);
    }

    public int describeContents() {
        return  0;
    }

}
