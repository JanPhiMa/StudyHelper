package at.fhj.ima.studyhelper.data

import at.fhj.ima.studyhelper.API.bearerToken
import okhttp3.MultipartBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
interface UploadService {

    @Multipart
    @POST("upload")
    @Headers(
            "token: $bearerToken",
            "accept: application/vnd.lewdcat.json"
    )
    //Bearer key
    fun uploadPhoto(@Part multipart: MultipartBody.Part):Call<ResponseBody>
    }