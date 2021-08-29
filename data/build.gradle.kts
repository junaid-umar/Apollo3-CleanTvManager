plugins {
    id("com.android.library")
    id("kotlin-android")
    kotlin("kapt")
    id("com.apollographql.apollo3")
}
val clientKey: String by project
val applicationId: String by project

android {
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK



        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFile("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            buildConfigField("String",
                "SERVER_URL",
                "\"https://tv-show-manager.combyne.com/graphql\"")
            buildConfigField("String", "CLIENT_KEY", clientKey)
            buildConfigField("String", "APPLICATION_ID", applicationId)
        }
        getByName("debug") {
            buildConfigField("String",
                "SERVER_URL",
                "\"https://tv-show-manager.combyne.com/graphql\"")
            buildConfigField("String", "CLIENT_KEY", clientKey)
            buildConfigField("String", "APPLICATION_ID", applicationId)
        }
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    packagingOptions {
        resources.pickFirsts.add("META-INF/*")
        resources.excludes.add("**/attach_hotspot_windows.dll")
        resources.excludes.add("META-INF/LICENSE")
        resources.excludes.add("META-INF/licenses/ASM")
        resources.excludes.add("META-INF/LICENSE.txt")
        resources.excludes.add("META-INF/license.txt")
        resources.excludes.add("META-INF/NOTICE")
        resources.excludes.add("META-INF/NOTICE.txt")
        resources.excludes.add("META-INF/notice.txt")
        resources.excludes.add("META-INF/notice.txt")
        resources.excludes.add("META-INF/ASL2.0")
        resources.excludes.add("META-INF/*.kotlin_module")
    }
}
apollo {
    packageName.set("com.combyne.data")
    generateKotlinModels.set(true)
}
dependencies {
    implementation(project(":domain"))

    implementation(Libs.KOTLIN_SDTLIB)

    implementation(Libs.COROUTINES)

    implementation(Libs.APOLLO)
    implementation(Libs.APOLLO_CACHE)
    implementation(Libs.APOLLO_CACHE_SQLITE)

    implementation(Libs.HILT)
    kapt(Libs.HILT_COMPILER)


    // Test
    testImplementation(Libs.JUNIT4)
    testImplementation(Libs.TRUTH)
    testImplementation(Libs.JUPITER_ENGINE)
    testImplementation(Libs.MOCKK)
    testImplementation(Libs.COROUTINES_TEST)


    // Not in use but to write instrumentation test later
    androidTestImplementation(Libs.JUNIT4)
    androidTestImplementation(Libs.JUPITER_ENGINE)
    androidTestImplementation(Libs.TRUTH)
    androidTestImplementation(Libs.MOCKK)
    androidTestImplementation(Libs.COROUTINES_TEST)
    androidTestImplementation(Libs.TURBINE)
    androidTestImplementation(Libs.MOCK_WEB_SERVER)
    androidTestImplementation(Libs.TEST_CORE)
    androidTestImplementation(Libs.CORE_TESTING)
    androidTestImplementation(Libs.TEST_RUNNER)
    androidTestImplementation(Libs.HILT_TESTING)
    kaptAndroidTest(Libs.HILT_COMPILER)
    kaptAndroidTest(Libs.TRUTH)
}