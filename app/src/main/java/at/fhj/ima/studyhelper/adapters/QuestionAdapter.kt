package at.fhj.ima.studyhelper.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.classes.Questions
import kotlinx.android.synthetic.main.item_study_question.view.*

class QuestionAdapter: RecyclerView.Adapter<QuestionViewholder>() {

    private var questionList = listOf<Questions>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val questionItemView = inflater.inflate(R.layout.item_study_question, parent, false)
        return QuestionViewholder(questionItemView)
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    override fun onBindViewHolder(holder: QuestionViewholder, position: Int) {
        holder.bindItem(questionList[position])
    }
    fun updateList(newList: List<Questions>) {
        questionList = newList
        notifyDataSetChanged()
    }
}

class QuestionViewholder(itemView: View):RecyclerView.ViewHolder(itemView) {
    fun bindItem(question: Questions) {
        itemView.item_study_question.text = question.question
        itemView.item_study_visual.text = question.visual
        itemView.item_study_auditory.text = question.auditory
        itemView.item_study_tactile.text = question.tactile
    }
}