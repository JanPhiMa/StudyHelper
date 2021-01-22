package at.fhj.ima.studyhelper.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import at.fhj.ima.studyhelper.R
import kotlinx.android.synthetic.main.activity_landing.*


class LandingActivity : AppCompatActivity() {
    companion object {
        val usernameKey = "USERNAME"
        val passwordKey = "PASSWORD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        val savedUsername = sharedPreferences.getString(usernameKey, null)
        landing_username_login.setText(savedUsername)
        val savedPassword = sharedPreferences.getString(passwordKey, null)
        landing_password.setText(savedPassword)

        if (savedUsername != null || savedPassword != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        landing_button_login.setOnClickListener {
        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

            sharedPreferences.edit().putString(usernameKey, landing_username_login.text.toString()).apply()
            sharedPreferences.edit().putString(passwordKey, landing_password.text.toString()).apply()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}