
package com.example.youthhub.resModel.supportRes.raiseticket;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SupportRaiseTicket implements Parcelable
{

    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("data")
    @Expose
    private RaiseTicketData raiseTicketData;
    @SerializedName("message")
    @Expose
    private String message;
    public final static Creator<SupportRaiseTicket> CREATOR = new Creator<SupportRaiseTicket>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SupportRaiseTicket createFromParcel(Parcel in) {
            return new SupportRaiseTicket(in);
        }

        public SupportRaiseTicket[] newArray(int size) {
            return (new SupportRaiseTicket[size]);
        }

    }
    ;

    protected SupportRaiseTicket(Parcel in) {
        this.status = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.raiseTicketData = ((RaiseTicketData) in.readValue((RaiseTicketData.class.getClassLoader())));
        this.message = ((String) in.readValue((String.class.getClassLoader())));
    }

    public SupportRaiseTicket() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public RaiseTicketData getRaiseTicketData() {
        return raiseTicketData;
    }

    public void setRaiseTicketData(RaiseTicketData raiseTicketData) {
        this.raiseTicketData = raiseTicketData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(status);
        dest.writeValue(raiseTicketData);
        dest.writeValue(message);
    }

    public int describeContents() {
        return  0;
    }

}
