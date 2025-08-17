package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import timber.log.Timber

class ShoeDetailFragment : Fragment() {

    // from https://developer.android.com/topic/libraries/view-binding#fragments
    private lateinit var _binding: FragmentShoeDetailBinding
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")
        _binding = FragmentShoeDetailBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }
}