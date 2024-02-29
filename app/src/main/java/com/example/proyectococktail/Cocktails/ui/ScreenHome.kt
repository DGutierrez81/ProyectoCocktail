package com.example.proyectococktail.Cocktails.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectococktail.Cocktails.Model.Routes
import com.example.proyectococktail.home.Home
import com.example.proyectococktail.logito.Logito
import com.example.proyectococktail.lupa.Lupa
import com.example.proyectococktail.seefaoritespie.SeefaoritesPie


/**
 * La función ScreenHome representa la pantalla principal de la aplicación.
 * Dependiendo del tipo de cocktail seleccionado, muestra una información diferente en la cabecera.
 *
 * @param navController Controlador de navegación utilizado para cambiar entre diferentes pantallas.
 * @param viewModel ViewModel utilizado para manejar la lógica de negocio y los datos de la pantalla principal.
 */
@Composable
fun ScreenHome(navController: NavController, viewModel: Viewmodel) {
    // LaunchedEffect es un efecto de composición que se ejecuta una vez cuando el componente es inicializado.
    LaunchedEffect(Unit) {
        // Este bloque de código dentro de LaunchedEffect no tiene ninguna acción definida.
        // Esto podría ser utilizado para realizar tareas de inicialización asíncronas,
        // como cargar datos desde una fuente remota, pero en este caso parece estar vacío.
    }

    // Scaffold es un componente de diseño de Material Design que proporciona una estructura básica
    // para las pantallas, incluyendo una barra superior y una barra inferior.
    Scaffold(
        topBar = { Cabecera(navController, viewModel) },
        bottomBar = { Pie(navController) }
    ) { innerPadding ->
        // Home es otro componente definido en algún otro lugar, se pasa con modificador de relleno y tamaño máximo.
        Home(
            Modifier.padding(innerPadding).fillMaxSize(),
            // Las siguientes líneas definen lambdas para las acciones que se ejecutarán al hacer clic en diferentes elementos de la pantalla.
            // Cada acción realiza una serie de operaciones a través del ViewModel y luego navega a otra pantalla.
            {
                viewModel.getRandom()
                viewModel.changeScreen(3)
                navController.navigate(Routes.cocktails.Route)
                viewModel.Clean()
            },
            {
                viewModel.getOrdinary()
                viewModel.changeScreen(4)
                navController.navigate(Routes.cocktails.Route)
                viewModel.Clean()
            },
            {
                viewModel.getCocktailGlass()
                viewModel.changeScreen(1)
                navController.navigate(Routes.cocktails.Route)
                viewModel.Clean()
            },
            {
                viewModel.getGlassChamp()
                viewModel.changeScreen(2)
                navController.navigate(Routes.cocktails.Route)
                viewModel.Clean()
            },
            {
                viewModel.vCocktailAlcoholic()
                viewModel.changeScreen(5)
                navController.navigate(Routes.cocktails.Route)
                viewModel.Clean()
            },
            {
                viewModel.getNoAlcoholic()
                viewModel.changeScreen(6)
                navController.navigate(Routes.cocktails.Route)
                viewModel.Clean()
            }
        )
    }
}


/**
 * Esta función representa la cabecera de la pantalla, donde se muestra un logo, un campo de búsqueda y un icono de búsqueda.
 * Dependiendo del tipo de cocktail, muestra una información diferente en la cabecera.
 * @param navController el controlador de navegación utilizado para navegar entre pantallas.
 * @param viewModel el ViewModel que contiene la lógica de negocio y los datos necesarios para la cabecera.
 */
@Composable
fun Cabecera(navController: NavController, viewModel: Viewmodel) {
    // La cabecera está contenida en un Box con un fondo de color gris oscuro.
    Box(
        Modifier
            .fillMaxWidth()
            .background(color = Color(0xFF45413C))
    ) {
        // Dentro del Box, hay una fila que contiene el logo, el campo de búsqueda y el icono de búsqueda.
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // El logo es representado por el componente Logito.
            Logito(Modifier.padding(5.dp)) {
                // Al hacer clic en el logo, se navega a la pantalla principal.
                navController.navigate(Routes.ScreenHome.Route)
            }

            // El TextField es el campo de búsqueda que permite al usuario ingresar el nombre del cocktail.
            TextField(
                value = viewModel.cocktailName,
                onValueChange = { viewModel.changeNameCocktail(it) },
                label = { Text(text = "Busqueda por nombre") },
                modifier = Modifier
                    .padding(5.dp)
                    .background(color = Color.White)
                    .border(
                        width = 2.dp,
                        color = Color(0xFF00F5D4)
                    ),
                shape = RoundedCornerShape(100.dp)
            )

            // El icono de búsqueda, representado por el componente Lupa.
            Lupa(Modifier.padding(5.dp).size(30.dp, 30.dp)) {
                // Al hacer clic en el icono de búsqueda, se realiza la búsqueda del nombre del cocktail.
                viewModel.getName(viewModel.cocktailName)
                // Luego de la búsqueda, se navega a la pantalla de cocktails y se limpian los datos del ViewModel.
                navController.navigate(Routes.cocktails.Route)
                viewModel.Clean()
            }
        }
    }
}


/**
 * Esta función representa el pie de la pantalla, donde se muestra un elemento relacionado con favoritos.
 * @param navController el controlador de navegación utilizado para navegar entre pantallas.
 */
@Composable
fun Pie(navController: NavController) {
    // El pie está contenido en un Box con ancho máximo y altura fija.
    Box(
        Modifier
            .fillMaxWidth()
            .height(75.dp)
    ) {
        // Dentro del Box, se encuentra el componente SeefaoritesPie.
        SeefaoritesPie(Modifier.fillMaxWidth()) {
            // Al hacer clic en el elemento relacionado con favoritos, se navega a la pantalla correspondiente.
            navController.navigate(Routes.ViewConktailUser.Route)
        }
    }
}
