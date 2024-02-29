package com.example.proyectococktail.Cocktails.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.proyectococktail.Cocktails.Model.Routes
import com.example.proyectococktail.pantallaprincipal.PantallaPrincipal



/**
 * Esta función representa la pantalla principal de la aplicación, donde se muestra la interfaz de inicio de sesión.
 * @param navController el controlador de navegación utilizado para navegar entre pantallas.
 * @param loginVM el ViewModel que contiene la lógica de negocio relacionada con el inicio de sesión.
 */
@Composable
fun PrincipalScreen(navController: NavController, loginVM: Viewmodel) {
    // La pantalla principal contiene una interfaz de inicio de sesión con campos de texto y un botón de entrada.
    PantallaPrincipal(
        modifier = Modifier.fillMaxSize(),
        {
            // Cuando se hace clic en el botón de inicio de sesión, se ejecuta la lógica correspondiente en el ViewModel
            // y se navega a la pantalla de inicio de sesión.
            loginVM.pantallasIncio(1)
            navController.navigate(Routes.singLog.Route)
        },
        {
            // Cuando se hace clic en el botón de registro, se ejecuta la lógica correspondiente en el ViewModel
            // y se navega a la pantalla de registro.
            loginVM.pantallasIncio(2)
            navController.navigate(Routes.singLog.Route)
        }
    )
}
