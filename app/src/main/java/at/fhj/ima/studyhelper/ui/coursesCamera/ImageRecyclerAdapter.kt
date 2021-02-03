package at.fhj.ima.studyhelper.ui.coursesCamera

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import at.fhj.ima.studyhelper.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop

class ImageRecyclerAdapter(
    private val images: List<String>,
    private val ids: List<String>,
    private val itemListener: ImageItemListener
)
    : RecyclerView.Adapter<ImageRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.image_list_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        val id = ids[position]
        Glide.with(holder.itemView.context)
            .load(image)
            .transform(CenterCrop())
            .into(holder.image)

        holder.itemView.setOnClickListener {
            itemListener.onImageItemClick(image)
        }
        holder.itemView.setOnLongClickListener {
            itemListener.onImageItemLongClick(id, images, ids)
            true
        }
    }

    override fun getItemCount() = images.size

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image)
    }

    interface ImageItemListener {
        fun onImageItemClick(image: String)
        fun onImageItemLongClick(id: String, images: List<String>, ids: List<String>)
    }
}