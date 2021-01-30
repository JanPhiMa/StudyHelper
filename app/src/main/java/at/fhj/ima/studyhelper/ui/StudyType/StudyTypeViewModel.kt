package at.fhj.ima.studyhelper.ui.StudyType

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StudyTypeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Find out what Study Type you are."
    }
    val text: LiveData<String> = _text

    fun setText(string:String){
        _text.value = string
    }
}