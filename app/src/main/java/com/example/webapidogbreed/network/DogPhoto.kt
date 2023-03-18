package com.example.webapidogbreed.network

import com.squareup.moshi.Json

data class DogPhoto (
    //la data class lo que hace es fungir como DTO, objetos que almacenan la informacion que le digamos,
    //que proviene de un servicio web.
    @Json(name="message") val imageUrl: String?=null,
    @Json(name="status") val statusResponse:String? = null

)
