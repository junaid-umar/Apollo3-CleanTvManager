package com.combyne.data.di

import android.content.Context
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.http.HttpRequest
import com.apollographql.apollo3.api.http.HttpResponse
import com.apollographql.apollo3.api.http.withHeaders
import com.apollographql.apollo3.cache.normalized.sql.SqlNormalizedCacheFactory
import com.apollographql.apollo3.cache.normalized.withNormalizedCache
import com.apollographql.apollo3.network.http.HttpInterceptor
import com.apollographql.apollo3.network.http.HttpInterceptorChain
import com.apollographql.apollo3.network.http.HttpNetworkTransport
import com.combyne.data.BuildConfig
import com.combyne.data.remote.api.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieRemoteModule {

    @Singleton
    @Provides
    fun provideInterceptor(): HttpInterceptor {
        return object : HttpInterceptor {
            override suspend fun intercept(
                request: HttpRequest,
                chain: HttpInterceptorChain,
            ): HttpResponse {
                return chain.proceed(request.withHeaders(ApiClient.headers))
            }

        }
    }

    @Singleton
    @Provides
    fun provideApolloClient(
        @ApplicationContext context: Context,
        httpInterceptor: HttpInterceptor,
    ): ApolloClient {
        return ApolloClient(
            networkTransport = HttpNetworkTransport(
                serverUrl = BuildConfig.SERVER_URL,
                interceptors = listOf(httpInterceptor)
            )).withNormalizedCache(SqlNormalizedCacheFactory(context,
            ApiClient.DATABASE_NAME))
    }
}