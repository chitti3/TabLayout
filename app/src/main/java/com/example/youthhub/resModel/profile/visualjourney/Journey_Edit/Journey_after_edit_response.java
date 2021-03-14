package com.example.youthhub.resModel.profile.visualjourney.Journey_Edit;

public class Journey_after_edit_response {


        private Data data;

        private int status;

        public Data getData ()
        {
            return data;
        }

        public void setData (Data data)
        {
            this.data = data;
        }

        public int getStatus ()
        {
            return status;
        }

        public void setStatus (int status)
        {
            this.status = status;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [data = "+data+", status = "+status+"]";
        }




    public class Data
    {
        private String video_path_source;

        private String image_path_source;

        private Journeylist journeylist;

        private String[] endorsed_by;

        private String image_path_medium;

        private String default_image;

        private String point_score_msg;

        private String video_path_image;

        public String getVideo_path_source ()
        {
            return video_path_source;
        }

        public void setVideo_path_source (String video_path_source)
        {
            this.video_path_source = video_path_source;
        }

        public String getImage_path_source ()
        {
            return image_path_source;
        }

        public void setImage_path_source (String image_path_source)
        {
            this.image_path_source = image_path_source;
        }

        public Journeylist getJourneylist ()
        {
            return journeylist;
        }

        public void setJourneylist (Journeylist journeylist)
        {
            this.journeylist = journeylist;
        }

        public String[] getEndorsed_by ()
        {
            return endorsed_by;
        }

        public void setEndorsed_by (String[] endorsed_by)
        {
            this.endorsed_by = endorsed_by;
        }

        public String getImage_path_medium ()
        {
            return image_path_medium;
        }

        public void setImage_path_medium (String image_path_medium)
        {
            this.image_path_medium = image_path_medium;
        }

        public String getDefault_image ()
        {
            return default_image;
        }

        public void setDefault_image (String default_image)
        {
            this.default_image = default_image;
        }

        public String getPoint_score_msg ()
        {
            return point_score_msg;
        }

        public void setPoint_score_msg (String point_score_msg)
        {
            this.point_score_msg = point_score_msg;
        }

        public String getVideo_path_image ()
        {
            return video_path_image;
        }

        public void setVideo_path_image (String video_path_image)
        {
            this.video_path_image = video_path_image;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [video_path_source = "+video_path_source+", image_path_source = "+image_path_source+", journeylist = "+journeylist+", endorsed_by = "+endorsed_by+", image_path_medium = "+image_path_medium+", default_image = "+default_image+", point_score_msg = "+point_score_msg+", video_path_image = "+video_path_image+"]";
        }
    }


    public class Journeylist {
        private String jum_tags_name;

        private String juc_video;

        private String jum_updated_by;

        private String jum_order;

        private String is_milestone;

        private String juc_video_id;

        private String juc_image;

        private String jum_title;

        private String jum_active;

        private String jum_journey_id;

        private String jum_full_description;

        private String jum_short_description;

        private String jum_created_on;

        private String jum_tags;

        private String jum_um_user_id;

        private String jum_code;

        private String jum_created_by;

        private String juc_type;

        private String jum_old_id;

        private String jum_updated_on;

        private String jum_display;

        public String getJum_tags_name() {
            return jum_tags_name;
        }

        public void setJum_tags_name(String jum_tags_name) {
            this.jum_tags_name = jum_tags_name;
        }

        public String getJuc_video() {
            return juc_video;
        }

        public void setJuc_video(String juc_video) {
            this.juc_video = juc_video;
        }

        public String getJum_updated_by() {
            return jum_updated_by;
        }

        public void setJum_updated_by(String jum_updated_by) {
            this.jum_updated_by = jum_updated_by;
        }

        public String getJum_order() {
            return jum_order;
        }

        public void setJum_order(String jum_order) {
            this.jum_order = jum_order;
        }

        public String getIs_milestone() {
            return is_milestone;
        }

        public void setIs_milestone(String is_milestone) {
            this.is_milestone = is_milestone;
        }

        public String getJuc_video_id() {
            return juc_video_id;
        }

        public void setJuc_video_id(String juc_video_id) {
            this.juc_video_id = juc_video_id;
        }

        public String getJuc_image() {
            return juc_image;
        }

        public void setJuc_image(String juc_image) {
            this.juc_image = juc_image;
        }

        public String getJum_title() {
            return jum_title;
        }

        public void setJum_title(String jum_title) {
            this.jum_title = jum_title;
        }

        public String getJum_active() {
            return jum_active;
        }

        public void setJum_active(String jum_active) {
            this.jum_active = jum_active;
        }

        public String getJum_journey_id() {
            return jum_journey_id;
        }

        public void setJum_journey_id(String jum_journey_id) {
            this.jum_journey_id = jum_journey_id;
        }

        public String getJum_full_description() {
            return jum_full_description;
        }

        public void setJum_full_description(String jum_full_description) {
            this.jum_full_description = jum_full_description;
        }

        public String getJum_short_description() {
            return jum_short_description;
        }

        public void setJum_short_description(String jum_short_description) {
            this.jum_short_description = jum_short_description;
        }

        public String getJum_created_on() {
            return jum_created_on;
        }

        public void setJum_created_on(String jum_created_on) {
            this.jum_created_on = jum_created_on;
        }

        public String getJum_tags() {
            return jum_tags;
        }

        public void setJum_tags(String jum_tags) {
            this.jum_tags = jum_tags;
        }

        public String getJum_um_user_id() {
            return jum_um_user_id;
        }

        public void setJum_um_user_id(String jum_um_user_id) {
            this.jum_um_user_id = jum_um_user_id;
        }

        public String getJum_code() {
            return jum_code;
        }

        public void setJum_code(String jum_code) {
            this.jum_code = jum_code;
        }

        public String getJum_created_by() {
            return jum_created_by;
        }

        public void setJum_created_by(String jum_created_by) {
            this.jum_created_by = jum_created_by;
        }

        public String getJuc_type() {
            return juc_type;
        }

        public void setJuc_type(String juc_type) {
            this.juc_type = juc_type;
        }

        public String getJum_old_id() {
            return jum_old_id;
        }

        public void setJum_old_id(String jum_old_id) {
            this.jum_old_id = jum_old_id;
        }

        public String getJum_updated_on() {
            return jum_updated_on;
        }

        public void setJum_updated_on(String jum_updated_on) {
            this.jum_updated_on = jum_updated_on;
        }

        public String getJum_display() {
            return jum_display;
        }

        public void setJum_display(String jum_display) {
            this.jum_display = jum_display;
        }

        @Override
        public String toString() {
            return "ClassPojo [jum_tags_name = " + jum_tags_name + ", juc_video = " + juc_video + ", jum_updated_by = " + jum_updated_by + ", jum_order = " + jum_order + ", is_milestone = " + is_milestone + ", juc_video_id = " + juc_video_id + ", juc_image = " + juc_image + ", jum_title = " + jum_title + ", jum_active = " + jum_active + ", jum_journey_id = " + jum_journey_id + ", jum_full_description = " + jum_full_description + ", jum_short_description = " + jum_short_description + ", jum_created_on = " + jum_created_on + ", jum_tags = " + jum_tags + ", jum_um_user_id = " + jum_um_user_id + ", jum_code = " + jum_code + ", jum_created_by = " + jum_created_by + ", juc_type = " + juc_type + ", jum_old_id = " + jum_old_id + ", jum_updated_on = " + jum_updated_on + ", jum_display = " + jum_display + "]";
        }

    }

    }