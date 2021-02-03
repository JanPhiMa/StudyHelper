package at.fhj.ima.studyhelper.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.adapters.QuestionAdapter
import at.fhj.ima.studyhelper.adapters.QuestionViewholder
import at.fhj.ima.studyhelper.classes.StudyType
import at.fhj.ima.studyhelper.data.StudyTypeRepository
import at.fhj.ima.studyhelper.ui.StudyType.StudyTypeFragment
import kotlinx.android.synthetic.main.activity_study_type.*
import kotlinx.android.synthetic.main.item_study_question.*

class StudyTypeActivity : AppCompatActivity() {
    companion object {
        val typeKey = "TYPEKEY"
        val typeTextKey = "TEXT"
    }
    val questionAdapter = QuestionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_type)

        questionAdapter.updateList(StudyTypeRepository.readQuestions())
        study_recycler_view.layoutManager = LinearLayoutManager(this)
        study_recycler_view.adapter = questionAdapter

        val sharedPreferences = getSharedPreferences(packageName, Context.MODE_PRIVATE)

        save_type.setOnClickListener() {
            val visualCount = questionAdapter.getQuestionList().count { it.selectedType == 1 }
            val auditoryCount = questionAdapter.getQuestionList().count { it.selectedType == 2 }
            val tactileCount = questionAdapter.getQuestionList().count { it.selectedType == 3 }

            if (visualCount + auditoryCount + tactileCount != 20) {
                Toast.makeText(this, "Please make sure that you answered every question!", Toast.LENGTH_SHORT).show()
            } else {
                for (question in StudyTypeRepository.readQuestions()) {
                    when {
                    visualCount > auditoryCount && visualCount > tactileCount -> {
                        sharedPreferences.edit().putString(typeKey, StudyTypeRepository.readType("Visual").type).apply()
                        sharedPreferences.edit().putString(typeTextKey, StudyTypeRepository.readType("Visual").text).apply()
                    }
                    auditoryCount > visualCount && auditoryCount > tactileCount -> {
                        sharedPreferences.edit().putString(typeKey, StudyTypeRepository.readType("Auditory").type).apply()
                        sharedPreferences.edit().putString(typeTextKey, StudyTypeRepository.readType("Auditory").text).apply()
                    }
                    tactileCount > visualCount && tactileCount > auditoryCount -> {
                        sharedPreferences.edit().putString(typeKey, StudyTypeRepository.readType("Tactile").type).apply()
                        sharedPreferences.edit().putString(typeTextKey, StudyTypeRepository.readType("Tactile").text).apply()
                    }
                    else -> {
                        sharedPreferences.edit().putString(typeKey, StudyTypeRepository.readType("Mixed").type).apply()
                        sharedPreferences.edit().putString(typeTextKey, StudyTypeRepository.readType("Mixed").text).apply()
                        }
                    }
                }
                finish()
            }
        }
    }
}