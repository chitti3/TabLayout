package com.example.youthhub.resModel.profile;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Subethnicity implements Parcelable {

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private String id;

	@SerializedName("subsubethnicity")
	private List<SubsubethnicityItem> subsubethnicity;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setSubsubethnicity(List<SubsubethnicityItem> subsubethnicity){
		this.subsubethnicity = subsubethnicity;
	}

	public List<SubsubethnicityItem> getSubsubethnicity(){
		return subsubethnicity;
	}

	@Override
 	public String toString(){
		return 
			"Subethnicity{" + 
			"name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",subsubethnicity = '" + subsubethnicity + '\'' + 
			"}";
		}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.name);
		dest.writeString(this.id);
		dest.writeList(this.subsubethnicity);
	}

	public Subethnicity() {
	}

	protected Subethnicity(Parcel in) {
		this.name = in.readString();
		this.id = in.readString();
		this.subsubethnicity = new ArrayList<SubsubethnicityItem>();
		in.readList(this.subsubethnicity, SubsubethnicityItem.class.getClassLoader());
	}

	public static final Parcelable.Creator<Subethnicity> CREATOR = new Parcelable.Creator<Subethnicity>() {
		@Override
		public Subethnicity createFromParcel(Parcel source) {
			return new Subethnicity(source);
		}

		@Override
		public Subethnicity[] newArray(int size) {
			return new Subethnicity[size];
		}
	};
}