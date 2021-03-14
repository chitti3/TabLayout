package com.example.youthhub.resModel.profile;

public class WishlistItem{
	private String witName;
	private String witTagId;

	public void setWitName(String witName){
		this.witName = witName;
	}

	public String getWitName(){
		return witName;
	}

	public void setWitTagId(String witTagId){
		this.witTagId = witTagId;
	}

	public String getWitTagId(){
		return witTagId;
	}

	@Override
 	public String toString(){
		return 
			"WishlistItem{" + 
			"wit_name = '" + witName + '\'' + 
			",wit_tag_id = '" + witTagId + '\'' + 
			"}";
		}
}
