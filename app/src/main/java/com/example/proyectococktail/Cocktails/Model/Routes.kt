package com.example.proyectococktail.Cocktails.Model

/**
 * Esta clase sellada define las rutas utilizadas en la navegación de la aplicación.
 * @param Route la ruta asociada a cada objeto de la clase.
 */
sealed class Routes(val Route: String) {
    object principalScreen: Routes("principalScreen") // Ruta para la pantalla principal.
    object singLog: Routes("singLog") // Ruta para la pantalla de inicio de sesión.
    object cocktails: Routes("cocktails") // Ruta para la pantalla de cócteles.

    object ScreenHome: Routes("screen4") // Ruta para la pantalla de inicio.

    object Cards: Routes("screen5") // Ruta para la pantalla de tarjetas de cócteles.

    object ViewConktailUser: Routes("screen6") // Ruta para la pantalla de visualización de cócteles para el usuario.
}
