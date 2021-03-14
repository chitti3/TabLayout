package com.example.youthhub.resModel.profile.technicalskill;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class TechnicalSkillsItem{

	@SerializedName("sku_level")
	private String skuLevel;

	@SerializedName("sku_sequence_id")
	private String skuSequenceId;

	@SerializedName("sku_name")
	private String skuName;

	public void setSkuLevel(String skuLevel){
		this.skuLevel = skuLevel;
	}

	public String getSkuLevel(){
		return skuLevel;
	}

	public void setSkuSequenceId(String skuSequenceId){
		this.skuSequenceId = skuSequenceId;
	}

	public String getSkuSequenceId(){
		return skuSequenceId;
	}

	public void setSkuName(String skuName){
		this.skuName = skuName;
	}

	public String getSkuName(){
		return skuName;
	}

	@Override
 	public String toString(){
		return 
			"TechnicalSkillsItem{" + 
			"sku_level = '" + skuLevel + '\'' + 
			",sku_sequence_id = '" + skuSequenceId + '\'' + 
			",sku_name = '" + skuName + '\'' + 
			"}";
		}
}