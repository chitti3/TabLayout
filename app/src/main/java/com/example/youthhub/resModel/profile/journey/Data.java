package com.example.youthhub.resModel.profile.journey;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data implements Parcelable {

	@SerializedName("video_path_source")
	private String videoPathSource;

	@SerializedName("image_path_source")
	private String imagePathSource;

	@SerializedName("profile_user_id")
	private String profileUserId;

	@SerializedName("journeylist")
	private List<JourneylistItem> journeylist;

	@SerializedName("profile_user_type")
	private String profileUserType;

	@SerializedName("login_user_id")
	private String loginUserId;

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

	public void setImagePathSource(String imagePathSource){
		this.imagePathSource = imagePathSource;
	}

	public String getImagePathSource(){
		return imagePathSource;
	}

	public void setProfileUserId(String profileUserId){
		this.profileUserId = profileUserId;
	}

	public String getProfileUserId(){
		return profileUserId;
	}

	public void setJourneylist(List<JourneylistItem> journeylist){
		this.journeylist = journeylist;
	}

	public List<JourneylistItem> getJourneylist(){
		return journeylist;
	}

	public void setProfileUserType(String profileUserType){
		this.profileUserType = profileUserType;
	}

	public String getProfileUserType(){
		return profileUserType;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginUserId(){
		return loginUserId;
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
			",image_path_source = '" + imagePathSource + '\'' + 
			",profile_user_id = '" + profileUserId + '\'' + 
			",journeylist = '" + journeylist + '\'' + 
			",profile_user_type = '" + profileUserType + '\'' + 
			",login_user_id = '" + loginUserId + '\'' + 
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
		dest.writeString(this.imagePathSource);
		dest.writeString(this.profileUserId);
		dest.writeTypedList(this.journeylist);
		dest.writeString(this.profileUserType);
		dest.writeString(this.loginUserId);
		dest.writeString(this.imagePathMedium);
		dest.writeString(this.defaultImage);
		dest.writeString(this.videoPathImage);
	}

	public Data() {
	}

	protected Data(Parcel in) {
		this.videoPathSource = in.readString();
		this.imagePathSource = in.readString();
		this.profileUserId = in.readString();
		this.journeylist = in.createTypedArrayList(JourneylistItem.CREATOR);
		this.profileUserType = in.readString();
		this.loginUserId = in.readString();
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