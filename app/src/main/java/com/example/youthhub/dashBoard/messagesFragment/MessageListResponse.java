package com.example.youthhub.dashBoard.messagesFragment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MessageListResponse implements Serializable {
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("nextpage")
    @Expose
    private Integer nextpage;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("status_img")
    @Expose
    private String status_img;

    public String getStatus_img() {
        return status_img;
    }

    public void setStatus_img(String status_img) {
        this.status_img = status_img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data implements Serializable {
        @SerializedName("user_list")
        @Expose
        private List<UserList> user_list;

        public List<UserList> getUser_list() {
            return user_list;
        }

        public void setUser_list(List<UserList> user_list) {
            this.user_list = user_list;
        }
    }

    public class UserList implements Serializable {
        @SerializedName("um_user_code")
        @Expose
        private String um_user_code;
        @SerializedName("um_name")
        @Expose
        private String um_name;
        @SerializedName("username_code")
        @Expose
        private String username_code;
        @SerializedName("um_profile_picture")
        @Expose
        private String um_profile_picture;
        @SerializedName("um_user_id")
        @Expose
        private String um_user_id;
        @SerializedName("user_online_status")
        @Expose
        private String user_online_status;
        @SerializedName("um_ut_type_id")
        @Expose
        private String um_ut_type_id;
        @SerializedName("ut_type_name")
        @Expose
        private String ut_type_name;
        @SerializedName("chat_id")
        @Expose
        private Integer chat_id;
        @SerializedName("is_follow")
        @Expose
        private Integer is_follow;
        @SerializedName("um_code")
        @Expose
        private String um_code;
        @SerializedName("latest_message")
        @Expose
        private String latest_message;
        @SerializedName("last_chat_on")
        @Expose
        private String last_chat_on;
        @SerializedName("unread_count")
        @Expose
        private String unread_count;

        public String getUm_code() {
            return um_code;
        }

        public void setUm_code(String um_code) {
            this.um_code = um_code;
        }

        public String getLatest_message() {
            return latest_message;
        }

        public void setLatest_message(String latest_message) {
            this.latest_message = latest_message;
        }

        public String getLast_chat_on() {
            return last_chat_on;
        }

        public void setLast_chat_on(String last_chat_on) {
            this.last_chat_on = last_chat_on;
        }

        public String getUnread_count() {
            return unread_count;
        }

        public void setUnread_count(String unread_count) {
            this.unread_count = unread_count;
        }

        public String getUm_user_code() {
            return um_user_code;
        }

        public void setUm_user_code(String um_user_code) {
            this.um_user_code = um_user_code;
        }

        public String getUm_name() {
            return um_name;
        }

        public void setUm_name(String um_name) {
            this.um_name = um_name;
        }

        public String getUsername_code() {
            return username_code;
        }

        public void setUsername_code(String username_code) {
            this.username_code = username_code;
        }

        public String getUm_profile_picture() {
            return um_profile_picture;
        }

        public void setUm_profile_picture(String um_profile_picture) {
            this.um_profile_picture = um_profile_picture;
        }

        public String getUm_user_id() {
            return um_user_id;
        }

        public void setUm_user_id(String um_user_id) {
            this.um_user_id = um_user_id;
        }

        public String getUser_online_status() {
            return user_online_status;
        }

        public void setUser_online_status(String user_online_status) {
            this.user_online_status = user_online_status;
        }

        public String getUm_ut_type_id() {
            return um_ut_type_id;
        }

        public void setUm_ut_type_id(String um_ut_type_id) {
            this.um_ut_type_id = um_ut_type_id;
        }

        public String getUt_type_name() {
            return ut_type_name;
        }

        public void setUt_type_name(String ut_type_name) {
            this.ut_type_name = ut_type_name;
        }

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
    }
}
