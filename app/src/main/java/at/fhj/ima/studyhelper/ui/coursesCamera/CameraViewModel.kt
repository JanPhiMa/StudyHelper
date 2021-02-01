package at.fhj.ima.studyhelper.ui.coursesCamera

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.io.File

class CameraViewModel: ViewModel() {
    var imageSrc = MutableLiveData<File>()
}