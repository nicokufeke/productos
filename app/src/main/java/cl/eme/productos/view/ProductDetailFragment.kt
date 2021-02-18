package cl.eme.productos.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.eme.productos.databinding.FragmentDetailProductBinding
import coil.load

class ProductDetailFragment: Fragment() {
    private lateinit var binding : FragmentDetailProductBinding
    private val viewModel: ProductsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= FragmentDetailProductBinding.inflate(layoutInflater)
        viewModel.selectedItem().observe(viewLifecycleOwner, {
        binding.ivDetail.load(it.image)
        binding.tvNameDetail.text = it.name
        binding.tvPriceDetail2.text = it.price
        binding.tvDescriptionDetail2.text = it.description.toString()
        binding.tvLastPriceDetail.text = it.lastPrice
        binding.tvCreditDetail.text = it.credit
        })

        return binding.root
    }
}