package at.fhj.ima.studyhelper.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.classes.Courses
import at.fhj.ima.studyhelper.data.UserRepository
import at.fhj.ima.studyhelper.ui.home.HomeFragment
import at.fhj.ima.studyhelper.ui.home.HomeFragment.Companion.EXTRA_COURSE_COURSE
import kotlinx.android.synthetic.main.activity_courses_single.*

class CoursesSingleActivity : AppCompatActivity() {
    companion object {
        val commentKey = "COMMENT"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses_single)

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val previousComments = sharedPreferences.getString(commentKey, activity_courses_single_notesection.getText().toString())

        activity_courses_single_notesection.setOnClickListener {
            sharedPreferences.edit().putString(commentKey, activity_courses_single_notesection.getText().toString()).apply()
        }


        activity_courses_single_course.text = intent.getStringExtra(HomeFragment.EXTRA_COURSE_COURSE)
        activity_courses_single_semester.text = "Semester of relevance: " + intent.getStringExtra(HomeFragment.EXTRA_COURSE_SEMESTER)
        activity_courses_single_lecturer.text = "Course Lecturer(s): " + intent.getStringExtra(HomeFragment.EXTRA_COURSE_LECTURER)
        activity_courses_single_ects.text = "Course ECTS Credits: " + intent.getStringExtra(HomeFragment.EXTRA_COURSE_ECTS)
        activity_courses_single_sws.text = "Weekly hours: " + intent.getStringExtra(HomeFragment.EXTRA_COURSE_SWS)
        activity_courses_single_notesection.setText(previousComments)
    }
}