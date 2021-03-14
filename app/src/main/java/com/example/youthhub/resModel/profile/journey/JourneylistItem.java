package com.example.youthhub.resModel.profile.journey;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class JourneylistItem implements Parcelable {

	@SerializedName("jum_tags_name")
	private String jumTagsName;

	@SerializedName("juc_video")
	private String jucVideo;

	@SerializedName("jum_updated_by")
	private String jumUpdatedBy;

	@SerializedName("jum_order")
	private String jumOrder;

	@SerializedName("is_milestone")
	private int isMilestone;

	@SerializedName("juc_video_id")
	private String jucVideoId;

	@SerializedName("endorsed_by")
	private List<Object> endorsedBy;

	@SerializedName("juc_image")
	private String jucImage;

	@SerializedName("jum_title")
	private String jumTitle;

	@SerializedName("jum_active")
	private String jumActive;

	@SerializedName("jum_journey_id")
	private String jumJourneyId;

	@SerializedName("jum_full_description")
	private String jumFullDescription;

	@SerializedName("jum_short_description")
	private String jumShortDescription;

	@SerializedName("jum_created_on")
	private String jumCreatedOn;

	@SerializedName("jum_tags")
	private String jumTags;

	@SerializedName("jum_um_user_id")
	private String jumUmUserId;

	@SerializedName("jum_code")
	private String jumCode;

	@SerializedName("jum_created_by")
	private String jumCreatedBy;

	@SerializedName("juc_type")
	private int jucType;

	@SerializedName("jum_old_id")
	private String jumOldId;

	@SerializedName("jum_updated_on")
	private String jumUpdatedOn;

	@SerializedName("jum_display")
	private String jumDisplay;

	public void setJumTagsName(String jumTagsName){
		this.jumTagsName = jumTagsName;
	}

	public String getJumTagsName(){
		return jumTagsName;
	}

	public void setJucVideo(String jucVideo){
		this.jucVideo = jucVideo;
	}

	public String getJucVideo(){
		return jucVideo;
	}

	public void setJumUpdatedBy(String jumUpdatedBy){
		this.jumUpdatedBy = jumUpdatedBy;
	}

	public String getJumUpdatedBy(){
		return jumUpdatedBy;
	}

	public void setJumOrder(String jumOrder){
		this.jumOrder = jumOrder;
	}

	public String getJumOrder(){
		return jumOrder;
	}

	public void setIsMilestone(int isMilestone){
		this.isMilestone = isMilestone;
	}

	public int getIsMilestone(){
		return isMilestone;
	}

	public void setJucVideoId(String jucVideoId){
		this.jucVideoId = jucVideoId;
	}

	public String getJucVideoId(){
		return jucVideoId;
	}

	public void setEndorsedBy(List<Object> endorsedBy){
		this.endorsedBy = endorsedBy;
	}

	public List<Object> getEndorsedBy(){
		return endorsedBy;
	}

	public void setJucImage(String jucImage){
		this.jucImage = jucImage;
	}

	public String getJucImage(){
		return jucImage;
	}

	public void setJumTitle(String jumTitle){
		this.jumTitle = jumTitle;
	}

	public String getJumTitle(){
		return jumTitle;
	}

	public void setJumActive(String jumActive){
		this.jumActive = jumActive;
	}

	public String getJumActive(){
		return jumActive;
	}

	public void setJumJourneyId(String jumJourneyId){
		this.jumJourneyId = jumJourneyId;
	}

	public String getJumJourneyId(){
		return jumJourneyId;
	}

	public void setJumFullDescription(String jumFullDescription){
		this.jumFullDescription = jumFullDescription;
	}

	public String getJumFullDescription(){
		return jumFullDescription;
	}

	public void setJumShortDescription(String jumShortDescription){
		this.jumShortDescription = jumShortDescription;
	}

	public String getJumShortDescription(){
		return jumShortDescription;
	}

	public void setJumCreatedOn(String jumCreatedOn){
		this.jumCreatedOn = jumCreatedOn;
	}

	public String getJumCreatedOn(){
		return jumCreatedOn;
	}

	public void setJumTags(String jumTags){
		this.jumTags = jumTags;
	}

	public String getJumTags(){
		return jumTags;
	}

	public void setJumUmUserId(String jumUmUserId){
		this.jumUmUserId = jumUmUserId;
	}

	public String getJumUmUserId(){
		return jumUmUserId;
	}

	public void setJumCode(String jumCode){
		this.jumCode = jumCode;
	}

	public String getJumCode(){
		return jumCode;
	}

	public void setJumCreatedBy(String jumCreatedBy){
		this.jumCreatedBy = jumCreatedBy;
	}

	public String getJumCreatedBy(){
		return jumCreatedBy;
	}

	public void setJucType(int jucType){
		this.jucType = jucType;
	}

	public int getJucType(){
		return jucType;
	}

	public void setJumOldId(String jumOldId){
		this.jumOldId = jumOldId;
	}

	public String getJumOldId(){
		return jumOldId;
	}

	public void setJumUpdatedOn(String jumUpdatedOn){
		this.jumUpdatedOn = jumUpdatedOn;
	}

	public String getJumUpdatedOn(){
		return jumUpdatedOn;
	}

	public void setJumDisplay(String jumDisplay){
		this.jumDisplay = jumDisplay;
	}

	public String getJumDisplay(){
		return jumDisplay;
	}

	@Override
 	public String toString(){
		return 
			"JourneylistItem{" + 
			"jum_tags_name = '" + jumTagsName + '\'' + 
			",juc_video = '" + jucVideo + '\'' + 
			",jum_updated_by = '" + jumUpdatedBy + '\'' + 
			",jum_order = '" + jumOrder + '\'' + 
			",is_milestone = '" + isMilestone + '\'' + 
			",juc_video_id = '" + jucVideoId + '\'' + 
			",endorsed_by = '" + endorsedBy + '\'' + 
			",juc_image = '" + jucImage + '\'' + 
			",jum_title = '" + jumTitle + '\'' + 
			",jum_active = '" + jumActive + '\'' + 
			",jum_journey_id = '" + jumJourneyId + '\'' + 
			",jum_full_description = '" + jumFullDescription + '\'' + 
			",jum_short_description = '" + jumShortDescription + '\'' + 
			",jum_created_on = '" + jumCreatedOn + '\'' + 
			",jum_tags = '" + jumTags + '\'' + 
			",jum_um_user_id = '" + jumUmUserId + '\'' + 
			",jum_code = '" + jumCode + '\'' + 
			",jum_created_by = '" + jumCreatedBy + '\'' + 
			",juc_type = '" + jucType + '\'' + 
			",jum_old_id = '" + jumOldId + '\'' + 
			",jum_updated_on = '" + jumUpdatedOn + '\'' + 
			",jum_display = '" + jumDisplay + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.jumTagsName);
		dest.writeString(this.jucVideo);
		dest.writeString(this.jumUpdatedBy);
		dest.writeString(this.jumOrder);
		dest.writeInt(this.isMilestone);
		dest.writeString(this.jucVideoId);
		dest.writeList(this.endorsedBy);
		dest.writeString(this.jucImage);
		dest.writeString(this.jumTitle);
		dest.writeString(this.jumActive);
		dest.writeString(this.jumJourneyId);
		dest.writeString(this.jumFullDescription);
		dest.writeString(this.jumShortDescription);
		dest.writeString(this.jumCreatedOn);
		dest.writeString(this.jumTags);
		dest.writeString(this.jumUmUserId);
		dest.writeString(this.jumCode);
		dest.writeString(this.jumCreatedBy);
		dest.writeInt(this.jucType);
		dest.writeString(this.jumOldId);
		dest.writeString(this.jumUpdatedOn);
		dest.writeString(this.jumDisplay);
	}

	public JourneylistItem() {
	}

	protected JourneylistItem(Parcel in) {
		this.jumTagsName = in.readString();
		this.jucVideo = in.readString();
		this.jumUpdatedBy = in.readString();
		this.jumOrder = in.readString();
		this.isMilestone = in.readInt();
		this.jucVideoId = in.readString();
		this.endorsedBy = new ArrayList<Object>();
		in.readList(this.endorsedBy, Object.class.getClassLoader());
		this.jucImage = in.readString();
		this.jumTitle = in.readString();
		this.jumActive = in.readString();
		this.jumJourneyId = in.readString();
		this.jumFullDescription = in.readString();
		this.jumShortDescription = in.readString();
		this.jumCreatedOn = in.readString();
		this.jumTags = in.readString();
		this.jumUmUserId = in.readString();
		this.jumCode = in.readString();
		this.jumCreatedBy = in.readString();
		this.jucType = in.readInt();
		this.jumOldId = in.readString();
		this.jumUpdatedOn = in.readString();
		this.jumDisplay = in.readString();
	}

	public static final Parcelable.Creator<JourneylistItem> CREATOR = new Parcelable.Creator<JourneylistItem>() {
		@Override
		public JourneylistItem createFromParcel(Parcel source) {
			return new JourneylistItem(source);
		}

		@Override
		public JourneylistItem[] newArray(int size) {
			return new JourneylistItem[size];
		}
	};
}