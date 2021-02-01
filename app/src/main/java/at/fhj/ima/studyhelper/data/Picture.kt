package at.fhj.ima.studyhelper.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Picture (
    val message:String,
    val url:String,
    val name: String,
    val hash:String,
    val deleteUrl:String,
    val size:Int,
    val thumb:String
)