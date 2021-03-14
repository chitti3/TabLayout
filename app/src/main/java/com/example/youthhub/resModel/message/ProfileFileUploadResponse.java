package com.example.youthhub.resModel.message;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ProfileFileUploadResponse implements Serializable {

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("message")
    @Expose
    private String message;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public class Data implements Serializable{
        @SerializedName("filename")
        @Expose
        private String filename;
        @SerializedName("filenameuploadfield")
        @Expose
        private String filenameuploadfield;
        @SerializedName("path_source")
        @Expose
        private String path_source;
        @SerializedName("path_medium")
        @Expose
        private String path_medium;
        @SerializedName("path_thumb")
        @Expose
        private String path_thumb;
        @SerializedName("vid_path")
        @Expose
        private String vid_path;
        @SerializedName("file_path")
        @Expose
        private String file_path;

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public String getFilenameuploadfield() {
            return filenameuploadfield;
        }

        public void setFilenameuploadfield(String filenameuploadfield) {
            this.filenameuploadfield = filenameuploadfield;
        }

        public String getPath_source() {
            return path_source;
        }

        public void setPath_source(String path_source) {
            this.path_source = path_source;
        }

        public String getPath_medium() {
            return path_medium;
        }

        public void setPath_medium(String path_medium) {
            this.path_medium = path_medium;
        }

        public String getPath_thumb() {
            return path_thumb;
        }

        public void setPath_thumb(String path_thumb) {
            this.path_thumb = path_thumb;
        }

        public String getVid_path() {
            return vid_path;
        }

        public void setVid_path(String vid_path) {
            this.vid_path = vid_path;
        }

        public String getFile_path() {
            return file_path;
        }

        public void setFile_path(String file_path) {
            this.file_path = file_path;
        }
    }
}
