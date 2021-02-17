package cl.eme.productos.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.eme.productos.databinding.ItemListProductBinding
import cl.eme.productos.model.Products

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductVH>() {

    class ProductVH (val binding: ItemListProductBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(product: Products) {

    }

    }

    private var productList = listOf<Products>()
    private val selectedItem = MutableLiveData<Products>()

    fun selectedItem(): LiveData<Products> = selectedItem
    fun update(getProducts: List<Products>) {
        productList= getProducts
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {
    val binding = ItemListProductBinding.inflate(LayoutInflater.from(parent.context))
        return ProductVH(binding)
    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {
    val product = productList[position]
        holder.bind(product)
    }

    override fun getItemCount(): Int {
    return productList.size
    }
}
