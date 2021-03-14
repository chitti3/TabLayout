package com.example.youthhub.resModel.profile.language;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class LanguageItem{

	@SerializedName("lau_sequence_id")
	private String lauSequenceId;

	@SerializedName("lau_lam_language_id")
	private String lauLamLanguageId;

	@SerializedName("lam_name")
	private String lamName;

	public void setLauSequenceId(String lauSequenceId){
		this.lauSequenceId = lauSequenceId;
	}

	public String getLauSequenceId(){
		return lauSequenceId;
	}

	public void setLauLamLanguageId(String lauLamLanguageId){
		this.lauLamLanguageId = lauLamLanguageId;
	}

	public String getLauLamLanguageId(){
		return lauLamLanguageId;
	}

	public void setLamName(String lamName){
		this.lamName = lamName;
	}

	public String getLamName(){
		return lamName;
	}

	@Override
 	public String toString(){
		return 
			"LanguageItem{" + 
			"lau_sequence_id = '" + lauSequenceId + '\'' + 
			",lau_lam_language_id = '" + lauLamLanguageId + '\'' + 
			",lam_name = '" + lamName + '\'' + 
			"}";
		}
}