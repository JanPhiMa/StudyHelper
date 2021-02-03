package at.fhj.ima.studyhelper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.classes.Courses
import kotlinx.android.synthetic.main.item_courses.view.*

class CoursesAdapter(val clickListener: (courses: Courses) -> Unit): RecyclerView.Adapter<CoursesViewHolder>(){
    var coursesList = mutableListOf<Courses>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val coursesItemView = inflater.inflate(R.layout.item_courses, parent, false)
        return CoursesViewHolder(coursesItemView, clickListener)
    }

    override fun getItemCount(): Int {
        return coursesList.size
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
        holder.bindItem(coursesList[position])

    }

    fun updateList (newList: MutableList<Courses>) {
        coursesList = newList
        notifyDataSetChanged()

    }

    fun updateListFilteredForSemester (newList: MutableList<Courses>, programSearch: String, semesterSearch: String? = "1") {
        for (course in newList){
            if (course.Program == programSearch && course.Semester.toString() == semesterSearch) {
                coursesList.add(course)
                coursesList
            }
        }
        notifyDataSetChanged()
    }

}




class CoursesViewHolder(itemView: View, val clickListener: (courses: Courses) -> Unit): RecyclerView.ViewHolder(itemView) {
    fun bindItem(courses: Courses) {
        itemView.item_courses_course.text = courses.Course
        itemView.item_courses_lecturer.text = courses.Lecturer
        itemView.item_courses_semesters.text = courses.Semester.toString()
        itemView.item_courses_ects.text = courses.ECTS.toString()
        itemView.item_courses_sws.text = courses.SWS.toString()
        itemView.setOnClickListener {
            clickListener(courses)
        }

    }
}