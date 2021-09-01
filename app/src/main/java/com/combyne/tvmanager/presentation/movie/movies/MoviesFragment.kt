package com.combyne.tvmanager.presentation.movie.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.combyne.tvmanager.databinding.FragmentMoviesBinding
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MoviesFragment : Fragment() {
    private val viewModel by viewModels<MoviesViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val binding: FragmentMoviesBinding = FragmentMoviesBinding.inflate(
            inflater, container, false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}