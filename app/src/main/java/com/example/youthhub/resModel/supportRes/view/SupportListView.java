
package com.example.youthhub.resModel.supportRes.view;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupportListView implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private ViewData viewData;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<SupportListView> CREATOR = new Creator<SupportListView>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SupportListView createFromParcel(Parcel in) {
            return new SupportListView(in);
        }

        public SupportListView[] newArray(int size) {
            return (new SupportListView[size]);
        }

    }
    ;

    protected SupportListView(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.viewData = ((ViewData) in.readValue((ViewData.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SupportListView() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public ViewData getViewData() {
        return viewData;
    }

    public void setViewData(ViewData viewData) {
        this.viewData = viewData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(viewData);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
