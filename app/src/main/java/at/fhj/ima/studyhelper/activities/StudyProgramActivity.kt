package at.fhj.ima.studyhelper.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.adapters.CoursesAdapter
import at.fhj.ima.studyhelper.adapters.StudyProgramAdapter
import at.fhj.ima.studyhelper.classes.StudyProgram
import at.fhj.ima.studyhelper.data.CoursesRepository
import at.fhj.ima.studyhelper.data.StudyProgramRepository
import kotlinx.android.synthetic.main.activity_study_program.*
import kotlinx.android.synthetic.main.item_studyprogram.*

class StudyProgramActivity : AppCompatActivity() {
    companion object {
        //val studyProgramKey = "STUDYPROGRAM"
        val EXTRA_PROGRAM_PROGRAM = "PROGRAM_PROGRAM_EXTRA"
    }

    val studyProgramAdapter = StudyProgramAdapter(){
        val intent = Intent (this, CoursesActivity::class.java)
        intent.putExtra(EXTRA_PROGRAM_PROGRAM, it.StudyProgram)
        //val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)
        //sharedPreferences.edit().putString(StudyProgramActivity.studyProgramKey, item_studyprogram_studyprogram.text.toString()).apply()

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