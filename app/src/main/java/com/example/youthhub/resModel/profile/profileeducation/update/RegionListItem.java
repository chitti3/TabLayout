package com.example.youthhub.resModel.profile.profileeducation.update;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class RegionListItem{

	@SerializedName("re_name")
	private String reName;

	@SerializedName("re_region_id")
	private String reRegionId;

	public void setReName(String reName){
		this.reName = reName;
	}

	public String getReName(){
		return reName;
	}

	public void setReRegionId(String reRegionId){
		this.reRegionId = reRegionId;
	}

	public String getReRegionId(){
		return reRegionId;
	}

	@Override
 	public String toString(){
		return 
			"RegionListItem{" + 
			"re_name = '" + reName + '\'' + 
			",re_region_id = '" + reRegionId + '\'' + 
			"}";
		}
}