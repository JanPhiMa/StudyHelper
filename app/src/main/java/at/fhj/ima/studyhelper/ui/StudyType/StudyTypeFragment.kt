package at.fhj.ima.studyhelper.ui.StudyType

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.activities.MainActivity
import at.fhj.ima.studyhelper.activities.StudyTypeActivity
import kotlinx.android.synthetic.main.fragment_study_type.*

class StudyTypeFragment : Fragment() {

    private lateinit var studyTypeViewModel: StudyTypeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        studyTypeViewModel =
            ViewModelProvider(this).get(StudyTypeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_study_type, container, false)
        val textView: TextView = root.findViewById(R.id.text_study_type)

        studyTypeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        studytype_button.setOnClickListener {
            val intent = Intent(activity, StudyTypeActivity::class.java)
            startActivity(intent)
        }
    }
}