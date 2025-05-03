package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentOnboardingBinding
import timber.log.Timber

class OnboardingFragment : Fragment() {

    // from https://developer.android.com/topic/libraries/view-binding#fragments
    private lateinit var _binding: FragmentOnboardingBinding
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.onboardingTitle.requestFocus() // To make text animate marquee style

        val nextButton = binding.onboardingNextButton
        nextButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_onboardingFragment_to_instructionsFragment)
        )

        return view
    }
}