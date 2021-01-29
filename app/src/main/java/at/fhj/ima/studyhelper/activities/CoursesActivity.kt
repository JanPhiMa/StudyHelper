package at.fhj.ima.studyhelper.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.adapters.CoursesAdapter
import at.fhj.ima.studyhelper.adapters.StudyProgramAdapter
import at.fhj.ima.studyhelper.data.CoursesRepository
import at.fhj.ima.studyhelper.data.StudyProgramRepository
import kotlinx.android.synthetic.main.activity_courses.*
import kotlinx.android.synthetic.main.activity_study_program.*
import kotlinx.android.synthetic.main.item_studyprogram.*

class CoursesActivity : AppCompatActivity() {

    val coursesAdapter = CoursesAdapter(){
        val intent = Intent(this, CoursesSingleActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        //val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        val programName = intent.getStringExtra(StudyProgramActivity.EXTRA_PROGRAM_PROGRAM)


        if (programName != null){
            coursesAdapter.updateListFiltered(CoursesRepository.coursesList(), programName)
        } else {
            coursesAdapter.updateList(CoursesRepository.coursesList())
        }
        activity_courses_recyclerview.layoutManager = LinearLayoutManager(this)
        activity_courses_recyclerview.adapter = coursesAdapter
    }
}