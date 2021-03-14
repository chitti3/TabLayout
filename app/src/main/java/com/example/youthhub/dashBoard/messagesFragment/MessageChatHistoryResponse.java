package com.example.youthhub.dashBoard.messagesFragment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MessageChatHistoryResponse implements Serializable {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("nextpage")
    @Expose
    private Integer nextpage;
    @SerializedName("data_count")
    @Expose
    private Integer data_count;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("status_img")
    @Expose
    private String status_img;
    @SerializedName("message")
    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus_img() {
        return status_img;
    }

    public void setStatus_img(String status_img) {
        this.status_img = status_img;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getNextpage() {
        return nextpage;
    }

    public void setNextpage(Integer nextpage) {
        this.nextpage = nextpage;
    }

    public Integer getData_count() {
        return data_count;
    }

    public void setData_count(Integer data_count) {
        this.data_count = data_count;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data implements Serializable{

        @SerializedName("chat_id")
        @Expose
        private Integer chat_id;
        @SerializedName("is_follow")
        @Expose
        private Integer is_follow;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("source_path")
        @Expose
        private String source_path;
        @SerializedName("medium_path")
        @Expose
        private String medium_path;
        @SerializedName("thumbnail_path")
        @Expose
        private String thumbnail_path;
        @SerializedName("user_medium_path")
        @Expose
        private String user_medium_path;
        @SerializedName("user_thumbnail_path")
        @Expose
        private String user_thumbnail_path;

        @SerializedName("user_info")
        @Expose
        private List<UserInfo> user_info;
        @SerializedName("chat_list")
        @Expose
        private List<ChatList> chat_list;

        public Integer getChat_id() {
            return chat_id;
        }

        public void setChat_id(Integer chat_id) {
            this.chat_id = chat_id;
        }

        public Integer getIs_follow() {
            return is_follow;
        }

        public void setIs_follow(Integer is_follow) {
            this.is_follow = is_follow;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getSource_path() {
            return source_path;
        }

        public void setSource_path(String source_path) {
            this.source_path = source_path;
        }

        public String getMedium_path() {
            return medium_path;
        }

        public void setMedium_path(String medium_path) {
            this.medium_path = medium_path;
        }

        public String getThumbnail_path() {
            return thumbnail_path;
        }

        public void setThumbnail_path(String thumbnail_path) {
            this.thumbnail_path = thumbnail_path;
        }

        public String getUser_medium_path() {
            return user_medium_path;
        }

        public void setUser_medium_path(String user_medium_path) {
            this.user_medium_path = user_medium_path;
        }

        public String getUser_thumbnail_path() {
            return user_thumbnail_path;
        }

        public void setUser_thumbnail_path(String user_thumbnail_path) {
            this.user_thumbnail_path = user_thumbnail_path;
        }

        public List<UserInfo> getUser_info() {
            return user_info;
        }

        public void setUser_info(List<UserInfo> user_info) {
            this.user_info = user_info;
        }

        public List<ChatList> getChat_list() {
            return chat_list;
        }

        public void setChat_list(List<ChatList> chat_list) {
            this.chat_list = chat_list;
        }

        public class UserInfo implements Serializable{

            @SerializedName("um_user_id")
            @Expose
            private String um_user_id;
            @SerializedName("um_code")
            @Expose
            private String um_code;
            @SerializedName("um_ut_type_id")
            @Expose
            private String um_ut_type_id;
            @SerializedName("um_name")
            @Expose
            private String um_name;
            @SerializedName("um_profile_picture")
            @Expose
            private String um_profile_picture;
            @SerializedName("um_about_me")
            @Expose
            private String um_about_me;
            @SerializedName("ut_name")
            @Expose
            private String ut_name;
            @SerializedName("street")
            @Expose
            private String street;
            @SerializedName("city")
            @Expose
            private String city; @SerializedName("region")
            @Expose
            private String region;
            @SerializedName("suburb")
            @Expose
            private String suburb;
            @SerializedName("postcode")
            @Expose
            private String postcode;
            @SerializedName("um_log_status")
            @Expose
            private String um_log_status;
            @SerializedName("um_log_updated_on")
            @Expose
            private String um_log_updated_on;
            @SerializedName("username_code")
            @Expose
            private String username_code;
            @SerializedName("user_online_status")
            @Expose
            private String user_online_status;
            @SerializedName("last_seen")
            @Expose
            private String last_seen;


            public String getUm_user_id() {
                return um_user_id;
            }

            public void setUm_user_id(String um_user_id) {
                this.um_user_id = um_user_id;
            }

            public String getUm_code() {
                return um_code;
            }

            public void setUm_code(String um_code) {
                this.um_code = um_code;
            }

            public String getUm_ut_type_id() {
                return um_ut_type_id;
            }

            public void setUm_ut_type_id(String um_ut_type_id) {
                this.um_ut_type_id = um_ut_type_id;
            }

            public String getUm_name() {
                return um_name;
            }

            public void setUm_name(String um_name) {
                this.um_name = um_name;
            }

            public String getUm_profile_picture() {
                return um_profile_picture;
            }

            public void setUm_profile_picture(String um_profile_picture) {
                this.um_profile_picture = um_profile_picture;
            }

            public String getUm_about_me() {
                return um_about_me;
            }

            public void setUm_about_me(String um_about_me) {
                this.um_about_me = um_about_me;
            }

            public String getUt_name() {
                return ut_name;
            }

            public void setUt_name(String ut_name) {
                this.ut_name = ut_name;
            }

            public String getStreet() {
                return street;
            }

            public void setStreet(String street) {
                this.street = street;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getRegion() {
                return region;
            }

            public void setRegion(String region) {
                this.region = region;
            }

            public String getSuburb() {
                return suburb;
            }

            public void setSuburb(String suburb) {
                this.suburb = suburb;
            }

            public String getPostcode() {
                return postcode;
            }

            public void setPostcode(String postcode) {
                this.postcode = postcode;
            }

            public String getUm_log_status() {
                return um_log_status;
            }

            public void setUm_log_status(String um_log_status) {
                this.um_log_status = um_log_status;
            }

            public String getUm_log_updated_on() {
                return um_log_updated_on;
            }

            public void setUm_log_updated_on(String um_log_updated_on) {
                this.um_log_updated_on = um_log_updated_on;
            }

            public String getUsername_code() {
                return username_code;
            }

            public void setUsername_code(String username_code) {
                this.username_code = username_code;
            }

            public String getUser_online_status() {
                return user_online_status;
            }

            public void setUser_online_status(String user_online_status) {
                this.user_online_status = user_online_status;
            }

            public String getLast_seen() {
                return last_seen;
            }

            public void setLast_seen(String last_seen) {
                this.last_seen = last_seen;
            }
        }
        public class ChatList implements Serializable{

            @SerializedName("cmes_message")
            @Expose
            private String cmes_message;
            @SerializedName("cmes_type")
            @Expose
            private String cmes_type;
            @SerializedName("cmes_message_id")
            @Expose
            private String cmes_message_id;
            @SerializedName("cmes_file_name")
            @Expose
            private String cmes_file_name;
            @SerializedName("cmes_um_user_id")
            @Expose
            private String cmes_um_user_id;
            @SerializedName("cmes_created_on")
            @Expose
            private String cmes_created_on;
            @SerializedName("cmes_cm_chat_id")
            @Expose
            private String cmes_cm_chat_id;
            @SerializedName("cmes_media_code")
            @Expose
            private String cmes_media_code;
            @SerializedName("um_code")
            @Expose
            private String um_code;
            @SerializedName("um_name")
            @Expose
            private String um_name;
            @SerializedName("um_profile_picture")
            @Expose
            private String um_profile_picture;
            @SerializedName("username_code")
            @Expose
            private String username_code;
            @SerializedName("is_unread")
            @Expose
            private String is_unread;
            @SerializedName("chat_date")
            @Expose
            private String chat_date;
            @SerializedName("chat_time")
            @Expose
            private String chat_time;
            @SerializedName("vid_url")
            @Expose
            private String vid_url;
            @SerializedName("file_url")
            @Expose
            private String file_url;

            public String getCmes_message() {
                return cmes_message;
            }

            public void setCmes_message(String cmes_message) {
                this.cmes_message = cmes_message;
            }

            public String getCmes_type() {
                return cmes_type;
            }

            public void setCmes_type(String cmes_type) {
                this.cmes_type = cmes_type;
            }

            public String getCmes_message_id() {
                return cmes_message_id;
            }

            public void setCmes_message_id(String cmes_message_id) {
                this.cmes_message_id = cmes_message_id;
            }

            public String getCmes_file_name() {
                return cmes_file_name;
            }

            public void setCmes_file_name(String cmes_file_name) {
                this.cmes_file_name = cmes_file_name;
            }

            public String getCmes_um_user_id() {
                return cmes_um_user_id;
            }

            public void setCmes_um_user_id(String cmes_um_user_id) {
                this.cmes_um_user_id = cmes_um_user_id;
            }

            public String getCmes_created_on() {
                return cmes_created_on;
            }

            public void setCmes_created_on(String cmes_created_on) {
                this.cmes_created_on = cmes_created_on;
            }

            public String getCmes_cm_chat_id() {
                return cmes_cm_chat_id;
            }

            public void setCmes_cm_chat_id(String cmes_cm_chat_id) {
                this.cmes_cm_chat_id = cmes_cm_chat_id;
            }

            public String getCmes_media_code() {
                return cmes_media_code;
            }

            public void setCmes_media_code(String cmes_media_code) {
                this.cmes_media_code = cmes_media_code;
            }

            public String getUm_code() {
                return um_code;
            }

            public void setUm_code(String um_code) {
                this.um_code = um_code;
            }

            public String getUm_name() {
                return um_name;
            }

            public void setUm_name(String um_name) {
                this.um_name = um_name;
            }

            public String getUm_profile_picture() {
                return um_profile_picture;
            }

            public void setUm_profile_picture(String um_profile_picture) {
                this.um_profile_picture = um_profile_picture;
            }

            public String getUsername_code() {
                return username_code;
            }

            public void setUsername_code(String username_code) {
                this.username_code = username_code;
            }

            public String getIs_unread() {
                return is_unread;
            }

            public void setIs_unread(String is_unread) {
                this.is_unread = is_unread;
            }

            public String getChat_date() {
                return chat_date;
            }

            public void setChat_date(String chat_date) {
                this.chat_date = chat_date;
            }

            public String getChat_time() {
                return chat_time;
            }

            public void setChat_time(String chat_time) {
                this.chat_time = chat_time;
            }

            public String getVid_url() {
                return vid_url;
            }

            public void setVid_url(String vid_url) {
                this.vid_url = vid_url;
            }

            public String getFile_url() {
                return file_url;
            }

            public void setFile_url(String file_url) {
                this.file_url = file_url;
            }
        }
    }
}
