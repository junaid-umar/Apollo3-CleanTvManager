package com.combyne.data.remote.api

import com.combyne.data.BuildConfig

internal object ApiClient {

    const val DATABASE_NAME = "tv_manager"

    val headers: Map<String, String> =
        mapOf("X-Parse-Client-Key" to BuildConfig.CLIENT_KEY,
            "X-Parse-Application-Id" to BuildConfig.APPLICATION_ID)

}