package cl.eme.productos.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cl.eme.productos.model.ProductDetail
import cl.eme.productos.model.Products
import cl.eme.productos.model.Repository
import kotlinx.coroutines.launch
import timber.log.Timber

class ProductsViewModel: ViewModel() {

    private val repository = Repository()
    private val selected = repository.getProduct
    fun selected(): LiveData<List<Products>> = selected

    //private val getProductDetail= repository.getProductDetail

    init {
        Timber.d("Get Products")
        viewModelScope.launch {
            repository.getProduct()
        }
    }
    private val mutableLiveData = MutableLiveData<ProductDetail>()
    fun selectedItem():LiveData<ProductDetail> = mutableLiveData
    fun selectedItem(productDetail:ProductDetail) {
        mutableLiveData.value = productDetail
    }

}
