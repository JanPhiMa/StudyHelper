package at.fhj.ima.studyhelper.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.classes.Questions
import at.fhj.ima.studyhelper.data.QuestionAnswerWrapper
import kotlinx.android.synthetic.main.item_study_question.view.*

class QuestionAdapter: RecyclerView.Adapter<QuestionViewholder>() {

    private var questionList = listOf<QuestionAnswerWrapper>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewholder {
        val inflater = LayoutInflater.from(parent.context)
        val questionItemView = inflater.inflate(R.layout.item_study_question, parent, false)
        return QuestionViewholder(questionItemView)
    }

    override fun getItemCount(): Int {
        return questionList.size
    }

    fun getQuestionList() = questionList

    override fun onBindViewHolder(holder: QuestionViewholder, position: Int) {
        holder.bindItem(questionList[position])
        holder.setIsRecyclable(false);
    }
    fun updateList(newList: List<QuestionAnswerWrapper>) {
        questionList = newList
        notifyDataSetChanged()
    }
}

class QuestionViewholder(itemView: View):RecyclerView.ViewHolder(itemView) {
    fun bindItem(question: QuestionAnswerWrapper) {

        itemView.item_study_question.text = question.question.question
        itemView.item_study_visual.text = question.question.visual
        itemView.item_study_auditory.text = question.question.auditory
        itemView.item_study_tactile.text = question.question.tactile

        itemView.item_study_selection.clearCheck()

        when(question.selectedType) {
            1 -> itemView.item_study_visual.isChecked = true
            2 -> itemView.item_study_auditory.isChecked = true
            3 -> itemView.item_study_tactile.isChecked = true
        }

        itemView.item_study_selection.setOnCheckedChangeListener { group, checkedId ->
            Log.e("CHECKED", checkedId.toString())
            when(checkedId) {
                itemView.item_study_visual.id -> question.selectedType = 1
                itemView.item_study_auditory.id -> question.selectedType = 2
                itemView.item_study_tactile.id -> question.selectedType = 3
            }
        }
    }
}