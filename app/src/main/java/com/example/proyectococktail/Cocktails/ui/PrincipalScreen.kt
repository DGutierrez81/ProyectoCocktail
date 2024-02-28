package com.example.proyectococktail.Cocktails.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectococktail.Cocktails.Model.Routes
import com.example.proyectococktail.pantallaprincipal.PantallaPrincipal

@Composable
fun principalScreen(navController: NavController, loginVM: Viewmodel){
    // DCS - Estructura de la interfaz de inicio de sesión con campos de texto y botón de entrada.
    PantallaPrincipal(Modifier, {
        loginVM.pantallasIncio(1)
        navController.navigate(Routes.screen2.Route)
                                }, {
        loginVM.pantallasIncio(2)
        navController.navigate(Routes.screen2.Route)
    })
/*
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Button(onClick = {navController.navigate(Routes.screen2.Route)}) {
            Text(text = "Formulario")
        }
        OutlinedTextField(
            value = loginVM.email,
            onValueChange = {
                loginVM.changeEmail(it)
            },
            label = { Text(text = "Email") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        )

        OutlinedTextField(
            value = loginVM.password,
            onValueChange = { loginVM.changePassword(it) },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                loginVM.login { navController.navigate(Routes.screen3.Route)}
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text(text = "Entrar")
        }

    }

 */
}