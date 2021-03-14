package com.example.youthhub.retrofit;

import com.example.youthhub.resModel.profile.profileinfo.ProfileInfo;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class UserResponseDeserializer implements JsonDeserializer<ResponseWrapper> {
    @Override
    public ResponseWrapper deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {


        if (((JsonObject) json).get("responseMessage") instanceof JsonObject){
            return new Gson().fromJson(json, ProfileInfo.class);
        } else {
            return new Gson().fromJson(json, ProfileInfo.class);
        }

    }
}