package com.josrom.recetarium.application;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ConfigApp extends AppCompatActivity {
    private Context context;
    private RequestQueue mRequestQueue;
    public static ConfigApp mInstance;
    public static final String TAG = ConfigApp.class.getSimpleName();

    private ConfigApp(Context context) {
        mRequestQueue = Volley.newRequestQueue(context);
    }

    public static synchronized ConfigApp getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ConfigApp(context);
        }

        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(context);
        }

        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        addToRequestQueue(req, TAG);
    }

    public <T> void addToRequestQueue(Request<T> req, String tag) {
        req.setTag(TextUtils.isEmpty(tag) ? TAG: tag);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
}
