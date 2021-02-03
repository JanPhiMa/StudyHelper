package at.fhj.ima.studyhelper.data

import android.database.Observable
import android.net.Uri
import android.service.voice.AlwaysOnHotwordDetector
import androidx.room.Delete
import at.fhj.ima.studyhelper.API.bearerToken
import at.fhj.ima.studyhelper.API.longToken
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import java.io.File
import java.io.FileWriter

interface UploadService {

    // Upload a picture
    @Multipart
    @POST("upload")
    @Headers(
            "token: $bearerToken",
            "accept: application/vnd.lewdcat.json"
    )
    fun uploadPhoto(@Part multipart: MultipartBody.Part):Call<Picture>

    // Create an album
    @POST("album/new")
    @Headers(
        "authorization: $longToken",
        "accept: application/vnd.lewdcat.json"
    )
    fun createAlbum(@Body albumPayload: Map<String,String?>):Call<ResponseBody>

    @POST("file/album/add")
    @Headers(
        "authorization: $longToken",
        "content-type: application/json",
        "accept: application/vnd.lewdcat.json"
    )
    fun addPhotoToAlbum(@Body albumSwitchPayload: RequestBody):Call<ResponseBody>

    @GET("albums/mini")
    @Headers(
        "authorization: $longToken",
        "accept: application/vnd.lewdcat.json"
    )
    fun getAlbums(): Call<ResponseData>

    @GET("files")
    @Headers(
        "authorization: $longToken",
        "accept: application/vnd.lewdcat.json"
    )
    fun getImages(): Call<ImageResponse>

    @GET("album/{id}/full")
    @Headers(
        "authorization: $longToken",
        "accept: application/vnd.lewdcat.json"
    )
    fun getAlbumImages(@Path("id") id: String): Call<AlbumIdList>

    @DELETE("file/{id}")
    @Headers(
        "authorization: $longToken",
        "accept: application/vnd.lewdcat.json"
    )
    fun deleteImage(@Path("id") id: String): Call<ResponseBody>
}