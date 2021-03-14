package com.example.youthhub.resModel.profile.visualjourney.add;

import com.google.gson.annotations.SerializedName;

public class MilestoneUpdateMaster {




        @SerializedName("data")
        private Dataupdate data;

            @SerializedName("status")
            private int status;

        public Dataupdate getData() {
            return data;
        }

        public void setData(Dataupdate data) {
            this.data = data;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }














    }

