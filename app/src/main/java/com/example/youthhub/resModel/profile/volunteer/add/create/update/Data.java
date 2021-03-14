package com.example.youthhub.resModel.profile.volunteer.add.create.update;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("volunteering")
	private List<com.example.youthhub.resModel.profile.profileinfo.VolunteeringItem> volunteering;

	public void setVolunteering(List<com.example.youthhub.resModel.profile.profileinfo.VolunteeringItem> volunteering){
		this.volunteering = volunteering;
	}

	public List<com.example.youthhub.resModel.profile.profileinfo.VolunteeringItem> getVolunteering(){
		return volunteering;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"volunteering = '" + volunteering + '\'' + 
			"}";
		}
}