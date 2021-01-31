package at.fhj.ima.studyhelper.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.adapters.QuestionAdapter
import at.fhj.ima.studyhelper.adapters.QuestionViewholder
import at.fhj.ima.studyhelper.data.StudyTypeRepository
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
            var visual = 0
            var auditory = 0
            var tactile = 0

            for (question in StudyTypeRepository.readQuestions()) {
                when {
                    item_study_visual.isChecked -> visual += 1
                    item_study_auditory.isChecked -> auditory += 1
                    item_study_tactile.isChecked -> tactile += 1
                }
                when {
                    visual > auditory && visual > tactile -> {
                        sharedPreferences.edit().putString(typeKey, StudyTypeRepository.readType("Visual").type).apply()
                        sharedPreferences.edit().putString(typeTextKey, StudyTypeRepository.readType("Visual").text).apply()
                    }
                    auditory > visual && auditory > tactile -> {
                        sharedPreferences.edit().putString(typeKey, StudyTypeRepository.readType("Auditory").type).apply()
                        sharedPreferences.edit().putString(typeTextKey, StudyTypeRepository.readType("Auditory").text).apply()
                    }
                    tactile > visual && tactile > auditory -> {
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