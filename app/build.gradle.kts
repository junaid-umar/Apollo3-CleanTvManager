plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        applicationId = "com.combyne.tvmanager"
        minSdk = Versions.MIN_SDK
        targetSdk = Versions.TARGET_SDK
        versionCode = Versions.VERSION_CODE
        versionName = Versions.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ), "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ), "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        compose = true
    }
    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
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

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))

    implementation(Libs.CORE_KTX)
    implementation(Libs.APPCOMPAT)

    implementation(Libs.VIEW_MODEL)
    implementation(Libs.LIFECYCLE_ANNOTATION)
    implementation(Libs.NAVIGATION_FRAGMENT)
    implementation(Libs.NAVIGATION_UI)


    implementation (Libs.COMPOSE_UI)
    implementation (Libs.COMPOSE_TOOLING)
    implementation (Libs.COMPOSE_FOUNDATION)
    implementation (Libs.COMPOSE_MATERIAL)



    implementation(Libs.MATERIAL)

    implementation(Libs.APOLLO)

    // for backward compatibility of Java 8 features e.g java time
    coreLibraryDesugaring(Libs.LIBRARY_DESUGAR)

    implementation(Libs.COROUTINES)

    implementation(Libs.HILT)
    kapt(Libs.HILT_COMPILER)

}