package com.example.youthhub.resModel.profile.visualjourney.milestoneadd;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("video_path_source")
	private String videoPathSource;

	@SerializedName("milestone_list")
	private MilestoneList milestoneList;

	@SerializedName("image_path_source")
	private String imagePathSource;

	@SerializedName("image_path_medium")
	private String imagePathMedium;

	@SerializedName("default_image")
	private String defaultImage;

	@SerializedName("point_score_msg")
	private String pointScoreMsg;

	@SerializedName("video_path_image")
	private String videoPathImage;

	public void setVideoPathSource(String videoPathSource){
		this.videoPathSource = videoPathSource;
	}

	public String getVideoPathSource(){
		return videoPathSource;
	}

	public void setMilestoneList(MilestoneList milestoneList){
		this.milestoneList = milestoneList;
	}

	public MilestoneList getMilestoneList(){
		return milestoneList;
	}

	public void setImagePathSource(String imagePathSource){
		this.imagePathSource = imagePathSource;
	}

	public String getImagePathSource(){
		return imagePathSource;
	}

	public void setImagePathMedium(String imagePathMedium){
		this.imagePathMedium = imagePathMedium;
	}

	public String getImagePathMedium(){
		return imagePathMedium;
	}

	public void setDefaultImage(String defaultImage){
		this.defaultImage = defaultImage;
	}

	public String getDefaultImage(){
		return defaultImage;
	}

	public void setPointScoreMsg(String pointScoreMsg){
		this.pointScoreMsg = pointScoreMsg;
	}

	public String getPointScoreMsg(){
		return pointScoreMsg;
	}

	public void setVideoPathImage(String videoPathImage){
		this.videoPathImage = videoPathImage;
	}

	public String getVideoPathImage(){
		return videoPathImage;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"video_path_source = '" + videoPathSource + '\'' + 
			",milestone_list = '" + milestoneList + '\'' + 
			",image_path_source = '" + imagePathSource + '\'' + 
			",image_path_medium = '" + imagePathMedium + '\'' + 
			",default_image = '" + defaultImage + '\'' + 
			",point_score_msg = '" + pointScoreMsg + '\'' + 
			",video_path_image = '" + videoPathImage + '\'' + 
			"}";
		}
}