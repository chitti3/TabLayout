package com.example.youthhub.resModel.profile.milestone;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class MilestoneListItem implements Parcelable {

	@SerializedName("juc_video")
	private String jucVideo;

	@SerializedName("jus_created_by")
	private String jusCreatedBy;

	@SerializedName("juc_content_id")
	private String jucContentId;

	@SerializedName("juc_video_id")
	private String jucVideoId;

	@SerializedName("jus_pm_post_id")
	private String jusPmPostId;

	@SerializedName("juc_title")
	private String jucTitle;

	@SerializedName("jus_created_on")
	private String jusCreatedOn;

	@SerializedName("jus_active")
	private String jusActive;

	@SerializedName("juc_image")
	private String jucImage;

	@SerializedName("juc_video_poster")
	private String jucVideoPoster;

	@SerializedName("jus_updated_by")
	private String jusUpdatedBy;

	@SerializedName("jus_jum_journey_id")
	private String jusJumJourneyId;

	@SerializedName("juc_type")
	private String jucType;

	@SerializedName("jus_detail")
	private String jusDetail;

	@SerializedName("jus_date")
	private String jusDate;

	@SerializedName("jus_updated_on")
	private String jusUpdatedOn;

	@SerializedName("jus_milestone_id")
	private String jusMilestoneId;

	@SerializedName("jus_title")
	private String jusTitle;

	public void setJucVideo(String jucVideo){
		this.jucVideo = jucVideo;
	}

	public String getJucVideo(){
		return jucVideo;
	}

	public void setJusCreatedBy(String jusCreatedBy){
		this.jusCreatedBy = jusCreatedBy;
	}

	public String getJusCreatedBy(){
		return jusCreatedBy;
	}

	public void setJucContentId(String jucContentId){
		this.jucContentId = jucContentId;
	}

	public String getJucContentId(){
		return jucContentId;
	}

	public void setJucVideoId(String jucVideoId){
		this.jucVideoId = jucVideoId;
	}

	public String getJucVideoId(){
		return jucVideoId;
	}

	public void setJusPmPostId(String jusPmPostId){
		this.jusPmPostId = jusPmPostId;
	}

	public String getJusPmPostId(){
		return jusPmPostId;
	}

	public void setJucTitle(String jucTitle){
		this.jucTitle = jucTitle;
	}

	public String getJucTitle(){
		return jucTitle;
	}

	public void setJusCreatedOn(String jusCreatedOn){
		this.jusCreatedOn = jusCreatedOn;
	}

	public String getJusCreatedOn(){
		return jusCreatedOn;
	}

	public void setJusActive(String jusActive){
		this.jusActive = jusActive;
	}

	public String getJusActive(){
		return jusActive;
	}

	public void setJucImage(String jucImage){
		this.jucImage = jucImage;
	}

	public String getJucImage(){
		return jucImage;
	}

	public void setJucVideoPoster(String jucVideoPoster){
		this.jucVideoPoster = jucVideoPoster;
	}

	public String getJucVideoPoster(){
		return jucVideoPoster;
	}

	public void setJusUpdatedBy(String jusUpdatedBy){
		this.jusUpdatedBy = jusUpdatedBy;
	}

	public String getJusUpdatedBy(){
		return jusUpdatedBy;
	}

	public void setJusJumJourneyId(String jusJumJourneyId){
		this.jusJumJourneyId = jusJumJourneyId;
	}

	public String getJusJumJourneyId(){
		return jusJumJourneyId;
	}

	public void setJucType(String jucType){
		this.jucType = jucType;
	}

	public String getJucType(){
		return jucType;
	}

	public void setJusDetail(String jusDetail){
		this.jusDetail = jusDetail;
	}

	public String getJusDetail(){
		return jusDetail;
	}

	public void setJusDate(String jusDate){
		this.jusDate = jusDate;
	}

	public String getJusDate(){
		return jusDate;
	}

	public void setJusUpdatedOn(String jusUpdatedOn){
		this.jusUpdatedOn = jusUpdatedOn;
	}

	public String getJusUpdatedOn(){
		return jusUpdatedOn;
	}

	public void setJusMilestoneId(String jusMilestoneId){
		this.jusMilestoneId = jusMilestoneId;
	}

	public String getJusMilestoneId(){
		return jusMilestoneId;
	}

	public void setJusTitle(String jusTitle){
		this.jusTitle = jusTitle;
	}

	public String getJusTitle(){
		return jusTitle;
	}

	@Override
 	public String toString(){
		return 
			"MilestoneListItem{" + 
			"juc_video = '" + jucVideo + '\'' + 
			",jus_created_by = '" + jusCreatedBy + '\'' + 
			",juc_content_id = '" + jucContentId + '\'' + 
			",juc_video_id = '" + jucVideoId + '\'' + 
			",jus_pm_post_id = '" + jusPmPostId + '\'' + 
			",juc_title = '" + jucTitle + '\'' + 
			",jus_created_on = '" + jusCreatedOn + '\'' + 
			",jus_active = '" + jusActive + '\'' + 
			",juc_image = '" + jucImage + '\'' + 
			",juc_video_poster = '" + jucVideoPoster + '\'' + 
			",jus_updated_by = '" + jusUpdatedBy + '\'' + 
			",jus_jum_journey_id = '" + jusJumJourneyId + '\'' + 
			",juc_type = '" + jucType + '\'' + 
			",jus_detail = '" + jusDetail + '\'' + 
			",jus_date = '" + jusDate + '\'' + 
			",jus_updated_on = '" + jusUpdatedOn + '\'' + 
			",jus_milestone_id = '" + jusMilestoneId + '\'' + 
			",jus_title = '" + jusTitle + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.jucVideo);
		dest.writeString(this.jusCreatedBy);
		dest.writeString(this.jucContentId);
		dest.writeString(this.jucVideoId);
		dest.writeString(this.jusPmPostId);
		dest.writeString(this.jucTitle);
		dest.writeString(this.jusCreatedOn);
		dest.writeString(this.jusActive);
		dest.writeString(this.jucImage);
		dest.writeString(this.jucVideoPoster);
		dest.writeString(this.jusUpdatedBy);
		dest.writeString(this.jusJumJourneyId);
		dest.writeString(this.jucType);
		dest.writeString(this.jusDetail);
		dest.writeString(this.jusDate);
		dest.writeString(this.jusUpdatedOn);
		dest.writeString(this.jusMilestoneId);
		dest.writeString(this.jusTitle);
	}

	public MilestoneListItem() {
	}

	protected MilestoneListItem(Parcel in) {
		this.jucVideo = in.readString();
		this.jusCreatedBy = in.readString();
		this.jucContentId = in.readString();
		this.jucVideoId = in.readString();
		this.jusPmPostId = in.readString();
		this.jucTitle = in.readString();
		this.jusCreatedOn = in.readString();
		this.jusActive = in.readString();
		this.jucImage = in.readString();
		this.jucVideoPoster = in.readString();
		this.jusUpdatedBy = in.readString();
		this.jusJumJourneyId = in.readString();
		this.jucType = in.readString();
		this.jusDetail = in.readString();
		this.jusDate = in.readString();
		this.jusUpdatedOn = in.readString();
		this.jusMilestoneId = in.readString();
		this.jusTitle = in.readString();
	}

	public static final Parcelable.Creator<MilestoneListItem> CREATOR = new Parcelable.Creator<MilestoneListItem>() {
		@Override
		public MilestoneListItem createFromParcel(Parcel source) {
			return new MilestoneListItem(source);
		}

		@Override
		public MilestoneListItem[] newArray(int size) {
			return new MilestoneListItem[size];
		}
	};
}