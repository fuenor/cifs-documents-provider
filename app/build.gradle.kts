plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.android.gms.oss-licenses-plugin")
}

android {
    compileSdk = Deps.compileSdkVersion
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    defaultConfig {
        applicationId = "com.wa2c.android.cifsdocumentsprovider"
        minSdk = Deps.minSdkVersion
        targetSdk = Deps.targetSdkVersion
        versionCode = 13
        versionName = "1.5.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        base.archivesName.set("CIFSDocumentsProvider-${versionName}")
    }

    buildTypes {
        debug {
            versionNameSuffix = "D"
        }
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        dataBinding = true
    }

}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to arrayOf("*.jar"))))
    implementation(project(":common"))
    implementation(project(":presentation"))
    implementation(project(":data"))

    implementation(Deps.App.daggerHilt)
    kapt(Deps.App.daggerHiltCompiler)

    // Util

    // Localization
    implementation(Deps.Util.localization)
    // OSS License
    implementation(Deps.Util.ossLicense)
}

kapt {
    // https://kotlinlang.org/docs/kapt.html
    correctErrorTypes = true
}
