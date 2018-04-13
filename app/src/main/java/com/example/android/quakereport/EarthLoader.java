package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;


public class EarthLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String urls;

     EarthLoader(Context context,String url) {
        super(context);
        urls = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {

        if (urls == null) {
            return null;
        }

        List<Earthquake> eartquakeArray = QueryUtils.fetchData(urls);

        return eartquakeArray;
    }

}
