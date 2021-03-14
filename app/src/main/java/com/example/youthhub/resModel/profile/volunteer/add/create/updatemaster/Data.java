package com.example.youthhub.resModel.profile.volunteer.add.create.updatemaster;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("volunteering_category")
	private List<VolunteeringCategoryItem> volunteeringCategory;

	@SerializedName("volunteering")
	private List<VolunteeringItem> volunteering;

	public void setVolunteeringCategory(List<VolunteeringCategoryItem> volunteeringCategory){
		this.volunteeringCategory = volunteeringCategory;
	}

	public List<VolunteeringCategoryItem> getVolunteeringCategory(){
		return volunteeringCategory;
	}

	public void setVolunteering(List<VolunteeringItem> volunteering){
		this.volunteering = volunteering;
	}

	public List<VolunteeringItem> getVolunteering(){
		return volunteering;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"volunteering_category = '" + volunteeringCategory + '\'' + 
			",volunteering = '" + volunteering + '\'' + 
			"}";
		}
}