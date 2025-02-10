plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //kotlin("kapt")//Habilita la herramienta para procesar anotaciones en Kotlin.
    //id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.calpalapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.calpalapp"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // Uso de ViewModel y ciclo de vida en Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)

    //para comprobar leaks de memoria en ejecucion
    debugImplementation(libs.leakcanary.android)

    //para serializar y deserializar datos en formato JSON en Kotlin
    implementation(libs.kotlinx.serialization.json)

    // Navegación en Compose
    implementation(libs.androidx.navigation.compose)

    // Carga de imágenes asíncronas
    implementation(libs.coil.compose)

    // Inyección de dependencias con Dagger Hilt
    implementation(libs.hilt.android)

    implementation (libs.androidx.material.icons.extended)

    //kapt(libs.hilt.android.compiler)
}