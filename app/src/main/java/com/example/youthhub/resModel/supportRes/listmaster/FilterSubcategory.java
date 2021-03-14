
package com.example.youthhub.resModel.supportRes.listmaster;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FilterSubcategory implements Parcelable
{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Creator<FilterSubcategory> CREATOR = new Creator<FilterSubcategory>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FilterSubcategory createFromParcel(Parcel in) {
            return new FilterSubcategory(in);
        }

        public FilterSubcategory[] newArray(int size) {
            return (new FilterSubcategory[size]);
        }

    }
    ;

    protected FilterSubcategory(Parcel in) {
        this.id = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public FilterSubcategory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public String toString() {
        return name;
    }
}
