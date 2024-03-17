package com.adityarawat.inovantsolutiontask.Service

import com.adityarawat.inovantsolutiontask.Model.AnesthesiaProduct
import retrofit2.Response
import retrofit2.http.GET

interface Service {
//baseURL https://klinq.com/rest/V1/
    @GET("productdetails/6701/253620?lang=en&store=KWD")
    suspend fun getDetails() : Response<AnesthesiaProduct>
}