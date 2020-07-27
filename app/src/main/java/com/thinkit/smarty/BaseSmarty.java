package com.thinkit.smarty;

import android.app.Application;

import com.thinkit.smarty.Utils.SessionManager;

public class BaseSmarty extends Application {


    private static SessionManager sessionManager;

    public static SessionManager getSessionManager() {
        return sessionManager;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        sessionManager = new SessionManager(getApplicationContext());
    }

}
