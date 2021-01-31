package at.fhj.ima.studyhelper.classes

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey



class StudyProgram ( val StudyProgram: String,val Courses: List<Courses>, val Semesters: Int, val Type: String, val Department: String)  {

}

