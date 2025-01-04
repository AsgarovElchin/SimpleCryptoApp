package asgarov.elchin.simplecryptoapp.data.remote



import asgarov.elchin.simplecrpytoapp.BuildConfig
import asgarov.elchin.simplecryptoapp.data.remote.dto.CryptoDto
import asgarov.elchin.simplecryptoapp.util.Constants
import retrofit2.http.GET
import retrofit2.http.Header

interface CryptoAPI {
    @GET("/economy/cripto")
    suspend fun getCrypto(
        @Header("content-type") type:String = Constants.CONTENT_TYPE,
       @Header("authorization") auth:String = BuildConfig.API_KEY

    ):CryptoDto
}