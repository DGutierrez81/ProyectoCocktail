package com.example.proyectococktail.Cocktails.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.proyectococktail.Cocktails.Model.Routes
import com.example.proyectococktail.home.jollyLodger

/**
 * Este componente representa la pantalla de visualización de cócteles para el usuario.
 * @param navController el controlador de navegación utilizado para navegar entre pantallas.
 * @param viewModel el ViewModel que contiene la lógica de negocio y los datos relacionados con la visualización de cócteles.
 */
@Composable
fun ViewConktailUser(navController: NavController, viewModel: Viewmodel) {
    // Se recopilan los datos de los cócteles desde el ViewModel y se observa su estado.
    val cocktailData by viewModel.cocktailData.collectAsState()
    val show = viewModel.show.value

    // Se utiliza LaunchedEffect para ejecutar una acción cuando este componente es lanzado.
    LaunchedEffect(Unit) {
        viewModel.fetchCoctail() // Se solicitan los datos de los cócteles al ViewModel.
    }

    // Se define la estructura básica de la pantalla utilizando Scaffold, que incluye una barra superior y una barra inferior.
    Scaffold(
        topBar = {
            // En la barra superior se muestra la cabecera de la pantalla y la información relacionada con la selección actual.
            Column {
                Cabecera(navController, viewModel)
                viewModel.Head(viewModel.number)
            }
        },
        bottomBar = {
            // En la barra inferior se muestra un enlace para ver todos los cócteles disponibles.
            Box(
                Modifier.fillMaxWidth().height(75.dp).background(color = Color(0xFF45413C)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "ViewCocktail",
                    fontFamily = jollyLodger,
                    color = Color(0xFF00F5D4),
                    fontSize = 36.sp,
                    modifier = Modifier.clickable {
                        // Al hacer clic en el enlace, se navega a la pantalla de visualización de cócteles.
                        navController.navigate(Routes.Cards.Route)
                    }
                )
            }
        }
    ) { innerPadding ->
        // El contenido principal se muestra dentro de un LazyColumn, que permite desplazamiento vertical y carga perezosa de elementos.
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color(0xFF45413C))
        ) {
            // Se recorren los elementos de la lista de cócteles y se muestran en la pantalla.
            itemsIndexed(cocktailData) { index, item ->
                Column {
                    // Cada cóctel se muestra como una fila que incluye una imagen y la lista de ingredientes.
                    Row(
                        modifier = Modifier
                            .height(100.dp)
                            .clickable {
                                // Al hacer clic en una fila, se ejecuta la lógica para mostrar los detalles del cóctel seleccionado.
                                viewModel.lightRow(show)
                                viewModel.SaveCocktail(
                                    idDrink = item.idDrink,
                                    strDrink = item.strDrink,
                                    strAlcoholic = item.strAlcoholic,
                                    strInstructions = item.strInstructions ?: "",
                                    strDrinkThumb = item.strDrinkThumb ?: "",
                                    strList = item.strList
                                )
                                viewModel.IngredientsUserCard(item)
                                viewModel.alcoholicOrno(item.strAlcoholic)
                                viewModel.changeSelectedRow(item.idDrink)
                                viewModel.changeCocktail(item.strDrink)
                            }
                            .border(
                                width = 2.dp,
                                color = viewModel.changeColorRow(item.idDrink)
                            )
                    ) {
                        // Dentro de la fila, se muestra la imagen del cóctel.
                        Box(
                            modifier = Modifier.width(100.dp)
                        ) {
                            Image(
                                painter = rememberImagePainter(item.strDrinkThumb),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(8.dp))
                            )
                        }
                        // Se muestra la lista de ingredientes del cóctel.
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(viewModel.calculateBackgroundColor(index))
                        ) {
                            Text(
                                text = "Ingredients:\n" + viewModel.IngredientsUser(item),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                    // Si se debe mostrar una alerta, se activa la lógica correspondiente en el ViewModel.
                    if (viewModel.showAlert) {
                        viewModel.lightRow(show)
                    }
                }
            }
        }
    }
}
