package com.example.proyectococktail.Cocktails.Model

sealed class Routes(val Route: String) {
    object principalScreen: Routes("principalScreen")
    object singLog: Routes("singLog")
    object cocktails: Routes("cocktails")

    object ScreenHome: Routes("screen4")

    object Cards: Routes("screen5")

    object ViewConktailUser: Routes("screen6")
}