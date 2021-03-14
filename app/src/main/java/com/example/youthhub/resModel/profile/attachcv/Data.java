package com.example.youthhub.resModel.profile.attachcv;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("type_master")
	private List<TypeMasterItem> typeMaster;

	public void setTypeMaster(List<TypeMasterItem> typeMaster){
		this.typeMaster = typeMaster;
	}

	public List<TypeMasterItem> getTypeMaster(){
		return typeMaster;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"type_master = '" + typeMaster + '\'' + 
			"}";
		}
}