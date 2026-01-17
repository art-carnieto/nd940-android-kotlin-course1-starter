package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingMethod
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import timber.log.Timber

class ShoeListFragment : Fragment() {

    // from https://developer.android.com/topic/libraries/view-binding#fragments
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

        android.util.Log.d("test", "test")
        Timber.d("btn clicked!")
        Toast.makeText(this.context, "test!", Toast.LENGTH_LONG).show()

        return view
    }

    fun openShoeDetails(v: View, index: Int) {
        v.setOnClickListener { view ->
            Timber.d("hello!")
            view?.findNavController()?.navigate(
                ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment(index)
            )
        }
    }

    fun testClick(v: View) {
        v.setOnClickListener {
            android.util.Log.d("test", "test")
            Timber.d("btn clicked!")
            Toast.makeText(this.context, "test!", Toast.LENGTH_LONG).show()
        }
    }

    fun log() { android.util.Log.d("test", "test") }

}