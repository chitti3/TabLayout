package com.example.youthhub.resModel.profile.visualjourney.add;

import com.google.gson.annotations.SerializedName;

public class Dataupdate {


        @SerializedName("milestone_view")
        private Milestoneview milestoneview;

        public Milestoneview getMilestoneview() {
            return milestoneview;
        }

        public void setMilestoneview(Milestoneview milestoneview) {
            this.milestoneview = milestoneview;

    }


}
