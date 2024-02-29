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
@Composable
fun SingLog(navController: NavController, loginVM: Viewmodel){
    val screen = loginVM.pantallasI

    Scaffold(
        topBar = {loginVM.LogOrsign(screen)},
        bottomBar = {BottomAppBar(navController, loginVM, screen)}
    ){innerPadding ->

        when(screen){
            1 -> {
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
                Column(

                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .background(color = Color(0xFF45413C))
                ) {
                    Spacer(modifier = Modifier.padding(37.dp))

                    Information("email ", loginVM)

                    PassW("password ", loginVM)
            }
        }

        }
    }

}

@Composable
fun BottomAppBar(navController: NavController, loginVM: Viewmodel, screen: Int){
    Box(
        Modifier
            .fillMaxWidth()
            .height(227.dp)
    ) {
        when(screen){
            1 -> SignUpdecision(
                Modifier.fillMaxWidth(), {loginVM.createUser { navController.navigate(Routes.ScreenHome.Route) }}
            )
            2 -> SignUpdecision(
                Modifier.fillMaxWidth(), {loginVM.login { navController.navigate(Routes.ScreenHome.Route) }}
            )
        }
    }
}

//loginVM.createUser {  navController.navigate(Routes.screen4.Route) }

@Composable
fun Information(valor: String, loginVM: Viewmodel){
    Box(
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = loginVM.informationElection(valor),
                onValueChange = { loginVM.ChangeElection(valor, it) },
                label = { Text(text = valor) },
                modifier = Modifier
                    .padding(37.dp)
                    .background(color = Color.White)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF00F5D4)
                    ),
                shape = RoundedCornerShape(100.dp)
            )
            loginVM.LogElection(valor = valor)

        }
    }
}

@Composable
fun PassW(valor: String, loginVM: Viewmodel){
    Box(
        contentAlignment = Alignment.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = loginVM.informationElection(valor),
                onValueChange = { loginVM.ChangeElection(valor, it) },
                label = { Text(text = valor) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .padding(37.dp)
                    .background(color = Color.White)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF00F5D4)
                    ),
                shape = RoundedCornerShape(100.dp)
            )
            loginVM.LogElection(valor = valor)

        }
    }
}
