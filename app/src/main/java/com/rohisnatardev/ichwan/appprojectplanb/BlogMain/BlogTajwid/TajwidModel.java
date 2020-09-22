package com.rohisnatardev.ichwan.appprojectplanb.BlogMain.BlogTajwid;

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

public class TajwidModel extends ViewModel {
    private static final String API_TAJWID = "AIzaSyDDcYZkYnHtJTFm29xhZjlwCFsFh7meOQw";
    private static final String ID_TAJWID = "7378872192809359189";

    private MutableLiveData<ArrayList<BlogTajwidItem>> liveDataTajwid = new MutableLiveData<>();

    public void setBlogTajwid(final String tajwids){
        AsyncHttpClient clientTajwid = new AsyncHttpClient();

        final ArrayList<BlogTajwidItem> listTajwid = new ArrayList<>();

        String url_tajwid = "https://www.googleapis.com/blogger/v3/blogs/"+ID_TAJWID+"/posts?key="+API_TAJWID;

        clientTajwid.get(url_tajwid, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                try {
                    String result = new String(responseBody);
                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray lists = jsonObject.getJSONArray("items");

                    for (int i = 0; i < lists.length(); i++){
                        JSONObject object = lists.getJSONObject(i);
                        BlogTajwidItem tajwidItem = new BlogTajwidItem(object);
                        listTajwid.add(tajwidItem);
                    }
                    liveDataTajwid.postValue(listTajwid);
                } catch (Exception e) {
                    Log.d("Exception",e.getMessage());}
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d("onFailure", error.getMessage());
            }
        });
    }

    public LiveData<ArrayList<BlogTajwidItem>> getLiveTajwid(){return liveDataTajwid;}
}
