package com.example.youthhub.resModel.profile;

import com.google.gson.annotations.SerializedName;

public class QualificationCategoryItem {


    @SerializedName("qac_category_id")
    private String qac_category_id;

    @SerializedName("qac_name")
    private String qac_name;

    public String getQac_category_id() {
        return qac_category_id;
    }

    public void setQac_category_id(String qac_category_id) {
        this.qac_category_id = qac_category_id;
    }

    public String getQac_name() {
        return qac_name;
    }

    public void setQac_name(String qac_name) {
        this.qac_name = qac_name;
    }
}
