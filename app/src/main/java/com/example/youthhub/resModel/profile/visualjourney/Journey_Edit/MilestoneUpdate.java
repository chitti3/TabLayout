package com.example.youthhub.resModel.profile.visualjourney.Journey_Edit;

import com.google.gson.annotations.SerializedName;

public class MilestoneUpdate {

        @SerializedName("status")
        private int status;


        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

}
