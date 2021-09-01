package com.combyne.tvmanager.presentation.movie.create_movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.combyne.tvmanager.databinding.FragmentCreateMovieBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CreateMovieFragment : Fragment() {
    private val viewModel by viewModels<CreateMovieViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding: FragmentCreateMovieBinding = FragmentCreateMovieBinding.inflate(
            inflater, container, false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}