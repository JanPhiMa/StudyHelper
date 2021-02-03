package at.fhj.ima.studyhelper.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class AlbumsListViewModel(app: Application) : AndroidViewModel(app) {
    val albumsListData = AlbumsListRepository(app).albumsListData
    val selectedImage = MutableLiveData<String>()
}