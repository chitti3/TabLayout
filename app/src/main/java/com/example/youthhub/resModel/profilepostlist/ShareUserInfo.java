package com.example.youthhub.resModel.profilepostlist;

import android.os.Parcel;
import android.os.Parcelable;

import javax.annotation.Generated;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ShareUserInfo implements Parcelable{


	@SerializedName("shared_by_id")
	@Expose
	private String sharedById;
	@SerializedName("shared_by_code")
	@Expose
	private String sharedByCode;
	@SerializedName("shared_by_name")
	@Expose
	private String sharedByName;
	@SerializedName("shared_by_name_code")
	@Expose
	private String sharedByNameCode;
	@SerializedName("shared_by_pic")
	@Expose
	private String sharedByPic;
	@SerializedName("pus_share_title")
	@Expose
	private String pusShareTitle;
	@SerializedName("shared_date")
	@Expose
	private String sharedDate;
	public final static Parcelable.Creator<ShareUserInfo> CREATOR = new Parcelable.Creator<ShareUserInfo>() {


		@SuppressWarnings({
				"unchecked"
		})
		public ShareUserInfo createFromParcel(Parcel in) {
			return new ShareUserInfo(in);
		}

		public ShareUserInfo[] newArray(int size) {
			return (new ShareUserInfo[size]);
		}

	}
			;

	protected ShareUserInfo(Parcel in) {
		this.sharedById = ((String) in.readValue((String.class.getClassLoader())));
		this.sharedByCode = ((String) in.readValue((String.class.getClassLoader())));
		this.sharedByName = ((String) in.readValue((String.class.getClassLoader())));
		this.sharedByNameCode = ((String) in.readValue((String.class.getClassLoader())));
		this.sharedByPic = ((String) in.readValue((String.class.getClassLoader())));
		this.pusShareTitle = ((String) in.readValue((String.class.getClassLoader())));
		this.sharedDate = ((String) in.readValue((String.class.getClassLoader())));
	}

	public ShareUserInfo() {
	}

	public String getSharedById() {
		return sharedById;
	}

	public void setSharedById(String sharedById) {
		this.sharedById = sharedById;
	}

	public String getSharedByCode() {
		return sharedByCode;
	}

	public void setSharedByCode(String sharedByCode) {
		this.sharedByCode = sharedByCode;
	}

	public String getSharedByName() {
		return sharedByName;
	}

	public void setSharedByName(String sharedByName) {
		this.sharedByName = sharedByName;
	}

	public String getSharedByNameCode() {
		return sharedByNameCode;
	}

	public void setSharedByNameCode(String sharedByNameCode) {
		this.sharedByNameCode = sharedByNameCode;
	}

	public String getSharedByPic() {
		return sharedByPic;
	}

	public void setSharedByPic(String sharedByPic) {
		this.sharedByPic = sharedByPic;
	}

	public String getPusShareTitle() {
		return pusShareTitle;
	}

	public void setPusShareTitle(String pusShareTitle) {
		this.pusShareTitle = pusShareTitle;
	}

	public String getSharedDate() {
		return sharedDate;
	}

	public void setSharedDate(String sharedDate) {
		this.sharedDate = sharedDate;
	}

	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(sharedById);
		dest.writeValue(sharedByCode);
		dest.writeValue(sharedByName);
		dest.writeValue(sharedByNameCode);
		dest.writeValue(sharedByPic);
		dest.writeValue(pusShareTitle);
		dest.writeValue(sharedDate);
	}

	public int describeContents() {
		return  0;
	}

}