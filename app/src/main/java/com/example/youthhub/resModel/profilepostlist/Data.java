package com.example.youthhub.resModel.profilepostlist;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("post_list")
	private List<PostListItem> postList;

	@SerializedName("jobs_list")
	private List<JobsListItem> jobsList;

	@SerializedName("path_medium")
	private String pathMedium;

	@SerializedName("connection_list")
	private List<ConnectionListItem> connectionList;

	@SerializedName("event_logo_path")
	private String eventLogoPath;

	@SerializedName("event_count")
	private int eventCount;

	@SerializedName("vid_poster_path")
	private String vidPosterPath;

	@SerializedName("event_list")
	private List<EventListItem> eventList;

	@SerializedName("path_source")
	private String pathSource;

	@SerializedName("path_thumb")
	private String pathThumb;

	@SerializedName("profile_medium_path")
	private String profileMediumPath;

	@SerializedName("connection_count")
	private int connectionCount;

	@SerializedName("explore_path2")
	private String explorePath2;

	@SerializedName("path_large")
	private String pathLarge;

	@SerializedName("explore_path1")
	private String explorePath1;

	@SerializedName("jobs_count")
	private int jobsCount;

	@SerializedName("profile_thumbnail_path")
	private String profileThumbnailPath;

	@SerializedName("vid_path")
	private String vidPath;

	public void setPostList(List<PostListItem> postList){
		this.postList = postList;
	}

	public List<PostListItem> getPostList(){
		return postList;
	}

	public void setJobsList(List<JobsListItem> jobsList){
		this.jobsList = jobsList;
	}

	public List<JobsListItem> getJobsList(){
		return jobsList;
	}

	public void setPathMedium(String pathMedium){
		this.pathMedium = pathMedium;
	}

	public String getPathMedium(){
		return pathMedium;
	}

	public void setConnectionList(List<ConnectionListItem> connectionList){
		this.connectionList = connectionList;
	}

	public List<ConnectionListItem> getConnectionList(){
		return connectionList;
	}

	public void setEventLogoPath(String eventLogoPath){
		this.eventLogoPath = eventLogoPath;
	}

	public String getEventLogoPath(){
		return eventLogoPath;
	}

	public void setEventCount(int eventCount){
		this.eventCount = eventCount;
	}

	public int getEventCount(){
		return eventCount;
	}

	public void setVidPosterPath(String vidPosterPath){
		this.vidPosterPath = vidPosterPath;
	}

	public String getVidPosterPath(){
		return vidPosterPath;
	}

	public void setEventList(List<EventListItem> eventList){
		this.eventList = eventList;
	}

	public List<EventListItem> getEventList(){
		return eventList;
	}

	public void setPathSource(String pathSource){
		this.pathSource = pathSource;
	}

	public String getPathSource(){
		return pathSource;
	}

	public void setPathThumb(String pathThumb){
		this.pathThumb = pathThumb;
	}

	public String getPathThumb(){
		return pathThumb;
	}

	public void setProfileMediumPath(String profileMediumPath){
		this.profileMediumPath = profileMediumPath;
	}

	public String getProfileMediumPath(){
		return profileMediumPath;
	}

	public void setConnectionCount(int connectionCount){
		this.connectionCount = connectionCount;
	}

	public int getConnectionCount(){
		return connectionCount;
	}

	public void setExplorePath2(String explorePath2){
		this.explorePath2 = explorePath2;
	}

	public String getExplorePath2(){
		return explorePath2;
	}

	public void setPathLarge(String pathLarge){
		this.pathLarge = pathLarge;
	}

	public String getPathLarge(){
		return pathLarge;
	}

	public void setExplorePath1(String explorePath1){
		this.explorePath1 = explorePath1;
	}

	public String getExplorePath1(){
		return explorePath1;
	}

	public void setJobsCount(int jobsCount){
		this.jobsCount = jobsCount;
	}

	public int getJobsCount(){
		return jobsCount;
	}

	public void setProfileThumbnailPath(String profileThumbnailPath){
		this.profileThumbnailPath = profileThumbnailPath;
	}

	public String getProfileThumbnailPath(){
		return profileThumbnailPath;
	}

	public void setVidPath(String vidPath){
		this.vidPath = vidPath;
	}

	public String getVidPath(){
		return vidPath;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"post_list = '" + postList + '\'' + 
			",jobs_list = '" + jobsList + '\'' + 
			",path_medium = '" + pathMedium + '\'' + 
			",connection_list = '" + connectionList + '\'' + 
			",event_logo_path = '" + eventLogoPath + '\'' + 
			",event_count = '" + eventCount + '\'' + 
			",vid_poster_path = '" + vidPosterPath + '\'' + 
			",event_list = '" + eventList + '\'' + 
			",path_source = '" + pathSource + '\'' + 
			",path_thumb = '" + pathThumb + '\'' + 
			",profile_medium_path = '" + profileMediumPath + '\'' + 
			",connection_count = '" + connectionCount + '\'' + 
			",explore_path2 = '" + explorePath2 + '\'' + 
			",path_large = '" + pathLarge + '\'' + 
			",explore_path1 = '" + explorePath1 + '\'' + 
			",jobs_count = '" + jobsCount + '\'' + 
			",profile_thumbnail_path = '" + profileThumbnailPath + '\'' + 
			",vid_path = '" + vidPath + '\'' + 
			"}";
		}
}