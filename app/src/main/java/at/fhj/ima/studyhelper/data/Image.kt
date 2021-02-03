package at.fhj.ima.studyhelper.data

data class ImageResponse(
    val message: String,
    val files: List<Image>
)

data class Image(
    val id: Int,
    val userId: Int,
    val name: String,
    val original: String,
    val type: String,
    val size: Int,
    val hash: String,
    val ip: String,
    val createdAt: String,
    val editedAt: String,
    val url: String,
    val thumb: String,
    val thumbSquare: String
)
