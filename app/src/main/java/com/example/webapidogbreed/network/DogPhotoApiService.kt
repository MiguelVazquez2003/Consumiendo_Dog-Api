package com.example.webapidogbreed.network
import com.example.webapidogbreed.network.DogPhoto
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
private const val BASE_URL="https://dog.ceo/api/"
//esto es comun definir variable moshi y retrofit para hacer llamadas para otros servidores o dentro
private val moshi=Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit=Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


//hace las llamadas al servicio web la clase ApiService

interface DogPhotoApiService{
    //ruta y el primer metodo GET http, es hacer una peticion a traves de una URL
    @GET("breeds/image/random")
    suspend fun getRandomPhoto():DogPhoto
}
//el objeto tambien lo trae cada apiservice
//en resumen necesitamos interface y objeto, ademas de las variables moshi y retrofit
object DogPhotoApi{
    //retrofit manda a llavar a la api
    //se le conoce como una sola instancia, "single..." esto puede variar en otros proyectos
    val retrofitService: DogPhotoApiService by lazy {
        retrofit.create((DogPhotoApiService::class.java))
    }
}



