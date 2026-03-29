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

        val args = ShoeDetailFragmentArgs.fromBundle(requireArguments())
        Timber.d("args = ${args.shoeName}")

        openShoe(args.shoeName.toString())

        return view
    }

    fun openShoe (name : String) {
        val shoe = shoeListviewModel.getShoe(name)
        if(shoe == null) Timber.e("Trying to open invalid shoe $name!")
        else {
            binding.apply {
                shoeImage.setImageResource(shoe.imgResourceId)
                shoeNameEdit.setText(shoe.name)
                companyEdit.setText(shoe.company)
                shoeSizeEdit.setText(shoe.size.toString())
                descriptionEdit.setText(shoe.description)
            }
        }
    }
}