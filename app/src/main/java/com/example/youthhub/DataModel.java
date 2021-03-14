package com.example.youthhub;

public class DataModel {

     String name;
    String message;
     int image;
     String time;

    public DataModel( String name, String message, String time,int image) {

        this.name = name;
        this.message = message;
        this.image = image;
        this.time = time;
    }

    public String getName() {

        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public int getImage() {

        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTime() {

        return time;
    }

    public void setTime(String time) {

        this.time = time;
    }
}