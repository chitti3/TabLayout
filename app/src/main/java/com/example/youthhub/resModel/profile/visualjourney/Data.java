package com.example.youthhub.resModel.profile.visualjourney;

import java.util.List;
import javax.annotation.Generated;

import com.example.youthhub.resModel.post.createPost.Tag;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("prime_tags_path")
	private String primeTagsPath;

	@SerializedName("prime_tags")
	private List<PrimeTagsItem> primeTags;

	@SerializedName("tags")
	private List<com.example.youthhub.resModel.post.createPost.Tag> tags;

	public void setPrimeTagsPath(String primeTagsPath){
		this.primeTagsPath = primeTagsPath;
	}

	public String getPrimeTagsPath(){
		return primeTagsPath;
	}

	public void setPrimeTags(List<PrimeTagsItem> primeTags){
		this.primeTags = primeTags;
	}

	public List<PrimeTagsItem> getPrimeTags(){
		return primeTags;
	}

	public void setTags(List<com.example.youthhub.resModel.post.createPost.Tag> tags){
		this.tags = tags;
	}

	public List<com.example.youthhub.resModel.post.createPost.Tag> getTags(){
		return tags;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"prime_tags_path = '" + primeTagsPath + '\'' + 
			",prime_tags = '" + primeTags + '\'' + 
			",tags = '" + tags + '\'' + 
			"}";
		}
}