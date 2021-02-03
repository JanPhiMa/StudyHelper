package at.fhj.ima.studyhelper.ui.coursesCamera

import android.content.Context
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView
import at.fhj.ima.studyhelper.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import java.io.File

class ImageRecyclerAdapter(private val context: Context, private val images: List<String>, private val itemListener:
ImageItemListener): RecyclerView.Adapter<ImageRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.image_list_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        with(holder) {
            Glide.with(holder.itemView.context)
                .load(image)
                .transform(CenterCrop())
                .into(holder.image)

            holder.itemView.setOnClickListener {
                itemListener.onImageItemClick(image)
            }
        }
    }

    override fun getItemCount() = images.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
    }

    interface ImageItemListener {
        fun onImageItemClick(image: String)
    }
}