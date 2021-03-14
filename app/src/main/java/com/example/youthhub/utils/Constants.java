package com.example.youthhub.utils;

import android.app.Activity;

public class Constants {

    public static final int CAMERA_REQUEST = 10;
    public static final int GALLERY_REQUEST = 11;
    public static final int FILE_REQUEST = 12;

    public static final String failureResponse = "FailRes";
    public static final String RegisterData = "RegisterData";
    public static final String LoginData = "LoginData";

    public static final String EthnicityList = "EthnicityList";
    public static final String RegionList = "RegionList";
    public static final String DistrictList = "DistrictList";
    public static final String GenderList = "GenderList";
    public static final String IwiList = "IwiList";
    public static final String JobWishList = "JobWishList";

    public static final String Email = "email";
    public static final String DOB = "dob";
    public static final String AcceptTerms = "AcceptTerms";
    public static final String Message = "message";
    public static final String Fragment = "fragment";
    public static final String PassCode = "passcode";
    public static final String PdfLoadFailure = "FailurePdf";
    public static final String EventViewRes = "EventViewRes";
    public static final String EventViewData = "EventViewData";
    public static final String GalleryDatas = "GalleryDatas";
    public static final String VideoPath = "VideoPath";

    public static final String AccessKey = "Access_key";
    public static final String Token = "Token";
    public static final String UserID = "UserID";
    public static final String UserCode = "UserCode";
    public static final String UserNameCode = "user_name_code";
    public static final String UserType = "UserType";
    public static final String UserChat = "UserChat";
    public static final String UserFollow = "UserFollow";
    public static final String UserPoints = "UserPoints";
    public static final String UserLevelName = "UserLevelName";
    public static final String UserName = "UserName";
    public static final String UserImagePath = "UserImageName";
    public static final String UserProfileImage = "UserProfileImage";
    public static final String UserLevel = "UserLevel";
    public static final String ExploreView = "ExploreView";
    public static final String ExploreTopicsView = "ExploreTopicsView";
    public static final String TopicContent = "TopicContent";
    public static final String PostAddMaster = "PostAddMaster";
    public static final String PostLikeList = "PostLikeList";
    public static final String PostImageList = "PostImageList";
    public static final String PostCommentList = "PostCommentList";
    public static final String PostCode = "PostCode";
    public static final String LikeCount = "LikeCount";
    public static final String VimeoVideoId = "VimeoVideoId";
    public static final String ProfileInfo = "ProfileInfo";
    public static final String GlideException = "GlideException";

    public static final String DEVICE_KEY = "Yh";
    public static final String DEVICE_TYPE = "Yh";
    public static final String App_TYPE = "android";


    public static final String App_CHAT_TYPE = "inbox";
    public static final String App_CHAT_USER_ONLINE = "online";
    public static final String App_CHAT_USER_OFFLINE = "offline";


    public static final String APP_File_Stack_Key = "AVo4XGlLGRW6fVLCZuCW3z";



    public static final String App_CHAT_ID = "chat_id";
    public static final String App_CHAT_USERCODE = "usercode";
   // public static final String App_CHAT_USER_OFFLINE = "offline";

    public static String getApiKey(Activity activity){
        return "T7aaUFPKAE0WDIZY8Q5s4LIknv0lXazE5xFP2ipq";
    }

    public static String getAccessKey(Activity activity) {
        return Preference.getInstance(activity).getStr(Constants.AccessKey);
    }

    public static String getToken(Activity activity) {
        return "Youthhub " + Preference.getInstance(activity).getStr(Constants.Token);
    }

    public static String getUserID(Activity activity) {
        return Preference.getInstance(activity).getStr(Constants.UserID);
    }

    public static String getUserCode(Activity activity) {
        return Preference.getInstance(activity).getStr(Constants.UserCode);
    }

    public static String getUserType(Activity activity) {
        return Preference.getInstance(activity).getStr(Constants.UserType);
    }

    public static String getLoadGlide(Activity activity,String path){
        return path+"?yh-access-key="+Constants.getAccessKey(activity);
    }

}
