package com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTajwid;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class BlogTajwidItem implements Parcelable {

    private String tlptTajwid;
    private String dsptTajwid;

    protected BlogTajwidItem(Parcel in) {
        tlptTajwid = in.readString();
        dsptTajwid = in.readString();
    }

    public static final Creator<BlogTajwidItem> CREATOR = new Creator<BlogTajwidItem>() {
        @Override
        public BlogTajwidItem createFromParcel(Parcel in) {
            return new BlogTajwidItem(in);
        }

        @Override
        public BlogTajwidItem[] newArray(int size) {
            return new BlogTajwidItem[size];
        }
    };

    public String getTlptTajwid() {
        return tlptTajwid;
    }

    public void setTlptTajwid(String tlptTajwid) {
        this.tlptTajwid = tlptTajwid;
    }

    public String getDsptTajwid() {
        return dsptTajwid;
    }

    public void setDsptTajwid(String dsptTajwid) {
        this.dsptTajwid = dsptTajwid;
    }

    public BlogTajwidItem(JSONObject object){
        try {
            String tlTajwid = object.getString("title");
            String ctTajwid = object.getString("content");

            this.tlptTajwid = tlTajwid;
            this.dsptTajwid = ctTajwid;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tlptTajwid);
        parcel.writeString(dsptTajwid);
    }
}
