package at.fhj.ima.studyhelper.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.classes.Courses
import at.fhj.ima.studyhelper.data.UserRepository
import at.fhj.ima.studyhelper.ui.home.HomeFragment
import at.fhj.ima.studyhelper.ui.home.HomeFragment.Companion.EXTRA_COURSE_COURSE
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_courses_single.*

class CoursesSingleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses_single)
    }
}