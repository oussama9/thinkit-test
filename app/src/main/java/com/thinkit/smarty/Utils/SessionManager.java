package com.thinkit.smarty.Utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.thinkit.smarty.homeUi.HomeActivity;
import com.thinkit.smarty.MainActivity;

public class SessionManager {
    SharedPreferences pref;

    // Editor reference for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared preferences mode
    int PRIVATE_MODE = 0;

    public static final String PREFER_NAME = "UserPref";

    public static final String IS_USER_LOGIN = "IsUserLoggedIn";
    public static final String USER_NAME = "UserName";



    public SessionManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREFER_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }



    public boolean checkLogin() {
        // Check login status
        Intent intent = null;
        boolean isLogged = false;
        if (this.isUserLoggedIn()) {

            // user is logged in redirect him to Home Activity
            intent = new Intent(_context, HomeActivity.class);
            isLogged = true;
        } else {
            editor.clear();
            editor.commit();
            intent = new Intent(_context, MainActivity.class);

        }

        // Closing all the Activities from stack
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Activity
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);

        _context.startActivity(intent);

        return isLogged;
    }

    // Check for login
    public boolean isUserLoggedIn() {
        return pref.getBoolean(IS_USER_LOGIN, false);
    }
    public String getUserName() {
        return pref.getString(USER_NAME, "User");
    }

    public void setUserLoggedIn(String name) {
        editor.putBoolean(IS_USER_LOGIN, true);
        editor.putString(USER_NAME, name);
        editor.apply();

    }

}
