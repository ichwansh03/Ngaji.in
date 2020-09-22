package com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogQuran;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class QuranModel extends ViewModel {
    private static final String API_QURAN = "AIzaSyDDcYZkYnHtJTFm29xhZjlwCFsFh7meOQw";
    private static final String ID_QURAN = "4359396763442789584";

    private MutableLiveData<ArrayList<BlogQuranItem>> liveDataQuran = new MutableLiveData<>();

    public void setBlogQuran(final String qurans){
        AsyncHttpClient clientQuran = new AsyncHttpClient();

        final ArrayList<BlogQuranItem> listQuran = new ArrayList<>();

        String url_quran = "https://www.googleapis.com/blogger/v3/blogs/"+ID_QURAN+"/posts?key="+API_QURAN;

        clientQuran.get(url_quran, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray lists = jsonObject.getJSONArray("items");

                    for (int x = 0;x < lists.length(); x++){
                        JSONObject object = lists.getJSONObject(x);
                        BlogQuranItem item = new BlogQuranItem(object);
                        listQuran.add(item);
                    }
                    liveDataQuran.postValue(listQuran);
                } catch (Exception e) {
                    Log.d("Exception", e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<BlogQuranItem>> getLiveQuran(){ return liveDataQuran;}
}
