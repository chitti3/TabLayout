package com.example.youthhub;

public class DataModel1 {
    String message,time;
    int image;

    public DataModel1(String message, String time, int image) {
        this.message = message;
        this.time = time;
        this.image = image;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
