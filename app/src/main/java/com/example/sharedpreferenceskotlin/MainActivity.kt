package com.example.sharedpreferenceskotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var mET_Username: EditText
    private lateinit var mET_Password: EditText
    private lateinit var mPref: SharedPreference
    private lateinit var mLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mET_Username = findViewById(R.id.username)
        mET_Password = findViewById(R.id.password)
        mPref = SharedPreference(applicationContext)

        if (mPref.readLoginStatus()) {
            val intent = Intent(this, SuccessActivity::class.java)
            startActivity(intent)
            finish()
        }
        mLogin = findViewById(R.id.login)
        mLogin.setOnClickListener() {
            var username: String = mET_Username.getText().toString()
            var password: String = mET_Password.getText().toString()

            // If login is successful:
            if (username.equals(resources.getString(R.string.username))
                    && password.equals(resources.getString(R.string.password))
            ) {
                // 1) start SuccessActivity
                val intent = Intent(this, SuccessActivity::class.java)
                startActivity(intent)
                mPref.writeLoginStatus(true)
                finish()
            }
            // Otherwise, tell user login failed and try again
            else {
                Toast.makeText(this,"", Toast.LENGTH_SHORT)
                mET_Username.setText("")
                mET_Password.setText("")
            }

        }


    }

}