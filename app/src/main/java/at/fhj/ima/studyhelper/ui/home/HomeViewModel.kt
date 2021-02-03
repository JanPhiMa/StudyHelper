package at.fhj.ima.studyhelper.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Here are your relevant courses"
    }

    val text: LiveData<String> = _text
}