package com.example.youthhub.resModel.profile.profileeducation.update;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class QualificationProviderItem{

	@SerializedName("qap_name")
	private String qapName;

	@SerializedName("qap_provider_id")
	private String qapProviderId;

	public void setQapName(String qapName){
		this.qapName = qapName;
	}

	public String getQapName(){
		return qapName;
	}

	public void setQapProviderId(String qapProviderId){
		this.qapProviderId = qapProviderId;
	}

	public String getQapProviderId(){
		return qapProviderId;
	}

	@Override
 	public String toString(){
		return 
			"QualificationProviderItem{" + 
			"qap_name = '" + qapName + '\'' + 
			",qap_provider_id = '" + qapProviderId + '\'' + 
			"}";
		}
}