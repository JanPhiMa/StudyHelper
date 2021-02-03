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
import kotlinx.android.synthetic.main.activity_landing.*
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

        register_signup_button.setOnClickListener {
            when {
                register_username_text.text.toString() == UserRepository.findUser(this, register_username_text.text.toString())?.username -> Toast.makeText(this, "Username is already taken!", Toast.LENGTH_SHORT).show()
                register_username_text.text.length < 6 -> Toast.makeText(this, "Username needs to be at least 6 characters long!", Toast.LENGTH_SHORT).show()
                register_password_text.text.length < 12 -> Toast.makeText(this, "Password needs to be at least 12 characters long!", Toast.LENGTH_SHORT).show()
                register_password2_text.text.toString() != register_password_text.text.toString() -> Toast.makeText(this, "Passwords don't match!", Toast.LENGTH_SHORT).show()
                else -> {
                    val addUser = Users(register_username_text.text.toString(), register_password_text.text.toString())
                    UserRepository.addUser(this, addUser)
                    sharedPreferences.edit().putString(usernameKey, register_username_text.text.toString()).apply()
                    sharedPreferences.edit().putString(passwordKey, register_password_text.text.toString()).apply()
                    val intent = Intent(this, StudyProgramActivity::class.java)
                    startActivity(intent)
                    finishActivity(101)
                    finish()
                }
            }
        }
    }
}