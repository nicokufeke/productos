package cl.eme.productos.model

import timber.log.Timber

class Repository {
    private val productsDatabase = ProductsApplication.productsDatabase!!
    val product= productsDatabase.productsDao().getProduct()
}
suspend fun getProducts() {
    val response = RetrofitClient.instance().getProduct()
    if (response.isSuccessful) {
        response.body()?.let {
            productsDatabase.productsDao().insert(it)
        } }
    else {
        Timber.d("${response.errorBody()}")
}

}



