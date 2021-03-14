package com.example.youthhub.resModel.post.postList;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class GalleryList1 {

	@SerializedName("pga_image")
	private String pgaImage;

	@SerializedName("explore_type1")
	private int exploreType1;

	public void setPgaImage(String pgaImage){
		this.pgaImage = pgaImage;
	}

	public String getPgaImage(){
		return pgaImage;
	}

	public void setExploreType1(int exploreType1){
		this.exploreType1 = exploreType1;
	}

	public int getExploreType1(){
		return exploreType1;
	}

	@Override
 	public String toString(){
		return 
			"GalleryList1{" +
			"pga_image = '" + pgaImage + '\'' + 
			",explore_type1 = '" + exploreType1 + '\'' + 
			"}";
		}
}