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
/*
class CoursesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        //val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
    }
}
*/