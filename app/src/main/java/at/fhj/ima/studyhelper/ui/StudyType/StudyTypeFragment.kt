package at.fhj.ima.studyhelper.ui.StudyType

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.activities.MainActivity
import at.fhj.ima.studyhelper.activities.StudyTypeActivity
import at.fhj.ima.studyhelper.activities.StudyTypeActivity.Companion.typeKey
import at.fhj.ima.studyhelper.activities.StudyTypeActivity.Companion.typeTextKey
import at.fhj.ima.studyhelper.data.StudyTypeRepository
import kotlinx.android.synthetic.main.fragment_study_type.*

class StudyTypeFragment : Fragment() {
    private val viewModel: StudyTypeViewModel by viewModels()

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


        val sharedPreferences = requireActivity().getSharedPreferences(requireActivity().packageName, Context.MODE_PRIVATE)
        val savedTypeText = sharedPreferences.getString(typeTextKey, null)

        if (savedTypeText != null) {
           viewModel.setText(savedTypeText.toString())
            studyTypeViewModel.text.observe(viewLifecycleOwner, Observer {
                textView.text = it
            })
        } else {
            studyTypeViewModel.text.observe(viewLifecycleOwner, Observer {
                textView.text = it
            })
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        studytype_button.setOnClickListener {
            val intent = Intent(activity, StudyTypeActivity::class.java)
            startActivity(intent)
        }

        val sharedPreferences = requireActivity().getSharedPreferences(requireActivity().packageName, Context.MODE_PRIVATE)
        val savedType = sharedPreferences.getString(typeKey, null)

        study_type_title.text = savedType
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

    }
    override fun onResume() {
        super.onResume()
            val sharedPreferences = requireActivity().getSharedPreferences(requireActivity().packageName, Context.MODE_PRIVATE)
            val savedType = sharedPreferences.getString(typeKey, null)

            study_type_title.text = savedType
    }
}