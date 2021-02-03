package at.fhj.ima.studyhelper.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.activities.MainActivity.Companion.darkModeKey
import at.fhj.ima.studyhelper.data.UserRepository
import kotlinx.android.synthetic.main.activity_landing.*
import kotlinx.android.synthetic.main.nav_header_main.*


class LandingActivity : AppCompatActivity() {
    companion object {
        val usernameKey = "USERNAME"
        val passwordKey = "PASSWORD"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean(darkModeKey, false)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        val savedUsername = sharedPreferences.getString(usernameKey, null)
        val savedPassword = sharedPreferences.getString(passwordKey, null)

        if (savedUsername != null || savedPassword != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        landing_button_login.setOnClickListener {
            val databaseUser = UserRepository.findUser(this, (landing_username_login.text.toString()))

            sharedPreferences.edit().putString(usernameKey, landing_username_login.text.toString()).apply()
            sharedPreferences.edit().putString(passwordKey, landing_password.text.toString()).apply()


                if (databaseUser?.username.toString() != landing_username_login.text.toString()) {
                    val intent = Intent(this, RegisterActivity::class.java)
                    startActivityForResult(intent,101)

                } else if (databaseUser?.password.toString() != landing_password.text.toString()) {
                    Toast.makeText(this, "It seems the password was incorrect!", Toast.LENGTH_SHORT).show()
                }
                else {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }