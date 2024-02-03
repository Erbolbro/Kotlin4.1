package com.example.kotlin41.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kotlin41.R
import com.example.kotlin41.databinding.FragmentSecondBinding
import com.example.kotlin41.ui.model.SecondViewModel
import com.example.kotlin41.ui.model.UserModel
import com.example.kotlin41.ui.prefernce.SharedPreference

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding: FragmentSecondBinding get() = _binding!!
    private val secondViewModel: SecondViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserver()
    }

    private fun initialize() {
        val preferenceHelper = SharedPreference(requireActivity())
        secondViewModel.updateUserModel(
            UserModel(
                preferenceHelper.user_name!!,
                preferenceHelper.age!!,
                preferenceHelper.email!!,
                preferenceHelper.password!!
            )
        )
    }

    private fun setupObserver() = with(binding) {
        secondViewModel.userData.observe(viewLifecycleOwner) { userData ->
            editTextId.text = userData.userName
            accelerate.text = userData.age
            tagUnhandledKeyEventManager.text = userData.email
            searchCloseBtn.text = userData.password

        }
        mtrlPickerTextInputRangeStart.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}