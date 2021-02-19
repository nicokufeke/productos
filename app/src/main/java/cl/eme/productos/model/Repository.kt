package cl.eme.productos.model

import androidx.lifecycle.LiveData
import timber.log.Timber

class Repository {
    private val productsDao = ProductsApplication.productsDatabase!!.productsDao()
    val getProduct = productsDao.getProduct()
    val getProductDetail = productsDao.getProductDetail()

    suspend fun getProduct() {
        Timber.d("getProducts from API")
        val response = RetrofitClient.instance().getProduct()

        when (response.isSuccessful) {
            true -> {
                response.body()?.let {
                    productsDao.insertProduct(it)
                }

            }
            false -> Timber.e("${response.code()} - ${response.errorBody()}")
        }
        fun getProductId(code: Int): LiveData<Products> {
            return productsDao.getProductId(code)
        }

        suspend fun getProductDetail(code : Int) {
            Timber.d("getProductsDetails from API")
            val responseDetail = RetrofitClient.instance().getProductDetail(code)

            when (responseDetail.isSuccessful) {
                true -> {
                    responseDetail.body()?.let {
                        productsDao.insertProductDetail(it)
                    }

                }
                false -> Timber.e("${responseDetail.code()} - ${responseDetail.errorBody()}")
            }
            fun getProductDetail(code: Int): LiveData<ProductDetail> {
                return productsDao.getProductDetailId(code)
            }
        }
    }
}



