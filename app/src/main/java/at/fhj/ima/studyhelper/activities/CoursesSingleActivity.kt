package at.fhj.ima.studyhelper.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.classes.Courses
import at.fhj.ima.studyhelper.ui.home.HomeFragment
import at.fhj.ima.studyhelper.ui.home.HomeFragment.Companion.EXTRA_COURSE_COURSE
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_courses_single.*

class CoursesSingleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses_single)
       // setSupportActionBar(findViewById(R.id.toolbar))

        /*findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Calling the API", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()

        }*/
    }
   /* override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_courses_single, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }*/
}