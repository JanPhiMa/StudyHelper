package at.fhj.ima.studyhelper.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Picture (
    val message: String,
    val name: String,
    val hash: String,
    val size: Int,
    val url: String,
    val thumb: String,
    val deleteUrl: String
)