package com.example.navigationdrawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationdrawer.databinding.FragmentDetailProfileBinding

class DetailProfileFragment : Fragment() {

    private var _binding: FragmentDetailProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDetailProfileBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        // MENERIMA PARAMETER BUNDLE
        val param1 = arguments?.getString("param1")

        binding.tvParam.text = param1 ?: "Data tidak ditemukan"

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
