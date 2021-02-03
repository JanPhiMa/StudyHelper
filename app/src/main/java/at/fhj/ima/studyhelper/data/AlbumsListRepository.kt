package at.fhj.ima.studyhelper.data

import android.app.Application
import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import at.fhj.ima.studyhelper.ui.coursesCamera.CameraFragment
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class AlbumsListRepository(val app: Application) {
    val albumsListData = MutableLiveData<List<AlbumList>>()

    init {
        CoroutineScope(Dispatchers.IO).launch {
            getData()
        }
    }

    @WorkerThread
    private fun getData() {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://kyot.me/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        val service = retrofit.create(UploadService::class.java)
        val serviceData = service.getAlbums() //.body()?.data

        serviceData.enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>, response: Response<ResponseData>) {
                albumsListData.postValue(response.body()?.albums)
            }

            override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                Log.i("ALBUMS", "Failed to get albums")
            }

        })
    }
}