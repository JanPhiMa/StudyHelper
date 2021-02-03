package at.fhj.ima.studyhelper.ui.coursesCamera

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.data.*
import at.fhj.ima.studyhelper.ui.home.HomeFragment
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.fragment_courses_single.*
import kotlinx.coroutines.*
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class CoursesSingleActivityFragment : Fragment(), ImageRecyclerAdapter.ImageItemListener {
    companion object{
        private const val notesKey = "NOTES"
        private const val TAG = "CSAF"
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var navController: NavController
    private lateinit var albumsListViewModel: AlbumsListViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_courses_single, container, false)
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)

        recyclerView = view.findViewById(R.id.image_recycler_view)
        recyclerView.layoutManager = GridLayoutManager(requireContext(),3)
        recyclerView.adapter = ImageRecyclerAdapter(emptyList(), emptyList(), this)

        albumsListViewModel = ViewModelProvider(requireActivity()).get(AlbumsListViewModel::class.java)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = requireActivity().getSharedPreferences(requireActivity().packageName, Context.MODE_PRIVATE)

        activity_courses_single_button_notes.setOnClickListener {
            sharedPreferences.edit().putString(notesKey, activity_courses_single_notesection.text.toString()).apply()
            Toast.makeText(requireActivity().applicationContext, "Notes saved!", Toast.LENGTH_SHORT).show()
        }

        val courseName = requireActivity().intent.getStringExtra(HomeFragment.EXTRA_COURSE_COURSE)

        activity_courses_single_course.text = courseName
        activity_courses_single_semester.text = ("Semester of relevance: " + requireActivity().intent.getStringExtra(HomeFragment.EXTRA_COURSE_SEMESTER))
        activity_courses_single_lecturer.text = ("Course Lecturer(s): " + requireActivity().intent.getStringExtra(HomeFragment.EXTRA_COURSE_LECTURER))
        activity_courses_single_ects.text = ("Course ECTS Credits: " + requireActivity().intent.getStringExtra(HomeFragment.EXTRA_COURSE_ECTS))
        activity_courses_single_sws.text = ("Weekly hours: " + requireActivity().intent.getStringExtra(HomeFragment.EXTRA_COURSE_SWS))
        activity_courses_single_notesection.setText(sharedPreferences.getString(notesKey, null))
        view.findViewById<Button>(R.id.activity_courses_single_button).setOnClickListener {
            navController.navigate(R.id.action_main_to_camera)
        }
        val albumPayload = mapOf("name" to courseName)
        Log.i("abcd","$albumPayload")
        CoroutineScope(Dispatchers.IO).launch {

            val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

            val retrofit = Retrofit.Builder()
                .baseUrl("https://lewd.cat/api/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .build()

            val service = retrofit.create(UploadService::class.java)
            service.createAlbum(albumPayload).enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    Log.i(TAG, response.toString())
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.e("Request failed", service.toString())
                }
            })
        }

        albumsListViewModel.albumsListData.observe(viewLifecycleOwner, {
            Log.i("Data", it.toString())
            val imageList: MutableList<String> = mutableListOf()
            val idList: MutableList<String> = mutableListOf()
            runBlocking {
                val job: Job = launch(context = Dispatchers.IO) {
                    val moshi = Moshi.Builder()
                        .add(KotlinJsonAdapterFactory())
                        .build()
                    val retrofit = Retrofit.Builder()
                        .baseUrl("https://kyot.me/api/")
                        .addConverterFactory(MoshiConverterFactory.create(moshi))
                        .build()
                    val service = retrofit.create(UploadService::class.java)

                    for (album in albumsListViewModel.albumsListData.value!!) {
                        if (album.name == courseName) {
                            val serviceData = service.getAlbumImages(album.id.toString())
                            serviceData.enqueue(object : Callback<AlbumIdList> {
                                override fun onResponse(call: Call<AlbumIdList>, response: Response<AlbumIdList>) {
                                    for (image in response.body()!!.files) {
                                        imageList.add(image.url)
                                        idList.add(image.id.toString())
                                    }
                                    recyclerView.adapter = ImageRecyclerAdapter(imageList, idList, this@CoursesSingleActivityFragment)
                                }

                                override fun onFailure(call: Call<AlbumIdList>, t: Throwable) {
                                    Log.i("ALBUMS", "Failed to get albums")
                                }
                            })
                        }
                    }
                }
            }
        })

    }

    override fun onImageItemClick(image: String) {
        albumsListViewModel.selectedImage.value = image
        navController.navigate(R.id.action_course_to_image)
    }

    override fun onImageItemLongClick(id: String, images: List<String>, ids: List<String>) {
        AlertDialog.Builder(requireContext())
            .setTitle("Delete image?")
            .setMessage("You cannot undo this.")
            .setPositiveButton("DELETE") { _, _ ->
                runBlocking {
                    val job: Job = launch(context = Dispatchers.IO) {
                        val moshi = Moshi.Builder()
                            .add(KotlinJsonAdapterFactory())
                            .build()
                        val retrofit = Retrofit.Builder()
                            .baseUrl("https://kyot.me/api/")
                            .addConverterFactory(MoshiConverterFactory.create(moshi))
                            .build()
                        val service = retrofit.create(UploadService::class.java)

                        val serviceData = service.deleteImage(id)
                        serviceData.enqueue(object : Callback<ResponseBody> {
                            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                                Log.i("DELETED", "SUCCESS")
                            }

                            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                                Log.i("ALBUMS", "Failed to get albums")
                            }

                        })
                    }
                    job.join()

                    val imagesList: MutableList<String> = mutableListOf()
                    val idsList: MutableList<String> = mutableListOf()
                    for ((index, image) in images.withIndex()) {
                        if (ids[index] != id) {
                            imagesList.add(image)
                            idsList.add(ids[index])
                        }
                    }
                    recyclerView.adapter = ImageRecyclerAdapter(imagesList, idsList, this@CoursesSingleActivityFragment)
                }
            }
            .setNegativeButton("CANCEL") { _, _ -> }
            .create()
            .show()
    }
}