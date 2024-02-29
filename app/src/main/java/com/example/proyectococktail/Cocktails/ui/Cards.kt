package com.example.proyectococktail.Cocktails.ui

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.proyectococktail.home.jollyLodger

/**
 * Esta función representa una tarjeta que muestra detalles de un cóctel, como su nombre, imagen, instrucciones y ingredientes.
 * También proporciona la funcionalidad para agregar el cóctel a favoritos.
 * @param navController el controlador de navegación utilizado para navegar entre pantallas.
 * @param viewModel el ViewModel que contiene los datos y la lógica relacionada con la tarjeta de cóctel.
 */
@Composable
fun Cards(navController: NavController, viewModel: Viewmodel) {
    // Se obtiene el contexto actual.
    val context = LocalContext.current

    // La estructura principal es una columna que alinea horizontalmente su contenido al centro.
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Scaffold se utiliza para proporcionar una estructura básica de la pantalla.
        Scaffold(
            topBar = {
                // El contenido de la barra superior incluye la cabecera y un elemento específico del ViewModel.
                Column {
                    Cabecera(navController, viewModel)
                    viewModel.Head(viewModel.number)
                }
            },
            bottomBar = {
                // El contenido de la barra inferior es un texto que permite agregar el cóctel a favoritos.
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(75.dp)
                        .background(color = Color(0xFF45413C)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Add favorites",
                        fontFamily = jollyLodger,
                        color = Color(0xFFFF01FB),
                        fontSize = 36.sp,
                        modifier = Modifier.clickable {
                            // Al hacer clic en el texto, se guarda el cóctel como favorito y se muestra un mensaje.
                            viewModel.saveNewCocktail() {
                                Toast.makeText(context, "Cocktail guardado correctamente", Toast.LENGTH_SHORT).show()
                                navController.popBackStack()
                            }
                        }
                    )
                }
            }
        ) { innerPadding ->
            // El contenido principal está contenido en un Box con fondo de color oscuro.
            Box(Modifier.fillMaxSize().background(color = Color(0xFF45413C))) {
                // Dentro del Box, se encuentra una tarjeta que muestra detalles del cóctel.
                Card(
                    border = BorderStroke(10.dp, Color(0xFF00F5D4)),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    // La tarjeta contiene una imagen del cóctel y una lista de texto con información adicional.
                    Image(
                        painter = rememberImagePainter(viewModel.drink.strDrinkThumb),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )

                    LazyColumn(
                        modifier = Modifier.background(Color.White)
                    ) {
                        item {
                            // Se muestran el nombre del cóctel, las instrucciones y los ingredientes.
                            viewModel.drink.strDrink.let {
                                Text(
                                    text = it,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    textAlign = TextAlign.Center
                                )
                            }
                            viewModel.drink.strInstructions.let {
                                Text(
                                    text = it,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    textAlign = TextAlign.Center
                                )
                            }
                            Text(
                                text = "Ingredients:\n${viewModel._ingredient2}",
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}
