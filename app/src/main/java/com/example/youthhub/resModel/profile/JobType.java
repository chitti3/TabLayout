package com.example.youthhub.resModel.profile;

import com.google.gson.annotations.SerializedName;

public class JobType {


    @SerializedName("jt_type_id")
    private String jt_type_id;

    @SerializedName("jt_name")
    private String jt_name;

    public String getJt_type_id() {
        return jt_type_id;
    }

    public void setJt_type_id(String jt_type_id) {
        this.jt_type_id = jt_type_id;
    }

    public String getJt_name() {
        return jt_name;
    }

    public void setJt_name(String jt_name) {
        this.jt_name = jt_name;
    }
}
