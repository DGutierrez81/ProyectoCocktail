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

@Composable
fun Cocktails(navController: NavController, viewModel: Viewmodel){
    val listCocktail by viewModel.listCocktail.collectAsState()
    val show = viewModel.show.value



    Scaffold (
        topBar = {
            Column {
                Cabecera(navController, viewModel)
                viewModel.Head(viewModel.number)
            }
            },
        bottomBar = { Box(Modifier.fillMaxWidth().height(75.dp).background(color = Color(0xFF45413C)),
            contentAlignment = Alignment.Center) {
            Text(text = "ViewCocktail", fontFamily = jollyLodger, color = Color(0xFF00F5D4), fontSize = 36.sp, modifier = Modifier.clickable { navController.navigate(
                Routes.Cards.Route) })
        }}
    ){innerPadding ->
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(color = Color(0xFF45413C))) {
            itemsIndexed(listCocktail) { index, item ->
                Column {
                    Row(
                        modifier = Modifier
                            .height(100.dp)
                            .clickable {
                                viewModel.lightRow(show)
                                viewModel.SaveCocktail(
                                    idDrink = item.idDrink,
                                    strDrink = item.strDrink,
                                    strAlcoholic= item.strAlcoholic,
                                    strInstructions = item.strInstructions ?: "vacio",
                                    strDrinkThumb = item.strDrinkThumb ?: "vacio",
                                    strList = mutableListOf(
                                        item.strIngredient1 ?: "vacio",
                                        item.strIngredient2 ?: "vacio",
                                        item.strIngredient3 ?: "vacio",
                                        item.strIngredient4 ?: "vacio",
                                        item.strIngredient5 ?: "vacio",
                                        item.strIngredient6 ?: "vacio",
                                        item.strIngredient7 ?: "vacio",
                                        item.strIngredient8 ?: "vacio",
                                        item.strIngredient9 ?: "vacio",
                                        item.strIngredient10 ?: "vacio",
                                        item.strIngredient12 ?: "vacio",
                                        item.strIngredient13 ?: "vacio",
                                        item.strIngredient14 ?: "vacio",
                                        item.strIngredient15 ?: "vacio",
                                    )
                                )
                                viewModel.IngredientsCard(item)
                                viewModel.changeSelectedRow(item.idDrink)
                                viewModel.alcoholicOrno(item.strAlcoholic)
                                viewModel.changeCocktail(item.strDrink)
                            }
                            .border(
                                width = 2.dp,
                                color = viewModel.changeColorRow(item.idDrink)
                            )
                    ) {
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
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(viewModel.calculateBackgroundColor(index)) // Establecer el color de fondo del contenedor
                        ) {
                            Text(
                                //"Ingredients:\n${item.strIngredient1}, ${item.strIngredient2}, ${item.strIngredient3},${item.strIngredient4}\n${item.strIngredient11}"
                                text = "Ingredients:\n" + viewModel.Ingredients(item),
                                modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                    if (viewModel.showAlert) {
                        /*navController.navigate(Routes.screen4.Route)*/
                        viewModel.lightRow(show)
                    }
                }
            }
        }
    }

/*
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = { viewModel.mostrar() }) {
                Text(text = "Pulsa aqui")
            }
            Button(onClick = { viewModel.saveNewCocktail { Toast.makeText(context, "Nota guardada OK", Toast.LENGTH_SHORT).show()
                navController.popBackStack() } }) {
                Text(text = "Add cocktail")
            }
        }
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            itemsIndexed(nombre) { index, item -> // Utilizamos itemsIndexed en lugar de items


                //val backgroundColor = if (index % 2 == 0) Color(0xFFF9EBE0) else Color.White // Alternar entre dos colores para las filas impares y pares

                Column {
                    Text(
                        text = item.strDrink ?: "vacio",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp), // Añadir un relleno alrededor del texto para que el color de fondo sea visible
                        textAlign = TextAlign.Center,
                        color = Color.Black // Color del texto
                    )
                    Row(
                        modifier = Modifier
                            .height(100.dp)
                            .clickable {
                                viewModel.lightRow(show)
                                viewModel.SaveCocktail(
                                    idDrink = item.idDrink?: "vacio",
                                    strDrink = item.strDrink?: "vacio",
                                    strInstructions = item.strInstructions ?: "vacio",
                                    strDrinkThumb = item.strDrinkThumb ?: "vacio",
                                    strList = mutableListOf(
                                        item.strIngredient1 ?: "vacio", item.strIngredient2 ?: "vacio", item.strIngredient3 ?: "vacio", item.strIngredient4 ?: "vacio", item.strIngredient5 ?: "vacio", item.strIngredient6 ?: "vacio",
                                        item.strIngredient6 ?: "vacio", item.strIngredient7 ?: "vacio", item.strIngredient8 ?: "vacio", item.strIngredient9 ?: "vacio", item.strIngredient10 ?: "vacio", item.strIngredient12 ?: "vacio",
                                        item.strIngredient13 ?: "vacio", item.strIngredient14 ?: "vacio", item.strIngredient15 ?: "vacio",
                                    )
                                )
                                viewModel.changeSelectedRow(item.idDrink)
                            }
                            .border(
                                width = 2.dp,
                                color = viewModel.changeColorRow(item.idDrink)
                            )
                    ) {
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
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .background(viewModel.calculateBackgroundColor(index)) // Establecer el color de fondo del contenedor
                        ) {
                            Text(
                                //"Ingredients:\n${item.strIngredient1}, ${item.strIngredient2}, ${item.strIngredient3},${item.strIngredient4}\n${item.strIngredient11}"
                                text = "Ingredients:\n" + viewModel.Ingredients(item),
                                modifier = Modifier.padding(5.dp).fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }

                    }
                    if (viewModel.showAlert) {
                        /*navController.navigate(Routes.screen4.Route)*/
                        viewModel.lightRow(show)
                    }
                }
            }
        }
    }

 */
}