package com.example.playground.memorydump

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.example.playground.R
import com.example.playground.databinding.FragmentFirstBinding
import java.util.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btMemory.setOnClickListener {

            val charArray = CharArray(binding.etPassword.length())

            binding.etPassword.text.getChars(0, binding.etPassword.length(), charArray, 0)

            Arrays.fill(charArray, ' ')

            binding.etPassword.text.clear()

//            startActivity(Intent(context  , TestActivity::class.java))

            activity?.finish()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}