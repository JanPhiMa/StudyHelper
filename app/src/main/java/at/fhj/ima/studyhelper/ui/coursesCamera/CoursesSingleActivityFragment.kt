package at.fhj.ima.studyhelper.ui.coursesCamera

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.ui.home.HomeFragment
import kotlinx.android.synthetic.main.fragment_courses_single.*


class CoursesSingleActivityFragment : Fragment() {

    private lateinit var navController: NavController

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        return inflater.inflate(R.layout.fragment_courses_single, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity_courses_single_course.text = requireActivity().intent.getStringExtra(HomeFragment.EXTRA_COURSE_COURSE)
        activity_courses_single_semester.text = ("Semester of relevance: " + requireActivity().intent.getStringExtra(HomeFragment.EXTRA_COURSE_SEMESTER))
        activity_courses_single_lecturer.text = ("Course Lecturer(s): " + requireActivity().intent.getStringExtra(HomeFragment.EXTRA_COURSE_LECTURER))
        activity_courses_single_ects.text = ("Course ECTS Credits: " + requireActivity().intent.getStringExtra(HomeFragment.EXTRA_COURSE_ECTS))
        activity_courses_single_sws.text = ("Weekly hours: " + requireActivity().intent.getStringExtra(HomeFragment.EXTRA_COURSE_SWS))

        view.findViewById<Button>(R.id.activity_courses_single_button).setOnClickListener {
            navController.navigate(R.id.action_main_to_camera)
        }
    }
}