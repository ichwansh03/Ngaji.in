package com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTahsin;

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

public class TahsinModel extends ViewModel {
    private static final String API_TAHSIN = "AIzaSyDDcYZkYnHtJTFm29xhZjlwCFsFh7meOQw";
    private static final String ID_TAHSIN = "2224040062667062858";

    private MutableLiveData<ArrayList<BlogTahsinItem>> liveDataTahsin = new MutableLiveData<>();

    public void setBlogTahsin(final String tahsins){
        AsyncHttpClient clientTahsin = new AsyncHttpClient();

        final ArrayList<BlogTahsinItem> listTahsin = new ArrayList<>();

        String url_tahsin = "https://www.googleapis.com/blogger/v3/blogs/"+ID_TAHSIN+"/posts?key="+API_TAHSIN;

        clientTahsin.get(url_tahsin, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String hasil = new String(responseBody);
                    JSONObject jsonObject = new JSONObject(hasil);
                    JSONArray list = jsonObject.getJSONArray("items");

                    for (int s = 0;s < list.length(); s++){
                        JSONObject object = list.getJSONObject(s);
                        BlogTahsinItem blogTahsinItem = new BlogTahsinItem(object);
                        listTahsin.add(blogTahsinItem);
                    }
                    liveDataTahsin.postValue(listTahsin);
                } catch (Exception e){
                    Log.d("Exception",e.getMessage());
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<BlogTahsinItem>> getLiveTahsin(){ return liveDataTahsin;}

}
