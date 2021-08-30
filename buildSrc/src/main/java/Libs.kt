object Libs {


    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_TKX}"
    const val KOTLIN_SDTLIB = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.KOTLIN}"

    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"

    const val VIEW_MODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE_VERSION}"
    const val LIFECYCLE_ANNOTATION =
        "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE_VERSION}"

    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_VERSION}"
    const val NAVIGATION_UI =
        "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_VERSION}"

    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"


    const val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val APOLLO = "com.apollographql.apollo3:apollo-runtime:${Versions.APOLLO}"
    const val APOLLO_CACHE = "com.apollographql.apollo3:apollo-normalized-cache:${Versions.APOLLO}"
    const val APOLLO_CACHE_SQLITE = "com.apollographql.apollo3:apollo-normalized-cache-sqlite:${Versions.APOLLO}"




    const val LIBRARY_DESUGAR = "com.android.tools:desugar_jdk_libs:${Versions.LIBRARY_DESUGAR}"

    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_CORE = "com.google.dagger:hilt-core:${Versions.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"



    const val JUPITER_ENGINE = "org.junit.jupiter:junit-jupiter-engine:${Versions.JUNIT5}"
    const val JUNIT4 = "junit:junit:${Versions.JUNIT4}"
    const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
    const val COROUTINES_TEST =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES_TEST}"

    const val TEST_CORE = "androidx.test:core:${Versions.TEST_CORE}"
    const val TEST_RUNNER = "androidx.test:runner:${Versions.TEST_CORE}"
    const val CORE_TESTING = "android.arch.core:core-testing:${Versions.CORE_TESTING}"
    const val HILT_TESTING = "com.google.dagger:hilt-android-testing:${Versions.HILT}"
    const val TURBINE = "app.cash.turbine:turbine:${Versions.TURBINE}"
    const val TRUTH = "com.google.truth:truth:${Versions.TRUTH}"
    const val MOCK_WEB_SERVER = "com.squareup.okhttp3:mockwebserver:${Versions.OKHTTP_VERSION}"
}