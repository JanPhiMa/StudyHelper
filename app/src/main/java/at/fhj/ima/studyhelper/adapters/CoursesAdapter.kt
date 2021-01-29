package at.fhj.ima.studyhelper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.classes.Courses
import at.fhj.ima.studyhelper.classes.StudyProgram
import kotlinx.android.synthetic.main.item_courses.view.*

class CoursesAdapter: RecyclerView.Adapter<CoursesViewHolder>(){
    var coursesList = mutableListOf<Courses>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val coursesItemView = inflater.inflate(R.layout.item_courses, parent, false)
        return CoursesViewHolder(coursesItemView)
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

    //Filterung funktioniert nicht
    fun updateListFiltered (newList: MutableList<Courses>, programSearch: String?) {
        val coursesListIterator = coursesList.iterator()
        var position: Int = 0
        while (coursesListIterator.hasNext()) {
            if (coursesList[position].Program == programSearch) {
                newList += (coursesList[position])
            }
            position ++
        }
        coursesList = newList
        notifyDataSetChanged()
    }
}

class CoursesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    fun bindItem(courses: Courses) {
        itemView.item_courses_course.text = courses.Course
        itemView.item_courses_lecturer.text = courses.Lecturer
        itemView.item_courses_semesters.text = courses.Semester.toString()
        itemView.item_courses_ects.text = courses.ECTS.toString()
        itemView.item_courses_sws.text = courses.SWS.toString()

    }
}