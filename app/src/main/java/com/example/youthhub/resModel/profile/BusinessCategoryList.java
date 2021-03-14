package com.example.youthhub.resModel.profile;

import com.google.gson.annotations.SerializedName;

public class BusinessCategoryList {

    @SerializedName("ica_category_id")
    private String ica_category_id;

    @SerializedName("ica_name")
    private String ica_name;

    public String getIca_category_id() {
        return ica_category_id;
    }

    public void setIca_category_id(String ica_category_id) {
        this.ica_category_id = ica_category_id;
    }

    public String getIca_name() {
        return ica_name;
    }

    public void setIca_name(String ica_name) {
        this.ica_name = ica_name;
    }
}
