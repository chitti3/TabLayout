package com.example.youthhub.resModel.profile.profileinfodatatest;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("workinfo")
	private List<Object> workinfo;

	@SerializedName("user_medium_path")
	private String userMediumPath;

	@SerializedName("cv_path")
	private String cvPath;

	@SerializedName("education")
	private List<Object> education;

	@SerializedName("achievement")
	private List<Object> achievement;

	@SerializedName("technical_skills")
	private List<Object> technicalSkills;

	@SerializedName("profile_info")
	private ProfileInfo profileInfo;

	@SerializedName("language")
	private List<Object> language;

	@SerializedName("experience")
	private List<Object> experience;

	@SerializedName("skills")
	private List<Object> skills;

	@SerializedName("testimonials")
	private List<Object> testimonials;

	@SerializedName("user_settings")
	private UserSettings userSettings;

	@SerializedName("profile_user_id")
	private String profileUserId;

	@SerializedName("user_info")
	private UserInfo userInfo;

	@SerializedName("profile_user_type")
	private String profileUserType;

	@SerializedName("volunteering")
	private List<Object> volunteering;

	@SerializedName("job_wishlist")
	private List<JobWishlistItem> jobWishlist;

	@SerializedName("login_user_id")
	private String loginUserId;

	@SerializedName("user_thumbnail_path")
	private String userThumbnailPath;

	@SerializedName("interests")
	private List<Object> interests;

	@SerializedName("user_cv")
	private List<Object> userCv;

	@SerializedName("user_cover_path")
	private String userCoverPath;

	public void setWorkinfo(List<Object> workinfo){
		this.workinfo = workinfo;
	}

	public List<Object> getWorkinfo(){
		return workinfo;
	}

	public void setUserMediumPath(String userMediumPath){
		this.userMediumPath = userMediumPath;
	}

	public String getUserMediumPath(){
		return userMediumPath;
	}

	public void setCvPath(String cvPath){
		this.cvPath = cvPath;
	}

	public String getCvPath(){
		return cvPath;
	}

	public void setEducation(List<Object> education){
		this.education = education;
	}

	public List<Object> getEducation(){
		return education;
	}

	public void setAchievement(List<Object> achievement){
		this.achievement = achievement;
	}

	public List<Object> getAchievement(){
		return achievement;
	}

	public void setTechnicalSkills(List<Object> technicalSkills){
		this.technicalSkills = technicalSkills;
	}

	public List<Object> getTechnicalSkills(){
		return technicalSkills;
	}

	public void setProfileInfo(ProfileInfo profileInfo){
		this.profileInfo = profileInfo;
	}

	public ProfileInfo getProfileInfo(){
		return profileInfo;
	}

	public void setLanguage(List<Object> language){
		this.language = language;
	}

	public List<Object> getLanguage(){
		return language;
	}

	public void setExperience(List<Object> experience){
		this.experience = experience;
	}

	public List<Object> getExperience(){
		return experience;
	}

	public void setSkills(List<Object> skills){
		this.skills = skills;
	}

	public List<Object> getSkills(){
		return skills;
	}

	public void setTestimonials(List<Object> testimonials){
		this.testimonials = testimonials;
	}

	public List<Object> getTestimonials(){
		return testimonials;
	}

	public void setUserSettings(UserSettings userSettings){
		this.userSettings = userSettings;
	}

	public UserSettings getUserSettings(){
		return userSettings;
	}

	public void setProfileUserId(String profileUserId){
		this.profileUserId = profileUserId;
	}

	public String getProfileUserId(){
		return profileUserId;
	}

	public void setUserInfo(UserInfo userInfo){
		this.userInfo = userInfo;
	}

	public UserInfo getUserInfo(){
		return userInfo;
	}

	public void setProfileUserType(String profileUserType){
		this.profileUserType = profileUserType;
	}

	public String getProfileUserType(){
		return profileUserType;
	}

	public void setVolunteering(List<Object> volunteering){
		this.volunteering = volunteering;
	}

	public List<Object> getVolunteering(){
		return volunteering;
	}

	public void setJobWishlist(List<JobWishlistItem> jobWishlist){
		this.jobWishlist = jobWishlist;
	}

	public List<JobWishlistItem> getJobWishlist(){
		return jobWishlist;
	}

	public void setLoginUserId(String loginUserId){
		this.loginUserId = loginUserId;
	}

	public String getLoginUserId(){
		return loginUserId;
	}

	public void setUserThumbnailPath(String userThumbnailPath){
		this.userThumbnailPath = userThumbnailPath;
	}

	public String getUserThumbnailPath(){
		return userThumbnailPath;
	}

	public void setInterests(List<Object> interests){
		this.interests = interests;
	}

	public List<Object> getInterests(){
		return interests;
	}

	public void setUserCv(List<Object> userCv){
		this.userCv = userCv;
	}

	public List<Object> getUserCv(){
		return userCv;
	}

	public void setUserCoverPath(String userCoverPath){
		this.userCoverPath = userCoverPath;
	}

	public String getUserCoverPath(){
		return userCoverPath;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"workinfo = '" + workinfo + '\'' + 
			",user_medium_path = '" + userMediumPath + '\'' + 
			",cv_path = '" + cvPath + '\'' + 
			",education = '" + education + '\'' + 
			",achievement = '" + achievement + '\'' + 
			",technical_skills = '" + technicalSkills + '\'' + 
			",profile_info = '" + profileInfo + '\'' + 
			",language = '" + language + '\'' + 
			",experience = '" + experience + '\'' + 
			",skills = '" + skills + '\'' + 
			",testimonials = '" + testimonials + '\'' + 
			",user_settings = '" + userSettings + '\'' + 
			",profile_user_id = '" + profileUserId + '\'' + 
			",user_info = '" + userInfo + '\'' + 
			",profile_user_type = '" + profileUserType + '\'' + 
			",volunteering = '" + volunteering + '\'' + 
			",job_wishlist = '" + jobWishlist + '\'' + 
			",login_user_id = '" + loginUserId + '\'' + 
			",user_thumbnail_path = '" + userThumbnailPath + '\'' + 
			",interests = '" + interests + '\'' + 
			",user_cv = '" + userCv + '\'' + 
			",user_cover_path = '" + userCoverPath + '\'' + 
			"}";
		}
}