package at.fhj.ima.studyhelper.data

import android.database.Observable
import android.net.Uri
import at.fhj.ima.studyhelper.API.bearerToken
import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*
import java.io.File
import java.io.FileWriter

interface UploadService {

    /*@Multipart
    @POST("api/upload")
    @Headers("authorization: ${UserPictureApi.accessToken}","accept: application/vnd.lewdcat.json")
    fun uploadPhoto(
        @Part ("form-data") file: File
    ):Picture*/

    /*@GET("/api/files")
    @Headers("authorization: ${UserPictureApi.accessToken}","accept: application/vnd.kyotme.json")
    fun getPhoto(id:Int)*/

    /*@Multipart
    @POST("api/upload")
    @Headers("Authorization: Bearer ${UserPictureApi.accessToken}","accept: application/vnd.lewdcat.json")
    fun uploadPhoto(@Part multipart: MultipartBody.Part):Call<ResponseBody>*/

    @Multipart
    @POST("upload")
    @Headers(
            "token: $bearerToken",
            "accept: application/vnd.lewdcat.json"
    )
    //Bearer key
    fun uploadPhoto(@Part multipart: MultipartBody.Part):Call<ResponseBody>

    /*ultipart
    @POST("upload")
    Call<ResponseBody> upload(
    @Part("description") RequestBody description,
    @Part MultipartBody.Part file
    )*/
    }