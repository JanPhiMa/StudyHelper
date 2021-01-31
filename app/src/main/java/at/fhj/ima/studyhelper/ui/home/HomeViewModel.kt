package at.fhj.ima.studyhelper.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Here are your relevant courses"
    }
    private val _text2 = MutableLiveData<String>().apply {
        value = "Should you not see any, you might have forgotten to enter your semester"
    }
    val text: LiveData<String> = _text
    val text2: LiveData<String> = _text2
}