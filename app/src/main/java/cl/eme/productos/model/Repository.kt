package cl.eme.productos.model

import androidx.lifecycle.LiveData
import timber.log.Timber

class Repository {
    private val productsDao = ProductsApplication.productsDatabase!!.productsDao()
    val getProductDetail = productsDao.getProductDetail(1)


    suspend fun getProduct() {
        Timber.d("getProducts from API")
        val response = RetrofitClient.instance().getProduct()

        when (response.isSuccessful) {
            true -> {
                response.body()?.let {
                productsDao.insert(it)
                }

            }
            false -> Timber.e("${response.code()} - ${response.errorBody()}")
        }

    }
}



