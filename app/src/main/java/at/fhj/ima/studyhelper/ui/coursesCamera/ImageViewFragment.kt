package at.fhj.ima.studyhelper.ui.coursesCamera

import android.app.AlertDialog
import android.content.res.Configuration
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.exifinterface.media.ExifInterface
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.preference.PreferenceManager
import at.fhj.ima.studyhelper.R
import at.fhj.ima.studyhelper.activities.CoursesSingleActivity
import at.fhj.ima.studyhelper.data.AlbumsListViewModel
import com.bumptech.glide.Glide

class ImageViewFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var albumsListViewModel: AlbumsListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_image_view, container, false)

        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        albumsListViewModel = ViewModelProvider(requireActivity()).get(AlbumsListViewModel::class.java)

        val image = root.findViewById<ImageView>(R.id.image)

        Glide.with(this)
            .load(albumsListViewModel.selectedImage.value)
            .into(image)

        return root
    }
}