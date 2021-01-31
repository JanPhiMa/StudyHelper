package at.fhj.ima.studyhelper.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.adapters.CoursesAdapter
import at.fhj.ima.studyhelper.adapters.StudyProgramAdapter
import at.fhj.ima.studyhelper.classes.StudyProgram
import at.fhj.ima.studyhelper.data.CoursesRepository
import at.fhj.ima.studyhelper.activities.LandingActivity.Companion.usernameKey
import at.fhj.ima.studyhelper.data.StudyProgramRepository
import at.fhj.ima.studyhelper.data.UserRepository
import at.fhj.ima.studyhelper.data.UsersDao
import kotlinx.android.synthetic.main.activity_study_program.*
import kotlinx.android.synthetic.main.item_studyprogram.*

class StudyProgramActivity : AppCompatActivity() {
    companion object {
        //val studyProgramKey = "STUDYPROGRAM"
        val EXTRA_PROGRAM_PROGRAM = "PROGRAM_PROGRAM_EXTRA"
        val EXTRA_PROGRAM_SEMESTER = "SEMESTER_PROGRAM_EXTRA"
        val semesterKey = "SEMESTER"
    }


    val studyProgramAdapter = StudyProgramAdapter(){
        val intent = Intent (this, MainActivity::class.java)
        intent.putExtra(EXTRA_PROGRAM_PROGRAM, it.StudyProgram)
        intent.putExtra(EXTRA_PROGRAM_SEMESTER, editTextNumber.text.toString())
        //val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        //sharedPreferences.edit().putString(StudyProgramActivity.studyProgramKey, item_studyprogram_studyprogram.text.toString()).apply()

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val user = sharedPreferences.getString(usernameKey, null).toString()
        UserRepository.addStudyProgram(this, user, it.StudyProgram)
        //sharedPreferences.edit().putString(semesterKey, editTextNumber.text.toString()).apply()
        UserRepository.addSemester(this, user, editTextNumber.text.toString())

        startActivity(intent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_program)


        studyProgramAdapter.updateList(StudyProgramRepository.studyProgramsList())
        studyProgram_RecyclerView.layoutManager = LinearLayoutManager(this)
        studyProgram_RecyclerView.adapter = studyProgramAdapter
    }


}