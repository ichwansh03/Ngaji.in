package com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogQuran;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONObject;

public class BlogQuranItem implements Parcelable {

    String tlquran;
    String cnquran;

    protected BlogQuranItem(Parcel in) {
        tlquran = in.readString();
        cnquran = in.readString();
    }

    public static final Creator<BlogQuranItem> CREATOR = new Creator<BlogQuranItem>() {
        @Override
        public BlogQuranItem createFromParcel(Parcel in) {
            return new BlogQuranItem(in);
        }

        @Override
        public BlogQuranItem[] newArray(int size) {
            return new BlogQuranItem[size];
        }
    };

    public String getTlquran() {
        return tlquran;
    }

    public void setTlquran(String tlquran) {
        this.tlquran = tlquran;
    }

    public String getCnquran() {
        return cnquran;
    }

    public void setCnquran(String cnquran) {
        this.cnquran = cnquran;
    }

    public BlogQuranItem(JSONObject jsonObject){
        try {
            String title = jsonObject.getString("title");
            String content = jsonObject.getString("content");

            this.tlquran = title;
            this.cnquran = content;
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
        parcel.writeString(tlquran);
        parcel.writeString(cnquran);
    }
}
