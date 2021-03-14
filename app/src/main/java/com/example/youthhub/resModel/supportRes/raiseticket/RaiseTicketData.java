
package com.example.youthhub.resModel.supportRes.raiseticket;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RaiseTicketData implements Parcelable
{

    @SerializedName("helpdesk_info")
    @Expose
    private HelpdeskInfo helpdeskInfo;
    @SerializedName("helpdesk_detail")
    @Expose
    private List<HelpdeskDetail> helpdeskDetail = null;
    @SerializedName("user_thumbnail_path")
    @Expose
    private String userThumbnailPath;
    @SerializedName("file_path")
    @Expose
    private String filePath;
    public final static Creator<RaiseTicketData> CREATOR = new Creator<RaiseTicketData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RaiseTicketData createFromParcel(Parcel in) {
            return new RaiseTicketData(in);
        }

        public RaiseTicketData[] newArray(int size) {
            return (new RaiseTicketData[size]);
        }

    }
    ;

    protected RaiseTicketData(Parcel in) {
        this.helpdeskInfo = ((HelpdeskInfo) in.readValue((HelpdeskInfo.class.getClassLoader())));
        in.readList(this.helpdeskDetail, (com.example.youthhub.resModel.supportRes.raiseticket.HelpdeskDetail.class.getClassLoader()));
        this.userThumbnailPath = ((String) in.readValue((String.class.getClassLoader())));
        this.filePath = ((String) in.readValue((String.class.getClassLoader())));
    }

    public RaiseTicketData() {
    }

    public HelpdeskInfo getHelpdeskInfo() {
        return helpdeskInfo;
    }

    public void setHelpdeskInfo(HelpdeskInfo helpdeskInfo) {
        this.helpdeskInfo = helpdeskInfo;
    }

    public List<HelpdeskDetail> getHelpdeskDetail() {
        return helpdeskDetail;
    }

    public void setHelpdeskDetail(List<HelpdeskDetail> helpdeskDetail) {
        this.helpdeskDetail = helpdeskDetail;
    }

    public String getUserThumbnailPath() {
        return userThumbnailPath;
    }

    public void setUserThumbnailPath(String userThumbnailPath) {
        this.userThumbnailPath = userThumbnailPath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(helpdeskInfo);
        dest.writeList(helpdeskDetail);
        dest.writeValue(userThumbnailPath);
        dest.writeValue(filePath);
    }

    public int describeContents() {
        return  0;
    }

}
