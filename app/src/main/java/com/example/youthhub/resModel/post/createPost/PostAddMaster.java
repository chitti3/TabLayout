
package com.example.youthhub.resModel.post.createPost;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostAddMaster implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private PostAddMasterData postAddMasterData;
    public final static Creator<PostAddMaster> CREATOR = new Creator<PostAddMaster>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PostAddMaster createFromParcel(Parcel in) {
            return new PostAddMaster(in);
        }

        public PostAddMaster[] newArray(int size) {
            return (new PostAddMaster[size]);
        }

    }
    ;

    protected PostAddMaster(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.postAddMasterData = ((PostAddMasterData) in.readValue((PostAddMasterData.class.getClassLoader())));
    }

    public PostAddMaster() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public PostAddMasterData getPostAddMasterData() {
        return postAddMasterData;
    }

    public void setPostAddMasterData(PostAddMasterData postAddMasterData) {
        this.postAddMasterData = postAddMasterData;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(postAddMasterData);
    }

    public int describeContents() {
        return  0;
    }

}
