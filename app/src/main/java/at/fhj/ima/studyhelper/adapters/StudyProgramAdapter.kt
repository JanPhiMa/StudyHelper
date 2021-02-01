package at.fhj.ima.studyhelper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.activities.StudyProgramActivity
import at.fhj.ima.studyhelper.classes.Courses
import at.fhj.ima.studyhelper.classes.StudyProgram
import kotlinx.android.synthetic.main.item_studyprogram.view.*

class StudyProgramAdapter(val clickListener: (studyProgram: StudyProgram) -> Unit): RecyclerView.Adapter<StudyProgramViewHolder>() {

    var studyProgramList = listOf<StudyProgram>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudyProgramViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val studyProgramItemView = inflater.inflate(R.layout.item_studyprogram, parent, false)
        return StudyProgramViewHolder(studyProgramItemView, clickListener)
    }

    override fun getItemCount(): Int {
        return studyProgramList.size
    }

    override fun onBindViewHolder(holder: StudyProgramViewHolder, position: Int) {
        holder.bindItem(studyProgramList[position])
    }

    fun updateList (newList: List<StudyProgram>){
        studyProgramList = newList
        notifyDataSetChanged()
    }




}

class StudyProgramViewHolder(itemView: View, val clickListener: (studyProgram: StudyProgram) -> Unit): RecyclerView.ViewHolder(itemView) {
    fun bindItem(studyProgram: StudyProgram) {
        itemView.item_studyprogram_studyprogram.text = studyProgram.StudyProgram
        itemView.item_studyprogram_department.text = studyProgram.Department
        itemView.item_studyprogram_semesters.text = studyProgram.Semesters.toString()
        itemView.item_studyprogram_type.text = studyProgram.Type
        itemView.item_studyprogram_header.text = studyProgram.StudyProgram
        itemView.setOnClickListener {
            clickListener(studyProgram)
        }
    }
}