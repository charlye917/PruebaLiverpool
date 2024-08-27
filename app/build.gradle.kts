plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kapt)
}

android {
    namespace = "com.charlye934.shoppinliverpool"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.charlye934.shoppinliverpool"
        minSdk = 33
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "BASE_URL","\"https://shoppapp.liverpool.com.mx/appclienteservices/services/v3/\"")
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
    }
    viewBinding {
        enable = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

kapt{
    correctErrorTypes = true
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.swiperefresh)

    //RETROFIT
    implementation(libs.gson)
    implementation(libs.retrofit)
    implementation(libs.retrofit.convert)

    //OKHTTP
    implementation(libs.okhttp)
    implementation(libs.okhttp.login.interceptor)
    implementation(libs.okhttp.url.conecction)

    //VIEWMODEL
    implementation(libs.viewmodel)
    implementation(libs.livedata)
    implementation(libs.savedstate)
    implementation(libs.coroutines)

    //HILT
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //NAVIGATION
    implementation(libs.navigation.ui)
    implementation(libs.navigation.fragment)

    //Glide
    implementation(libs.glide)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}