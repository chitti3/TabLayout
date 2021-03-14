package com.example.youthhub.resModel.profile.visualjourney.Journey_Edit;

import java.util.List;

public class Journey_edit_response {

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
        private  List <Jum_tags_name> jum_tags_name;

        private Journey_info journey_info;

        private String is_milestone;

        private String prime_tags_path;

        private Prime_tags[] prime_tags;

        private Tags[] tags;

        public List <Jum_tags_name> getJum_tags_name ()
        {
            return jum_tags_name;
        }

        public void setJum_tags_name (List<Jum_tags_name> jum_tags_name)
        {
            this.jum_tags_name = jum_tags_name;
        }

        public Journey_info getJourney_info ()
        {
            return journey_info;
        }

        public void setJourney_info (Journey_info journey_info)
        {
            this.journey_info = journey_info;
        }

        public String getIs_milestone ()
        {
            return is_milestone;
        }

        public void setIs_milestone (String is_milestone)
        {
            this.is_milestone = is_milestone;
        }

        public String getPrime_tags_path ()
        {
            return prime_tags_path;
        }

        public void setPrime_tags_path (String prime_tags_path)
        {
            this.prime_tags_path = prime_tags_path;
        }

        public Prime_tags[] getPrime_tags ()
        {
            return prime_tags;
        }

        public void setPrime_tags (Prime_tags[] prime_tags)
        {
            this.prime_tags = prime_tags;
        }

        public Tags[] getTags ()
        {
            return tags;
        }

        public void setTags (Tags[] tags)
        {
            this.tags = tags;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [jum_tags_name = "+jum_tags_name+", journey_info = "+journey_info+", is_milestone = "+is_milestone+", prime_tags_path = "+prime_tags_path+", prime_tags = "+prime_tags+", tags = "+tags+"]";
        }
    }






    public class Prime_tags
    {
        private String tg_name;

        private String tg_icon;

        private String tg_tag_id;

        public String getTg_name ()
        {
            return tg_name;
        }

        public void setTg_name (String tg_name)
        {
            this.tg_name = tg_name;
        }

        public String getTg_icon ()
        {
            return tg_icon;
        }

        public void setTg_icon (String tg_icon)
        {
            this.tg_icon = tg_icon;
        }

        public String getTg_tag_id ()
        {
            return tg_tag_id;
        }

        public void setTg_tag_id (String tg_tag_id)
        {
            this.tg_tag_id = tg_tag_id;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [tg_name = "+tg_name+", tg_icon = "+tg_icon+", tg_tag_id = "+tg_tag_id+"]";
        }
    }


    public class Tags
    {
        private String tg_name;

        private String tg_tag_id;

        public String getTg_name ()
        {
            return tg_name;
        }

        public void setTg_name (String tg_name)
        {
            this.tg_name = tg_name;
        }

        public String getTg_tag_id ()
        {
            return tg_tag_id;
        }

        public void setTg_tag_id (String tg_tag_id)
        {
            this.tg_tag_id = tg_tag_id;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [tg_name = "+tg_name+", tg_tag_id = "+tg_tag_id+"]";
        }
    }


    public class Jum_tags_name
    {
        private String tg_name;

        private String tg_tag_id;

        public String getTg_name ()
        {
            return tg_name;
        }

        public void setTg_name (String tg_name)
        {
            this.tg_name = tg_name;
        }

        public String getTg_tag_id ()
        {
            return tg_tag_id;
        }

        public void setTg_tag_id (String tg_tag_id)
        {
            this.tg_tag_id = tg_tag_id;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [tg_name = "+tg_name+", tg_tag_id = "+tg_tag_id+"]";
        }
    }


    public class Journey_info
    {
        private String jus_pm_post_id;

        private String jum_active;

        private String jum_full_description;

        private String jum_short_description;

        private String jum_tags;

        private String jum_code;

        private String jus_jum_journey_id;

        private String jus_detail;

        private String jus_date;

        private String jum_old_id;

        private String jum_updated_on;

        private String jus_milestone_id;

        private String jum_display;

        private String jus_created_by;

        private String jum_updated_by;

        private String jum_order;

        private String jus_created_on;

        private String jus_active;

        private String jum_title;

        private String jum_journey_id;

        private String jum_created_on;

        private String jum_um_user_id;

        private String jus_updated_by;

        private String jum_created_by;

        private String jus_updated_on;

        private String jus_title;

        public String getJus_pm_post_id ()
        {
            return jus_pm_post_id;
        }

        public void setJus_pm_post_id (String jus_pm_post_id)
        {
            this.jus_pm_post_id = jus_pm_post_id;
        }

        public String getJum_active ()
        {
            return jum_active;
        }

        public void setJum_active (String jum_active)
        {
            this.jum_active = jum_active;
        }

        public String getJum_full_description ()
        {
            return jum_full_description;
        }

        public void setJum_full_description (String jum_full_description)
        {
            this.jum_full_description = jum_full_description;
        }

        public String getJum_short_description ()
        {
            return jum_short_description;
        }

        public void setJum_short_description (String jum_short_description)
        {
            this.jum_short_description = jum_short_description;
        }

        public String getJum_tags ()
        {
            return jum_tags;
        }

        public void setJum_tags (String jum_tags)
        {
            this.jum_tags = jum_tags;
        }

        public String getJum_code ()
        {
            return jum_code;
        }

        public void setJum_code (String jum_code)
        {
            this.jum_code = jum_code;
        }

        public String getJus_jum_journey_id ()
        {
            return jus_jum_journey_id;
        }

        public void setJus_jum_journey_id (String jus_jum_journey_id)
        {
            this.jus_jum_journey_id = jus_jum_journey_id;
        }

        public String getJus_detail ()
        {
            return jus_detail;
        }

        public void setJus_detail (String jus_detail)
        {
            this.jus_detail = jus_detail;
        }

        public String getJus_date ()
        {
            return jus_date;
        }

        public void setJus_date (String jus_date)
        {
            this.jus_date = jus_date;
        }

        public String getJum_old_id ()
        {
            return jum_old_id;
        }

        public void setJum_old_id (String jum_old_id)
        {
            this.jum_old_id = jum_old_id;
        }

        public String getJum_updated_on ()
        {
            return jum_updated_on;
        }

        public void setJum_updated_on (String jum_updated_on)
        {
            this.jum_updated_on = jum_updated_on;
        }

        public String getJus_milestone_id ()
        {
            return jus_milestone_id;
        }

        public void setJus_milestone_id (String jus_milestone_id)
        {
            this.jus_milestone_id = jus_milestone_id;
        }

        public String getJum_display ()
        {
            return jum_display;
        }

        public void setJum_display (String jum_display)
        {
            this.jum_display = jum_display;
        }

        public String getJus_created_by ()
        {
            return jus_created_by;
        }

        public void setJus_created_by (String jus_created_by)
        {
            this.jus_created_by = jus_created_by;
        }

        public String getJum_updated_by ()
        {
            return jum_updated_by;
        }

        public void setJum_updated_by (String jum_updated_by)
        {
            this.jum_updated_by = jum_updated_by;
        }

        public String getJum_order ()
        {
            return jum_order;
        }

        public void setJum_order (String jum_order)
        {
            this.jum_order = jum_order;
        }

        public String getJus_created_on ()
        {
            return jus_created_on;
        }

        public void setJus_created_on (String jus_created_on)
        {
            this.jus_created_on = jus_created_on;
        }

        public String getJus_active ()
        {
            return jus_active;
        }

        public void setJus_active (String jus_active)
        {
            this.jus_active = jus_active;
        }

        public String getJum_title ()
        {
            return jum_title;
        }

        public void setJum_title (String jum_title)
        {
            this.jum_title = jum_title;
        }

        public String getJum_journey_id ()
        {
            return jum_journey_id;
        }

        public void setJum_journey_id (String jum_journey_id)
        {
            this.jum_journey_id = jum_journey_id;
        }

        public String getJum_created_on ()
        {
            return jum_created_on;
        }

        public void setJum_created_on (String jum_created_on)
        {
            this.jum_created_on = jum_created_on;
        }

        public String getJum_um_user_id ()
        {
            return jum_um_user_id;
        }

        public void setJum_um_user_id (String jum_um_user_id)
        {
            this.jum_um_user_id = jum_um_user_id;
        }

        public String getJus_updated_by ()
        {
            return jus_updated_by;
        }

        public void setJus_updated_by (String jus_updated_by)
        {
            this.jus_updated_by = jus_updated_by;
        }

        public String getJum_created_by ()
        {
            return jum_created_by;
        }

        public void setJum_created_by (String jum_created_by)
        {
            this.jum_created_by = jum_created_by;
        }

        public String getJus_updated_on ()
        {
            return jus_updated_on;
        }

        public void setJus_updated_on (String jus_updated_on)
        {
            this.jus_updated_on = jus_updated_on;
        }

        public String getJus_title ()
        {
            return jus_title;
        }

        public void setJus_title (String jus_title)
        {
            this.jus_title = jus_title;
        }


        @Override
        public String toString()
        {
            return "ClassPojo [jus_pm_post_id = "+jus_pm_post_id+", jum_active = "+jum_active+", jum_full_description = "+jum_full_description+", jum_short_description = "+jum_short_description+", jum_tags = "+jum_tags+", jum_code = "+jum_code+", jus_jum_journey_id = "+jus_jum_journey_id+", jus_detail = "+jus_detail+", jus_date = "+jus_date+", jum_old_id = "+jum_old_id+", jum_updated_on = "+jum_updated_on+", jus_milestone_id = "+jus_milestone_id+", jum_display = "+jum_display+", jus_created_by = "+jus_created_by+", jum_updated_by = "+jum_updated_by+", jum_order = "+jum_order+", jus_created_on = "+jus_created_on+", jus_active = "+jus_active+", jum_title = "+jum_title+", jum_journey_id = "+jum_journey_id+", jum_created_on = "+jum_created_on+", jum_um_user_id = "+jum_um_user_id+", jus_updated_by = "+jus_updated_by+", jum_created_by = "+jum_created_by+", jus_updated_on = "+jus_updated_on+", jus_title = "+jus_title+"]";
        }
    }



}
