package at.fhj.ima.studyhelper.data

data class ResponseData(
    val message: String,
    val albums: List<AlbumList>
)

data class AlbumList(
    val id: Int,
    val name: String,
    val nsfw: Boolean,
    val createdAt: String,
    val editedAt: String,
    val fileCount: Int,
    val files: List<AlbumContent>
)

data class AlbumContent(
    val id: Int,
    val name: String,
    val url: String,
    val thumb: String,
    val thumbSquare: String
)

data class AlbumIdList(
    val message: String,
    val name: String,
    val files: List<AlbumIdContent>
)

data class AlbumIdContent(
    val id: Int,
    val name: String,
    val createdAt: String,
    val url: String,
    val thumb: String,
    val thumbSquare: String
)