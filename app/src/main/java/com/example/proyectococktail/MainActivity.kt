package com.example.proyectococktail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectococktail.Cocktails.Model.Routes
import com.example.proyectococktail.Cocktails.ui.Screen2
import com.example.proyectococktail.Cocktails.ui.Screen3
import com.example.proyectococktail.Cocktails.ui.ScreenHome
import com.example.proyectococktail.Cocktails.ui.Viewmodel
import com.example.proyectococktail.Cocktails.ui.principalScreen
import com.example.proyectococktail.pantallaprincipal.PantallaPrincipal
import com.example.proyectococktail.ui.theme.ProyectoCocktailTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: Viewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoCocktailTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Routes.principalScreen.Route){
                        composable(Routes.principalScreen.Route){principalScreen(navController, viewModel)}
                        composable(Routes.screen2.Route){Screen2(navController, viewModel)}
                        composable(Routes.screen3.Route){Screen3(navController, viewModel)}
                        composable(Routes.ScreenHome.Route){ScreenHome(navController, viewModel)}
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ProyectoCocktailTheme {
        Greeting("Android")
    }
}}