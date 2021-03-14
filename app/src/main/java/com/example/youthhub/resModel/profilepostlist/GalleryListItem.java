package com.example.youthhub.resModel.profilepostlist;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class GalleryListItem implements Parcelable {

	@SerializedName("pga_um_user_id")
	private String pgaUmUserId;

	@SerializedName("pga_video_poster")
	private String pgaVideoPoster;

	@SerializedName("pga_video_id")
	private String pgaVideoId;

	@SerializedName("pga_type")
	private String pgaType;

	@SerializedName("pga_video")
	private String pgaVideo;

	@SerializedName("pga_image")
	private String pgaImage;

	@SerializedName("pga_gallery_id")
	private String pgaGalleryId;

	@SerializedName("explore_type1")
	private int exploreType1;

	public int getExploreType1() {
		return exploreType1;
	}

	public void setExploreType1(int exploreType1) {
		this.exploreType1 = exploreType1;
	}

	public void setPgaUmUserId(String pgaUmUserId){
		this.pgaUmUserId = pgaUmUserId;
	}

	public String getPgaUmUserId(){
		return pgaUmUserId;
	}

	public void setPgaVideoPoster(String pgaVideoPoster){
		this.pgaVideoPoster = pgaVideoPoster;
	}

	public String getPgaVideoPoster(){
		return pgaVideoPoster;
	}

	public void setPgaVideoId(String pgaVideoId){
		this.pgaVideoId = pgaVideoId;
	}

	public String getPgaVideoId(){
		return pgaVideoId;
	}

	public void setPgaType(String pgaType){
		this.pgaType = pgaType;
	}

	public String getPgaType(){
		return pgaType;
	}

	public void setPgaVideo(String pgaVideo){
		this.pgaVideo = pgaVideo;
	}

	public String getPgaVideo(){
		return pgaVideo;
	}

	public void setPgaImage(String pgaImage){
		this.pgaImage = pgaImage;
	}

	public String getPgaImage(){
		return pgaImage;
	}

	public void setPgaGalleryId(String pgaGalleryId){
		this.pgaGalleryId = pgaGalleryId;
	}

	public String getPgaGalleryId(){
		return pgaGalleryId;
	}

	@Override
 	public String toString(){
		return 
			"GalleryListItem{" + 
			"pga_um_user_id = '" + pgaUmUserId + '\'' + 
			",pga_video_poster = '" + pgaVideoPoster + '\'' + 
			",pga_video_id = '" + pgaVideoId + '\'' + 
			",pga_type = '" + pgaType + '\'' + 
			",pga_video = '" + pgaVideo + '\'' + 
			",pga_image = '" + pgaImage + '\'' + 
			",pga_gallery_id = '" + pgaGalleryId + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel parcel, int i) {

	}
}

