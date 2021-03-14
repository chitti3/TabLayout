package com.example.youthhub.resModel.profile.profileinfo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data implements Parcelable {

	@SerializedName("workinfo")
	@Expose
	private Workinfo workinfo;

	@SerializedName("user_medium_path")
	private String userMediumPath;

	@SerializedName("cv_path")
	private String cvPath;

	@SerializedName("education")
	private List<EducationItem> education;

	@SerializedName("achievement")
	private List<AchievementItem> achievement;

	@SerializedName("technical_skills")
	private List<TechnicalSkillsItem> technicalSkills;

	@SerializedName("profile_info")
	private ProfileInfo profileInfo;

	@SerializedName("language")
	private List<LanguageItem> language;

	@SerializedName("experience")
	private List<ExperienceItem> experience;

	@SerializedName("skills")
	private List<SkillsItem> skills;

	@SerializedName("testimonials")
	private List<TestimonialsItem> testimonials;

	@SerializedName("user_settings")
	private UserSettings userSettings;

	@SerializedName("profile_user_id")
	private String profileUserId;

	@SerializedName("profile_user_type")
	private String profileUserType;

	@SerializedName("volunteering")
	private List<VolunteeringItem> volunteering;

	@SerializedName("job_wishlist")
	private List<JobWishlistItem> jobWishlist;

	@SerializedName("login_user_id")
	private String loginUserId;

	@SerializedName("user_thumbnail_path")
	private String userThumbnailPath;

	@SerializedName("interests")
	private List<InterestsItem> interests;

	@SerializedName("user_cv")
	private List<UserCvItem> userCv;

	@SerializedName("user_cover_path")
	private String userCoverPath;

	public void setWorkinfo(Workinfo workinfo){
		this.workinfo = workinfo;
	}

	public Workinfo getWorkinfo(){
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

	public void setEducation(List<EducationItem> education){
		this.education = education;
	}

	public List<EducationItem> getEducation(){
		return education;
	}

	public void setAchievement(List<AchievementItem> achievement){
		this.achievement = achievement;
	}

	public List<AchievementItem> getAchievement(){
		return achievement;
	}

	public void setTechnicalSkills(List<TechnicalSkillsItem> technicalSkills){
		this.technicalSkills = technicalSkills;
	}

	public List<TechnicalSkillsItem> getTechnicalSkills(){
		return technicalSkills;
	}

	public void setProfileInfo(ProfileInfo profileInfo){
		this.profileInfo = profileInfo;
	}

	public ProfileInfo getProfileInfo(){
		return profileInfo;
	}

	public void setLanguage(List<LanguageItem> language){
		this.language = language;
	}

	public List<LanguageItem> getLanguage(){
		return language;
	}

	public void setExperience(List<ExperienceItem> experience){
		this.experience = experience;
	}

	public List<ExperienceItem> getExperience(){
		return experience;
	}

	public void setSkills(List<SkillsItem> skills){
		this.skills = skills;
	}

	public List<SkillsItem> getSkills(){
		return skills;
	}

	public void setTestimonials(List<TestimonialsItem> testimonials){
		this.testimonials = testimonials;
	}

	public List<TestimonialsItem> getTestimonials(){
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

	public void setProfileUserType(String profileUserType){
		this.profileUserType = profileUserType;
	}

	public String getProfileUserType(){
		return profileUserType;
	}

	public void setVolunteering(List<VolunteeringItem> volunteering){
		this.volunteering = volunteering;
	}

	public List<VolunteeringItem> getVolunteering(){
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

	public void setInterests(List<InterestsItem> interests){
		this.interests = interests;
	}

	public List<InterestsItem> getInterests(){
		return interests;
	}

	public void setUserCv(List<UserCvItem> userCv){
		this.userCv = userCv;
	}

	public List<UserCvItem> getUserCv(){
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

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeParcelable(this.workinfo, flags);
		dest.writeString(this.userMediumPath);
		dest.writeString(this.cvPath);
		dest.writeList(this.education);
		dest.writeList(this.achievement);
		dest.writeList(this.technicalSkills);
		dest.writeParcelable(this.profileInfo, flags);
		dest.writeList(this.language);
		dest.writeList(this.experience);
		dest.writeList(this.skills);
		dest.writeList(this.testimonials);
		dest.writeParcelable(this.userSettings, flags);
		dest.writeString(this.profileUserId);
		dest.writeString(this.profileUserType);
		dest.writeList(this.volunteering);
		dest.writeList(this.jobWishlist);
		dest.writeString(this.loginUserId);
		dest.writeString(this.userThumbnailPath);
		dest.writeList(this.interests);
		dest.writeList(this.userCv);
		dest.writeString(this.userCoverPath);
	}

	public Data() {
	}

	protected Data(Parcel in) {
		this.workinfo = in.readParcelable(Workinfo.class.getClassLoader());
		this.userMediumPath = in.readString();
		this.cvPath = in.readString();
		this.education = new ArrayList<EducationItem>();
		in.readList(this.education, EducationItem.class.getClassLoader());
		this.achievement = new ArrayList<AchievementItem>();
		in.readList(this.achievement, AchievementItem.class.getClassLoader());
		this.technicalSkills = new ArrayList<TechnicalSkillsItem>();
		in.readList(this.technicalSkills, TechnicalSkillsItem.class.getClassLoader());
		this.profileInfo = in.readParcelable(ProfileInfo.class.getClassLoader());
		this.language = new ArrayList<LanguageItem>();
		in.readList(this.language, LanguageItem.class.getClassLoader());
		this.experience = new ArrayList<ExperienceItem>();
		in.readList(this.experience, ExperienceItem.class.getClassLoader());
		this.skills = new ArrayList<SkillsItem>();
		in.readList(this.skills, SkillsItem.class.getClassLoader());
		this.testimonials = new ArrayList<TestimonialsItem>();
		in.readList(this.testimonials, TestimonialsItem.class.getClassLoader());
		this.userSettings = in.readParcelable(UserSettings.class.getClassLoader());
		this.profileUserId = in.readString();
		this.profileUserType = in.readString();
		this.volunteering = new ArrayList<VolunteeringItem>();
		in.readList(this.volunteering, VolunteeringItem.class.getClassLoader());
		this.jobWishlist = new ArrayList<JobWishlistItem>();
		in.readList(this.jobWishlist, JobWishlistItem.class.getClassLoader());
		this.loginUserId = in.readString();
		this.userThumbnailPath = in.readString();
		this.interests = new ArrayList<InterestsItem>();
		in.readList(this.interests, InterestsItem.class.getClassLoader());
		this.userCv = new ArrayList<UserCvItem>();
		in.readList(this.userCv, UserCvItem.class.getClassLoader());
		this.userCoverPath = in.readString();
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