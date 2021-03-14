package com.example.youthhub.dashBoard.messagesFragment;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class MessageSendResponse implements Serializable {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private Data data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data implements Serializable {
        private String source_path;
        @SerializedName("medium_path")
        @Expose
        private String medium_path;
        @SerializedName("thumbnail_path")
        @Expose
        private String thumbnail_path;
        @SerializedName("vid_img_path")
        @Expose
        private String vid_img_path;
        @SerializedName("chat_list")
        @Expose
        private List<MessageChatHistoryResponse.Data.ChatList> chat_list;

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

        public String getVid_img_path() {
            return vid_img_path;
        }

        public void setVid_img_path(String vid_img_path) {
            this.vid_img_path = vid_img_path;
        }

        public List<MessageChatHistoryResponse.Data.ChatList> getChat_list() {
            return chat_list;
        }

        public void setChat_list(List<MessageChatHistoryResponse.Data.ChatList> chat_list) {
            this.chat_list = chat_list;
        }


    }
}
