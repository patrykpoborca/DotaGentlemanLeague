package io.ppoborca.dotagentlemanleague;

import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.firebase.client.Firebase;

public class gentlemanApp extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        MultiDex.install(this);
    }
}
