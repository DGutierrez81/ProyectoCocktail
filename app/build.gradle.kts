plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    //DCS - Dagger Hilt
    kotlin("kapt")
    id("com.google.dagger.hilt.android")

    id("com.google.relay") version "0.3.02"
}

android {
    namespace = "com.example.proyectococktail"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.proyectococktail"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.wear.compose:compose-material:1.3.0")
    implementation ("androidx.compose.material:material:1.4.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation(platform("com.google.firebase:firebase-bom:32.7.2"))
    implementation("com.google.firebase:firebase-analytics")
    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    // https://firebase.google.com/docs/android/setup#available-libraries
    // DCS - Servicio de Autenticación
    implementation("com.google.firebase:firebase-auth-ktx:22.3.1")
    // DCS - Base de datos Firestore
    implementation("com.google.firebase:firebase-firestore-ktx:24.10.1")

    //DCS - Versión Alpha donde está el componente SearchBar
    implementation(platform("androidx.compose:compose-bom:2023.05.01"))

    //DCS - Cambiamos la versión a la misma: 2023.05.01
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.05.01"))

    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.4")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.3.1")
    implementation("androidx.navigation:navigation-compose:2.7.5")

    //DCS - Dagger Hilt
    implementation("com.google.dagger:hilt-android:2.44.2")
    kapt("com.google.dagger:hilt-android-compiler:2.44")

    //DCS - Navigation
    implementation("androidx.navigation:navigation-compose:2.7.7")

    //DCS - Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //DCS - Coil
    //DCS - Coil es una biblioteca de carga de imágenes para Android que es compatible con Jetpack Compose.
    implementation("io.coil-kt:coil-compose:1.4.0")
}

//DCS - Dagger Hilt - Allow references to generated code
kapt {
    correctErrorTypes = true
}


