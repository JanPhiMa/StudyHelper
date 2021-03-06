package at.fhj.ima.studyhelper.ui.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import at.fhj.ima.studyhelper.activities.LandingActivity.Companion.usernameKey
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.activities.CoursesSingleActivity
import at.fhj.ima.studyhelper.activities.LandingActivity
import at.fhj.ima.studyhelper.activities.StudyProgramActivity
import at.fhj.ima.studyhelper.adapters.CoursesAdapter
import at.fhj.ima.studyhelper.data.CoursesRepository
import at.fhj.ima.studyhelper.data.UserRepository
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {


   companion object {
       val EXTRA_COURSE_COURSE = "COURSE_COURSE_EXTRA"
       val EXTRA_COURSE_LECTURER = "LECTURER_COURSE_EXTRA"
       val EXTRA_COURSE_SEMESTER = "SEMESTER_COURSE_EXTRA"
       val EXTRA_COURSE_ECTS = "ECTS_COURSE_EXTRA"
       val EXTRA_COURSE_SWS = "SWS_COURSE_EXTRA"
   }


    private lateinit var homeViewModel: HomeViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireActivity().getSharedPreferences(requireActivity().packageName, Context.MODE_PRIVATE)

    val coursesAdapter = CoursesAdapter(){
        val intent = Intent(activity, CoursesSingleActivity::class.java)
        intent.putExtra(EXTRA_COURSE_COURSE, it.Course)
        intent.putExtra(EXTRA_COURSE_LECTURER, it.Lecturer)
        intent.putExtra(EXTRA_COURSE_SEMESTER, it.Semester.toString())
        intent.putExtra(EXTRA_COURSE_ECTS, it.ECTS.toString())
        intent.putExtra(EXTRA_COURSE_SWS, it.SWS.toString())
        startActivity(intent)
    }
        val programName = UserRepository.findUser(requireActivity().applicationContext, sharedPreferences.getString(usernameKey, null).toString())?.studyProgram
        val coursesSemester = UserRepository.findUser(requireActivity().applicationContext, sharedPreferences.getString(usernameKey, null).toString())?.semester



        when {
            programName != null && coursesSemester != null -> coursesAdapter.updateListFilteredForSemester(CoursesRepository.coursesList(), programName, coursesSemester)
            else -> coursesAdapter.updateList(CoursesRepository.coursesList())
        }
        fragment_home_recyclerview.layoutManager = LinearLayoutManager(activity)
        fragment_home_recyclerview.adapter = coursesAdapter

    }
    }
