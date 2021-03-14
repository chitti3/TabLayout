
package com.example.youthhub.resModel.connection;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConnectionData implements Parcelable
{

    @SerializedName("connection_list")
    @Expose
    private List<ConnectionList> connectionList = null;
    @SerializedName("user_medium_path")
    @Expose
    private String userMediumPath;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    public final static Creator<ConnectionData> CREATOR = new Creator<ConnectionData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ConnectionData createFromParcel(Parcel in) {
            return new ConnectionData(in);
        }

        public ConnectionData[] newArray(int size) {
            return (new ConnectionData[size]);
        }

    }
    ;

    protected ConnectionData(Parcel in) {
        in.readList(this.connectionList, (ConnectionList.class.getClassLoader()));
        this.userMediumPath = ((String) in.readValue((String.class.getClassLoader())));
        this.userThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ConnectionData() {
    }

    public List<ConnectionList> getConnectionList() {
        return connectionList;
    }

    public void setConnectionList(List<ConnectionList> connectionList) {
        this.connectionList = connectionList;
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
        dest.writeList(connectionList);
        dest.writeValue(userMediumPath);
        dest.writeValue(userThumbnailPath);
    }

    public int describeContents() {
        return  0;
    }

}
