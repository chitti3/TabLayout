package com.example.youthhub.resModel.profile.follower;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("result")
	private List<ResultItem> result;

	@SerializedName("user_medium_path")
	private String userMediumPath;

	@SerializedName("profile_user_id")
	private String profileUserId;

	@SerializedName("login_user_id")
	private String loginUserId;

	@SerializedName("user_thumbnail_path")
	private String userThumbnailPath;

	@SerializedName("type")
	private String type;

	@SerializedName("result_count")
	private int resultCount;

	public void setResult(List<ResultItem> result){
		this.result = result;
	}

	public List<ResultItem> getResult(){
		return result;
	}

	public void setUserMediumPath(String userMediumPath){
		this.userMediumPath = userMediumPath;
	}

	public String getUserMediumPath(){
		return userMediumPath;
	}

	public void setProfileUserId(String profileUserId){
		this.profileUserId = profileUserId;
	}

	public String getProfileUserId(){
		return profileUserId;
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

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setResultCount(int resultCount){
		this.resultCount = resultCount;
	}

	public int getResultCount(){
		return resultCount;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"result = '" + result + '\'' + 
			",user_medium_path = '" + userMediumPath + '\'' + 
			",profile_user_id = '" + profileUserId + '\'' + 
			",login_user_id = '" + loginUserId + '\'' + 
			",user_thumbnail_path = '" + userThumbnailPath + '\'' + 
			",type = '" + type + '\'' + 
			",result_count = '" + resultCount + '\'' + 
			"}";
		}
}