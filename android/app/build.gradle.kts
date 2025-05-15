plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.new_pwd"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.new_pwd"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            signingConfig = null
            isMinifyEnabled = false
            isShrinkResources = false
        }
    }

    applicationVariants.all {
        outputs.all {
            outputFileName = "new_pwd.apk"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.0")
}