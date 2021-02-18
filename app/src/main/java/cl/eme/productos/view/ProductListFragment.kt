package cl.eme.productos.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.eme.productos.databinding.FragmentListingProductBinding
import timber.log.Timber

class ProductListFragment: Fragment() {

    private lateinit var binding : FragmentListingProductBinding
    private val viewModel : ProductsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val adapter = ProductAdapter()
        binding = FragmentListingProductBinding.inflate(layoutInflater)
        binding.rvProduct.layoutManager = LinearLayoutManager(context)
        binding.rvProduct.adapter = adapter

        viewModel.selected().observe(viewLifecycleOwner, {
            Timber.d("Detalle de Producto")
            it?.let {
                Timber.d("Tamaño de la Lista de Productos ${it.size}")
                adapter.update(it)
            }
        })
        adapter.selectedItem().observe(viewLifecycleOwner, {
            viewModel.selectedItem()
        })
        return binding.root
    }
}