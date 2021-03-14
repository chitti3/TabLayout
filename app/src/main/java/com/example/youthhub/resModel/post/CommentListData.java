
package com.example.youthhub.resModel.post;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CommentListData implements Parcelable
{

    @SerializedName("comment_list")
    @Expose
    private List<CommentList> commentList = new ArrayList<>();
    @SerializedName("user_medium_path")
    @Expose
    private String userMediumPath;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    public final static Creator<CommentListData> CREATOR = new Creator<CommentListData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CommentListData createFromParcel(Parcel in) {
            return new CommentListData(in);
        }

        public CommentListData[] newArray(int size) {
            return (new CommentListData[size]);
        }

    }
    ;

    protected CommentListData(Parcel in) {
        in.readList(this.commentList, (com.example.youthhub.resModel.post.CommentList.class.getClassLoader()));
        this.userMediumPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public CommentListData() {
    }

    public List<CommentList> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentList> commentList) {
        this.commentList = commentList;
    }

    public String getUserMediumPath() {
        return userMediumPath;
    }

    public void setUserMediumPath(String userMediumPath) {
        this.userMediumPath = userMediumPath;
    }

    public String getUserThumbnailPath() {
        return userThumbnailPath;
    }

    public void setUserThumbnailPath(String userThumbnailPath) {
        this.userThumbnailPath = userThumbnailPath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(commentList);
        dest.writeValue(userMediumPath);
        dest.writeValue(userThumbnailPath);
    }

    public int describeContents() {
        return  0;
    }

}
