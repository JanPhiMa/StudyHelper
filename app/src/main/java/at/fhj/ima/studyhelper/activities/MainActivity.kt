package at.fhj.ima.studyhelper.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.activities.LandingActivity.Companion.usernameKey
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    companion object {
        val darkModeKey = "DARKMODE"
    }

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val headerView: View = navView.getHeaderView(0)
        val navUsername: TextView = headerView.findViewById(R.id.header_username)
        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        navUsername.text = sharedPreferences.getString(usernameKey, null)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
                setOf(
                        R.id.nav_home, R.id.nav_studyType
                ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_logout -> {
                val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
                sharedPreferences.edit().putString(LandingActivity.usernameKey, null).apply()
                sharedPreferences.edit().putString(LandingActivity.passwordKey, null).apply()
                val intent = Intent(this, LandingActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_studyprogram -> {
                val intent = Intent(this, StudyProgramActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_dark_mode -> {
                val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
                if (sharedPreferences.getBoolean(darkModeKey, false)) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    sharedPreferences.edit().putBoolean(darkModeKey, false).apply()
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    sharedPreferences.edit().putBoolean(darkModeKey, true).apply()
                }
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}