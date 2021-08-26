plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")

}

android {
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK



        testInstrumentationRunner = "com.combyne.tvmanager.data.AppTestRunner"
        consumerProguardFile("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            buildConfigField("String", "BASE_URL", "\"https://tv-show-manager.combyne.com/graphql\"")
            buildConfigField("String", "CLIENT_KEY", "yiCk1DW6WHWG58wjj3C4pB/WyhpokCeDeSQEXA5HaicgGh4pTUd+3/rMOR5xu1Yi")
            buildConfigField("String", "APPLICATION_ID", "AaQjHwTIQtkCOhtjJaN/nDtMdiftbzMWW5N8uRZ+DNX9LI8AOziS10eHuryBEcCI")
        }
        getByName("debug") {
            buildConfigField("String", "BASE_URL", "\"https://tv-show-manager.combyne.com/graphql\"")
            buildConfigField("String", "CLIENT_KEY", "yiCk1DW6WHWG58wjj3C4pB/WyhpokCeDeSQEXA5HaicgGh4pTUd+3/rMOR5xu1Yi")
            buildConfigField("String", "APPLICATION_ID", "AaQjHwTIQtkCOhtjJaN/nDtMdiftbzMWW5N8uRZ+DNX9LI8AOziS10eHuryBEcCI")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

}

dependencies {
    implementation(project(":domain"))

    implementation(Libs.KOTLIN_SDTLIB)

    implementation(Libs.COROUTINES)

    api(Libs.ROOM)
    implementation(Libs.ROOM_KTX)
    kapt(Libs.ROOM_KAPT)

    implementation(Libs.HILT)
    kapt(Libs.HILT_COMPILER)

    androidTestImplementation(Libs.JUNIT4)
    androidTestImplementation(Libs.JUPITER_ENGINE)

    androidTestImplementation(Libs.TEST_CORE)
    androidTestImplementation(Libs.CORE_TESTING)
    androidTestImplementation(Libs.TEST_RUNNER)

    androidTestImplementation(Libs.MOCKK)
    androidTestImplementation(Libs.COROUTINES_TEST)
    androidTestImplementation(Libs.HILT_TESTING)
    androidTestImplementation(Libs.TURBINE)
    kaptAndroidTest(Libs.HILT_COMPILER)
    kaptAndroidTest(Libs.TRUTH)
}