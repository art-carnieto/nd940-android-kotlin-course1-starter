package com.udacity.shoestore.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding
import timber.log.Timber

class LoginFragment : Fragment() {

    // from https://developer.android.com/topic/libraries/view-binding#fragments
    private lateinit var _binding: FragmentLoginBinding
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.d("onCreateView")
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        val loginButtonExisting = binding.loginButtonExistingAcc
        loginButtonExisting.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_onboardingFragment)
        )

        val loginButtonNew = binding.loginButtonNewAcc
        loginButtonNew.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_onboardingFragment)
        )

        return view
    }
}