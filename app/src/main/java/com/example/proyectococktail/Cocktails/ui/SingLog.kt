package com.example.proyectococktail.Cocktails.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectococktail.Cocktails.Model.Routes
import com.example.proyectococktail.signupdecision.SignUpdecision


@OptIn(ExperimentalMaterial3Api::class)
/**
 * Esta función representa la pantalla de inicio de sesión o registro, dependiendo del estado actual.
 * @param navController el controlador de navegación utilizado para navegar entre pantallas.
 * @param loginVM el ViewModel que contiene la lógica de negocio relacionada con el inicio de sesión y registro.
 */
@Composable
fun SingLog(navController: NavController, loginVM: Viewmodel) {
    // Se obtiene el estado actual de la pantalla de inicio de sesión o registro.
    val screen = loginVM.pantallasI

    // La pantalla se construye utilizando el componente Scaffold para una estructura básica de la pantalla.
    Scaffold(
        topBar = {
            // Se muestra la barra superior, que puede contener opciones de inicio de sesión o registro dependiendo del estado.
            loginVM.LogOrsign(screen)
        },
        bottomBar = {
            // Se muestra la barra inferior, que puede contener acciones relacionadas con la navegación o el proceso de inicio de sesión.
            BottomAppBar(navController, loginVM, screen)
        }
    ) { innerPadding ->
        // Se utiliza un when para determinar qué elementos mostrar en la pantalla dependiendo del estado actual.
        when (screen) {
            1 -> {
                // Si la pantalla actual es la de inicio de sesión, se muestra un formulario con campos de nombre de usuario, correo electrónico y contraseña.
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .background(color = Color(0xFF45413C))
                ) {
                    Information("userName", loginVM)
                    Information("email", loginVM)
                    PassW("password", loginVM)
                }
            }
            2 -> {
                // Si la pantalla actual es la de registro, se muestra un formulario con campos de correo electrónico y contraseña.
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .background(color = Color(0xFF45413C))
                ) {
                    Spacer(modifier = Modifier.padding(37.dp)) // Espaciador para ajustar el diseño
                    Information("email", loginVM)
                    PassW("password", loginVM)
                }
            }
        }
    }
}


/**
 * Este componente representa la barra inferior de la pantalla, que contiene acciones relacionadas con el proceso de inicio de sesión o registro.
 * @param navController el controlador de navegación utilizado para navegar entre pantallas.
 * @param loginVM el ViewModel que contiene la lógica de negocio relacionada con el inicio de sesión y registro.
 * @param screen el estado actual de la pantalla de inicio de sesión o registro.
 */
@Composable
fun BottomAppBar(navController: NavController, loginVM: Viewmodel, screen: Int) {
    // El componente está contenido en un Box con ancho máximo y altura fija.
    Box(
        Modifier
            .fillMaxWidth()
            .height(227.dp)
    ) {
        // Se utiliza un when para determinar qué acción mostrar en la barra inferior según el estado actual de la pantalla.
        when (screen) {
            1 -> {
                // Si el estado es 1 (registro), se muestra la opción de registro.
                SignUpdecision(
                    modifier = Modifier.fillMaxWidth(),
                    {
                        // Cuando se hace clic en el botón de registro, se ejecuta la lógica correspondiente en el ViewModel
                        // y se navega a la pantalla principal.
                        loginVM.createUser { navController.navigate(Routes.ScreenHome.Route) }
                    }
                )
            }
            2 -> {
                // Si el estado es 2 (inicio de sesión), se muestra la opción de inicio de sesión.
                SignUpdecision(
                    modifier = Modifier.fillMaxWidth(),
                    {
                        // Cuando se hace clic en el botón de inicio de sesión, se ejecuta la lógica correspondiente en el ViewModel
                        // y se navega a la pantalla principal.
                        loginVM.login { navController.navigate(Routes.ScreenHome.Route) }
                    }
                )
            }
        }
    }
}



/**
 * Este componente representa un campo de entrada de información, como un nombre de usuario o un correo electrónico.
 * @param valor el tipo de información que se está solicitando, como "userName" o "email".
 * @param loginVM el ViewModel que contiene la lógica de negocio relacionada con la entrada de información.
 */
@Composable
fun Information(valor: String, loginVM: Viewmodel) {
    // El campo de entrada de información está contenido en un Box con alineación de contenido al centro.
    Box(
        contentAlignment = Alignment.Center
    ) {
        // Dentro del Box, se utiliza un Row para organizar horizontalmente el TextField y cualquier otro componente relacionado.
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // El TextField permite al usuario ingresar la información solicitada, como el nombre de usuario o el correo electrónico.
            TextField(
                value = loginVM.informationElection(valor), // El valor del TextField es gestionado por el ViewModel.
                onValueChange = { loginVM.ChangeElection(valor, it) }, // Se actualiza el valor en el ViewModel cuando cambia el contenido del TextField.
                label = { Text(text = valor) }, // Se muestra una etiqueta indicando el tipo de información solicitada.
                modifier = Modifier
                    .padding(37.dp)
                    .background(color = Color.White)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF00F5D4)
                    ),
                shape = RoundedCornerShape(100.dp)
            )
            // Se ejecuta la lógica en el ViewModel para gestionar la entrada de información.
            loginVM.LogElection(valor = valor)
        }
    }
}


/**
 * Este componente representa un campo de entrada de contraseña.
 * @param valor el tipo de campo de contraseña que se está solicitando, como "password".
 * @param loginVM el ViewModel que contiene la lógica de negocio relacionada con la entrada de contraseña.
 */
@Composable
fun PassW(valor: String, loginVM: Viewmodel) {
    // El campo de contraseña está contenido en un Box con alineación de contenido al centro.
    Box(
        contentAlignment = Alignment.Center
    ) {
        // Dentro del Box, se utiliza un Row para organizar horizontalmente el TextField y cualquier otro componente relacionado.
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // El TextField permite al usuario ingresar la contraseña solicitada.
            TextField(
                value = loginVM.informationElection(valor), // El valor del TextField es gestionado por el ViewModel.
                onValueChange = { loginVM.ChangeElection(valor, it) }, // Se actualiza el valor en el ViewModel cuando cambia el contenido del TextField.
                label = { Text(text = valor) }, // Se muestra una etiqueta indicando el tipo de campo de contraseña.
                visualTransformation = PasswordVisualTransformation(), // Se aplica la transformación visual para ocultar la contraseña.
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password), // Se configura el teclado para mostrar un teclado de contraseña.
                modifier = Modifier
                    .padding(37.dp)
                    .background(color = Color.White)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF00F5D4)
                    ),
                shape = RoundedCornerShape(100.dp)
            )
            // Se ejecuta la lógica en el ViewModel para gestionar la entrada de contraseña.
            loginVM.LogElection(valor = valor)
        }
    }
}

