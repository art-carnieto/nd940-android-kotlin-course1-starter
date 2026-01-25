package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
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

        inflateShoes(binding.shoeList, shoeListviewModel.shoeList.value ?: emptyList())

        return view
    }

    private fun inflateShoes(layout: LinearLayout, shoeList: List<Shoe>) {
        val inflater = LayoutInflater.from(layout.context)
        for (shoe in shoeList) {
            val newShoe: View = inflater.inflate(R.layout.shoe_item, layout, false)

            // shoe thumbnail
            val shoeImage: ImageView = newShoe.findViewById(R.id.shoeThumbnail)
            shoeImage.setImageResource(shoe.imgResourceId)

            // shoe name
            val shoeName: TextView = newShoe.findViewById(R.id.shoeName)
            shoeName.text = shoe.name

            // shoe button
            val shoeButton: Button = newShoe.findViewById(R.id.shoeDetailsBtn)
            shoeButton.setOnClickListener { view ->
                Timber.d("Clicked on shoe ${shoe.name}!")
                view?.findNavController()?.navigate(
                    ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment(shoe.name)
                )
            }
            layout.addView(newShoe)
        }
    }

}