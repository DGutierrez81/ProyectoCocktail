package com.example.proyectococktail.Cocktails.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.proyectococktail.Cocktails.Model.Routes
import com.example.proyectococktail.pantallaprincipal.PantallaPrincipal

@Composable
fun PrincipalScreen(navController: NavController, loginVM: Viewmodel){
    // DCS - Estructura de la interfaz de inicio de sesión con campos de texto y botón de entrada.
    PantallaPrincipal(Modifier, {
        loginVM.pantallasIncio(1)
        navController.navigate(Routes.singLog.Route)
                                }, {
        loginVM.pantallasIncio(2)
        navController.navigate(Routes.singLog.Route)
    })
}