package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.shoestore.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    private lateinit var _binding : FragmentShoeListBinding
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding

    private lateinit var shoeListviewModel : ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentShoeListBinding.inflate(inflater, container, false)
        val view = binding.root

        shoeListviewModel = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        binding.viewModel = shoeListviewModel
        binding.lifecycleOwner = this

        return view
    }
}