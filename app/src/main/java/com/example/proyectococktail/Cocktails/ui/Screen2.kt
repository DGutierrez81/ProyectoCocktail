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
import com.example.proyectococktail.compsignup.CompSignUp
import com.example.proyectococktail.eiuser.EiUser
import com.example.proyectococktail.fluentemojihighcontrastenvelope.FluentEmojiHighContrastEnvelope
import com.example.proyectococktail.logito.Logito
import com.example.proyectococktail.signupdecision.SignUpdecision


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(navController: NavController, loginVM: Viewmodel){
    // DCS - Estructura de la interfaz de inicio de sesión con campos de texto y botón de entrada.

    Scaffold(
        topBar = {Toolbar()},
        bottomBar = {BottomAppBar()}
    ){innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(innerPadding)
                .background(color = Color(0xFF45413C))
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = loginVM.userName,
                        onValueChange = { loginVM.changeUserName(it) },
                        label = { Text(text = "Username") },
                        modifier = Modifier
                            .padding(33.dp)
                            .background(color = Color.White)
                            .border(
                                width = 2.dp,
                                color = Color.Red
                            ),
                        shape = RoundedCornerShape(100.dp)
                    )
                    EiUser(Modifier.size(50.dp,50.dp))
                }
            }

            Box(
                Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = loginVM.email,
                        onValueChange = { loginVM.changeEmail(it) },
                        label = { Text(text = "Username") },
                        modifier = Modifier
                            .padding(33.dp)
                            .background(color = Color.White),
                        shape = RoundedCornerShape(100.dp)
                    )
                    FluentEmojiHighContrastEnvelope(Modifier.size(50.dp,50.dp))

                }
            }

            Box(
                Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = loginVM.password,
                        onValueChange = { loginVM.changePassword(it) },
                        label = { Text(text = "Username") },
                        modifier = Modifier
                            .padding(33.dp)
                            .background(color = Color.White),
                        shape = RoundedCornerShape(100.dp)
                    )
                    BasilKeyOutline(Modifier.size(50.dp,50.dp))

                }
            }
        }
    }
/*
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            Modifier
                .fillMaxWidth()
                .height(227.dp)
        ) {
            CompSignUp(
                Modifier.fillMaxWidth()
            )
        }

        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = loginVM.userName,
                    onValueChange = { loginVM.changeUserName(it) },
                    label = { Text(text = "Username") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    shape = RoundedCornerShape(100.dp)
                )
                EiUser(Modifier.size(50.dp,50.dp))
            }
        }

        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = loginVM.email,
                    onValueChange = { loginVM.changeEmail(it) },
                    label = { Text(text = "Username") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    shape = RoundedCornerShape(100.dp)
                )
                FluentEmojiHighContrastEnvelope(Modifier.size(50.dp,50.dp))
            }
        }

        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                OutlinedTextField(
                    value = loginVM.password,
                    onValueChange = { loginVM.changePassword(it) },
                    label = { Text(text = "Username") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 30.dp, end = 30.dp),
                    shape = RoundedCornerShape(100.dp)
                )
                BasilKeyOutline(Modifier.size(50.dp,50.dp))
            }
        }

        Box(
            Modifier
                .fillMaxWidth()
                .height(227.dp)
        ) {
            SignUpdecision(
                Modifier.fillMaxWidth()
            )
        }


        /*
        OutlinedTextField(
            value = loginVM.userName,
            onValueChange = { loginVM.changeUserName(it) },
            label = { Text(text = "Username") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            shape = RoundedCornerShape(100.dp)
        )

        OutlinedTextField(
            value = loginVM.email,
            onValueChange = { loginVM.changeEmail(it) },
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
                loginVM.createUser {  navController.navigate(Routes.screen3.Route) }
            }, modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp)
        ) {
            Text(text = "Registrarse")
        }



         */

    }


 */

}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Toolbar() {
    Box(
        Modifier
            .fillMaxWidth()
            .height(227.dp)
    ) {
        CompSignUp(
            Modifier.fillMaxWidth()
        )
    }
}



@Composable
fun BottomAppBar(){
    Box(
        Modifier
            .fillMaxWidth()
            .height(227.dp)
    ) {
        SignUpdecision(
            Modifier.fillMaxWidth()
        )
    }
}

/*
@Composable
fun ScaffoldExample() {
    var presses by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Top app bar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { presses++ }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text =
                """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button $presses times.
                """.trimIndent(),
            )
        }
    }
}

 */