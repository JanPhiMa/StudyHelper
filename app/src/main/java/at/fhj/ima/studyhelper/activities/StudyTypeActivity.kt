package at.fhj.ima.studyhelper.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.adapters.QuestionAdapter
import at.fhj.ima.studyhelper.adapters.QuestionViewholder
import at.fhj.ima.studyhelper.data.StudyTypeRepository
import kotlinx.android.synthetic.main.activity_study_type.*

class StudyTypeActivity : AppCompatActivity() {
    val questionAdapter = QuestionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_study_type)

        questionAdapter.updateList(StudyTypeRepository.readQuestions())
        study_recycler_view.layoutManager = LinearLayoutManager(this)
        study_recycler_view.adapter = questionAdapter
    }
}