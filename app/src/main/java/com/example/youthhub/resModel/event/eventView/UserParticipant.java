
package com.example.youthhub.resModel.event.eventView;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserParticipant implements Parcelable
{

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("data")
    @Expose
    private Object data;
    public final static Creator<UserParticipant> CREATOR = new Creator<UserParticipant>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UserParticipant createFromParcel(Parcel in) {
            return new UserParticipant(in);
        }

        public UserParticipant[] newArray(int size) {
            return (new UserParticipant[size]);
        }

    }
    ;

    protected UserParticipant(Parcel in) {
        this.count = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.data = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public UserParticipant() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(count);
        dest.writeValue(data);
    }

    public int describeContents() {
        return  0;
    }

}
