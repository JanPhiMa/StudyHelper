package at.fhj.ima.studyhelper.ui.coursesCamera

import android.Manifest
import android.content.pm.ActivityInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.data.*
import at.fhj.ima.studyhelper.ui.home.HomeFragment
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.android.synthetic.main.fragment_camera.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Multipart
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class CameraFragment : Fragment() {

    private lateinit var outputDirectory: File
    private lateinit var navController: NavController
    private lateinit var cameraExecutor: ExecutorService
    private lateinit var albumsListViewModel: AlbumsListViewModel
    private lateinit var orientationEventListener: OrientationEventListener

    private var imageCapture: ImageCapture? = null
    private var selectedCamera = CameraSelector.DEFAULT_BACK_CAMERA

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        albumsListViewModel = ViewModelProvider(requireActivity()).get(AlbumsListViewModel::class.java)
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(root: View, savedInstanceState: Bundle?) {
        super.onViewCreated(root, savedInstanceState)

        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        if (allPermissionsGranted()) {
            startCamera(selectedCamera)
        } else {
            requestPermissions(REQUIRED_PERMISSIONS, REQUEST_CODE_PERMISSIONS)
        }

        outputDirectory = getOutputDirectory()

        camera_button.setOnClickListener { takePhoto() }

        orientationEventListener = object: OrientationEventListener(context) {
            override fun onOrientationChanged(orientation: Int) {
                // Monitors orientation values to determine the target rotation value
                val rotation: Int
                if (orientation in 45..134) {
                    rotation = Surface.ROTATION_270
                } else if (orientation in 135..224) {
                    rotation = Surface.ROTATION_180
                } else if (orientation in 225..314) {
                    rotation = Surface.ROTATION_90
                } else {
                    rotation = Surface.ROTATION_0
                }

                imageCapture?.targetRotation = rotation
            }
        }

        orientationEventListener.enable()

        cameraExecutor = Executors.newSingleThreadExecutor()
    }

    private fun takePhoto() {
        val imageCapture = imageCapture ?: return

        // Add timestamp to output file name
        val photoFile = File(
                outputDirectory,
                SimpleDateFormat(
                        FILENAME_FORMAT, Locale.US
                ).format(System.currentTimeMillis()) + ".jpg"
        )

        // Create output options object which contains file + metadata
        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

        // Set up image capture listener, which is triggered after photo has been taken
        imageCapture.takePicture(
                outputOptions,
                ContextCompat.getMainExecutor(requireContext()),
                object : ImageCapture.OnImageSavedCallback {
                    override fun onError(exc: ImageCaptureException) {
                        Log.e(TAG, "Photo capture failed: ${exc.message}", exc)
                    }

                    override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                        cameraExecutor.shutdown()

                        val body = RequestBody.create(MediaType.parse("image/jpg"), photoFile.absoluteFile)
                        val multipart = MultipartBody.Part.createFormData("files[]", photoFile.name, body)
                        //val multipart

                        CoroutineScope(Dispatchers.IO).launch {
                            /*val interceptor = TokenInterceptor();

                            val client = OkHttpClient.Builder()
                                    .addInterceptor(interceptor)
                                    .build()*/

                            val moshi = Moshi.Builder()
                                    .add(KotlinJsonAdapterFactory())
                                    .build()

                            val retrofit = Retrofit.Builder()
                                    //.client(client)
                                    .baseUrl("https://lewd.cat/api/")
                                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                                    .build()

                            val service = retrofit.create(UploadService::class.java)
                            service.uploadPhoto(multipart).enqueue(object : Callback<Picture> {
                                override fun onResponse(call: Call<Picture>, response: Response<Picture>) {
                                    val uploadedFile = response.body()!!.name
                                    service.getImages().enqueue(object : Callback<ImageResponse> {
                                        override fun onResponse(
                                            call: Call<ImageResponse>, response: Response<ImageResponse>
                                        ) {
                                            for (file in response.body()!!.files) {
                                                if (file.name == uploadedFile) {
                                                    for (album in albumsListViewModel.albumsListData.value!!) {
                                                        if (album.name == requireActivity().intent.getStringExtra(HomeFragment.EXTRA_COURSE_COURSE)) {
                                                            val paramObject = JSONObject()
                                                            paramObject.put("albumId", album.id)
                                                            paramObject.put("fileId", file.id)
                                                            val jsonbody = RequestBody.create(MediaType.parse("application/json"), paramObject.toString())
                                                            service.addPhotoToAlbum(jsonbody).enqueue(object : Callback<ResponseBody> {
                                                                override fun onResponse(
                                                                    call: Call<ResponseBody>,
                                                                    response: Response<ResponseBody>
                                                                ) {
                                                                    navController.navigateUp()
                                                                }

                                                                override fun onFailure(
                                                                    call: Call<ResponseBody>,
                                                                    t: Throwable
                                                                ) {
                                                                    Log.i("addPhotoToAlbum", "FAILED")
                                                                }

                                                            })
                                                        }
                                                    }
                                                }
                                            }
                                        }

                                        override fun onFailure(
                                            call: Call<ImageResponse>, t: Throwable
                                        ) {
                                            Log.i("getImages", t.toString())
                                        }

                                    })
                                }

                                override fun onFailure(call: Call<Picture>, t: Throwable) {
                                    Log.e("Request failed", service.toString())
                                }
                            })
                        }
                        Toast.makeText(requireContext(), "Image saved", Toast.LENGTH_SHORT).show()
                    }
                })
    }

    private fun allPermissionsGranted() = REQUIRED_PERMISSIONS.all {
        ContextCompat.checkSelfPermission(requireContext(), it) == PackageManager.PERMISSION_GRANTED
    }

    private fun getOutputDirectory(): File {
        @Suppress("Deprecation")
        val mediaDir = requireContext().externalMediaDirs.firstOrNull().let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }
        return if (mediaDir.exists())
            mediaDir else requireContext().filesDir
    }

    private fun startCamera(cameraSelector: CameraSelector) {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                    .build()
                    .also {
                        it.setSurfaceProvider(camera_viewfinder.surfaceProvider)
                    }

            val camera = cameraProvider.bindToLifecycle(this, cameraSelector, preview)

            imageCapture = ImageCapture.Builder().build()

            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()
                // Bind use cases to camera
                cameraProvider.bindToLifecycle(
                        viewLifecycleOwner,
                        cameraSelector,
                        preview,
                        imageCapture
                )
            } catch (exc: Exception) {
                Log.e(TAG, "Use case binding failed", exc)
            }

        }, ContextCompat.getMainExecutor(requireContext()))
    }

    override fun onRequestPermissionsResult(
            requestCode: Int, permissions: Array<String>, grantResults:
            IntArray
    ) {
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera(selectedCamera)
            } else {
                Toast.makeText(requireContext(), "Permission denied", Toast.LENGTH_SHORT).show()
                return
            }
        }
    }

    override fun onPause() {
        super.onPause()
        cameraExecutor.shutdown()
    }

    override fun onResume() {
        super.onResume()
        startCamera(selectedCamera)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        cameraExecutor.shutdown()
        orientationEventListener.disable()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_FULL_USER
    }

    companion object {
        private const val TAG = "CameraXBasic"
        private const val REQUEST_CODE_PERMISSIONS = 2
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        private val REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            navController.navigateUp()
        }
        return super.onOptionsItemSelected(item)
    }
}