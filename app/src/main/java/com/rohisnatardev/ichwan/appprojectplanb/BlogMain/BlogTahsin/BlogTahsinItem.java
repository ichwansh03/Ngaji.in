package com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTahsin;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class BlogTahsinItem implements Parcelable {

    private String tlbTahsin;
    private String ctbTahsin;

    protected BlogTahsinItem(Parcel in) {
        tlbTahsin = in.readString();
        ctbTahsin = in.readString();
    }

    public static final Creator<BlogTahsinItem> CREATOR = new Creator<BlogTahsinItem>() {
        @Override
        public BlogTahsinItem createFromParcel(Parcel in) {
            return new BlogTahsinItem(in);
        }

        @Override
        public BlogTahsinItem[] newArray(int size) {
            return new BlogTahsinItem[size];
        }
    };

    public String getTlbTahsin() {
        return tlbTahsin;
    }

    public void setTlbTahsin(String tlbTahsin) {
        this.tlbTahsin = tlbTahsin;
    }

    public String getCtbTahsin() {
        return ctbTahsin;
    }

    public void setCtbTahsin(String ctbTahsin) {
        this.ctbTahsin = ctbTahsin;
    }

    public BlogTahsinItem(JSONObject jsObject){
        try {
            String tlTahsin = jsObject.getString("title");
            String ctTahsin = jsObject.getString("content");

            this.tlbTahsin = tlTahsin;
            this.ctbTahsin = ctTahsin;
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
        parcel.writeString(tlbTahsin);
        parcel.writeString(ctbTahsin);
    }
}
