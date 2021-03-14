package com.example.youthhub.resModel.post.postList;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class PostList implements Parcelable {

	@SerializedName("pm_type_id")
	private String pmTypeId;

	@SerializedName("encourage_status")
	private int encourageStatus;

	@SerializedName("pm_description")
	private String pmDescription;

	@SerializedName("favorite_status_name")
	private String favoriteStatusName;

	@SerializedName("share_user_count")
	private int shareUserCount;

	@SerializedName("pm_code")
	private String pmCode;

	@SerializedName("pm_tags_name")
	private String pmTagsName;

	@SerializedName("um_code")
	private String umCode;

	@SerializedName("pm_type")
	private String pmType;

	@SerializedName("username_code")
	private String usernameCode;

	@SerializedName("pm_total_comment")
	private String pmTotalComment;

	@SerializedName("pm_post_id")
	private String pmPostId;

	@SerializedName("favorite_status")
	private int favoriteStatus;

	@SerializedName("is_share_icon")
	private int isShareIcon;

	@SerializedName("share_user_info")
	private ShareUserInfo shareUserInfo;

	@SerializedName("pm_share_type")
	private String pmShareType;

	@SerializedName("pus_created_on")
	private String pusCreatedOn;

	@SerializedName("pus_type")
	private String pusType;

	@SerializedName("pm_created_on")
	private String pmCreatedOn;

	@SerializedName("um_profile_picture")
	private String umProfilePicture;

	@SerializedName("gallery_list")
	private List<GalleryListItem> galleryList;

	@SerializedName("gallery_list1")
	private List<GalleryList> galleryList1;

	@SerializedName("pm_gma_group_id")
	private String pmGmaGroupId;

	@SerializedName("pm_tags")
	private String pmTags;

	@SerializedName("max_sequence_id")
	private String maxSequenceId;

	@SerializedName("pus_pm_post_id")
	private String pusPmPostId;

	@SerializedName("pm_total_like")
	private String pmTotalLike;

	@SerializedName("um_name")
	private String umName;

	@SerializedName("pm_um_user_id")
	private String pmUmUserId;

	@SerializedName("encourage_status_name")
	private String encourageStatusName;

	public void setPmTypeId(String pmTypeId){
		this.pmTypeId = pmTypeId;
	}

	public String getPmTypeId(){
		return pmTypeId;
	}

	public void setEncourageStatus(int encourageStatus){
		this.encourageStatus = encourageStatus;
	}

	public int getEncourageStatus(){
		return encourageStatus;
	}

	public void setPmDescription(String pmDescription){
		this.pmDescription = pmDescription;
	}

	public String getPmDescription(){
		return pmDescription;
	}

	public List<GalleryList> getGalleryList1() {
		return galleryList1;
	}

	public void setGalleryList1(List<GalleryList> galleryList1) {
		this.galleryList1 = galleryList1;
	}

	public void setFavoriteStatusName(String favoriteStatusName){
		this.favoriteStatusName = favoriteStatusName;
	}

	public String getFavoriteStatusName(){
		return favoriteStatusName;
	}

	public void setShareUserCount(int shareUserCount){
		this.shareUserCount = shareUserCount;
	}

	public int getShareUserCount(){
		return shareUserCount;
	}

	public void setPmCode(String pmCode){
		this.pmCode = pmCode;
	}

	public String getPmCode(){
		return pmCode;
	}

	public void setPmTagsName(String pmTagsName){
		this.pmTagsName = pmTagsName;
	}

	public String getPmTagsName(){
		return pmTagsName;
	}

	public void setUmCode(String umCode){
		this.umCode = umCode;
	}

	public String getUmCode(){
		return umCode;
	}

	public void setPmType(String pmType){
		this.pmType = pmType;
	}

	public String getPmType(){
		return pmType;
	}

	public void setUsernameCode(String usernameCode){
		this.usernameCode = usernameCode;
	}

	public String getUsernameCode(){
		return usernameCode;
	}

	public void setPmTotalComment(String pmTotalComment){
		this.pmTotalComment = pmTotalComment;
	}

	public String getPmTotalComment(){
		return pmTotalComment;
	}

	public void setPmPostId(String pmPostId){
		this.pmPostId = pmPostId;
	}

	public String getPmPostId(){
		return pmPostId;
	}

	public void setFavoriteStatus(int favoriteStatus){
		this.favoriteStatus = favoriteStatus;
	}

	public int getFavoriteStatus(){
		return favoriteStatus;
	}

	public void setIsShareIcon(int isShareIcon){
		this.isShareIcon = isShareIcon;
	}

	public int getIsShareIcon(){
		return isShareIcon;
	}

	public void setShareUserInfo(ShareUserInfo shareUserInfo){
		this.shareUserInfo = shareUserInfo;
	}

	public ShareUserInfo getShareUserInfo(){
		return shareUserInfo;
	}

	public void setPmShareType(String pmShareType){
		this.pmShareType = pmShareType;
	}

	public String getPmShareType(){
		return pmShareType;
	}

	public void setPusCreatedOn(String pusCreatedOn){
		this.pusCreatedOn = pusCreatedOn;
	}

	public String getPusCreatedOn(){
		return pusCreatedOn;
	}

	public void setPusType(String pusType){
		this.pusType = pusType;
	}

	public String getPusType(){
		return pusType;
	}

	public void setPmCreatedOn(String pmCreatedOn){
		this.pmCreatedOn = pmCreatedOn;
	}

	public String getPmCreatedOn(){
		return pmCreatedOn;
	}

	public void setUmProfilePicture(String umProfilePicture){
		this.umProfilePicture = umProfilePicture;
	}

	public String getUmProfilePicture(){
		return umProfilePicture;
	}

	public void setGalleryList(List<GalleryListItem> galleryList){
		this.galleryList = galleryList;
	}

	public List<GalleryListItem> getGalleryList(){
		return galleryList;
	}

	public void setPmGmaGroupId(String pmGmaGroupId){
		this.pmGmaGroupId = pmGmaGroupId;
	}

	public String getPmGmaGroupId(){
		return pmGmaGroupId;
	}

	public void setPmTags(String pmTags){
		this.pmTags = pmTags;
	}

	public String getPmTags(){
		return pmTags;
	}

	public void setMaxSequenceId(String maxSequenceId){
		this.maxSequenceId = maxSequenceId;
	}

	public String getMaxSequenceId(){
		return maxSequenceId;
	}

	public void setPusPmPostId(String pusPmPostId){
		this.pusPmPostId = pusPmPostId;
	}

	public String getPusPmPostId(){
		return pusPmPostId;
	}

	public void setPmTotalLike(String pmTotalLike){
		this.pmTotalLike = pmTotalLike;
	}

	public String getPmTotalLike(){
		return pmTotalLike;
	}

	public void setUmName(String umName){
		this.umName = umName;
	}

	public String getUmName(){
		return umName;
	}

	public void setPmUmUserId(String pmUmUserId){
		this.pmUmUserId = pmUmUserId;
	}

	public String getPmUmUserId(){
		return pmUmUserId;
	}

	public void setEncourageStatusName(String encourageStatusName){
		this.encourageStatusName = encourageStatusName;
	}

	public String getEncourageStatusName(){
		return encourageStatusName;
	}

	@Override
 	public String toString(){
		return 
			"PostList{" + 
			"pm_type_id = '" + pmTypeId + '\'' + 
			",encourage_status = '" + encourageStatus + '\'' + 
			",pm_description = '" + pmDescription + '\'' + 
			",favorite_status_name = '" + favoriteStatusName + '\'' + 
			",share_user_count = '" + shareUserCount + '\'' + 
			",pm_code = '" + pmCode + '\'' + 
			",pm_tags_name = '" + pmTagsName + '\'' + 
			",um_code = '" + umCode + '\'' + 
			",pm_type = '" + pmType + '\'' + 
			",username_code = '" + usernameCode + '\'' + 
			",pm_total_comment = '" + pmTotalComment + '\'' + 
			",pm_post_id = '" + pmPostId + '\'' + 
			",favorite_status = '" + favoriteStatus + '\'' + 
			",is_share_icon = '" + isShareIcon + '\'' + 
			",share_user_info = '" + shareUserInfo + '\'' + 
			",pm_share_type = '" + pmShareType + '\'' + 
			",pus_created_on = '" + pusCreatedOn + '\'' + 
			",pus_type = '" + pusType + '\'' + 
			",pm_created_on = '" + pmCreatedOn + '\'' + 
			",um_profile_picture = '" + umProfilePicture + '\'' + 
			",gallery_list = '" + galleryList + '\'' + 
			",pm_gma_group_id = '" + pmGmaGroupId + '\'' + 
			",pm_tags = '" + pmTags + '\'' + 
			",max_sequence_id = '" + maxSequenceId + '\'' + 
			",pus_pm_post_id = '" + pusPmPostId + '\'' + 
			",pm_total_like = '" + pmTotalLike + '\'' + 
			",um_name = '" + umName + '\'' + 
			",pm_um_user_id = '" + pmUmUserId + '\'' + 
			",encourage_status_name = '" + encourageStatusName + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.pmTypeId);
		dest.writeInt(this.encourageStatus);
		dest.writeString(this.pmDescription);
		dest.writeString(this.favoriteStatusName);
		dest.writeInt(this.shareUserCount);
		dest.writeString(this.pmCode);
		dest.writeString(this.pmTagsName);
		dest.writeString(this.umCode);
		dest.writeString(this.pmType);
		dest.writeString(this.usernameCode);
		dest.writeString(this.pmTotalComment);
		dest.writeString(this.pmPostId);
		dest.writeInt(this.favoriteStatus);
		dest.writeInt(this.isShareIcon);
		dest.writeParcelable(this.shareUserInfo, flags);
		dest.writeString(this.pmShareType);
		dest.writeString(this.pusCreatedOn);
		dest.writeString(this.pusType);
		dest.writeString(this.pmCreatedOn);
		dest.writeString(this.umProfilePicture);
		dest.writeList(this.galleryList);
		dest.writeString(this.pmGmaGroupId);
		dest.writeString(this.pmTags);
		dest.writeString(this.maxSequenceId);
		dest.writeString(this.pusPmPostId);
		dest.writeString(this.pmTotalLike);
		dest.writeString(this.umName);
		dest.writeString(this.pmUmUserId);
		dest.writeString(this.encourageStatusName);
		dest.writeTypedList(this.galleryList1);
	}

	public PostList() {
	}

	protected PostList(Parcel in) {
		this.pmTypeId = in.readString();
		this.encourageStatus = in.readInt();
		this.pmDescription = in.readString();
		this.favoriteStatusName = in.readString();
		this.shareUserCount = in.readInt();
		this.pmCode = in.readString();
		this.pmTagsName = in.readString();
		this.umCode = in.readString();
		this.pmType = in.readString();
		this.usernameCode = in.readString();
		this.pmTotalComment = in.readString();
		this.pmPostId = in.readString();
		this.favoriteStatus = in.readInt();
		this.isShareIcon = in.readInt();
		this.shareUserInfo = in.readParcelable(ShareUserInfo.class.getClassLoader());
		this.pmShareType = in.readString();
		this.pusCreatedOn = in.readString();
		this.pusType = in.readString();
		this.pmCreatedOn = in.readString();
		this.umProfilePicture = in.readString();
		this.galleryList = new ArrayList<GalleryListItem>();
		in.readList(this.galleryList, GalleryListItem.class.getClassLoader());
		this.pmGmaGroupId = in.readString();
		this.pmTags = in.readString();
		this.maxSequenceId = in.readString();
		this.pusPmPostId = in.readString();
		this.pmTotalLike = in.readString();
		this.umName = in.readString();
		this.pmUmUserId = in.readString();
		this.encourageStatusName = in.readString();
		this.galleryList1 = in.createTypedArrayList(GalleryList.CREATOR);
	}

	public static final Parcelable.Creator<PostList> CREATOR = new Parcelable.Creator<PostList>() {
		@Override
		public PostList createFromParcel(Parcel source) {
			return new PostList(source);
		}

		@Override
		public PostList[] newArray(int size) {
			return new PostList[size];
		}
	};
}