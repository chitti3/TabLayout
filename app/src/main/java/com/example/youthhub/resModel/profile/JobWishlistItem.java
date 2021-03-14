package com.example.youthhub.resModel.profile;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class JobWishlistItem{

	@SerializedName("wit_name")
	private String witName;

	@SerializedName("wiu_wishlist_id")
	private String wiuWishlistId;

	public void setWitName(String witName){
		this.witName = witName;
	}

	public String getWitName(){
		return witName;
	}

	public void setWiuWishlistId(String wiuWishlistId){
		this.wiuWishlistId = wiuWishlistId;
	}

	public String getWiuWishlistId(){
		return wiuWishlistId;
	}

	@Override
 	public String toString(){
		return 
			"JobWishlistItem{" + 
			"wit_name = '" + witName + '\'' + 
			",wiu_wishlist_id = '" + wiuWishlistId + '\'' + 
			"}";
		}
}