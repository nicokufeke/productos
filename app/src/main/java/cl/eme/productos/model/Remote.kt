package cl.eme.productos.model

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ProductAPI {

    @GET("products/")
    suspend fun getProduct() : Response<List<Products>>

    @GET("details/1")
    suspend fun getProductDetail() : Response<ProductDetail>

}

// Cliente Retrofit

const val BASE_URL = "https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"

class RetrofitClient {
    companion object {

        fun instance() : ProductAPI{
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()).build()

            return retrofit.create(ProductAPI::class.java)

        }
    }

}
