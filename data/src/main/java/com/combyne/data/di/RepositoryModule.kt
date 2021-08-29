package com.combyne.data.di

import com.combyne.data.remote.MovieRemoteData
import com.combyne.data.remote.MovieRemoteDataImpl
import com.combyne.data.repository.MovieRepositoryImpl
import com.combyne.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideMovieRemoteData(movieRemoteData: MovieRemoteDataImpl): MovieRemoteData

    @Binds
    abstract fun provideMovieRepository(movieRepository: MovieRepositoryImpl): MovieRepository
}