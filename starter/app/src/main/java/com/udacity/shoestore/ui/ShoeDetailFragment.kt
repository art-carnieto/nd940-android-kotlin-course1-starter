package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    // from https://developer.android.com/topic/libraries/view-binding#fragments
    private lateinit var _binding: FragmentShoeDetailBinding
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding

    private lateinit var shoeListviewModel : ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")
        _binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        shoeListviewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.viewModel = shoeListviewModel
        binding.lifecycleOwner = this

        //test
        //openShoe(1)
        val args = ShoeDetailFragmentArgs.fromBundle(requireArguments())
        Timber.d("args = ${args.shoeName}")

        return view
    }

    fun openShoe (index: Int) {
        val shoe = shoeListviewModel.getShoe(index)
        if(shoe == null) Timber.e("Trying to open invalid shoe index $index!")
        else {
            // binding.shoeImage = shoe.images.get(0) TODO: fix image loading!
            binding.shoeNameEdit.setText(shoe.name)
            binding.companyEdit.setText(shoe.company)
            binding.shoeSizeEdit.setText(shoe.size.toString())
            binding.descriptionEdit.setText(shoe.description)
        }
    }
}