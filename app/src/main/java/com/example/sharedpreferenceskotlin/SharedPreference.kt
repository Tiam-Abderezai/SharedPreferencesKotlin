package com.example.sharedpreferenceskotlin

import android.content.Context
import android.content.SharedPreferences

// Handles the SharedPreferences' operations
class SharedPreference {

    private var mPref: SharedPreferences
    private var mContext: Context

    constructor(context: Context) {
        this.mContext = context
        // 1st parameter is the file name
        // 2nd parameter allows only the app to read/write the preference
        mPref = context.getSharedPreferences(
            context.getResources().getString(R.string.login_preference),
            Context.MODE_PRIVATE
        )
    }

    // Save the SharedPreferences status (true/false)
    fun writeLoginStatus(status: Boolean) {
        val editor = mPref.edit()
        // 1st parameter is the key for the data
        // 2nd parameter is the boolean status
        editor.putBoolean(
            mContext.resources.getString(R.string.login_status_preference),
            status
        )
        // Saves the changes
        editor.commit();
    }

    fun readLoginStatus(): Boolean {
        // Default value
        var status: Boolean = false
        // 1st parameter is the key for the data
        // 2nd parameter is the default value (false)
        status =
            mPref.getBoolean(mContext.resources.getString(R.string.login_status_preference), false)
        return status;
    }

}
