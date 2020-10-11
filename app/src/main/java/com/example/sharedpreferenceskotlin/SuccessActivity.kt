package com.example.sharedpreferenceskotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SuccessActivity : AppCompatActivity() {
    private lateinit var mPref: SharedPreference
    private lateinit var mLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)
        mPref = SharedPreference(applicationContext)
        mLogout = findViewById(R.id.logout)

        mLogout.setOnClickListener() {
            mPref.writeLoginStatus(false)
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}
