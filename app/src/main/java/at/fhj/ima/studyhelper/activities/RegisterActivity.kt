package at.fhj.ima.studyhelper.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.activities.LandingActivity.Companion.passwordKey
import at.fhj.ima.studyhelper.activities.LandingActivity.Companion.usernameKey
import at.fhj.ima.studyhelper.classes.Users
import at.fhj.ima.studyhelper.data.UserRepository
import at.fhj.ima.studyhelper.data.UsersDao
import kotlinx.android.synthetic.main.activity_register_acitivity.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_acitivity)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val savedUsername = sharedPreferences.getString(usernameKey, null)
        val savedPassword = sharedPreferences.getString(passwordKey, null)

        register_username_text.setText(savedUsername)
        register_password_text.setText(savedPassword)

        register_signup_button.setOnClickListener() {
            if (register_password2_text.text.toString() != savedPassword) {
                Toast.makeText(this, "Passwords don't match!", Toast.LENGTH_SHORT).show()
            } else {
                val addUser = Users(savedUsername.toString(), savedPassword.toString())
                UserRepository.addUser(this, addUser)
                val intent = Intent(this, StudyProgramActivity::class.java)
                startActivity(intent)
            }
        }
    }
}