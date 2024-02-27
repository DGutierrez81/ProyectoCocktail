package com.example.proyectococktail.Cocktails.Model

sealed class Routes(val Route: String) {
    object principalScreen: Routes("principalScreen")
    object screen2: Routes("screen2")
    object screen3: Routes("screen3")
}