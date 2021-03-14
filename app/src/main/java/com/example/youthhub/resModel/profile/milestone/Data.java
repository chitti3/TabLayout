package com.example.youthhub.resModel.profile.milestone;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data implements Parcelable {

	@SerializedName("video_path_source")
	private String videoPathSource;

	@SerializedName("milestone_list")
	private List<MilestoneListItem> milestoneList;

	@SerializedName("image_path_source")
	private String imagePathSource;

	@SerializedName("image_path_medium")
	private String imagePathMedium;

	@SerializedName("default_image")
	private String defaultImage;

	@SerializedName("video_path_image")
	private String videoPathImage;

	public void setVideoPathSource(String videoPathSource){
		this.videoPathSource = videoPathSource;
	}

	public String getVideoPathSource(){
		return videoPathSource;
	}

	public void setMilestoneList(List<MilestoneListItem> milestoneList){
		this.milestoneList = milestoneList;
	}

	public List<MilestoneListItem> getMilestoneList(){
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
			",video_path_image = '" + videoPathImage + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.videoPathSource);
		dest.writeList(this.milestoneList);
		dest.writeString(this.imagePathSource);
		dest.writeString(this.imagePathMedium);
		dest.writeString(this.defaultImage);
		dest.writeString(this.videoPathImage);
	}

	public Data() {
	}

	protected Data(Parcel in) {
		this.videoPathSource = in.readString();
		this.milestoneList = new ArrayList<MilestoneListItem>();
		in.readList(this.milestoneList, MilestoneListItem.class.getClassLoader());
		this.imagePathSource = in.readString();
		this.imagePathMedium = in.readString();
		this.defaultImage = in.readString();
		this.videoPathImage = in.readString();
	}

	public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() {
		@Override
		public Data createFromParcel(Parcel source) {
			return new Data(source);
		}

		@Override
		public Data[] newArray(int size) {
			return new Data[size];
		}
	};
}