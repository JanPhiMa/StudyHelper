package at.fhj.ima.studyhelper.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.activities.LandingActivity.Companion.usernameKey
import at.fhj.ima.studyhelper.adapters.StudyProgramAdapter
import at.fhj.ima.studyhelper.data.StudyProgramRepository
import at.fhj.ima.studyhelper.data.UserRepository
import kotlinx.android.synthetic.main.activity_study_program.*
import kotlinx.android.synthetic.main.item_studyprogram.*


class StudyProgramActivity : AppCompatActivity() {
    companion object {
        val EXTRA_PROGRAM_PROGRAM = "PROGRAM_PROGRAM_EXTRA"
        val EXTRA_PROGRAM_SEMESTER = "SEMESTER_PROGRAM_EXTRA"
    }


    val studyProgramAdapter = StudyProgramAdapter(){
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra(EXTRA_PROGRAM_PROGRAM, it.StudyProgram)
        intent.putExtra(EXTRA_PROGRAM_SEMESTER, semesterSpinner.selectedItem.toString())

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        val user = sharedPreferences.getString(usernameKey, null).toString()
        UserRepository.addStudyProgram(this, user, it.StudyProgram)
        UserRepository.addSemester(this, user, semesterSpinner.selectedItem.toString())

        startActivity(intent)
        finish()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_program)

        val spinner = findViewById<View>(R.id.semesterSpinner) as Spinner

        val adapter = ArrayAdapter.createFromResource(this, R.array.semester_array, android.R.layout.simple_spinner_item)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = adapter

        studyProgramAdapter.updateList(StudyProgramRepository.studyProgramsList())
        studyProgram_RecyclerView.layoutManager = LinearLayoutManager(this)
        studyProgram_RecyclerView.adapter = studyProgramAdapter
    }


}