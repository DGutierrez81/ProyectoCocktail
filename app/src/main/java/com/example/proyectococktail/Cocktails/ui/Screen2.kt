package com.example.proyectococktail.Cocktails.ui

import android.icu.text.CaseMap.Title
import android.widget.Toolbar
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectococktail.Cocktails.Model.Routes
import com.example.proyectococktail.R
import com.example.proyectococktail.basilkeyoutline.BasilKeyOutline
import com.example.proyectococktail.complogin.CompLogIn
import com.example.proyectococktail.compsignup.CompSignUp
import com.example.proyectococktail.eiuser.EiUser
import com.example.proyectococktail.fluentemojihighcontrastenvelope.FluentEmojiHighContrastEnvelope
import com.example.proyectococktail.logito.Logito
import com.example.proyectococktail.signupdecision.SignUpdecision


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(navController: NavController, loginVM: Viewmodel){
    val screen = loginVM.pantallasI

    Scaffold(
        topBar = {loginVM.LogOrsign(screen)},
        bottomBar = {BottomAppBar(navController)}
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

                    Information("password", loginVM)
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

                    Information("password ", loginVM)
            }
        }

        }
    }

}

@Composable
fun BottomAppBar(navController: NavController){
    Box(
        Modifier
            .fillMaxWidth()
            .height(227.dp)
    ) {
        SignUpdecision(
            Modifier.fillMaxWidth(), {navController.navigate(Routes.ScreenHome.Route)}
        )
    }
}

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
                value = loginVM.InformationElection(valor),
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
