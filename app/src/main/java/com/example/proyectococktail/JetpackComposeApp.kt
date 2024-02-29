package com.example.proyectococktail

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Esta clase representa la aplicación Jetpack Compose.
 * Está anotada con @HiltAndroidApp para habilitar la inyección de dependencias con Hilt.
 * Extiende la clase Application y puede ser utilizada para inicializar la aplicación Jetpack Compose.
 */
@HiltAndroidApp
class JetpackComposeApp: Application() {
}
