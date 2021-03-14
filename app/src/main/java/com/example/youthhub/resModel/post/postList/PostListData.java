
package com.example.youthhub.resModel.post.postList;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostListData implements Parcelable
{

    @SerializedName("post_list")
    @Expose
    private List<PostList> postList = new ArrayList<>();
    @SerializedName("event_count")
    @Expose
    private Integer eventCount;
    @SerializedName("event_list")
    @Expose
    private List<EventList> eventList = new ArrayList<>();

    @SerializedName("jobs_count")
    @Expose
    private Integer jobsCount;
    @SerializedName("jobs_list")
    @Expose
    private List<JobsList> jobsList  = new ArrayList<>();
    @SerializedName("connection_count")
    @Expose
    private Integer connectionCount;
    @SerializedName("connection_list")
    @Expose
    private List<ConnectionList> connectionList  = new ArrayList<>();
    @SerializedName("path_source")
    @Expose
    private String pathSource;
    @SerializedName("path_large")
    @Expose
    private String pathLarge;
    @SerializedName("path_medium")
    @Expose
    private String pathMedium;
    @SerializedName("path_thumb")
    @Expose
    private String pathThumb;
    @SerializedName("vid_path")
    @Expose
    private String vidPath;
    @SerializedName("vid_poster_path")
    @Expose
    private String vidPosterPath;
    @SerializedName("profile_medium_path")
    @Expose
    private String profileMediumPath;
    @SerializedName("profile_thumbnail_path")
    @Expose
    private String profileThumbnailPath;
    @SerializedName("event_logo_path")
    @Expose
    private String eventLogoPath;

    @SerializedName("explore_path1")
    @Expose
    private String explore_path1;
    @SerializedName("explore_path2")
    @Expose
    private String explore_path2;
    public final static Creator<PostListData> CREATOR = new Creator<PostListData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PostListData createFromParcel(Parcel in) {
            return new PostListData(in);
        }

        public PostListData[] newArray(int size) {
            return (new PostListData[size]);
        }

    }
    ;

    protected PostListData(Parcel in) {
        in.readList(this.postList, (com.example.youthhub.resModel.post.postList.PostList.class.getClassLoader()));
        this.eventCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
    //    this.gallery_list = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.eventList, (com.example.youthhub.resModel.post.postList.EventList.class.getClassLoader()));
        this.jobsCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.jobsList, (com.example.youthhub.resModel.post.postList.JobsList.class.getClassLoader()));
        this.connectionCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.connectionList, (ConnectionList.class.getClassLoader()));
        this.pathSource = ((String) in.readValue((String.class.getClassLoader())));
        this.pathLarge = ((String) in.readValue((String.class.getClassLoader())));
        this.pathMedium = ((String) in.readValue((String.class.getClassLoader())));
        this.pathThumb = ((String) in.readValue((String.class.getClassLoader())));
        this.vidPath = ((String) in.readValue((String.class.getClassLoader())));
        this.vidPosterPath = ((String) in.readValue((String.class.getClassLoader())));
        this.profileMediumPath = ((String) in.readValue((String.class.getClassLoader())));
        this.profileThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
        this.eventLogoPath = ((String) in.readValue((String.class.getClassLoader())));
        this.explore_path1 = ((String) in.readValue((String.class.getClassLoader())));
        this.explore_path2 = ((String) in.readValue((String.class.getClassLoader())));
    }


    public PostListData() {
    }

    public String getExplore_path1() {
        return explore_path1;
    }

    public void setExplore_path1(String explore_path1) {
        this.explore_path1 = explore_path1;
    }

    public String getExplore_path2() {
        return explore_path2;
    }

    public void setExplore_path2(String explore_path2) {
        this.explore_path2 = explore_path2;
    }

    public List<PostList> getPostList() {
        return postList;
    }

    public void setPostList(List<PostList> postList) {
        this.postList = postList;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public List<EventList> getEventList() {
        return eventList;
    }

    public void setEventList(List<EventList> eventList) {
        this.eventList = eventList;
    }

    public Integer getJobsCount() {
        return jobsCount;
    }

    public void setJobsCount(Integer jobsCount) {
        this.jobsCount = jobsCount;
    }

    public List<JobsList> getJobsList() {
        return jobsList;
    }

    public void setJobsList(List<JobsList> jobsList) {
        this.jobsList = jobsList;
    }

    public Integer getConnectionCount() {
        return connectionCount;
    }

    public void setConnectionCount(Integer connectionCount) {
        this.connectionCount = connectionCount;
    }

    public List<ConnectionList> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<ConnectionList> connectionList) {
        this.connectionList = connectionList;
    }

    public String getPathSource() {
        return pathSource;
    }

    public void setPathSource(String pathSource) {
        this.pathSource = pathSource;
    }

    public String getPathLarge() {
        return pathLarge;
    }

    public void setPathLarge(String pathLarge) {
        this.pathLarge = pathLarge;
    }

    public String getPathMedium() {
        return pathMedium;
    }

    public void setPathMedium(String pathMedium) {
        this.pathMedium = pathMedium;
    }

    public String getPathThumb() {
        return pathThumb;
    }

    public void setPathThumb(String pathThumb) {
        this.pathThumb = pathThumb;
    }

    public String getVidPath() {
        return vidPath;
    }

    public void setVidPath(String vidPath) {
        this.vidPath = vidPath;
    }

    public String getVidPosterPath() {
        return vidPosterPath;
    }

    public void setVidPosterPath(String vidPosterPath) {
        this.vidPosterPath = vidPosterPath;
    }

    public String getProfileMediumPath() {
        return profileMediumPath;
    }

    public void setProfileMediumPath(String profileMediumPath) {
        this.profileMediumPath = profileMediumPath;
    }

    public String getProfileThumbnailPath() {
        return profileThumbnailPath;
    }

    public void setProfileThumbnailPath(String profileThumbnailPath) {
        this.profileThumbnailPath = profileThumbnailPath;
    }

    public String getEventLogoPath() {
        return eventLogoPath;
    }

    public void setEventLogoPath(String eventLogoPath) {
        this.eventLogoPath = eventLogoPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(postList);
        dest.writeValue(eventCount);
        dest.writeList(eventList);
        dest.writeValue(jobsCount);
        dest.writeList(jobsList);
        dest.writeValue(connectionCount);
        dest.writeList(connectionList);
        dest.writeValue(pathSource);
        dest.writeValue(pathLarge);
        dest.writeValue(pathMedium);
        dest.writeValue(pathThumb);
        dest.writeValue(vidPath);
        dest.writeValue(vidPosterPath);
        dest.writeValue(profileMediumPath);
        dest.writeValue(profileThumbnailPath);
        dest.writeValue(eventLogoPath);
        dest.writeValue(explore_path1);
        dest.writeValue(explore_path2);
    }

    public int describeContents() {
        return  0;
    }

}
