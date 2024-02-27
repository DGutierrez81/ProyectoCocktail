package com.example.proyectococktail.Cocktails.Model

sealed class Routes(val Route: String) {
    object screen: Routes("screen")
}