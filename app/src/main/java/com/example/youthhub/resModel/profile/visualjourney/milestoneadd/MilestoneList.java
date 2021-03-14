package com.example.youthhub.resModel.profile.visualjourney.milestoneadd;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class MilestoneList{

	@SerializedName("jus_created_by")
	private String jusCreatedBy;

	@SerializedName("jus_updated_by")
	private String jusUpdatedBy;

	@SerializedName("journey_content")
	private List<Object> journeyContent;

	@SerializedName("jus_jum_journey_id")
	private String jusJumJourneyId;

	@SerializedName("jus_detail")
	private String jusDetail;

	@SerializedName("jus_date")
	private String jusDate;

	@SerializedName("jus_pm_post_id")
	private String jusPmPostId;

	@SerializedName("jus_created_on")
	private String jusCreatedOn;

	@SerializedName("jus_active")
	private String jusActive;

	@SerializedName("jus_updated_on")
	private String jusUpdatedOn;

	@SerializedName("jus_milestone_id")
	private String jusMilestoneId;

	@SerializedName("jus_title")
	private String jusTitle;

	public void setJusCreatedBy(String jusCreatedBy){
		this.jusCreatedBy = jusCreatedBy;
	}

	public String getJusCreatedBy(){
		return jusCreatedBy;
	}

	public void setJusUpdatedBy(String jusUpdatedBy){
		this.jusUpdatedBy = jusUpdatedBy;
	}

	public String getJusUpdatedBy(){
		return jusUpdatedBy;
	}

	public void setJourneyContent(List<Object> journeyContent){
		this.journeyContent = journeyContent;
	}

	public List<Object> getJourneyContent(){
		return journeyContent;
	}

	public void setJusJumJourneyId(String jusJumJourneyId){
		this.jusJumJourneyId = jusJumJourneyId;
	}

	public String getJusJumJourneyId(){
		return jusJumJourneyId;
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

	public void setJusPmPostId(String jusPmPostId){
		this.jusPmPostId = jusPmPostId;
	}

	public String getJusPmPostId(){
		return jusPmPostId;
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
			"MilestoneList{" + 
			"jus_created_by = '" + jusCreatedBy + '\'' + 
			",jus_updated_by = '" + jusUpdatedBy + '\'' + 
			",journey_content = '" + journeyContent + '\'' + 
			",jus_jum_journey_id = '" + jusJumJourneyId + '\'' + 
			",jus_detail = '" + jusDetail + '\'' + 
			",jus_date = '" + jusDate + '\'' + 
			",jus_pm_post_id = '" + jusPmPostId + '\'' + 
			",jus_created_on = '" + jusCreatedOn + '\'' + 
			",jus_active = '" + jusActive + '\'' + 
			",jus_updated_on = '" + jusUpdatedOn + '\'' + 
			",jus_milestone_id = '" + jusMilestoneId + '\'' + 
			",jus_title = '" + jusTitle + '\'' + 
			"}";
		}
}