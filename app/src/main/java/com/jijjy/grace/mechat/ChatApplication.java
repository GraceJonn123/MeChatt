package com.jijjy.grace.mechat;

import com.firebase.client.Firebase;

/**
 * Created by grace on 4/8/16.
 */
public class ChatApplication extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
