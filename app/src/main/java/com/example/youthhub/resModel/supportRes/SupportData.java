
package com.example.youthhub.resModel.supportRes;

import java.util.Collection;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupportData implements Parcelable
{

    @SerializedName("helpdesklist")
    @Expose
    private List<SupportList> helpdesklist = null;
    public final static Creator<SupportData> CREATOR = new Creator<SupportData>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SupportData createFromParcel(Parcel in) {
            return new SupportData(in);
        }

        public SupportData[] newArray(int size) {
            return (new SupportData[size]);
        }

    }
    ;

    protected SupportData(Parcel in) {
        in.readList(this.helpdesklist, (SupportList.class.getClassLoader()));
    }

    public SupportData() {
    }

    public List<SupportList> getHelpdesklist() {
        return helpdesklist;
    }

    public void setHelpdesklist(List<SupportList> helpdesklist) {
        this.helpdesklist = helpdesklist;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(helpdesklist);
    }

    public int describeContents() {
        return  0;
    }

}
